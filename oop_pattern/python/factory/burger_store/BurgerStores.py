from enum import Enum
from abc import ABC, abstractmethod

from Burgers import (
    Burger,
    CheeseBurger,
    DeluxeCheeseBurger,
    VeganBurger,
    DeluxeVeganBurger
)


class Burgers(Enum):
    CHEESE = "CHEESE"
    DELUXECHEESE = "DELUXECHEESE"
    VEGAN = "VEGAN"
    DELUXEVEGAN = "DELUXEVEGAN"


class BurgerStore(ABC):

    @abstractmethod
    def create_burger(self, item: Burgers) -> Burger:
        pass

    def order_burger(self, type: Burgers) -> Burger:
        burger = self.create_burger(type)
        print(f"--- Making a {burger.get_name()} ---")
        burger.prepare()
        burger.cook()
        burger.serve()
        return burger


class CheeseBurgerStore(BurgerStore):

    def create_burger(self, item: Burgers) -> Burger:
        if item == Burgers.CHEESE:
            return CheeseBurger()
        elif item == Burgers.DELUXECHEESE:
            return DeluxeCheeseBurger()
        else:
            return None


class VeganBurgerStore(BurgerStore):

    def create_burger(self, item: Burgers) -> Burger:
        if item == Burgers.VEGAN:
            return VeganBurger()
        elif item == Burgers.DELUXEVEGAN:
            return DeluxeVeganBurger()
        else:
            return None
