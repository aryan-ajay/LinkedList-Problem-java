class LinkedList {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }        
    }
    public static Node head;
    public static Node tail;

    public void addLast(int data) {
        Node newNode = new Node(data);
        //base case
        if(head == null) {
            head = tail = newNode;
            return;
        }
        // stape2 - link the node
        tail.next = newNode;
        tail = newNode;
    }
    // print function
    public void print() {
        Node temp = head;

        if(head == null) {
            System.out.println("Linkedlist is empty");
            return;
        }

        while(temp != null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void ZigZag() {
        //step1- find mid
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;  /*Mid is Found */

        //step 2 - reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        //Alternate mergining - ZigZag 
        while(left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            //update 
            left = nextL;
            right = nextR;
        }
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        //call print function
        ll.print();
        //call the ZinZag function
        ll.ZigZag();
        // again call print function
        ll.print();
    }
}