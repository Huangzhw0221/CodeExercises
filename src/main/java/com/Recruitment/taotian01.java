package com.Recruitment;

/**
 * @description:
 * @author: Huang Zhiwei
 * @time: 2023/9/28 11:26
 */
public class taotian01 {
    public static void main(String[] args) {
        String str = "+3.14E6";
        System.out.println(isvalid(str));
    }

    public static boolean isvalid(String str){
        str = str.trim();
        char[] chars = str .toCharArray();
        int state = 0;
        // 状态机
        // +- 数字 点 数字 e/E +- 数字
        //0 1 2   3   4   5  6   7
        for(char c: chars)
            switch (state){
                case 0: state = (c == '-' || c == '+') ? 1 : 2 ; continue;

                case 1: state = (c < '9' && c > '0') ? 2:99;continue;

                case 2: if(c < '9' && c > '0'){
                    state = 2;
                }else if(c == '.'){
                    state = 3;
                }else {
                    state = 99;
                }continue;

                case 3: state = (c< '9' && c >'0') ? 4:99;continue;

                case 4: if(c < '9'&& c > '0'){
                    state = 4;
                }else if(c == 'e'|| c == 'E'){
                    state = 5;
                }else{
                    state = 99;
                }continue;

                case 5: if(c =='-' ||  c == '+'){
                    state = 6;
                }else if(c < '9'&& c > '0'){
                    state = 7;
                }else {
                    state = 99;
                }continue;

                case 6: state = (c < '9' && c > '0') ? 7:99;continue;

                case 7: state = (c < '9' && c > '0') ? 7:99;continue;

                case 99: return false;
        }
        return true;
    }
}
