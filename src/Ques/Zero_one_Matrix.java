package Ques;
import java.util.*;
public class Zero_one_Matrix {
    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            Queue<int[]> q=new LinkedList<>();
            int[][] ans= new int[mat.length][mat[0].length];
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[0].length;j++){
                    if(mat[i][j]==0){
                        ans[i][j]=0;
                        q.add(new int[]{i,j});
                    }else{
                        ans[i][j]=Integer.MAX_VALUE;
                    }
                }
            }
            int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
            while(!q.isEmpty()){
                int[] rv= q.poll();
                int r=rv[0];int c=rv[1];
                for(int[] d:dir){
                    int nr=r+d[0];
                    int nc=c+d[1];
                    if(nr>=0&& nr<mat.length && nc>=0 && nc<mat[0].length && ans[nr][nc]>ans[r][c]+1){
                        ans[nr][nc]=ans[r][c]+1;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            return ans;
        }
    }
}
