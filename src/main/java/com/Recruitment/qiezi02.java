package com.Recruitment;

/**
 * @description:
 * @author: Huang Zhiwei
 * @time: 2023/8/30 19:09
 */
public class qiezi02 {
    public static void main(String[] args) {
        Access obj = new Access();
        obj.cal(2,3);
        System.out.println(obj.x+" "+obj.y);
    }
}
class Access{
    public int x;
    int y;
    void cal(int a, int b){
        x=a+1;
        y =b;
    }
}

