package com.cui;
import java.io.*;
import java.util.ArrayList;

public class Gb2312All {
    public static void main(String[] args){
        int start = Integer.parseInt("4e00", 16);
        int end = Integer.parseInt("9fa5", 16);

        ArrayList strList = new ArrayList();

        StringBuilder chinese = new StringBuilder();
        for (int i = start; i <= end; i++) {
            strList.add((char) i);
            chinese.append((char) i);
        }

        StringBuilder name = new StringBuilder();
        int num = 1;
        String split = ",\n";
        for(int i=0;i<strList.size();i++) {
            for(int n=0;n<strList.size();n++) {
                if(strList.get(n).toString().equals("睿") || strList.get(n).toString().equals("熙")) {
                    num ++;
                    name.append("崔"+strList.get(i).toString()+strList.get(n).toString() + split);
                }
            }
        }

        name.append("共" + num + "个名字");

        // 将文字写入文本中
        try {
            FileOutputStream chineseFileOutputStream = new FileOutputStream ("chinese.CSV",false);
            OutputStreamWriter chineseOutputStreamWriter = new OutputStreamWriter(chineseFileOutputStream, "UTF-8");
            BufferedWriter chineseWriter = new BufferedWriter(chineseOutputStreamWriter);
            chineseWriter.write(chinese.toString());
            chineseWriter.close();

            FileOutputStream nameFileOutputStream = new FileOutputStream ("name.CSV",false);
            OutputStreamWriter nameOutputStreamWriter = new OutputStreamWriter(nameFileOutputStream, "UTF-8");
            BufferedWriter nameWriter = new BufferedWriter(nameOutputStreamWriter);
            nameWriter.write(name.toString());
            nameWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文字已写入当前工程Chinese.txt中，请刷新工程查看。");
        System.out.println("文字已写入当前工程name.txt中，请刷新工程查看。");
    }
}