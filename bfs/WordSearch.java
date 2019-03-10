package leetcode.bfs;

public class WordSearch {
    private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean flag = false;
    public boolean myExist(char[][] board, String word) {
        if(word.length() == 0) return true;

        int m = board.length, n = board[0].length;
        if(m == 0 || n == 0) return false;

        boolean[][] used = new boolean[m][n];

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(board[i][j] == word.charAt(0)){
                    used[i][j] = true;
                    dfs(board, word, used, 1, i, j);
                    used[i][j] = false;
                }
        return flag;
    }

    private void dfs(char[][] board, String word, boolean[][] used, int index, int i, int j){
        if(i < 0 || i > board.length-1 || j < 0 || j > board[0].length-1 || index > word.length()) return;

        if(index == word.length()){
            flag = true;
            return;
        }

        if(flag) return; //找到一个就全部终止，否则会不停搜索下去，耗时太长

        for(int[] direct : directions){
            int nextI = i + direct[0];
            int nextJ = j + direct[1];

            if(0 <= nextI && nextI <= board.length-1 && 0 <= nextJ && nextJ <= board[0].length-1
                    && !used[nextI][nextJ] && board[nextI][nextJ] == word.charAt(index)){
                //System.out.println(nextI + " " + nextJ);
                used[nextI][nextJ] = true;
                dfs(board, word, used, index+1, nextI, nextJ);
                used[nextI][nextJ] = false;
            }

        }

    }

    //solution
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (exist(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x+1, word, i+1)
                || exist(board, y, x-1, word, i+1)
                || exist(board, y+1, x, word, i+1)
                || exist(board, y-1, x, word, i+1);
        board[y][x] ^= 256;
        return exist;
    }
}
