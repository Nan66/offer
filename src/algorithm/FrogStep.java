/**
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������
 * */
package algorithm;

public class FrogStep {
    public int JumpFloor(int target) {
        if(target==1){
            return 1;
        }
        else if(target==2)
            return 2;
        else
            return JumpFloor(target-1)+JumpFloor(target-2);
    }
}
