package Ques;
import java.util.*;
public class Surrounded_regions {
    class Solution {
        public void solve(char[][] board) {

            int row=board.length;
            int col=board[0].length;

            for(int i=0;i<row;i++){
                if(board[i][0]=='O'){
                    bfs(board,i,0);
                }
                if(board[i][col-1]=='O'){
                    bfs(board,i,col-1);
                }
            }
            for(int i=0;i<col;i++){
                if(board[0][i]=='O'){
                    bfs(board,0,i);
                }
                if(board[row-1][i]=='O'){
                    bfs(board,row-1,i);
                }
            }
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(board[i][j]=='O'){
                        board[i][j]='X';
                    }
                    if(board[i][j]=='S'){
                        board[i][j]='O';
                    }
                }
            }

        }
        private void bfs(char[][] board, int r, int c) {
            int m = board.length;
            int n = board[0].length;
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{r, c});
            board[r][c] = 'S';

            int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
            while (!q.isEmpty()) {
                int[] curr = q.poll();
                int x = curr[0], y = curr[1];
                for (int[] d : dir) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 'O') {
                        board[nx][ny] = 'S';
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
