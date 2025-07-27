package Graph;

public class LC0733_FloodFill {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        dfsHelper(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    public void dfsHelper(int[][] image, int r, int c, int color, int origColor){
        if(r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != origColor) return;
        image[r][c] = color;

        for(int[] dir : dirs){
            int x = r + dir[0];
            int y = c + dir[1];
            dfsHelper(image, x, y, color, origColor);
        }
    }
}
