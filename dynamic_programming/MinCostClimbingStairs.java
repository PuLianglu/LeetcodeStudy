/**
 * @program: LeetcodeStudy
 * @description: 使用最小花费爬楼梯
 * @author: puLiangLu
 * @create: 2023-06-14 10:25
 **/
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] cost = {1,100};

        MinCostClimbingStairs a = new MinCostClimbingStairs();
        int b = a.minCostClimbingStairs(cost);

        System.out.println("==============");

    }

    public int minCostClimbingStairs(int[] cost) {

        if (cost.length <= 2){
            return 0;
        }
        //离自己两阶的台阶
        int a = 0;
        //理自己一阶的台阶
        int b = 0;

        for (int i = 2; i <= cost.length; i++) {
            int temp = Math.min(a+cost[i - 2],b + cost[i -1]);
            a = b;
            b = temp;
        }

        return b;
    }
}
