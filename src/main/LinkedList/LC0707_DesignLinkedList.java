package LinkedList;

class DesignLinkedList {
    class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
            this.next = null;
        }
        
        public Node(){}
    }
    
    Node head;
    int size;

    public DesignLinkedList() {
        this.head = new Node(0);
        this.size = 0;
    }
    
    private Node getNodeAt(int index){
        if(index < -1 || index >= this.size) return null;
        
        int i = 0;
        Node cur = this.head;
        while(i <= index){
            cur = cur.next;
            i++;
        }
        
        return cur;
    }
    
    public int get(int index) {
        Node node = this.getNodeAt(index);
        
        return node == null ? -1 : node.val;
    }
    
    public void addAtHead(int val) {
        this.addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        if(this.size == 0){
            addAtHead(val);
            return;
        }
        
        Node tail = this.getTail();
        
        Node newNode = new Node(val);
        tail.next = newNode;
        this.size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index < 0) index = 0;
        Node prev = this.getNodeAt(index - 1);
        Node newNode = new Node(val);
        
        if(prev == null){
            this.head.next = newNode;
        }
        else{
            newNode.next = prev.next;
            prev.next = newNode;
        }
        this.size++;
    }
    
    private Node getTail(){
        Node tail = this.getNodeAt(size - 1);
        
        return tail;
    }
    
    public void deleteAtIndex(int index) {
        Node prev = this.getNodeAt(index - 1);
        if(prev == null || prev.next == null) return;

        prev.next = prev.next.next;
        this.size--;
    }
}
