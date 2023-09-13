package com.Recruitment;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 1. @ClassDescription:字节跳动02
 * 给出一个矩阵，该矩阵可以由三种颜色组成，然后给出一组范围，计算该范围内的色彩数量
 *
 * 纯正的模拟法，但是没有ac
 * 2. @author: Huang Zhiwei
 * 3. @date: 2023年08月27日 10:43
 * 3 3
 * red blue blue
 * red blue blue
 * green green green
 * 2
 * 1 2 2 3
 * 2 1 3 2
 */
public class bytedance02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashSet<String> colors = new HashSet<>();
        int countrow = in.nextInt();
        int countcol = in.nextInt();
        String[][] matrix = new String[countrow][countcol];
        for(int i = 0;i< countrow;i++){
            for(int j = 0;j<countcol;j++){
                matrix[i][j] = in.next();
            }
        }
        int countQ = in.nextInt();
        int[] questions = new int[4];
        for(int i = 0 ;i <countQ;i++){
            questions[0] = in.nextInt()-1;
            questions[1] = in.nextInt()-1;
            questions[2] = in.nextInt()-1;
            questions[3] = in.nextInt()-1;
            for(int row = questions[0];row<questions[2]+1;row++){
                for(int col = questions[1];col<questions[3]+1;col++){
                    colors.add(matrix[row][col]);
                    if (colors.size() == 3){
                        break;
                    }
                }
                if (colors.size() == 3){
                    break;
                }
            }
            System.out.println(colors.size());
            colors.clear();
        }
    }

}
