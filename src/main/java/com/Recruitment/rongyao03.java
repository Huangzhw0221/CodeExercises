package com.Recruitment;

import java.util.Scanner;

/**
 * @description: 字符串匹配问题，主要是非常复杂繁琐，难度是很低的
 * @author: Huang Zhiwei
 * @time: 2023/9/10 18:54
 */
//read read[mask=0xff,addr=0x17,val=0x7],read[],read[addr=0xF0,mask=0xff,val=0x80]
public class rongyao03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        // 基准串
        String base = input.split( " ")[0];
        // 剩余串
        String res = input.split(" ")[1];
        String[] split = res.split("],");

        for(int i = 0;i<split.length;i++){
            // 找到前缀
            String compare = split[i].split("\\[")[0];
            try {
                String[] later = split[i].split("\\[")[1].split(",");
            }catch (Exception e){
                System.out.println("FAIL");
                continue;
            }
            String[] later = split[i].split("\\[")[1].split(",");
            // 拆分后面的部分
            judge(later,base,compare);
        }
        System.out.println();
    }
    public static void judge(String[] str,String base,String compare){
        if(str.length != 3 || !base.equals(compare)){
            System.out.println("FAIL");
            return;
        }
        boolean judgeA =false,judgeB=false,judgeC=false;
        String[] str1 = new String[3];
        for(int i =0;i <3;i++){
            if(!judgeA){
                judgeA =  str[i].matches("^addr=0x.*") || str[0].matches("^addr=0X.*");
                if(judgeA){str1[0] = str[i];}
            }
            if(!judgeB){
                judgeB =  str[i].matches("^mask=0x.*") || str[0].matches("^mask=0X.*");
                if(judgeB){str1[1] = str[i];}
            }
            if(!judgeC){
                judgeC =  str[i].matches("^val=0x.*") || str[0].matches("^val=0X.*");
                if(judgeC){str1[2] = str[i];}
            }
        }
        str = str1;
//        judgeA =  str[0].matches("^addr=0x.*") || str[0].matches("^addr=0X.*");
//        judgeB =  str[1].matches("^mask=0x.*") || str[0].matches("^mask=0X.*");
//        judgeC =  str[2].matches("^val=0x.*") || str[0].matches("^val=0X.*");
        if(judgeA && judgeB && judgeC){
            String A = str[0].split("addr=")[1].split("]")[0];
            String B = str[1].split("mask=")[1].split("]")[0];
            String C = str[2].split("val=")[1].split("]")[0];
            judgeA = A.matches("(?i)^(0x|0X)?[0-9a-f]+$");
            judgeB = B.matches("(?i)^(0x|0X)?[0-9a-f]+$");
            judgeC = C.matches("(?i)^(0x|0X)?[0-9a-f]+$");
            if(judgeA && judgeB && judgeC){
                A = A.split("]")[0];
                B = B.split("]")[0];
                C = C.split("]")[0];
                if(A.length()<=2&&B.length()<=2&&C.length()<=2){
                    System.out.println("FAIL");
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(A).append(" ");
                sb.append(B).append(" ");
                sb.append(C).append(" ");
                System.out.println(sb);
            }else {
                System.out.println("FAIL");
            }
        }else {
            System.out.println("FAIL");
        }
    }
}
