package com.Recruitment;

/**
 * @description:
 * @author: Huang Zhiwei
 * @time: 2023/10/10 11:18
 */
import java.util.*;

public class dewu04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();

        int[] nums = new int[n];
        HashSet<Integer> set = new HashSet<>();
        int index = 0;
        for (int i = 0; i < n; i++) {
            int temp = in.nextInt();
            if(!set.contains(temp)){
                nums[index++] = temp;
                set.add(temp);
            }
        }
        int[] arr = new int[set.size()];
        System.arraycopy(nums, 0, arr, 0, set.size());

        Deque<Integer> path = new ArrayDeque<>(n);
        List<Integer> size = new ArrayList<>();
        Arrays.sort(arr);
        dfs(arr, set.size(), 0, m, path, size);

        if (size.isEmpty()) System.out.println("No solution");
        else System.out.println(Collections.min(size));
    }

    public static void dfs(int[] arr, int len, int begin, int target, Deque<Integer> path, List<Integer> size) {
        if (target == 0) {
            size.add(path.size());
            return;
        }

        for (int i = begin; i < len; i++) {
            if (target - arr[i] < 0) break;
            path.addLast(arr[i]);
            dfs(arr, len, i + 1, target - arr[i], path, size);
            path.removeLast();
        }
    }
}
