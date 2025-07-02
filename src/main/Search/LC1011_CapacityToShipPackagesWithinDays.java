package Search;

public class LC1011_CapacityToShipPackagesWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        int minCapacity = 1; // min capacity should be the max load of weights[]
        int totalCapacity = 0;
        int len = weights.length;
        for(int i = 0; i < len; i++){
            minCapacity = Math.max(minCapacity, weights[i]);
            totalCapacity += weights[i];
        } 

        int l = minCapacity;
        int r = totalCapacity; //[l,r)

        while(l < r){
            int mid = l + (r - l) / 2; // this is the capacity we try to load
            int useDays = 1;

            int curLoad = 0;
            for (int weight : weights) {
                if (curLoad + weight > mid) {
                    useDays += 1;
                    curLoad = 0;
                }
                curLoad += weight;
            }

            if(useDays <= days){ // estimated daily load is above average, shrink it
                r = mid;
            }
            else{ // estimate daily load is not enough, search it on the right half
                l = mid + 1;
            }
        }

        return l;
    }
}
