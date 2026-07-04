import java.math.BigInteger;
import java.util.Arrays;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        System.out.println("real value of l1 ==>" + getRealValue(l1));
        System.out.println("real value of l2 ==>" + getRealValue(l2));
        BigInteger l1Val = getRealValue(l1);
        BigInteger l2Val = getRealValue(l2);
        BigInteger sum = l1Val.add(l2Val);

        System.out.println("sum ==>" + sum);
        StringBuilder reversedSumStr = new StringBuilder();
        BigInteger tempSum = sum;

        if (sum.equals(BigInteger.ZERO)) {
            reversedSumStr.append(0);
        } else {
            while (tempSum.compareTo(BigInteger.ZERO) > 0) {
                BigInteger remainder = tempSum.remainder(BigInteger.valueOf(10));
                reversedSumStr.append(remainder);
                tempSum = tempSum.divide(BigInteger.valueOf(10));
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

    public static BigInteger getRealValue(ListNode head) {
        int count = 0;
        ListNode current = head;
        BigInteger realVall1 = BigInteger.ZERO;
        while (current != null) {
            realVall1 = realVall1.add(getValue(count, current.val));
            count++;
            current = current.next;
        }
        return realVall1;
    }

    public static BigInteger getValue(int count, int val) {
        // Use BigInteger.valueOf and BigInteger.TEN.pow for integer power of 10
        return BigInteger.valueOf(val).multiply(BigInteger.TEN.pow(count));
    }
}
