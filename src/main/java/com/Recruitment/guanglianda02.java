package com.Recruitment;

/**
 * @description: 拷贝问题
 * @author: Huang Zhiwei
 * @time: 2023/9/6 10:47
 */
public class guanglianda02 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        System.out.println(co(nums));
    }
    public static int co(int[] ints){
        if(ints.length==1){
            return 0;
        }
        // 对比的目标数字
        int target = ints[ints.length-1];
        // 指针指向的数字
        int index = ints.length-2;
        // 操作数
        int count = 0;
        // 相同的数字计数
        int samecount = 0;
        // 已经相同的个数
        int totalcount = 0;
        while (index >= 0){
            samecount = 0;
            while (index >= 0 && ints[index] == target){
                index -- ;
                samecount++;
            }
            if(index < ints.length/2) {
                count++;
                break;
            }
            count ++;
            // index减去已经相同的数字就可以了
//            totalcount = (totalcount+samecount) * 2
            index = index - 1 - (totalcount+samecount);
            totalcount += samecount+1;
        }
        return count;
    }

}
