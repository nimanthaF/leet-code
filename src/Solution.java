import java.util.Arrays;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        System.out.println("real value of l1 ==>" + getRealValue(l1));
        System.out.println("real value of l2 ==>" + getRealValue(l2));
        long l1Val = getRealValue(l1);
        long l2Val = getRealValue(l2);
        long sum = l1Val + l2Val;

        System.out.println("sum ==>" + sum);
        StringBuilder reversedSumStr = new StringBuilder();
        long tempSum = sum;

        if (sum == 0) {
            reversedSumStr.append(0);
        } else {
            while (tempSum > 0) {
                long remainder = tempSum % 10;
                reversedSumStr.append(remainder);
                tempSum = tempSum / 10;
            }
        }

        System.out.println("reversedSumStr ===>" + reversedSumStr);
        int[] digits = reversedSumStr.chars() // Streams the ASCII/Unicode values of characters
                .map(Character::getNumericValue) // Converts '0' -> 0, '1' -> 1
                .toArray();

        System.out.println("digits ==>" + Arrays.toString(digits));
        return createList(digits);
    }

    public static ListNode createList(int[] digits) {
        System.out.println("digits[0]  ==>" + digits[0]);
        ListNode head = new ListNode(digits[0]);
        ListNode current = head;

        for (int i = 1; i < digits.length; i++) {
            current.next = new ListNode(digits[i]);
            current = current.next;
        }

        return head;
    }

    public static long getRealValue(ListNode head) {
        int count = 0;
        ListNode current  = head;
        long realVall1 = 0;
        while ( current != null) {
            realVall1 = realVall1 + getValue(count, current.val);
            count++;
            current = current.next;
        }
        return realVall1;
    }

    public static long getValue(int count, long val) {
        return (long) (val * Math.pow(10, count));
    }
}
