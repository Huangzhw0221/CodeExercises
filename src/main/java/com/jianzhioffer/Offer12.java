package com.jianzhioffer;

/**
 * @description: 矩阵中的路径
 * 使用深度优先搜索，相当于用了递归和剪枝。当数组越界或者匹配不上的情况发生的时候就返回false，其他情况就对该位置上下左右四个位置做判断。
 * 由于不能走回头路，所以要将当前位置置为不可见字符。
 * 当下面几层的递归结束后还要把这个位置的字符放回去。
 * @author: Huang Zhiwei
 * @time: 2023/4/10 15:46
 */
public class Offer12 {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
    public static boolean exist(char[][] board, String word) {
        char[] wordArray = word.toCharArray();
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(dfs(board,wordArray,i,j,0)) return true;
            }
        }
        return false;
    }
    public static boolean dfs(char[][] board,char[] wordArray,int i,int j,int k){
        if(i>= board.length || j>= board[0].length || i<0 || j<0 || board[i][j] != wordArray[k]) return false;
        if(k == wordArray.length-1) return true;
        //由于不能走回头路，所以要将当前位置置为不可见字符。
        board[i][j] = '\0';
        boolean res = dfs(board,wordArray,i-1,j,k+1) || dfs(board,wordArray,i+1,j,k+1)
                ||dfs(board,wordArray,i,j-1,k+1)||dfs(board,wordArray,i,j+1,k+1);
        //当下面几层的递归结束后还要把这个位置的字符放回去。
        board[i][j] = wordArray[k];
        return res;
    }
}
