package list;

//https://leetcode.com/problems/add-two-numbers/

public class _2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 0. Guard condition
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode ans = l1, l = l1, r = l2;
        ListNode pre = null;
        int carry = 0;
        while (l != null || r != null) {
            // 1. Add value to l1, move both l&r
            if (l != null && r != null) {
                l.val += r.val + carry;
                carry = l.val / 10;
                l.val %= 10;
                pre = l;
                l = l.next;
                r = r.next;
                // link tail of l1 to r
                if (l == null) {
                    pre.next = r;
                }
            }
            // 2. Skip l2 and add value to l1, move l
            else if (l != null) {
                l.val += carry;
                carry = l.val / 10;
                l.val %= 10;
                pre = l;
                l = l.next;
                if (carry == 0) {
                    break;
                }
            }
            // 3. Skip l1 and add value to l2, move r
            else {
                r.val += carry;
                carry = r.val / 10;
                r.val %= 10;
                pre = r;
                r = r.next;
                if (carry == 0) {
                    break;
                }
            }
        }

        // 4. Append carry to tail if it's non-zero
        if (carry != 0) {
            pre.next = new ListNode(carry);
        }

        return ans;
    }
}
