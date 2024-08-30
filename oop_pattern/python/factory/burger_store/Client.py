from BurgerStores import Burgers, CheeseBurgerStore, VeganBurgerStore

cheese_store = CheeseBurgerStore()
vegan_store = VeganBurgerStore()

burger = cheese_store.order_burger(Burgers.CHEESE)
print(f"Ethan ordered a {burger.get_name()}")
burger = vegan_store.order_burger(Burgers.VEGAN)
print(f"Joel ordered a {burger.get_name()}")
