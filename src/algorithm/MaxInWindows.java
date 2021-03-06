package algorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInWindows {
    ////思路：用一个大顶堆，保存当前滑动窗口中的数据。滑动窗口每次移动一格，就将前面一个数出堆，后面一个数入堆。
    //152ms
    //14936k
    PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1,o2)->o2-o1);
    ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        if(num==null||num.length==0||size<=0||size>num.length){
            return result;
        }
        int count = 0;
        for(;count<size;count++){//初始化滑动窗口
            maxQueue.offer(num[count]);
        }
        while (count<num.length){//对每次操作，找到最大值（用优先队列的大顶堆），然后向后滑动（出堆一个，入堆一个）
            result.add(maxQueue.peek());
            maxQueue.remove(num[count-size]);
            maxQueue.add(num[count]);
            count++;
        }
        result.add(maxQueue.peek());//最后一次入堆后没保存结果，这里额外做一次即可
        return result;
    }
}
