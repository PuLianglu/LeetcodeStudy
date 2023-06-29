/**
 * @program: LeetcodeStudy
 * @description: 目标和
 * https://leetcode.cn/problems/target-sum/
 * @author: puLiangLu
 * @create: 2023-06-28 18:44
 **/
public class TargetSum {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        int target = 3;
        TargetSum s = new TargetSum();
        System.out.println(s.findTargetSumWays(nums,target));
        System.out.println("===========");
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num:nums){
            sum += num;
        }

        if (sum < target){
            return 0;
        }

        if ((sum + target) % 2 != 0 ){
            return 0;
        }
        int halfSum = (sum + target) / 2;

        int[] dp = new int[halfSum+1];

        for (int i = 0; i <= halfSum; i++){
            if (i == 0 && i == nums[0]){
                dp[i] = 2;
            }else if (i == 0 || i == nums[0]){
                dp[i] = 1;
            }
        }

        for (int numIndex = 1; numIndex < nums.length; numIndex++){
            for (int j = halfSum; j >= 0; j--){
                if (j >= nums[numIndex]){
                    dp[j] = dp[j] + dp[j-nums[numIndex]];
                }
            }
        }

        return dp[halfSum];
    }
}
