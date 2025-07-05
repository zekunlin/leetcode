package BinarySearch;

public class LC0875_KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 1;

        for(int p : piles){
            maxSpeed = Math.max(p, maxSpeed);
        }

        while(minSpeed < maxSpeed){
            int midSpeed = (maxSpeed + minSpeed) / 2;
            int hours = 0;
            for(int pile : piles){
                hours += Math.ceil((double) pile / midSpeed);
            }

            if(hours <= h){
                maxSpeed = midSpeed;
            }
            else{
                minSpeed = midSpeed + 1;
            }
        }

        return minSpeed;
    }
}
