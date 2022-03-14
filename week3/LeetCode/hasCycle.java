/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {    //当链表为空或者只有一个节点，则直接返回false
            return false;
        }
        ListNode slow = head;   //定义快慢指针的起点
        ListNode fast = head.next;
        while (slow != fast) {  //当slow和fast不相等时循环
            if (fast == null || fast.next == null) {
                //若快指针走到头了，则肯定没有环
                return false;
            }
            //否则慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
