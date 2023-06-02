/**
 * @program: LeetcodeStudy
 * @description: <a href='https://leetcode.cn/problems/spiral-matrix-ii/'>螺旋矩阵</>
 * @author: puLiangLu
 * @create: 2023-05-30 14:29
 **/
public class generateMatrix {
    public static  int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++) {
                mat[t][i] = num++; // left to right.
            }
            t++;
            for(int i = t; i <= b; i++) {
                mat[i][r] = num++; // top to bottom.
            }
            r--;
            for(int i = r; i >= l; i--) {
                mat[b][i] = num++; // right to left.
            }
            b--;
            for(int i = b; i >= t; i--) {
                mat[i][l] = num++; // bottom to top.
            }
            l++;
        }
        return mat;

    }


    public static void main(String[] args) {
        int matrix[][];
        matrix = generateMatrix(2);
        System.out.println(matrix);
        System.out.println("===============");
    }
}
