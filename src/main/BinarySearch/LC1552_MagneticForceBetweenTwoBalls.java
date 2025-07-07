package BinarySearch;

import java.util.Arrays;

public class LC1552_MagneticForceBetweenTwoBalls {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int len = position.length;
        int minForce = 1;
        int maxForce = position[len - 1] + 1;
        int maxMinForce = 0;

        while(minForce < maxForce){
            int mid = minForce + (maxForce - minForce) / 2;
            boolean canFit = canFitMid(position, m, mid);

            if(canFit){
                maxMinForce = mid;
                minForce = mid + 1;
            }
            else{
                maxForce = mid;
            }
        }
        
        return maxMinForce;
    }

    public boolean canFitMid(int[] position, int m, int force){
        int ballPlaced = 1;
        int lastBallPos = position[0];
        
        for(int i = 1; i < position.length; i++){
            if(position[i] - lastBallPos >= force){
                ballPlaced += 1;
                lastBallPos = position[i];
            }
        }

        return ballPlaced >= m;
    }
}
