package Array;

class MyCircularQueue {
    int capacity;
    int[] arrayQ;
    int headIdx;
    int size;

    public MyCircularQueue(int k) {
        this.capacity = k;
        arrayQ = new int[k];
        headIdx = 0;
        size = 0;
    }
    
    public boolean enQueue(int value) {
        if(this.size == this.capacity) return false;

        this.arrayQ[(this.headIdx + this.size) % this.capacity] = value;
        this.size++;
        return true;
    }
    
    public boolean deQueue() {
        if(this.size == 0) return false;

        this.headIdx = (this.headIdx + 1) % capacity;
        this.size--;
        return true; 
    }
    
    public int Front() {
        if(this.size == 0) return -1;
        return this.arrayQ[this.headIdx];
    }
    
    public int Rear() {
        if(this.size == 0) return -1;
        return this.arrayQ[(this.headIdx + this.size - 1) % this.capacity];
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public boolean isFull() {
        return this.size == this.capacity;
    }
}
