import java.util.ArrayList;
import java.util.List;

public class Leetcode54 {
    
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0||matrix[0].length == 0){
            return new ArrayList<>();
        }
        int [][] corners = new int[][]{
            {0, 0}, 
            {0, matrix[0].length-1}, 
            {matrix.length-1, matrix[0].length-1},
            {matrix.length-1, 0}
        };

        List<Integer> res = new ArrayList<>();
        l2r(matrix, corners, res);
        return res;
    }

    public void l2r(int[][] matrix, int[][] corners, List<Integer> res){

        if (corners[0][1] > corners[1][1]) return;
        for (int i = corners[0][1]; i <= corners[1][1]; i++) {
            res.add(matrix[corners[0][0]][i]);
        }
        corners[0][0]++;
        corners[1][0]++;
        u2d(matrix, corners, res);

    }

    public void u2d(int[][] matrix, int[][] corners, List<Integer> res){
        if (corners[1][0] > corners[2][0]) return;

        for (int i = corners[1][0]; i <= corners[2][0]; i++) {
            res.add(matrix[i][corners[1][1]]);
        }
        corners[1][1]--;
        corners[2][1]--;
        r2l(matrix, corners, res);

    }

    public void r2l(int[][] matrix, int[][] corners, List<Integer> res){
        if (corners[2][1] < corners[3][1]) return;

        for (int i = corners[2][1]; i >= corners[3][1]; i--) {
            res.add(matrix[corners[2][0]][i]);
        }
        corners[2][0]--;
        corners[3][0]--;

        d2u(matrix, corners, res);

    }

    public void d2u(int[][] matrix, int[][] corners, List<Integer> res){
        if (corners[3][0] < corners[0][0]) return;

        for (int i = corners[3][0]; i >= corners[0][0]; i--) {
            res.add(matrix[i][corners[3][1]]);
        }
        corners[3][1]++;
        corners[0][1]++;

        l2r(matrix, corners, res);

    }
}
