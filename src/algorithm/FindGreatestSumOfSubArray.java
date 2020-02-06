package algorithm;

/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
 * 当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class FindGreatestSumOfSubArray {
    /**
     * 动规
     * 23ms
     * 9480k
     * 思路：通过遍历数组，用j遍历array，i记录开始位置，bestI记录最大值的i，bestJ记录最大值的j
     * @param array array
     * @return sum
     */
    public int findGreatestSumOfSubArray(int[] array) {
        int bestI=0,bestJ=0,sum=array[0],b=0,i=0;
        for(int j =0;j<array.length;j++){
            if(b>0){
                b+=array[j];
            }else {
                b=array[j];
                i=j;
            }
            if(b>sum){
                sum = b;
                bestI = i;
                bestJ = j;
            }
        }
        return sum;
    }
}