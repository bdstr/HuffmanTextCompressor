package net.kloczkowski.data_structure;

import java.util.Arrays;

public class Heap {
    private Node[] heap;
    private int heapSize;

    public Heap(Node[] heap) {
        this.heap = heap;
        this.heapSize = heap.length;
        buildMinHeap();
    }

    public Node[] getArray() {
        return Arrays.copyOfRange(heap, 0, heapSize);
    }

    public int getSize() {
        return heapSize;
    }

    public void buildMinHeap() {
        for (int i = (heapSize / 2); i >= 0; i--) {
            minHeapify(i);
        }
    }

    private void minHeapify(int i) {
        int smallest;
        int l = 2 * i;
        int r = (2 * i) + 1;

        if (l < heapSize && heap[l].getQuantity() < heap[i].getQuantity()) {
            smallest = l;
        } else {
            smallest = i;
        }

        if (r < heapSize && heap[r].getQuantity() < heap[smallest].getQuantity()) {
            smallest = r;
        }

        if (i != smallest) {
            swap(smallest, i);
            minHeapify(smallest);
        }
    }

    private void swap(int indexA, int indexB) {
        Node buffer = heap[indexA];
        heap[indexA] = heap[indexB];
        heap[indexB] = buffer;
    }

    public Node extractMin() {
        Node min = heap[0];
        heapSize--;
        swap(0, heapSize);
        minHeapify(0);
        return min;
    }

    public void insert(Node node) {
        heapSize++;
        heap = Arrays.copyOf(heap, heapSize);
        heap[heapSize - 1] = node;
        buildMinHeap();
    }
}
