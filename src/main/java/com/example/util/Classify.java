package com.example.util;

import jieba.keyword.Keyword;
import jieba.keyword.TFIDFAnalyzer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Classify {

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

    public String GetSpecialType(String special,int n)
    {
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
            if (vector[i][0]!=0)
                result[i] = result[i]/(vector[i][0]*vector[i][0]);
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

}
