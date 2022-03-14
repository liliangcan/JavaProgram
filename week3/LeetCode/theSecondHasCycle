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
        Set<ListNode> temp = new HashSet<ListNode>();
        while (head != null) {
            if (!temp.add(head)) {  //若已经添加过则说明有环
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
