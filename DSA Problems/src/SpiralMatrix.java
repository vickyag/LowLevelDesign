import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    public static void main(String... s){
        int[][] arr = new int[][]{{4, 1, 6, 8}, {3, 9, 2, 7}, {8, 2, 5, 6}, {7, 3, 9, 1}};
        int n = arr.length;
        boolean[][] visited = new boolean[n][n];
        List<Integer> ans = new ArrayList<>();
        for(boolean[] i: visited) Arrays.fill(i, false);
        int visitedCount = 0;
        int row = 0, col = 0;
        int totalElements = n*n;
        while(visitedCount < totalElements){
            while(col < n && !visited[row][col]){
                ans.add(arr[row][col]);
                visited[row][col] = true;
                visitedCount++;
                col++;
            }
            col--;
            row++;

            while(row < n && !visited[row][col]){
                ans.add(arr[row][col]);
                visited[row][col] = true;
                visitedCount++;
                row++;
            }
            row--;
            col--;

            while(col >= 0 && !visited[row][col]){
                ans.add(arr[row][col]);
                visited[row][col] = true;
                visitedCount++;
                col--;
            }
            col++;
            row--;

            while(row >=0  && !visited[row][col]){
                ans.add(arr[row][col]);
                visited[row][col] = true;
                visitedCount++;
                row--;
            }
            row++;
            col++;
        }

        System.out.println(ans);

    }
}
