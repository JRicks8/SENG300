import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class MinHeap {
    private int[] Heap;
    private int size;
    private int maxsize;

    public MinHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize];
    }

    public int getMaxSize() {
    	return this.maxsize;
    }
    
    public int getSize() {
    	return this.size;
    }
    
    private int parent(int pos) { return (pos - 1) / 2; }

    private int leftChild(int pos) { return (2 * pos+1); }

    private int rightChild(int pos)
    {
        return (2 * pos) + 2;
    }

    private boolean isLeaf(int pos)
    {
        if (pos > (size / 2)-1 && pos <= size-1) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

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

    public void insert(int element)
    {
        Heap[size] = element;

        int current = size;
        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

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
    
    public int peek() {
    	if (size >= 1) {
    		return Heap[0];
    	}
    	return -1;
    }

    public int extractMin() throws Exception
    {
        if (size >= 1) {
            int popped = Heap[0];
            Heap[0] = Heap[--size];
            Heap[size]=0;
            minHeapify(0);
            return popped;
        }
        throw new Exception(" you cannot extract from the heap: it is empty!");
    }
}

class Result {
    
    
    public static int cookies(int k, List<Integer> A) {
        MinHeap heap = new MinHeap(A.size());
        
        for (int i = 0; i < A.size(); i++) {
        	heap.insert(A.get(i));
        }
        
        if (heap.getSize() == 0) return -1;
        if (heap.getSize() == 1 && heap.peek() >= k) return 0;
        
        int iterations = 0;
        while (heap.peek() < k) {
        	if (heap.getSize() < 2) return -1;
        	int a = heap.extractMin();
        	int b = heap.extractMin();
        	heap.insert(a + 2 * b);
        	iterations++;
        }
        return iterations;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
