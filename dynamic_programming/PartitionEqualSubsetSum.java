/**
 * @program: LeetcodeStudy
 * @description: 分割等和子集
 * https://leetcode.cn/problems/partition-equal-subset-sum/
 * @author: puLiangLu
 * @create: 2023-06-27 15:25
 **/
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1,5,11,5};

        PartitionEqualSubsetSum a = new PartitionEqualSubsetSum();
        System.out.println(a.canPartition(nums));
        System.out.println("=============");


    }


    public boolean canPartition(int[] nums) {

        int sum = 0;
        //先统计求和
        for (int num:nums){
            sum += num;
        }

        //如果和是奇数，那么就不可能分成两个相等集合
        if (sum % 2 != 0){
            return false;
        }
        sum = sum / 2;
        //长度是从0-sum，所以数组长度为sum+1
        boolean[] dp = new boolean[sum + 1];
        //先初始化一下dp
        dp[0] = true;
        for (int target = 1; target <= sum; target++) {
            if (target == nums[0]){
                dp[target] = true;
            }else {
                dp[target] = false;
            }
        }

        //nums_index标识在nums的位置，
        //target标识在nums中取几个值之和能刚好等于target
        for (int nums_index = 1; nums_index < nums.length; nums_index++) {
            for (int target = sum; target >=0; target--) {
                if (target==sum && dp[target] ){
                    return true;
                }

                //当前元素直接就比要求的总和target大
                if ( target - nums[nums_index] > 0 ){
                    //分两种情况
                    //情况1，不需要当前元素nums_index，那么直接取最上层状态即可
                    //情况2，需要当前元素nums_index。那么剩下的就是target - num[nums_index] dp数组位置上的状态
                    dp[target] = dp[target] || dp[target - nums[nums_index]];
                }

            }
        }

        return dp[sum];
    }
}
