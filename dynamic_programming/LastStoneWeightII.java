/**
 * @program: LeetcodeStudy
 * @description: 最后一块石头的重量 II
 * https://leetcode.cn/problems/last-stone-weight-ii/
 * @author: puLiangLu
 * @create: 2023-06-28 09:53
 **/
public class LastStoneWeightII {
    public static void main(String[] args) {
        LastStoneWeightII a = new LastStoneWeightII();
//        int[] stones = new int[]{31,26,33,21,40};
//        int[] stones = new int[]{2,7,4,1,8,1};
        int[] stones = new int[]{14,1,7,17,8,10};
        System.out.println(a.lastStoneWeightII2(stones));
        System.out.println("=====================");
    }

    /**
     * 这道题需要转换成01背包问题，将石头分成两堆，让质量之差最小
     * 那其实就是在这一堆石头里，找能组成最接近【总重量/2】的石头，
     * 也就是找不超过【总重量/2】的最大重量嘛，这就转换成背包01问题了
     * 同样，这道题可以想用普通的二维数组做，然后再用以为数组优化
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone:stones){
            sum += stone;
        }

        int halfSum = sum / 2;
        int[][] dp = new int [stones.length][halfSum+1];

        //init dp[0][]
        for (int i = 0; i <= halfSum; i++) {
            if (i < stones[0]){
                dp[0][i] = 0;
            }else {
                dp[0][i] = stones[0];
            }

        }

        int flag = 0;
        for (int stoneIndex = 1;  stoneIndex< stones.length; ++stoneIndex){
            for (int target = 0; target <= halfSum; target++){
                //if target< stones[stoneIndex], Not necessary add stones[stoneIndex]
                if (target < stones[stoneIndex]){
                    dp[stoneIndex][target] = dp[stoneIndex - 1][target];
                }else {
                    dp[stoneIndex][target] = Math.max(dp[stoneIndex - 1][target],
                                              dp[stoneIndex - 1][target - stones[stoneIndex]] + stones[stoneIndex]  );
                }
            }
//            if (dp[stoneIndex][halfSum] == halfSum){
//                flag = stoneIndex;
//                break;
//            }
        }
        return sum - 2*dp[stones.length-1][halfSum];
    }

    /**
     * 使用滚动数组来实现
     * @param stones
     * @return
     */
    public int lastStoneWeightII2(int[] stones) {
        int sum = 0;
        for (int stone:stones){
            sum += stone;
        }
        int halfSum = sum / 2;
        int[] dp = new int[halfSum + 1];

        for (int i = 0; i <= halfSum; ++i){
            if (i < stones[0]){
                dp[i] = 0;
            }else {
                dp[i] = stones[0];
            }
        }

        for (int stoneIndex = 1; stoneIndex < stones.length; stoneIndex++){
            for (int target = halfSum; target >= 0; target--){
                if (target >= stones[stoneIndex]){
                    dp[target] =
                            Math.max(dp[target],dp[target - stones[stoneIndex]] + stones[stoneIndex]);
                }
            }
        }

        return sum - 2 * dp[halfSum];

    }
}
