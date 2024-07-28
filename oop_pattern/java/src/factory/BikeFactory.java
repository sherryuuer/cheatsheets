package factory;

public class BikeFactory extends VehicleFactory {
    @Override
    public Vehicle creatVehicle() {
        return new Bike();
    }
}
