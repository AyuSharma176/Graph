package Ques;
import java.util.*;
public class FloodFills {
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int orignal=image[sr][sc];
            if(orignal==color)return image;
            Queue<int[]> q = new LinkedList<>();
            int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
            q.add(new int[]{sr,sc});
            image[sr][sc]=color;
            while(!q.isEmpty()){
                int[] rv=q.poll();
                int r=rv[0];
                int c=rv[1];
                for(int[] d:dir){
                    int nr=r+d[0];
                    int nc=c+d[1];
                    if(nr>=0 && nr<image.length && nc>=0 && nc<image[0].length && image[nr][nc]==orignal){
                        image[nr][nc]=color;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            return image;
        }
    }
}
