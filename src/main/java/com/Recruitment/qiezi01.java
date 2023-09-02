package com.Recruitment;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Huang Zhiwei
 * @time: 2023/8/30 19:04
 */
public class qiezi01 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();
        list.add(99);
        list.getClass().getMethod("add", Object.class).invoke(list, "reflect");
        System.out.println(list);
    }
}
