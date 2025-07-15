package OOD.parkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Level {
    private final HashMap<vehicleType, Integer> capacity = new HashMap<>();
    private final HashMap<vehicleType, Integer> parkedVNum;
    private final int floor;
    private final ParkingSpot[] spots;

    public Level(int floor, int busNum, int carNum, int motoNum){
        this.floor = floor;
        spots = new ParkingSpot[busNum + carNum + motoNum];
        parkedVNum = new HashMap<>();
    }

    public boolean canPark(Vehicle v){
        vehicleType type = v.type;
        return capacity.get(type) > parkedVNum.get(type);
    }

    public boolean goPark(Vehicle v){
        if(!canPark(v)) return false;

        for(ParkingSpot spot : spots){
            if(spot.canPark(v)){
               spot.park(v);
                parkedVNum.put(v.type, parkedVNum.get(v.type) + 1);
               return true;
            }
        }

        return false;
    }

    public int availableSpots(Vehicle v){
        return capacity.get(v.type) - parkedVNum.get(v.type);
    }
}
