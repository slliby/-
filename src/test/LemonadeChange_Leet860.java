package test;

/**
 * 很简单的柠檬水找零问题了
 */
public class LemonadeChange_Leet860 {

    public static void main(String[] args){

        int[] bills = new int[]{5, 5, 5, 10, 20};
        System.out.println(lemonadeChange(bills));
    }

    public static boolean lemonadeChange(int[] bills){
        int[] num = new int[3];
        for(int i : bills){
            switch (i){
                case 5:
                    num[0]++;
                    break;
                case 10:
                    if(num[0] <= 0){
                        return false;
                    }
                    num[0]--;
                    num[1]++;
                    break;
                case 20:
                    if(num[0] < 1){
                        return false;
                    }else{
                        if(num[1] > 0){
                            num[0]--;
                            num[1]--;
                        }else if(num[0] < 3){
                            return false;
                        }else{
                            num[0] -= 3;
                        }
                    }
                    break;
            }
        }

        return true;
    }
}
