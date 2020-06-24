import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static int getValue(int[] gifts, int n) {
        int max = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i; j < n; j++) {
                // 计算每个元素的个数
                if (gifts[i] == gifts[j]) {
                    count++;
                }
            }
            if (count < (n / 2)) {
                // 如果个数小于 (n / 2), 则输出依然为 0.
                count = 0;
            }
            // 放入 map 中, 方便找出对应元素
            map.put(count, gifts[i]);
        }
        for (Integer count : map.keySet()) {
            // 遍历 map, 找出最大值
            if (count > sum) {
                sum = count;
                max = map.get(count);
            }
        }
        return max;
    }

    public static void main1(String[] args) {
        // 春节期间小明使用微信收到很多个红包，非常开心。
        // 在查看领取红包记录时发现，某个红包金额出现的次数超过了红包总数的一半。
        // 请帮小明找到该红包金额。写出具体算法思路和代码实现，要求算法尽可能高效。

        // 给定一个红包的金额数组 gifts 及它的大小 n，请返回所求红包的金额。
        // 若没有金额超过总数的一半，返回 0。

        // 测试样例：
        // [1, 2, 3, 2, 2], 5
        // 返回：2

        int[] gifes = {2, 3, 8, 4, 6, 1, 4, 3};
        int n = 8;
        int ret = getValue(gifes, n);
        System.out.println(ret);
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

class Partition {
    public ListNode partition(ListNode pHead, int x) {
        // 编写代码，以给定值 x 为基准将链表分割成两部分，所有小于 x 的结点排在大于或等于 x 的结点之前
        // 给定一个链表的头指针 ListNode pHead，请返回重新排列后的链表的头指针。
        // 注意：分割以后保持原来的数据顺序不变。
        
        ListNode node = new ListNode(-1);
        ListNode node1 = new ListNode(-1);
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        //设置两个链表
        //小于x的结点链表：head 为头结点，tail 为尾结点
        ListNode head = node;
        ListNode tail = node;
        //大于或等于x的结点链表：h 为头结点，t 为尾结点
        ListNode h = node1;
        ListNode t = node1;

        ListNode cur = pHead;
        while (cur != null) {
            if(cur.val < x) {
                tail.next = cur;
                tail = tail.next;
            }else {
                t.next = cur;
                t = t.next;
            }
            cur = cur.next;
        }
        tail.next = h.next;
        t.next = null;
        return head.next;
    }
}

class TestDemo {
    public static void main3(String[] args) {
        System.out.printf("%d\n", foo(20, 13)); // 81
    }

    private static int foo(int x, int y) {
        // 共调用 5 次
        if (x <= 0 || y <= 0) {
            return 1;
        }
        return 3 * foo(x - 6, y / 2);
    }
}

class Main {
    public static void main4(String[] args) {
        // 有一对兔子，从出生后第 3 个月起每个月都生一对兔子.
        // 小兔子长到第三个月后每个月又生一对兔子
        // 假如兔子都不死，问每个月的兔子总数为多少.

        // 输入 int 型表示 month
        // 输出兔子总数 int 型

        // 输入 9
        // 输出 34

        // 第一个月-----------------1对
        // 第二个月-----------------1对
        // 第三个月-----------------2对
        // 第四个月-----------------3对
        // 第五个月-----------------5对
        // 第六个月-----------------8对
        // 第七个月-----------------13对

        // 可以总结出:
        // 其实兔子总数相当于 斐波那契数列.

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int monthCount = sc.nextInt();
            System.out.println(getTotalCount(monthCount));
        }
    }
    private static int getTotalCount(int monthCount) {
        if (monthCount == 0) {
            return 0;
        }
        if (monthCount == 1 || monthCount == 2) {
            return 1;
        }
        return getTotalCount(monthCount - 1) + getTotalCount(monthCount - 2);
    }
}