package Heap;
import java.util.*;

public class BuildHeap {
    List<Integer> heap;

    public BuildHeap(List<Integer> array){
        this.heap = buildHeap(array);
    }

    public List<Integer> buildHeap(List<Integer> array)
    {
        int firstParentIdx = (array.size() - 1 - 1) /2;
        for(int curIdx = firstParentIdx; curIdx< array.size()-1;curIdx++)
        {
            siftDown(curIdx, array.size() - 1, array);
        }
        return array;
    }

    public void siftDown(int curIdx, int endIdx, List<Integer> heap)
    {
        int childOneIdx = curIdx *2 + 1;
        while(childOneIdx <= endIdx)
        {
            int childTwoIdx = curIdx * 2 + 2;
            childTwoIdx = childTwoIdx <= endIdx ? childTwoIdx : -1;
            int swapInd;
            if(childTwoIdx != -1 && heap.get(childOneIdx) > heap.get(childTwoIdx))
            {
                swapInd = childTwoIdx;
            }
            else
            {
                swapInd = childOneIdx;
            }

            if(heap.get(swapInd) < heap.get(curIdx))
            {
                this.swap( heap, curIdx, swapInd);
                curIdx = swapInd;
                childOneIdx = curIdx * 2 + 1;
            }
            else{
                return;
            }
        }
    }

    public void siftUp(int curIdx, List<Integer> heap){
        int parentIdx = (curIdx - 1) / 2;
        while(curIdx > 0 && heap.get(curIdx) < heap.get(parentIdx))
        {
            swap(heap, curIdx, parentIdx);
            curIdx = parentIdx;
            parentIdx = (curIdx - 1) / 2;
        }
    }

    public Integer remove(){
        this.swap(heap, 0, heap.size() - 1);
        int removingVal = heap.get(heap.size() - 1);
        heap.remove(heap.size() - 1);
        this.siftDown (0, heap.size() - 1, heap);
        return removingVal;
    }

    public Integer insert(int value){
        this.heap.add(value);
        this.siftUp(heap.size() - 1, heap);
        return value;
    }

    private void swap(List<Integer> heap, int i, int j)
    {
        int tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }
}
