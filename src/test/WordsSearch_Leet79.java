package test;


public class WordsSearch_Leet79 {

    //单词搜索
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        char[][] board = new char[][]{{'A','B','C','F'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";
        System.out.println(exist(board, word));

    }
    //寻找路径问题，很简单的回溯，思路是先找到符合字符串开头的位置，然后递归查找附近位置，满足的位置标记为true，因此需要一个辅助空间
    //然后一直找，找到直接返回，找不到把刚才标志改回false，回溯继续查找
    //题目不算难，尴尬的是我一开始把返回结果boolean变量也放到方法里作为一个形参了，由于是值传递。。。所以不会改变结果，导致一直出错，很难受
    static public boolean exist(char[][] board, String word) {

        if(word.length()==0)
            return true;
        boolean[][] temp = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    temp[i][j] = true;
                    if(isExist(board, word, 1, temp, i, j))
                        return true;
                    //找到路径了直接返回


                    temp[i][j] = false;
                }
            }
        }

        return false;
    }
    static boolean isExist(char[][] board,String word,int index,boolean[][] temp,int row,int col){
        if(index==word.length()){
            return true;
        }
        char c = word.charAt(index);

        //System.out.println("board[row][col-1]:"+board[row][col-1]);
        //上
        if(row>0&&board[row-1][col]==c&&!temp[row-1][col]){
            temp[row-1][col] = true;
            if(isExist(board, word, index+1, temp, row-1, col))
                return true;
            //回溯为原来状态
            temp[row-1][col] = false;
        }
        //左
        if(col>0&&board[row][col-1]==c&&!temp[row][col-1]){
            temp[row][col-1] = true;
            if(isExist(board, word, index+1, temp, row, col-1))
                return true;
            temp[row][col-1] = false;
        }
        //下
        if(row<board.length-1&&board[row+1][col]==c&&!temp[row+1][col]){
            temp[row+1][col] = true;
            if(isExist(board, word, index+1, temp, row+1, col))
                return true;
            //回溯回复原来状态
            temp[row+1][col] = false;
        }
        //右
        if(col<board[0].length-1&&board[row][col+1]==c&&!temp[row][col+1]){
            temp[row][col+1] = true;
            if(isExist(board, word, index+1, temp, row, col+1))
                return true;
            //回溯回复原来状态
            temp[row][col+1] = false;
        }
        return false;
    }

}

