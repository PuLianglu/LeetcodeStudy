/**
 * @program: LeetcodeStudy
 * @description: 二分查找
 * @author: puLiangLu
 * @create: 2023-04-22 14:18
 * @source <a href="https://leetcode.cn/problems/binary-search/">二分查找</a>
 **/
public class BinarySearch {

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        int middle  = nums.length / 2;
        while (right >= left){
            if (target == nums[middle ]){
                return middle ;
            }else if (target > nums[middle ]){
                left = middle + 1;
                middle  = (left + right) / 2 ;
            }else {
                right = middle - 1 ;
                middle  = (left + right) / 2 ;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
       int nums[] = new int[]{-1, 0, 3, 5, 9, 12};
       int target = 2;

       int m = search(nums,target);
        System.out.println(m);
    }
}
