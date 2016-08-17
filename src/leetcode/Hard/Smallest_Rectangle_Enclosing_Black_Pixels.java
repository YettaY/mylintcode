package leetcode.Hard;

/**
 * Created by yanglu on 16/8/8.
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

 For example, given the following image:

 [
 "0010",
 "0110",
 "0100"
 ]
 and x = 0, y = 2,
 Return 6.

 * DFS or BFS is the intuitive solution for this problem while the problem is with a tag "binary search".
 * So can anyone provide a binary search answer.
 * DFS complexity is O(m * n) and if binary search it would be O(n * lgm + m * lgn)
 */
public class Smallest_Rectangle_Enclosing_Black_Pixels {
    //Solution 1:
//    private int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = 0, maxY = 0;
//    public int minArea(char[][] image, int x, int y) {
//        if(image == null || image.length == 0 || image[0].length == 0) return 0;
//        dfs(image, x, y);
//        return(maxX - minX + 1) * (maxY - minY + 1);
//    }
//    private void dfs(char[][] image, int x, int y){
//        int m = image.length, n = image[0].length;
//        if(x < 0 || y < 0 || x >= m || y >= n || image[x][y] == '0') return;
//        image[x][y] = '0';
//        minX = Math.min(minX, x);
//        maxX = Math.max(maxX, x);
//        minY = Math.min(minY, y);
//        maxY = Math.max(maxY, y);
//        dfs(image, x + 1, y);
//        dfs(image, x - 1, y);
//        dfs(image, x, y - 1);
//        dfs(image, x, y + 1);
//    }

    //Solution 2:
    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        int colMin = binarySearch(image, true, 0, y, 0, m, true);
        int colMax = binarySearch(image, true, y + 1, n, 0, m, false);
        int rowMin = binarySearch(image, false, 0, x, colMin, colMax, true);
        int rowMax = binarySearch(image, false, x + 1, m, colMin, colMax, false);
        return (rowMax - rowMin) * (colMax - colMin);
    }

    public int binarySearch(char[][] image, boolean horizontal, int lower, int upper, int min, int max, boolean goLower) {
        while(lower < upper) {
            int mid = lower + (upper - lower) / 2;
            boolean inside = false;
            for(int i = min; i < max; i++) {
                if((horizontal ? image[i][mid] : image[mid][i]) == '1') {
                    inside = true;
                    break;
                }
            }
            if(inside == goLower)
                upper = mid;
            else
                lower = mid + 1;
        }
        return lower;
    }

}
