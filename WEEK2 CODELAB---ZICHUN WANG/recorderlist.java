//week2 Q7
public class recorderlist {
    public void reorderList(ListNode head) {
        if (head == null) return;
        reorderList(head, head.next);
    }
    public ListNode reorderList(ListNode root, ListNode curr) {
        if (curr == null) return root;
        root = reorderList(root, curr.next);
        if (root == null) return null;
        ListNode temp = null;
        if (root == curr || root.next == curr) {
            curr.next = null;
        } else {
            temp = root.next;
            root.next = curr;
            curr.next = temp;
        }
        return temp;
    }
}
