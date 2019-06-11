package jieba.keyword;

import com.example.util.Classify;
import com.huaban.analysis.jieba.JiebaSegmenter;

import java.io.*;
import java.util.*;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date Oct 20, 2018
 * tfidf算法原理参考：http://www.cnblogs.com/ywl925/p/3275878.html
 * 部分实现思路参考jieba分词：https://github.com/fxsjy/jieba
 */
public class TFIDFAnalyzer
{
	
	static HashMap<String,Double> idfMap;
	static HashSet<String> intensitySet;
	static HashSet<String> stopWordsSet;
	static double idfMedian;
	
	/**
	 * tfidf分析方法
	 * @param content 需要分析的文本/文档内容
	 * @param topN 需要返回的tfidf值最高的N个关键词，若超过content本身含有的词语上限数目，则默认返回全部
	 * @return
	 */
	public List<Keyword> analyze(String content,int topN){
		List<Keyword> keywordList=new ArrayList<>();
		
		if(stopWordsSet==null) {
			stopWordsSet=new HashSet<>();
			loadStopWords(stopWordsSet, this.getClass().getResourceAsStream("/stop_words.txt"));
		}
		if(idfMap==null) {
			idfMap=new HashMap<>();
			loadIDFMap(idfMap, "./\\src\\main\\resources\\new_dict.txt");
		}

		Map<String, Double> tfMap=getTF(content);
		for(String word:tfMap.keySet()) {
			// 若该词不在idf文档中，则使用平均的idf值(可能定期需要对新出现的网络词语进行纳入)
			if(idfMap.containsKey(word)) {
				keywordList.add(new Keyword(word,idfMap.get(word)*tfMap.get(word)));
			}else
			{
				//keywordList.add(new Keyword(word,idfMedian*tfMap.get(word)));
			}

		}
		
		Collections.sort(keywordList, new Comparator<Keyword>() {
			@Override
			public int compare(Keyword o1, Keyword o2) {
				return o1.getTfidfvalue() == o2.getTfidfvalue() ? 0 :
						(o1.getTfidfvalue() > o2.getTfidfvalue() ? -1 : 1);
			}
		});
		
		if(keywordList.size()>topN) {
			int num=keywordList.size()-topN;
			for(int i=0;i<num;i++) {
				keywordList.remove(topN);
			}
		}
		return keywordList;
	}

