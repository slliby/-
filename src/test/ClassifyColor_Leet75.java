package test;

public class ClassifyColor_Leet75 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] nums= new int[]{2,0,2,1,1,0};
        sortColors(nums);
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
    //颜色分类问题，其实就是包含三种数字的数组，要求是把相同数字放在一起
    //只便利一次，同时使用原地空间复杂度
    //还是比较简单，思路就是三个指针，分别表示三种颜色，开始begin指向开头，last和end指向末尾
    //然后从前向后遍历，如果是0就继续向后走，如果是一就把他和last上的数字交换，然后last--，
    //如果是2就把他和end的数字交换，然后由于end数字就是last的最后面（并不一定为1的）,所以在交换一次把他放到last最前面去就行，这是last--，end--
    //遍历知道begin指针大于last指针为止，相等时也要判断，因为一开始时假如就有序反而这样会破坏了顺序，因此所有元素都要遍历一遍
    static public void sortColors(int[] nums) {
        if(nums.length == 0)
            return;

        int begin = 0;
        int last = nums.length-1;
        int end = last;
        int temp = 0;
        while(begin<=last){
            if(nums[begin] == 1){
                temp = nums[begin];
                nums[begin] = nums[last];
                nums[last] = temp;
                last--;
            }else if(nums[begin] == 2){
                temp = nums[begin];
                nums[begin] = nums[last];
                nums[last] = nums[end];
                nums[end] = temp;
                end--;
                last--;
            }else{
                begin++;
            }
        }
    }
}
