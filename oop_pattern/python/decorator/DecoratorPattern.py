from abc import ABC, abstractmethod


class Beverage(ABC):

    @abstractmethod
    def cost(self):
        pass

    @abstractmethod
    def description(self):
        pass


class DarkRoast(Beverage):
    def cost(self):
        return 3.45

    def description(self):
        return "Dark Roast"


class LightRoast(Beverage):
    def cost(self):
        return 3.45

    def description(self):
        return "Light Roast"


class BeverageDecorator(Beverage):
    def __init__(self, beverage):
        self.beverage = beverage


class EspressoDecorator(BeverageDecorator):
    def __init__(self, beverage):
        super().__init__(beverage)

    def cost(self):
        return 0.5 + self.beverage.cost()

    def description(self):
        return self.beverage.description() + ", Espresso"


class CreamDecorator(BeverageDecorator):
    def __init__(self, beverage):
        super().__init__(beverage)

    def cost(self):
        return 0.3 + self.beverage.cost()

    def description(self):
        return self.beverage.description() + ", Cream"


class FoamDecorator(BeverageDecorator):
    def __init__(self, beverage):
        # 这个属性是一个instance
        super().__init__(beverage)

    def cost(self):
        return 0.2 + self.beverage.cost()

    def description(self):
        return self.beverage.description() + ", Foam"


# Client Code
# 每次传入的都是一个instance，输出的也是一个instance
# 这个instance就是上面代码中初始化用的beverage属性
beverage = FoamDecorator(
    CreamDecorator(EspressoDecorator(LightRoast()))
)
print(beverage.description())  # Output: Light Roast, Espresso, Cream, Foam
print(beverage.cost())  # Output: 4.45
