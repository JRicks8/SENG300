// Java program to implement Max Heap
package main;

// Main class
public class MinHeap {
	private int[] Heap;
	private int size;
	private int maxsize;

	// Constructor to initialize an
	// empty min heap with given maximum
	// capacity
	public MinHeap(int maxsize)
	{
		// This keyword refers to current instance itself
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[this.maxsize];
	}

	// Method 1
	// Returning position of parent
	private int parent(int pos) { return (pos - 1) / 2; }

	// Method 2
	// Returning left children
	private int leftChild(int pos) { return (2 * pos+1); }

	// Method 3
	// Returning left children
	private int rightChild(int pos)
	{
		return (2 * pos) + 2;
	}

	// Method 4
	// Returning true of given node is leaf
	private boolean isLeaf(int pos)
	{
		if (pos > (size / 2)-1 && pos <= size-1) {
			return true;
		}
		return false;
	}

	// Method 5
	// Swapping nodes
	private void swap(int fpos, int spos)
	{
		int tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

	// Method 6
	// Recursive function to min heapify given subtree
	private void minHeapify(int pos)
	{
		if (isLeaf(pos))
			return;
		
		if(rightChild(pos) >= size) {
			
			if (Heap[pos] > Heap[leftChild(pos)]) {
				swap(pos, leftChild(pos));
				minHeapify(leftChild(pos));
			}
			return;
		}

		if (Heap[pos] > Heap[leftChild(pos)]
			|| Heap[pos] > Heap[rightChild(pos)]) {

			if (Heap[leftChild(pos)]
				< Heap[rightChild(pos)]) {
				swap(pos, leftChild(pos));
				minHeapify(leftChild(pos));
			}
			else {
				swap(pos, rightChild(pos));
				minHeapify(rightChild(pos));
			}
		}
	}

	// Method 7
	// Inserts a new element to min heap
	public void insert(int element)
	{
		Heap[size] = element;

		// Traverse up and fix violated property
		int current = size;
		while (Heap[current] < Heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
		size++;
	}

	// Method 8
	// To display heap
	public void print()
	{
		for (int i = 0; i <= size / 2 - 1; i++) {
			System.out.print(
				" PARENT : " + Heap[i]
				+ " LEFT CHILD : " + Heap[2 * i + 1]
				+ " RIGHT CHILD :" + Heap[2 * i + 2]);
			System.out.println();
		}
	}

	// Method 9
	// Remove an element from min heap
	public int extractMin() throws Exception
	{
		System.out.println(size);
		if (size >= 1) {
			int popped = Heap[0];
			Heap[0] = Heap[--size];
			Heap[size]=0;
			minHeapify(0);
			return popped;
		}
		throw new Exception(" you cannot extract from the heap: it is empty!");
	}

	// Method 10
	// main dri er method
	public static void main(String[] arg) throws Exception { 
		int numelements = 6;

		MinHeap minHeap = new MinHeap(numelements);

		// Inserting nodes
		// Custom inputs
		// 8,9,16,1, 25, 4}
		
		minHeap.insert(8);
		minHeap.insert(9);
		minHeap.insert(16);
		minHeap.insert(1);
		minHeap.insert(25);
		minHeap.insert(4);
		
		// Calling minHeap() as defined above
		for (int i=0;i<numelements;i++) {
			// Print and dis10lay the minimum value in heap
			System.out.println("The min val is "+ minHeap.extractMin());
		}
	}
}
