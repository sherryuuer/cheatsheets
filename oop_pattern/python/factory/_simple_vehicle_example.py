from abc import ABC, abstractmethod
# abc 是标准库中的一个模块，名字来源于 "Abstract Base Classes"（抽象基类）


class Vehicle(ABC):
    @abstractmethod
    def getType(self) -> str:
        pass


class Car(Vehicle):
    def getType(self) -> str:
        return "Car"


class Bike(Vehicle):
    def getType(self) -> str:
        return "Bike"


class Truck(Vehicle):
    def getType(self) -> str:
        return "Truck"


class VehicleFactory(ABC):
    @abstractmethod
    def createVehicle(self) -> Vehicle:
        pass


class CarFactory(VehicleFactory):
    def createVehicle(self) -> Vehicle:
        return Car()


class BikeFactory(VehicleFactory):
    def createVehicle(self) -> Vehicle:
        return Bike()


class TruckFactory(VehicleFactory):
    def createVehicle(self) -> Vehicle:
        return Truck()


# 使用示例
carFactory = CarFactory()
truckFactory = TruckFactory()
bikeFactory = BikeFactory()

myCar = carFactory.createVehicle()
myTruck = truckFactory.createVehicle()
myBike = bikeFactory.createVehicle()

print(myCar.getType())   # "Car"
print(myTruck.getType())  # "Truck"
print(myBike.getType())  # "Bike"
