/**
 * @program: LeetcodeStudy
 * @description: <a href='https://leetcode.cn/problems/minimum-size-subarray-sum/'>长度最小的子数组</>
 * @author: puLiangLu
 * @create: 2023-05-29 15:27
 **/
public class minSubArrayLen {

    /**
     * 滑动窗口法
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        //current array length
       int current_length = 0;
       int min = 0;
       int start = 0, end = 0;
       int sum = 0;
       while (end < nums.length){
           sum = sum + nums[end];
           current_length++;
           if (sum < target){
               end++;
           }else {
               if (min == 0 || min > current_length){
                   min = current_length;
               }
               sum = sum - nums[start] - nums[end];
               current_length = current_length - 2 ;
               start++;
           }
       }
        return min;
    }

    /**
     * 题解2更清晰，用了两个while循环，我只用了一个，
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen2(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5};
        int target = 11;
        int a = minSubArrayLen(target,nums);

        System.out.println("==================");
    }

}
