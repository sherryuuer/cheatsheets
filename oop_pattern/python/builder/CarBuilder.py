# 产品类
class Car:
    def __init__(self):
        self.make = None
        self.model = None
        self.year = None
        self.color = None
        self.engine = None

    def __str__(self):
        return f"{self.year} {self.color} {self.make} {self.model} with {self.engine} engine"


# Builder类
class CarBuilder:
    def __init__(self):
        self.car = Car()

    def set_make(self, make):
        self.car.make = make
        return self

    def set_model(self, model):
        self.car.model = model
        return self

    def set_year(self, year):
        self.car.year = year
        return self

    def set_color(self, color):
        self.car.color = color
        return self

    def set_engine(self, engine):
        self.car.engine = engine
        return self

    def build(self):
        return self.car


# Director类
class CarDirector:
    def __init__(self, builder):
        self.builder = builder

    def construct_sports_car(self):
        return (self.builder
                .set_make("Ferrari")
                .set_model("488 GTB")
                .set_year(2022)
                .set_color("Red")
                .set_engine("V8")
                .build())

    def construct_family_car(self):
        return (self.builder
                .set_make("Toyota")
                .set_model("Camry")
                .set_year(2022)
                .set_color("Blue")
                .set_engine("V6")
                .build())


# 客户端代码
if __name__ == "__main__":
    builder = CarBuilder()
    director = CarDirector(builder)

    # 构建一辆跑车
    sports_car = director.construct_sports_car()
    print(sports_car)  # 输出: 2022 Red Ferrari 488 GTB with V8 engine

    # 构建一辆家庭用车
    family_car = director.construct_family_car()
    print(family_car)  # 输出: 2022 Blue Toyota Camry with V6 engine
