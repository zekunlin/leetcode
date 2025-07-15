package OOD.parkingLot;

public abstract class Vehicle {
    public vehicleType type;
    
    public vehicleType getType(){
        return this.type;
    }

    public Vehicle(vehicleType type){
        this.type = type;
    }
}
