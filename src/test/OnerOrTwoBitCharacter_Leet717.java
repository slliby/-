package test;

public class OnerOrTwoBitCharacter_Leet717 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    static public boolean isOneBitCharacter(int[] bits) {
        if(bits.length == 1)
            return true;

        if(bits[bits.length - 2] == 0)
            return true;

        int num = 1;
        for(int i=bits.length-2;i>=0;i--) {
            if(bits[i] == 0)
                break;
            num++;
        }
        if(num%2 == 1)
            return true;
        return false;

    }

}
