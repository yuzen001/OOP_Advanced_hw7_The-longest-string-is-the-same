package com.example.lib;

import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入一字串(<100)");
        String inputstring = scanner.next();
        String LongestStandard = "";
        int LongestLength = 0;
        System.out.println(inputstring);
        System.out.println(inputstring.substring(1, 3));
        int InputstringLength = inputstring.length();

        for (int i = 0; i < InputstringLength; ) {
            for (int j = 2; j < InputstringLength + 1; ) {                      //(若由後往前找得值等同起始值，可知沒有一個相同)
                if (inputstring.lastIndexOf(inputstring.substring(i, j)) == i) {//後面沒有相同的
                    i++;                                                //往下找
                    j = i + 2;                                          //倆倆先找
                    if (j >= InputstringLength + 1) {
                        i = InputstringLength;                          //字串收尋結束直接強迫結束迴圈
                    }
                } else {
                    int LN = inputstring.substring(i, j).length();
                    if (LN > LongestLength) {                           //如果有相同長度的字串大於"最長字串長度"
                        LongestStandard = inputstring.substring(i, j);  //將字串覆蓋於標準字串
                        LongestLength = LN;                             //將"最長字串長度"填入該長度
                    } else if (LN == LongestLength) {                   //若有長度相同
                        LongestStandard = LongestStandard + "," +       //進行字串增長
                                inputstring.substring(i, j);
                    }
                    j++;
                }
            }
        }
        System.out.println("最常重複字串:" + LongestStandard);

    }

}