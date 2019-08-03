import javax.xml.stream.events.NotationDeclaration;

public class MySingleListImpl implements ILinked{

    class Node {
        private int data;
        public Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }//节点类

    private Node head;
    public MySingleListImpl() {
        this.head = null;
    }

    public Node getHead() {
        return head;
    }

    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        if(this.head != null){
            node.next = this.head;
            this.head = node;
        } else {
            this.head=node;
        }
    }



   /* public void addFirst(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }
    }
*/
    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        //如果是第一次插入的时候
        if(cur == null) {
            this.head = node;
        }else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }

    }
    /*public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        //如果是第一次插入
        if(cur == null) {
            this.head = node;
        }else {
            //1、找尾巴
            while(cur.next != null) {
                cur = cur.next;
            }
            //退出上面的循环，cur所指向的位置就是尾节点
            cur.next = node;
        }
    }*/

    /**
     * 找到index-1的位置的节点
     * @param index
     * @return
     */
    private Node searchIndex(int index) {
        checkIndex(index);
        /*int count = index-1;
        Node cur = this.head;
        while(count != 0) {
            cur = cur.next;
            count--;
        }*/
        int count = 0;
        Node cur = this.head;
        while(count < index-1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    private void checkIndex(int index) {
        if(index < 0 || index > getLength()){
            throw new UnsupportedOperationException("index位置不合法");
        }
    }

    @Override
    public boolean addIndex(int index, int data) {
        //头部插入
        if(index == 0){
            addFirst(data);
            return true;
        }
        Node node = new Node(data);
        Node cur = searchIndex(index);
        node.next = cur.next;
        cur.next = node;
        return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while(cur != null) {
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    private Node searchPrev(int key) {
        Node cur = this.head;
        while (cur.next != null) {
            if(cur.next.data == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public int remove(int key) {
        if(this.head == null) {
            throw new UnsupportedOperationException("单链表为空");
        }
        int oldData = 0;
        //删除的节点是头结点
        if(this.head.data == key){
            oldData = this.head.data;
            this.head = this.head.next;
            return oldData;
        }
        Node prev = searchPrev(key);
        if(prev == null) {
            //return
            throw new UnsupportedOperationException("没有前驱");
        }
        Node del = prev.next;
        oldData = del.data;
        prev.next = del.next;
        //del = null;
        return oldData;
    }

    @Override
    public void removeAllKey(int key) {
        if(this.head == null) {
            return;
        }
        Node prev = this.head;
        Node cur = this.head.next;
        while (cur != null) {
            if(cur.data == key){
                prev.next = cur.next;
                cur = prev.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        if(this.head.data == key){
            this.head = this.head.next;
        }
    }

    @Override
    public int getLength() {
        if(this.head == null) {
            return 0;
        }
        int count = 0;
        Node cur = this.head;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head;
        while(cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        while (this.head.next != null) {
            Node del = this.head.next;
            this.head.next = del.next;
        }
        this.head = null;
    }
    //反转一个单链表
    public Node reverseList() {
        Node reverseHead = null;//反转后新的头结点
        Node cur = this.head;//cur代表当前需要反转的节点
        Node prev = null;//cur的前驱--》前驱信息
        while(cur != null) {
            Node curNext = cur.next;
            if(curNext == null) {
                reverseHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return reverseHead;
    }

    //打印指定节点开始的数据
    public void show(Node newHead) {
        Node cur = newHead;
        while(cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    //找到单链表的中间节点
    public Node middleNode() {
        Node cur = this.head;
        int len = getLength()/2;
        for (int i = 0; i < len; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public Node findKthToTail(int k){
        if(this.head == null || k <= 0){// k > getLength()
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        while(k-1 > 0) {//3    5
            if(fast.next != null) {
                fast = fast.next;
                k--;
            }else {
                System.out.println("没有这个节点");
                return null;
            }
        }
        //一起走
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public Node partition(int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        Node pHead = this.head;
        while(pHead != null) {
            ////
            Node pHeadNext = pHead.next;
            pHead.next = null;
            if(pHead.data < x) {
                if(beforeStart == null) {
                    beforeStart = pHead;
                    beforeEnd = beforeStart;
                }else {
                    beforeEnd.next = pHead;
                    beforeEnd = pHead;
                }
            }else {
                if(afterStart == null) {
                    afterStart = pHead;
                    afterEnd = afterStart;
                }else {
                    afterEnd.next = pHead;
                    afterEnd = afterEnd.next;
                }
            }
            pHead = pHeadNext;
            //pHead = pHead.next;
        }
        if(beforeStart == null) {
            return afterStart;
        }
        beforeEnd.next = afterStart;//单链表进行拼接
        return beforeStart;
    }

    //单链表是否有环
    public void createLoop() {
        Node cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = this.head.next.next;
    }

    public boolean hasCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                //return true;
                break;
            }
        }
        if(fast != null && fast.next != null) {
            return true;
        }
        return false;
    }
    //链表的环的入口点
    public Node detectCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        //没有环  返回null
        if(fast == null || fast.next == null){
            return null;
        }
        slow = this.head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node deleteDuplication(){
        Node node = new Node(-1);
        Node cur = this.head;
        Node tmpHead = node;
        while(cur != null) {
            if(cur.next != null && cur.data ==
                    cur.next.data) {
                while(cur.next != null &&cur.data ==
                        cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
                //cur指向的这个节点，和前面的节点不同
                tmpHead.next = cur;
            }else{
                //确定不为重复的节点，串
                tmpHead.next = cur;
                tmpHead = cur;
                cur = cur.next;
            }
        }
        return node.next;
    }
    //链表的回文结构
    public boolean chkPalindrome() {
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //slow指向的位置就是中间节点
        Node p = slow.next;
        Node pNext = p.next;
        while(p != null) {
            p.next = slow;
            slow = p;
            p = pNext;
            if(p != null) {
                pNext = p.next;
            }
        }
        //后半部分已经进行反转
        while(this.head != slow) {
            if(this.head.data != slow.data){
                return false;
            }

            if(this.head.next == slow) {
                return true;
            }

            head = head.next;
            slow = slow.next;
        }
        return true;
    }
}