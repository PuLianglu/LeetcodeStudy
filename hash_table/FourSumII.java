import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: LeetcodeStudy
 * @description: 四数相加II
 * https://leetcode.cn/problems/4sum-ii/
 * @author: puLiangLu
 * @create: 2023-06-07 09:44
 **/
public class FourSumII {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int a = 0;
        HashMap<Integer,Integer> mapA = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                if (mapA.containsKey(sum)){
                    mapA.put(sum,mapA.get(sum)+1);
                }else {
                    mapA.put(sum,1);
                }

            }
        }

        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int sum = nums3[i] + nums4[j];
                if (mapA.containsKey(0-sum)){
                    a = a + mapA.get(-sum);
                }
            }
        }
        return a;
    }
}
