package OOD;

public class ParkingSpot {
    private Vehicle parkedVehicle;
    private final vehicleType type;

    public ParkingSpot(vehicleType type){
        this.type = type;
        parkedVehicle = null;
    }

    public boolean canPark(Vehicle incomingCar){
        return this.parkedVehicle == null && incomingCar.type == this.type;
    }

    public synchronized boolean park(Vehicle incomingVehicle){
        if(canPark(incomingVehicle)){
            this.parkedVehicle = incomingVehicle;
            return true;
        }
        else{
            return false;
        }
    }

    public void leave(){
        this.parkedVehicle = null;
    }
}
