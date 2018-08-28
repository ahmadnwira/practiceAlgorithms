import java.util.Arrays;

class MaxHeap {
    private int capacity = 4;
    private int size = 0;
    public int[] heap = new int[capacity];

    private int getLeftIndex(int i) {
        return 2 * i + 1;
    }

    private int getRightIndex(int i) { return 2*i+2; }


    private void ensureCapacity() {
        if(size == capacity) {
            heap = Arrays.copyOf(heap, capacity*2);
            capacity *= 2;
        }
    }

    private void swap(int aIndex, int bIndex) {
        int temp = heap[aIndex];
        heap[aIndex] = heap[bIndex];
        heap[bIndex] = temp;
    }

    private void max_heapify(int[] A, int i) {
        int left = getLeftIndex(i);
        int right = getRightIndex(i);
        int largest = i;

        if(left < A.length && A[left] > A[largest]) largest = left;

        if(right < A.length && A[right] > A[largest]) largest = right;

        if(largest != i) {
           swap(i, largest);
            max_heapify(A, largest);
        }
    }

    private void build_heap(int[] A) {
        for(int i = A.length; i>=0; i--){
            max_heapify(A, i);
        }
    }

    public void push(int val) {
        ensureCapacity();
        heap[size] = val;
        size++;
        build_heap(heap);
    }

    public int pop() {
        int rv = heap[0];
        heap[0] = heap[size-1];
        heap[size-1] = 0;
        size--;
        build_heap(heap);
        return rv;
    }
}
