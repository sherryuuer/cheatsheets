package builder;

// 产品类
class Car {
    private String make;
    private String model;
    private int year;
    private String color;
    private String engine;

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return year + " " + color + " " + make + " " + model + " with " + engine + " engine";
    }
}

// Builder类
class CarBuilder {
    private Car car;

    public CarBuilder() {
        this.car = new Car();
    }

    public CarBuilder setMake(String make) {
        car.setMake(make);
        return this;
    }

    public CarBuilder setModel(String model) {
        car.setModel(model);
        return this;
    }

    public CarBuilder setYear(int year) {
        car.setYear(year);
        return this;
    }

    public CarBuilder setColor(String color) {
        car.setColor(color);
        return this;
    }

    public CarBuilder setEngine(String engine) {
        car.setEngine(engine);
        return this;
    }

    public Car build() {
        return car;
    }
}

// Director类
class CarDirector {
    private CarBuilder builder;

    public CarDirector(CarBuilder builder) {
        this.builder = builder;
    }

    public Car constructSportsCar() {
        return builder
                .setMake("Ferrari")
                .setModel("488 GTB")
                .setYear(2022)
                .setColor("Red")
                .setEngine("V8")
                .build();
    }

    public Car constructFamilyCar() {
        return builder
                .setMake("Toyota")
                .setModel("Camry")
                .setYear(2022)
                .setColor("Blue")
                .setEngine("V6")
                .build();
    }
}

// 客户端代码
public class CarDirectorMain {
    public static void main(String[] args) {
        CarBuilder builder = new CarBuilder();
        CarDirector director = new CarDirector(builder);

        // 构建一辆跑车
        Car sportsCar = director.constructSportsCar();
        System.out.println(sportsCar); // 输出: 2022 Red Ferrari 488 GTB with V8 engine

        // 构建一辆家庭用车
        Car familyCar = director.constructFamilyCar();
        System.out.println(familyCar); // 输出: 2022 Blue Toyota Camry with V6 engine
    }
}
