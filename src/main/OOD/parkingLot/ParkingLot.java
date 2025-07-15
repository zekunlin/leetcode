package OOD.parkingLot;

public class ParkingLot {
    private final Level[] levels;

    public ParkingLot(int levelNum){
        levels = new Level[levelNum];
    }

    public boolean canPark(Vehicle v){
        for(Level level : levels){
            if(level.canPark(v)) return true;
        }
        return false;
    }
}

enum vehicleType {
    BUS,
    CAR,
    MOTO;
}
