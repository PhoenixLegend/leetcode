
/**
 * [1456] 定长子串中元音的最大数目 | 滑动窗口
 * 在接触滑动窗口的思路之前，我第一时间能想到的方法是把字符串拆成数组，然后对每个数组的前缀再做一次for循环匹配前缀。虽然能得到正确结果，但是理所应当地超时。
 * 
 * 滑动窗口的好处在于，巧妙的利用了窗口的特性，在第一个窗口种遍历找出所有满足条件的数量。然后滑动窗口，只需要比较左边界和右边界的条件，一次遍历即可完成。
 * 
 */

class Solution {
    public static void main(String[] args) {
        System.out.println(maxVowels("ae", 2));
        // 1 <= k <= s.length
    }

    public static int maxVowels(String s, int k) {
        // windows = k;
        int count = 0;
        int max = 0;
        if (s.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < k; i++) {
            if ("aeiou".indexOf(s.charAt(i)) != -1) {
                count++;
            }
            max = count;
        }
        // 维护滑动窗口 左边元音就--，右边是元音就++
        int l = 0;
        int r = k + l - 1;
        while (r + 1 < s.length()) {
            if ("aeiou".indexOf(s.charAt(r + 1)) != -1) {
                count++;
            }
            if ("aeiou".indexOf(s.charAt(l)) != -1) {
                count--;
            }
            max = Math.max(max, count);
            l++;
            r++;
        }
        return max;
    }
}