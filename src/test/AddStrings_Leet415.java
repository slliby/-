package test;

/*
两个超大数字字符串相加，很简单的了，转换成字符数组进行相加
 */
public class AddStrings_Leet415 {

    public static void main(String[] args){
        System.out.println(addStrings("6", "501"));

    }

    public static String addStrings(String num1, String num2){
        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();
        char[] res = new char[Math.max(num1.length(), num2.length()) + 1];
        int i = nums1.length - 1;
        int j = nums2.length - 1;
        int end = res.length - 1;
        int temp = 0;
        while(i >= 0 && j >= 0 ){
             int a = nums1[i] - '0';
             int b = nums2[j] - '0';
             res[end--] = (char) ('0' + (a + b + temp) % 10);
             temp = (a + b + temp) / 10;
             i--;
             j--;
        }
        while(i >= 0){
            int a = nums1[i] - '0';
            res[end--] = (char) ('0' + (a + temp) % 10);
            temp = (a + temp) / 10;
            i--;
        }

        while(j >= 0){
            int b = nums2[j] - '0';
            res[end--] = (char) ('0' + (b + temp) % 10);
            temp = (b + temp) / 10;
            j--;
        }
        int offset = 0;
        if(temp > 0){
            res[0] = (char) ('0' + temp);
        }else{
            offset = 1;
        }
        String s = String.valueOf(res);
        return s.substring(offset);
    }
}
