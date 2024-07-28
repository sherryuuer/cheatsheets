package factory;

public class TruckFactory extends VehicleFactory {
    @Override
    public Vehicle creatVehicle() {
        return new Truck();
    }
}
