from abc import ABC, abstractmethod


class Burger(ABC):

    def __init__(self):
        self.name = ""
        self.bread = ""
        self.sauce = ""
        self.toppings = []

    @abstractmethod
    def prepare(self):
        pass

    @abstractmethod
    def cook(self):
        pass

    @abstractmethod
    def serve(self):
        pass

    # 这里的方法不需要实现，因为子类都是相同的方法get_name
    def get_name(self):
        return self.name


class CheeseBurger(Burger):

    def __init__(self):
        super().__init__()
        self.name = "Cheese Burger"
        # 还可以设置其他属性

    def prepare(self):
        pass

    def cook(self):
        pass

    def serve(self):
        pass


class DeluxeCheeseBurger(Burger):

    def __init__(self):
        super().__init__()
        self.name = "Deluxe Cheese Burger"

    def prepare(self):
        pass

    def cook(self):
        pass

    def serve(self):
        pass


class VeganBurger(Burger):

    def __init__(self):
        super().__init__()
        self.name = "Vegan Burger"

    def prepare(self):
        pass

    def cook(self):
        pass

    def serve(self):
        pass


class DeluxeVeganBurger(Burger):

    def __init__(self):
        super().__init__()
        self.name = "DeluxeVegan Burger"

    def prepare(self):
        pass

    def cook(self):
        pass

    def serve(self):
        pass
