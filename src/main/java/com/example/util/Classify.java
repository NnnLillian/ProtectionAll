package com.example.util;

import jieba.keyword.Keyword;
import jieba.keyword.TFIDFAnalyzer;

import java.io.*;
import java.util.*;

public class Classify {
    private HashMap<String,String> TypeList;
    private HashMap<String,String> IntensityList;
    private String[][] label;

    public Classify() {
        label = new String[4][];
        label[0] = getInputDocs("./\\src\\main\\resources\\geography.txt");
        label[1] = getInputDocs("./\\src\\main\\resources\\climate.txt");
        label[2] = getInputDocs("./\\src\\main\\resources\\border.txt");
        label[3] = getInputDocs("./\\src\\main\\resources\\category.txt");
    }

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

    public String GetSpecialType(String special)
    {
        TypeList=new HashMap<>();
        loadTypeMessage(TypeList, "./\\src\\main\\resources\\type.txt");

        String[] splitString = special.split("，");
        String newSpecial = "";
        for (int i=0;i<splitString.length-1;i++)
        {
            newSpecial += splitString[i]+",";
        }
        TFIDFAnalyzer tfidfAnalyzer=new TFIDFAnalyzer();
        Keyword result=tfidfAnalyzer.analyze(newSpecial);
        if (result != null)
            return TypeList.get(result.getName());
        else
            return "other";
    }

    public String GetSpecialIntensity(String special)
    {
        IntensityList=new HashMap<>();
        loadTypeMessage(IntensityList, "./\\src\\main\\resources\\intensity.txt");
        String[] splitString = special.split("，");
        String newSpecial = "";
        for (int i=0;i<splitString.length-1;i++)
        {
            newSpecial += splitString[i]+",";
        }
        TFIDFAnalyzer tfidfAnalyzer=new TFIDFAnalyzer();
        Keyword result=tfidfAnalyzer.getIntensity(newSpecial);
        if (result != null)
            return IntensityList.get(result.getName());
        else
            return "5";
    }
    public String GetSpecialType(String special,int n)
    {
        TypeList=new HashMap<>();
        loadTypeMessage(TypeList, "./\\src\\main\\resources\\type.txt");

        TFIDFAnalyzer tfidfAnalyzer=new TFIDFAnalyzer();
        List<Keyword> list=tfidfAnalyzer.analyze(special,n);
        double[][] vector = new double[4][list.size()];
        double[] result = new double[4];
        for (int i=0;i<4;i++)
        {
            result[i] = 0;
            for (int j=0;j<list.size();j++)
            {
                if(IsInStringList(list.get(j).getName(),label[i]))
                    vector[i][j] = list.get(j).getTfidfvalue();
                else
                    vector[i][j] = 0;
                result[i] += vector[i][j]*vector[i][j];
            }
        }
        double max = 0;
        int maxIndex = -1;
        for (int i = 0; i < result.length; i++) {

            if (result[i] > max) {
                max = result[i];
                maxIndex = i;
            }
        }
        if (maxIndex == 0)
            return "geography";
        else if (maxIndex == 1)
            return "climate";
        else if (maxIndex == 2)
            return "border";
        else if (maxIndex == 3)
            return "category";
        else
            return "other";
    }
    public boolean IsInStringList(String str,String[] doc)
    {
        for (int i=0;i<doc.length;i++)
        {
            if (str.equals(doc[i]))
                return true;
        }
        return false;
    }
    private void loadTypeMessage(Map<String,String> map, String file ){


        BufferedReader bufr;
        try
        {
            InputStream in = new FileInputStream(file);
            bufr = new BufferedReader(new InputStreamReader(in));
            String line=null;
            while((line=bufr.readLine())!=null) {
                String[] kv=line.trim().split(" ");
                map.put(kv[0],kv[1]);
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
}
