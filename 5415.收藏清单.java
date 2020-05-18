import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [5415] 收藏清单
 * 解题思路
    遍历所有的list，找出当前第i个list，是否属于其他list的子集。除此之外的都是题目所需结果。
    加快的方法：
    1.当前比对的是同一个list，直接跳过
    2.第i个list的长度，比第j个的长，则i一定不是j的子集，可以直接跳过。
    3.用set.containsAll方法去判断子集，而不是遍历list依次使用contains方法

    ps:如果使用list.containsAll方法，会超时
    因为list里面会遍历一遍比较的i的list和被比较j的list值，时间复杂度为O(n*m)
    而HashSet/HashMap则只需要遍历一次比较i的list的值，key-value用空间换了时间。时间复杂度为O(n)

    For a HashSet/HashMap this might be O(1) (best case, no collisions), so the overall runtime of containsAll would still be O(n)
    For an ArrayList, contains will take O(m) where m is the number items in the list (not the parameter), so the overall time for containsAll would be O(n*m)
    https://stackoverflow.com/questions/10199772/what-is-the-cost-of-containsall-in-java

 */

// @lc code=start
class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> rs = new ArrayList<Integer>();
        if (favoriteCompanies.size() == 0) {
            return rs;
        }
        if (favoriteCompanies.size() == 1) {
            rs.add(0);
            return rs;
        }
        int size = favoriteCompanies.size();
        // 找出 i 是否为 任意一个j的子集。 然后直接跳出循环，执行下一个i
        for (int i = 0; i < size; i++) {
            boolean flag = true;
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    continue;
                }
                // 我的长度小你，那我可能是你的子集
                if (favoriteCompanies.get(i).size() <= favoriteCompanies.get(j).size()) {
                    Set<String> set = new HashSet<>(favoriteCompanies.get(j));
                    if (set.containsAll(favoriteCompanies.get(i))) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                rs.add(i);
            }
        }
        return rs;
    }
}