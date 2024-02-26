class linkedList {
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
    public static int size;

    //add first
    public static void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public static void add(int idx, int data) {
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while(i < idx-1) {
            temp = temp.next;
            i++;
        }
        // i == idx-1 then
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static int removeFirst() {
        if(size == 0) {
            System.out.println("ll is empty!");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int value = head.data;
            head = tail = null;
            size = 0; 
            return value;
        }

        int value = head.data;
        head = head.next;
        size--;
        return value;
    }

    public static int removeList(){
        if(size == 0) {
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            return val;
        }
        Node prev = head;
        for(int i=0; i<size-2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }
    public int findTheKey(int key) {
        Node temp = head;
        int i=0;
        while (temp != null) {
            if(temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int helper(Node head, int key) {
        if(head == null) {
            return -1;
        }
        if(head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1) {
            return -1;
        }
        return idx+1;
    }
    public int recSearch(int key) {
        return helper(head, key);
    }

    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void removeFromNthnode(int n) {
        //caliculate size
        int size = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            size++;
        }

        if(size == 1) {
            head = head.next;
            return;
        }

        int i=1;
        int iToFind = size-n;
        Node prev = head;
        while (i<iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public boolean checkPlend() {
        if(head == null || head.next == null) {
            return true;
        }
        //find mid
        Node mid = findMid(head);

        //reverse 2nd node 
        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;

        // check 
        while (right != null) {
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    public static void print() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    
    public static void main(String[] args) {
        linkedList ll = new linkedList();
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(5);
        // ll.add(2, 90);
        
        // ll.print();
        
        // ll.removeFirst();
        // ll.print();
        // ll.removeList();
        
        // ll.print();
        // ll.reverse();
        ll.print();
        ll.reverse();
        ll.print();
        // System.out.println(ll.reverse());
        // System.out.println(ll.recSearch(10));
    }
}
