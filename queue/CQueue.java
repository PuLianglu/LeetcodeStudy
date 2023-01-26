import java.util.LinkedList;

/**
 * @program: LeetcodeStudy
 * @description:  题目来自于  https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * @author: puLiangLu
 * @create: 2023-01-26 12:32
 **/
class CQueue {
    //入队
    LinkedList<Integer> stack1;
    //出队
    LinkedList<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList();
        stack2 = new LinkedList();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        //出队的栈为空，就从入队的栈拿数据，两个栈都没数据返回-1
        if(stack2.size() == 0 ){
            if (stack1.size() == 0){
                return -1;
            }else {
                while (stack1.size() > 0){
                    stack2.push(stack1.pop());
                }
                return stack2.removeLast();
            }
        }else {
            return stack2.removeLast();
        }
    }
}
