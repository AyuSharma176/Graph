package Ques;
import java.util.*;
public class RottenOranges {
    class Solution {
        public int orangesRotting(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            Queue<int[]> q = new LinkedList<>();
            int fresh = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 2) {
                        q.add(new int[]{i, j});
                    } else if (grid[i][j] == 1) {
                        fresh++;
                    }
                }
            }

            if (fresh == 0) return 0;

            int min = 0;
            int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};

            while (!q.isEmpty()) {
                int size = q.size();
                boolean rotThisMinute = false;

                for (int i = 0; i < size; i++) {
                    int[] rv = q.poll();
                    int r = rv[0], c = rv[1];

                    for (int[] d : dir) {
                        int nr = r + d[0];
                        int nc = c + d[1];

                        if (nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 1) {
                            grid[nr][nc] = 2;
                            q.add(new int[]{nr, nc});
                            fresh--;
                            rotThisMinute = true;
                        }
                    }
                }

                if (rotThisMinute) {
                    min++;
                }
            }

            if(fresh==0){
                return min;
            }else{
                return -1;
            }
        }
    }

}