	public Keyword getIntensity(String content)
	{
		List<Keyword> keywordList=new ArrayList<>();

		if(intensitySet==null) {
			intensitySet=new HashSet<>();
			loadStopWords(intensitySet, this.getClass().getResourceAsStream("/intensity_words.txt"));
		}
		JiebaSegmenter segmenter = new JiebaSegmenter();
		List<String> segments=segmenter.sentenceProcess(content);
		Map<String,Integer> freqMap=new HashMap<>();

		int wordSum=0;
		for(String segment:segments) {
			//停用词不予考虑，单字词不予考虑
			if(intensitySet.contains(segment)) {
				wordSum++;
				if(freqMap.containsKey(segment)) {
					freqMap.put(segment,freqMap.get(segment)+1);
				}else {
					freqMap.put(segment, 1);
				}
			}
		}
		for(String word:freqMap.keySet()) {

			keywordList.add(new Keyword(word,freqMap.get(word)));
		}

		Collections.sort(keywordList, new Comparator<Keyword>() {
			@Override
			public int compare(Keyword o1, Keyword o2) {
				return o1.getTfidfvalue() == o2.getTfidfvalue() ? 0 :
						(o1.getTfidfvalue() > o2.getTfidfvalue() ? -1 : 1);
			}
		});
		if (keywordList.size()!=0)
			return keywordList.get(0);
		return null;
	}
	/**
	 * tf值计算公式
	 * tf=N(i,j)/(sum(N(k,j) for all k))
	 * N(i,j)表示词语Ni在该文档d（content）中出现的频率，sum(N(k,j))代表所有词语在文档d中出现的频率之和
	 * @param content
	 * @return
	 */
	private Map<String, Double> getTF(String content) {
		Map<String,Double> tfMap=new HashMap<>();
		if(content==null || content.equals(""))
			return tfMap; 
		
		JiebaSegmenter segmenter = new JiebaSegmenter();
		List<String> segments=segmenter.sentenceProcess(content);
		Map<String,Integer> freqMap=new HashMap<>();
		
		int wordSum=0;
		for(String segment:segments) {
			//停用词不予考虑，单字词不予考虑
			if(!stopWordsSet.contains(segment) && segment.length()>1) {
				wordSum++;
				if(freqMap.containsKey(segment)) {
					freqMap.put(segment,freqMap.get(segment)+1);
				}else {
					freqMap.put(segment, 1);
				}
			}
		}
		
		// 计算double型的tf值
		for(String word:freqMap.keySet()) {
			tfMap.put(word,freqMap.get(word)*0.1/wordSum);
		}
		
		return tfMap; 
	}
	/**
	 * 默认jieba分词的停词表
	 * url:https://github.com/yanyiwu/nodejieba/blob/master/dict/stop_words.utf8
	 * @param set
	 * @param in
	 */
	private void loadStopWords(Set<String> set, InputStream in){
		BufferedReader bufr;
		try
		{
			bufr = new BufferedReader(new InputStreamReader(in));
			String line=null;
			while((line=bufr.readLine())!=null) {
				set.add(line.trim());
			}
			try
			{
				bufr.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * idf值本来需要语料库来自己按照公式进行计算，不过jieba分词已经提供了一份很好的idf字典，所以默认直接使用jieba分词的idf字典
	 * url:https://raw.githubusercontent.com/yanyiwu/nodejieba/master/dict/idf.utf8
	 */
	private void loadIDFMap(Map<String,Double> map, String file ){
		BufferedReader bufr;
		try
		{
			InputStream in = new FileInputStream(file);
			bufr = new BufferedReader(new InputStreamReader(in));
			String line=null;
			while((line=bufr.readLine())!=null) {
				String[] kv=line.trim().split(" ");
				map.put(kv[0],Double.parseDouble(kv[1]));
			}
			try
			{
				bufr.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
			// 计算idf值的中位数
			List<Double> idfList=new ArrayList<>(map.values());
			Collections.sort(idfList);
			idfMedian=idfList.get(idfList.size()/2);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public Keyword analyze(String content){
		List<Keyword> keywordList=new ArrayList<>();

		if(stopWordsSet==null) {
			stopWordsSet=new HashSet<>();
			loadStopWords(stopWordsSet, this.getClass().getResourceAsStream("/stop_words.txt"));
		}
		if(idfMap==null) {
			idfMap=new HashMap<>();
			loadIDFMap(idfMap, "./\\src\\main\\resources\\new_dict.txt");
		}

		Map<String, Double> tfMap=getTF(content);
		for(String word:tfMap.keySet()) {
			// 若该词不在idf文档中，则使用平均的idf值(可能定期需要对新出现的网络词语进行纳入)
			if(idfMap.containsKey(word)) {
				keywordList.add(new Keyword(word,idfMap.get(word)*tfMap.get(word)));
			}else
			{
				//keywordList.add(new Keyword(word,idfMedian*tfMap.get(word)));
			}

		}

		Collections.sort(keywordList, new Comparator<Keyword>() {
			@Override
			public int compare(Keyword o1, Keyword o2) {
				return o1.getTfidfvalue() == o2.getTfidfvalue() ? 0 :
						(o1.getTfidfvalue() > o2.getTfidfvalue() ? -1 : 1);
			}
		});

		if (keywordList.size()>0)
			return keywordList.get(0);
		else
			return null;
	}
	public static void main(String[] args)
	{
		String content="新疆地区各季气候变化明显，大风和沙尘天气。大风天气容易使雷达天线甚至车辆发生倾覆危险，沙尘天气容易导致机箱内，尤其是高压部分会导致打火，进入液压支腿及F车大齿弧等裸露机械部分，会导致机械卡滞或其润滑油脂变质，使润滑效果下降，损坏兵器；高热的环境会影响雷达装备板件的性能，加速导弹各机部件、发动机装药的老化，影响导弹的可靠性和使用寿命，同时，温度超出导弹规定的工作界值，会对导弹的电缆线路产生影响，从而影响信号传输；干燥的环境会导致装备接地性能不好，影响装备工作的稳定性，导致故障率提高，同时干燥的环境也会导致静电的产生，导致维护难度的增加；低温或者极低温环境会增加装备机械润滑部分预热时间，增加大型真空管器件的预热时间。";
		String str = "新疆地区总体来说是地域辽阔、山地平原分明。辽阔的地域环境能保证地导部队灵活部署，同时也增加了敌方进袭目标的灵活性，加大了保卫目标的难度，增加了装备保障的难度。如果装备部署在平坦地区，加之单一的地貌特征很容易暴露目标，伪装防护要求较高，必须达到很好的效果；新疆地区戈壁和沙漠环境较多，对G车和导弹来说容易产生雷达镜像效应，容易使G车天线摆动剧烈以及使导弹丢失目标；如果涉及守卫山地目标或者防范山区方向进袭目标，地导部队可能部署到山区，这不但会影响抢占阵地还加大了装备故障概率，增加了抢修和器材保障难度。";
		String str2 = "新疆地区与多国边境接壤，尤其是与印度接壤的边境线很长，进来不稳定的中印关系，在“洞朗”事件的推动下，中印关系更是摇摇欲坠，新疆地区特别是中国新疆和印度接壤的山区进行作战部署的可能性大为增加，相应装备保障的紧迫性和必要性更是急需解决的。";
		String str3 = "新疆地区任务，训练机动频率高，机动路程远，装备种类多、组合结构复杂，机动过程中车辆行驶部分，尤其是车辆轮胎经常因长时问磨损、路况不好扎胎等原因造成损坏，发动机因频繁地工作，会导致故障发生概率骤然增大";
		String str4 = "大风天气容易使雷达天线甚至车辆发生倾覆危险，因此，行驶时需要对天线进行加固处理";
		String str5 = "由于该地区气压比较小，高压器件耐压急剧下降，使用寿命降低，因此，需要携带备用器件";
		//int topN=10;
		//TFIDFAnalyzer tfidfAnalyzer=new TFIDFAnalyzer();
		//List<Keyword> list=tfidfAnalyzer.analyze(content,topN);
		//for(Keyword word:list)
		//	System.out.print(word.getName()+":"+word.getTfidfvalue()+",");
		Classify classify = new Classify();
		System.out.println(classify.GetSpecialType(str5));
		System.out.println(classify.GetSpecialIntensity(str5));
	}
}

