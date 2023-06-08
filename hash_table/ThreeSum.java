import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetcodeStudy
 * @description: 三数之和
 * https://leetcode.cn/problems/3sum/
 * @author: puLiangLu
 * @create: 2023-06-07 14:44
 **/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //先排序
        Arrays.sort(nums);
        if (nums == null || nums.length < 3){
            return res;
        }
        for (int i = 0; i < nums.length-2; i++) {
            //对于有序数组，如果第一个元素就大于0，
            // 那么后面的元素之和不可能等于0
            if (nums[i] > 0){
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int l = i +1;
            int r = nums.length - 1;

            while (l < r){

                int x = nums[i] + nums[l] + nums[r] ;
                if (x == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    //去掉重复元素影响
                    // 左指针要找到第一个不重复的元素
                    while ((l < r) && nums[l] == nums[l+1]){
                        l++;
                    }
                    //右指针找到第一个不重复的元素
                    while ((l < r) && nums[r] == nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                }else if (x < 0){
                    l++;
                }else {
                    r--;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        ThreeSum a = new ThreeSum();
        int[] b = {0,0,0};
        a.threeSum(b);

        System.out.println("==========");
    }

}
