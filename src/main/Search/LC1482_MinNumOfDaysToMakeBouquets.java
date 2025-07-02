package Search;

public class LC1482_MinNumOfDaysToMakeBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int numFlower = bloomDay.length;
        if(numFlower < (long)m * k) return -1;
        
        int minDayBloom = 1;
        int maxDayBloom = 0;
        for(int i = 0; i < numFlower; i++){
            maxDayBloom = Math.max(maxDayBloom, bloomDay[i]);
        }

        int l = minDayBloom, r = maxDayBloom;

        while(l < r){
            int mid = l + (r - l) / 2; //try this as cur days to wait

            if (canMakeBouquets(bloomDay, m, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public boolean canMakeBouquets(int[] bloomDay, int m, int k, int dayLimit){
        int bouquets = 0;
        int flowers = 0;

        //for cur set day(mid), try loop through bloomDay to see how many flower can collect

        for(int day : bloomDay){
            if(day <= dayLimit){
                flowers++;
                if(flowers == k){
                    bouquets++;
                    flowers = 0;
                }
            }
            else{
                flowers = 0;
            }
        }

        return bouquets >= m;
    }
}
