/**
 * @program: LeetcodeStudy
 * @description: 不同路径 II
 * https://leetcode.cn/problems/unique-paths-ii/
 * @author: puLiangLu
 * @create: 2023-06-14 15:48
 **/
public class UniquePathsII {

    public static void main(String[] args) {

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];


        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        if (obstacleGrid[m-1][n-1] == 1){
            return 0;
        }

        boolean flagN = true;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0 && flagN){
                dp[0][i] = 1;
            }else {
                dp[0][i] = 0;
                flagN = false;
            }
        }

        boolean flagM = true;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0 && flagM){
                dp[i][0] = 1;
            }else {
                dp[i][0] = 0;
                flagM = false;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j] ;
                }

            }
        }
        return dp[m-1][n-1];
    }
}
