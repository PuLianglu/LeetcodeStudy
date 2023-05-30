/**
 * @program: LeetcodeStudy
 * @description: <a href="https://leetcode.cn/problems/search-insert-position/">搜索插入位置</a>
 * @author: puLiangLu
 * @create: 2023-04-22 15:14
 *
 **/
public class search_insert_position {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (left <= right){
            if (target == nums[index]){
                return index;
            }else if (target > nums[index]){
                left = index + 1;
                index = (left + right) / 2;
            }else {
                right =  index - 1;
                index = (left + right) / 2;
            }
        }

        return index;
    }
}
