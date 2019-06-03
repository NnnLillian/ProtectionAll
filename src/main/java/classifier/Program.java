package classifier;

import jieba.keyword.Keyword;
import jieba.keyword.TFIDFAnalyzer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public  class Program
{
    public static void main(String[] args) throws IOException
    {
        String content="新疆地区各季气候变化明显，大风和沙尘天气。大风天气容易使雷达天线甚至车辆发生倾覆危险，沙尘天气容易导致机箱内，尤其是高压部分会导致打火，进入液压支腿及F车大齿弧等裸露机械部分，会导致机械卡滞或其润滑油脂变质，使润滑效果下降，损坏兵器；高热的环境会影响雷达装备板件的性能，加速导弹各机部件、发动机装药的老化，影响导弹的可靠性和使用寿命，同时，温度超出导弹规定的工作界值，会对导弹的电缆线路产生影响，从而影响信号传输；干燥的环境会导致装备接地性能不好，影响装备工作的稳定性，导致故障率提高，同时干燥的环境也会导致静电的产生，导致维护难度的增加；低温或者极低温环境会增加装备机械润滑部分预热时间，增加大型真空管器件的预热时间。";
        int topN=5;
        TFIDFAnalyzer tfidfAnalyzer=new TFIDFAnalyzer();
        List<Keyword> list=tfidfAnalyzer.analyze(content,topN);
        for(Keyword word:list)
            System.out.print(word.getName()+":"+word.getTfidfvalue()+",");
        //1、获取文档输入
        String[] docs = getInputDocs("C:\\Users\\18362\\Desktop\\newDemo\\src\\main\\resources\\input.txt");

        if (docs.length < 1)
        {
            System.out.println("没有文档输入");
            System.in.read();

            return;
        }

        //2、初始化TFIDF测量器，用来生产每个文档的TFIDF权重
        TFIDFMeasure tf = new TFIDFMeasure(docs, new Tokeniser());
        System.out.println(tf.get_numTerms());


        int K = 3; //聚成3个聚类

        //3、生成k-means的输入数据，是一个联合数组，第一维表示文档个数，
        //第二维表示所有文档分出来的所有词
        double[][] data = new double[docs.length][];
        int docCount = docs.length; //文档个数
        int dimension = tf.get_numTerms();//所有词的数目
        for (int i = 0; i < docCount; i++)
        {
            for (int j = 0; j < dimension; j++)
            {
                data[i] = tf.GetTermVector2(i); //获取第i个文档的TFIDF权重向量
            }
        }

        //4、初始化k-means算法，第一个参数表示输入数据，第二个参数表示要聚成几个类
        WawaKMeans kmeans = new WawaKMeans(data, K);
        //5、开始迭代
        kmeans.Start();

        //6、获取聚类结果并输出
        WawaCluster[] clusters = kmeans.getClusters();
        for(WawaCluster cluster : clusters){

            List<Integer> members = cluster.CurrentMembership;
            System.out.println("-----------------");
            for (int i : members)
            {
                System.out.println(docs[i]);
            }

        }
    }

    /// <summary>
    /// 获取文档输入
    /// </summary>
    /// <returns></returns>
    private static String[] getInputDocs(String file)
    {
        List<String> ret = new ArrayList<String>();

        try
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            {
                String temp;
                while ((temp = br.readLine()) != null)
                {
                    ret.add(temp);
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        String[] fileString=new String[ret.size()];
        return (String[]) ret.toArray(fileString);
    }
}
