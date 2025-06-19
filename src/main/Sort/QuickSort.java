package Sort;

public class QuickSort {
    public int[] quickSort(int[] array) {
    // Write your code here.
    int len = array.length;
    quickSort(0, len - 1, array);
    return array;
  }

  public void quickSort(int left, int right, int[] array){
    if(left >= right) return;
    
    int pivotIdx = left + (right - left)/2;
    
    int newPivot = partition(left, right, pivotIdx, array);

    quickSort(left, newPivot - 1, array);
    quickSort(newPivot + 1, right, array);
  }

  private int partition(int left, int right, int pivotIdx, int[] array){
    int pivotVal = array[pivotIdx];

    swap(pivotIdx, right, array);

    int storeIdx = left;

    for(int i = left; i <= right; i++){
      if(array[i] < pivotVal){
        swap(i, storeIdx, array);
        storeIdx++;
      }
    }
    swap(storeIdx, right, array);
    return storeIdx;
  }

  private void swap(int i, int j, int[] array){
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
