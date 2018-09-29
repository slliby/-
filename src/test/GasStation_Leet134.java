package test;

public class GasStation_Leet134 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    /*其实就是判断两个数组，能不能从一点出发，便利两个数组
     * 其中一个的累加和永远大于另外一个
     * 那么先判断两个数组的总和大小，如果总和大于另一个，那么必然有解
     * 寻找解的过程就是从头出发，如果当前的累加和大于小号的累加和，那么向后遍历
     * 但是假如小于，那么说明这段都不可能成功，由于这段全是大于的，减去一段只会更加不满足
     * 就是正数减去证书只会变小，所以就是从不满足的下一个位置开始继续重复这个过程
     * 因此时间复杂度为O（n）
     */
    static public int canCompleteCircuit(int[] gas, int[] cost) {
        //先判断有没有解
        int sum = 0;
        for(int i=0;i<gas.length;i++) {
            sum += gas[i] - cost[i];
        }
        if(sum < 0)
            return -1;
        int i = 0;
        for(i=0;i<gas.length;i++) {
            int total = 0;
            int j = i;
            for(j=i;j<gas.length;j++) {
                total += gas[j] - cost[j];
                if(total < 0) {
                    i = j;
                    break;
                }
            }
            if(j == gas.length) {
                break;
            }
        }
        return i;
    }
}
