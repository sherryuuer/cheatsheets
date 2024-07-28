package factory;

public class Client {
    public static void main(String[] args) {
        VehicleFactory carfactory = new CarFactory();
        VehicleFactory bikefactory = new BikeFactory();
        VehicleFactory truckfactory = new TruckFactory();

        Vehicle myCar = carfactory.creatVehicle();
        Vehicle myBike = bikefactory.creatVehicle();
        Vehicle myTruck = truckfactory.creatVehicle();

        System.out.println(myCar.getType());
        System.out.println(myBike.getType());
        System.out.println(myTruck.getType());
    }
}
