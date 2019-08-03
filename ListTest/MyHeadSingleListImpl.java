public class MyHeadSingleListImpl implements ICLinked{

    class Node {
        private int data;
        private Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
        //头结点
        public Node() {
            this.data = -1;
            this.next = null;
        }
    }

    private Node head;

    public MyHeadSingleListImpl() {
        this.head = new Node();
        this.head.next = this.head;
    }

    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = this.head.next;
        this.head.next = node;
    }

    @Override
    public void addLast(int data) {
        Node cur = this.head;
        while(cur.next != this.head) {
            cur = cur.next;
        }
        Node node = new Node(data);
        node.next = cur.next;
        cur.next = node;
    }
    private void checkIndex(int index) {
        if(index < 0 || index > getLength()){
            throw new UnsupportedOperationException("index位置不合法");
        }
    }
    @Override
    public boolean addIndex(int index, int data) {
        checkIndex(index);
        Node cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        //cur就是index位置的前驱
        Node node = new Node(data);
        node.next = cur.next;
        cur.next = node;
        return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head.next;
        while(cur != this.head) {
            if(cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    private Node searchPrev(int key){
        Node cur = this.head;
        while (cur.next != this.head) {
            if(cur.next.data == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public int remove(int key) {
        Node prev=searchPrev(key);
        if(prev == null) {
            return -1;
        }
        int oldData = 0;
        Node del = prev.next;
        oldData = del.data;
        prev.next = del.next;
        return oldData;
    }


    @Override
    public void removeAllKey(int key) {
        if(this.head == null || this.head.next == this.head) {
            return;
        }
        Node prev = this.head;
        Node cur = this.head.next;
        while (cur != this.head) {
            if(cur.data == key){
                prev.next = cur.next;
                cur = prev.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
    }

    @Override
    public int getLength() {
        int count = 0;
        Node cur = this.head.next;
        while(cur != this.head) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head.next;
        while (cur != this.head) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        while(this.head.next != this.head) {
            Node cur = this.head.next;
            this.head.next = cur.next;
        }
        this.head = null;
    }
}