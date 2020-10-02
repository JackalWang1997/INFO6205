//week2 Q2
public class delateNfromM {
    static class Node
    {
        int data;
        Node next;
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    static class Main
    {
        public static void printList(Node head)
        {
            Node ptr = head;
            while (ptr != null)
            {
                System.out.print(ptr.data + " -> ");
                ptr = ptr.next;
            }
            System.out.println("null");
        }
        public static Node deleteNodes(Node head, int m, int n)
        {
            if (head == null || head.next == null) {
                return head;
            }
            Node prev = null, next;
            Node curr = head;
            for (int i = 1; curr != null && i <= m; i++)
            {
                prev = curr;
                curr = curr.next;
            }
            for (int i = 1; curr != null && i <= n; i++)
            {
                next = curr.next;
                curr = next;
            }
            prev.next = curr;
            deleteNodes(curr, m, n);
            return prev;
        }
    }
}
