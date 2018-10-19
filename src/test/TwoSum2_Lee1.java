package test;

/*
两数之和等于目标数
很简单，无序的话用hash，这里升序
那么自然用双指针，一头一尾，想加等于就返回，大于就右边的左移，小于就左边的右移
后面的所谓的三数之和，四数，都是拆分最后成两数之和来求的
 */
public class TwoSum2_Lee1 {

    public static void main(String[] args){

    }

    public int[] twoSum(int[] numbers, int target){
        int[] res = new int[2];
        int begin = 0;
        int end = numbers.length - 1;
        while(begin < end){
            if(numbers[begin] + numbers[end] == target){
                break;
            }else if(numbers[begin] + numbers[end] < target){
                begin++;
            }else{
                end--;
            }
        }
        res[0] = begin + 1;
        res[1] = end + 1;
        return  res;
    }
}
