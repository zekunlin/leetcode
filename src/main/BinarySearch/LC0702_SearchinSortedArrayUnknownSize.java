package BinarySearch;

class SearchinSortedArrayUnknownSize{
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;

        while(reader.get(right) < target){
            left = right;
            right *= 2;
        }
        //right += 1; with or without this both works :(
        while(left < right){
            int mid = left + (right - left) / 2;

            if(reader.get(mid) < target){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }

        return reader.get(left) == target ? left : -1;
    }

    //this is something not required .
    interface ArrayReader {
     public default int get(int index) {
        return 0;
     }
    }
}