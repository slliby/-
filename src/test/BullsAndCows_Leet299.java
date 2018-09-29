package test;

/*最近刚开始实习，好久没刷题了，哈哈哈
 * 猜数字问题，其实就是找两个字符串相同位置重复的数字个数以及除开这些重复的，相同却异位的个数
 * 思路很简单，用一个数组保存当前的存储字符，就是没有被对应的取走的字符，emmm我可能解释的不太清楚
 * 同时遍历，一个位置上如果相同，那么bull++
 * 如果不同，先判断guess的位置上的字符在存储数组中存储个数是否大于0，大于0说明原字符串存了一些进去，那么就存在异位的
 * 那么cow++，然后不管是否找到，都要把对应下标存储数组位置-1，因为原字符串也要进来找对应的
 * 然后原字符串对应的字符进来找是否数量小于0，小于0说明guess数组缺少对应的，那么cow++，
 * 然后无论找不找到，数量++，easy
 *
 */

public class BullsAndCows_Leet299 {

    public static void main(String[] args) {
        System.out.println(getHint("1123", "0111"));
    }

    static public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        int[] num = new int[10];
        for(int i=0;i<secret.length();i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bull++;
            }else {
                if(num[guess.charAt(i) - '0'] > 0) {
                    cow++;
                }
                num[guess.charAt(i) - '0']--;
                if(num[secret.charAt(i) - '0'] < 0) {
                    cow++;
                }
                num[secret.charAt(i) - '0']++;
            }
        }

        String s = bull + "A" + cow + "B";
        return s;
    }

}
