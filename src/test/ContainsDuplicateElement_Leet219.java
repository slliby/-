package test;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateElement_Leet219 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] nums = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,1,2,3,4};
        System.out.println(containsNearbyDuplicate(nums, 10));
    }

    static public boolean containsNearbyDuplicate(int[] nums, int k) {
		/*Ѱ���ظ�Ԫ�أ�λ���������ܳ���k���ܼ򵥵�˫��ѭ��
		for(int i=0;i<nums.length-1;i++) {
			for(int j=i+1;j<nums.length && j<=i+k;j++) {
				if(nums[i] == nums[j])
					return true;
			}
		}
		return false;
		*/

        //���õķ������ǿռ任ʱ�䣬������һ��k���ļ��ϣ�Ȼ��ά������Ҳ�ܷ��㣬ÿ�γ�ȥ����
        //����Ӧ�ÿ���,Ȼ��ʵ���ǳ���ʱ�䣬����ʹ��set���У�set��ʱ�����ô����ĩ�о��о�
        Set<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if (record.contains(nums[i])) {
                return true;
            }
            record.add(nums[i]);
            if (record.size() == k+1) {
                record.remove(nums[i-k]);
            }
        }
        return false;
    }
}
