package Sort;

public class MergeSort {
    public int[] mergeSort(int[] array) {
    // Write your code here.
    mergeSortHelper(array, 0, array.length -1);
    return array;
  }

  private void mergeSortHelper(int[] array, int left, int right){
    if(left >= right) return;

    int mid = left + (right - left)/2;

    // Recursively sort both halves
    mergeSortHelper(array, left, mid);
    mergeSortHelper(array, mid + 1, right);

    // Merge sorted halves
    merge(array, left, mid, right);
  }

  private void merge(int[] array, int left, int mid, int right){
    int[] tmpArray = new int[right - left + 1];
    int i = left; // Pointer for left half
    int j = mid + 1;// Pointer for right half
    int tmpArrayIdx = 0;// Pointer for temp array

    while(i <= mid && j <= right){
      if(array[i] <= array[j]){
        tmpArray[tmpArrayIdx++] = array[i++];
      }
      else{
        tmpArray[tmpArrayIdx++] = array[j++];
      }
    }

    // Copy remaining elements from left half
    while(i <= mid){
      tmpArray[tmpArrayIdx++] = array[i++];
    }

    // Copy remaining elements from right half
    while(j <= right){
      tmpArray[tmpArrayIdx++] = array[j++];
    }

    // Copy merged result back to original array
    for(int idx = 0; idx < tmpArray.length; idx++){
      array[left+idx] = tmpArray[idx];
    }
  }
}
