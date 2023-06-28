/**
 * @program: LeetcodeStudy
 * @description: 不同路径
 * https://leetcode.cn/problems/unique-paths/
 * @author: puLiangLu
 * @create: 2023-06-14 15:27
 **/
public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths a = new UniquePaths();
        int b =a.uniquePaths(3,7);

        System.out.println("===============");

    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0 && j==0){
                    dp[0][0] = 1;
                }else if (i == 0){
                    dp[i][j] = dp[i][j-1];
                }else if (j ==0){
                    dp[i][j] = dp[i-1][j] ;
                }else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j] ;
                }

            }
        }
        return dp[m-1][n-1];
    }
}
