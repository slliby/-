package test;

/*
盛水最多的容器，这题目关键在于理解关键点
就是面积 = 底 * 高，那么每次比较都是移动一位比较，底的变化固定了
关键在于高，而高又是选择两边更小的那边作为边，那么就很简单了，可以双指针
然后每次移动更小的那条边向中间移动并且计算新面积是否更大，一直到左右两边相遇

其实这题最重要的就是明白怎么移动，因为怒移动更大的那条边是没用的，另一边不增大面积最大就是不变而已
 */
public class MaxArea_Leet11 {

    public static void main(String[] args){

        int[]height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height){
        int begin = 0;
        int end = height.length - 1;
        int maxArea = Math.min(height[begin], height[end]) * (end - begin);
        while(begin < end - 1){
            //System.out.println("maxArea: " + maxArea);
            if(height[begin] > height[end]){
                end--;
            }else{
                begin++;
            }

            maxArea = Math.max(maxArea, Math.min(height[begin], height[end]) * (end - begin));
        }



        return maxArea;
    }
}
