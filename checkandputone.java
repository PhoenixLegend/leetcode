/**
 * i++和++i的区别使用： 先说结论: ++i，先运算后使用;i++，先使用后运算
 * 
 * 这里我简单描述一个生产过程中可能会遇到的场景，用于区分二者的使用情况。 从下面这个简单的迭代示例代码可以测试出来：
 * 1.这段代码传递一个迭代的方法，返回值大于5次之后return true 结束迭代 2.从思路上来讲，retryNum的值会在每次迭代之后加一
 * 3.结果a：retryNum++的话，作为参数传递的值还是retryNum本身不变，陷入死循环，stackoverflow
 * 3.结果b：++retryNum的话，作为参数传递的值还是retryNum先加一之后的值，最后成功退出迭代
 */

public class checkandaputone {
    public static void main(String[] args) {
        checkandaddone(1);

    }

    public static boolean checkandaddone(int retryNum) {
        if (retryNum > 5) {
            return true;
        }
        // return checkandaddone(retryNum++);
        return checkandaddone(++retryNum);
    }
}