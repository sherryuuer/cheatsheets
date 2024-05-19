const Starter = Object.freeze({
    SALAD: "Salad",
    SOUP: "Soup",
    BRUSCHETTA: "Bruschetta",
    VEGGIE_STICKS: "Veggie Sticks",
    CHICKEN_WINGS: "Chicken Wings"
});

const Main = Object.freeze({
    GRILLED_CHICKEN: "Grilled Chicken",
    PASTA: "Pasta",
    VEGGIE_STIR_FRY: "Veggie Stir Fry",
    FISH: "Fish",
    PIZZA: "Pizza"
});

const Dessert = Object.freeze({
    FRUIT_SALAD: "Fruit Salad",
    ICE_CREAM: "Ice Cream",
    CHOCOLATE_CAKE: "Chocolate Cake",
    VEGAN_PUDDING: "Vegan Pudding",
    CHEESECAKE: "Cheesecake"
});

const Drink = Object.freeze({
    WATER: "Water",
    VEGAN_SHAKE: "Vegan Shake",
    SODA: "Soda",
    FRUIT_JUICE: "Fruit Juice"
});

class Meal {
    constructor() {
        this.starter = null;
        this.main = null;
        this.dessert = null;
        this.drink = null;
    }

    getStarter() {
        return this.starter;
    }

    getMain() {
        return this.main;
    }

    getDessert() {
        return this.dessert;
    }

    getDrink() {
        return this.drink;
    }

    setStarter(starter) {
        this.starter = starter;
    }

    setMain(main) {
        this.main = main;
    }

    setDessert(dessert) {
        this.dessert = dessert;
    }

    setDrink(drink) {
        this.drink = drink;
    }
}

class VeganMealBuilder {
    constructor() {
        this.meal = new Meal();
    }

    addStarter() {
        this.meal.setStarter(Starter.SALAD);
    }

    addMainCourse() {
        this.meal.setMain(Main.VEGGIE_STIR_FRY);
    }

    addDessert() {
        this.meal.setDessert(Dessert.VEGAN_PUDDING);
    }

    addDrink() {
        this.meal.setDrink(Drink.VEGAN_SHAKE);
    }

    build() {
        return this.meal;
    }
}

class HealthyMealBuilder {
    constructor() {
        this.meal = new Meal();
    }

    addStarter() {
        this.meal.setStarter(Starter.SALAD);
    }

    addMainCourse() {
        this.meal.setMain(Main.GRILLED_CHICKEN);
    }

    addDessert() {
        this.meal.setDessert(Dessert.FRUIT_SALAD);
    }

    addDrink() {
        this.meal.setDrink(Drink.WATER);
    }

    build() {
        return this.meal;
    }
}

class Director {
    constructVeganMeal(builder) {
        builder.addStarter();
        builder.addMainCourse();
        builder.addDessert();
        builder.addDrink();
    }

    constructHealthyMeal(builder) {
        builder.addStarter();
        builder.addMainCourse();
        builder.addDessert();
        builder.addDrink();
    }
}

const director = new Director();

const veganBuilder = new VeganMealBuilder();
director.constructVeganMeal(veganBuilder);
const veganMeal = veganBuilder.build();
console.log("Vegan Meal constructed:");
console.log("Starter: " + veganMeal.getStarter());
console.log("Main: " + veganMeal.getMain());
console.log("Dessert: " + veganMeal.getDessert());
console.log("Drink: " + veganMeal.getDrink());

// Constructing a healthy meal
const healthyBuilder = new HealthyMealBuilder();
director.constructHealthyMeal(healthyBuilder);
const healthyMeal = healthyBuilder.build();
console.log("Healthy Meal constructed:");
console.log("Starter: " + healthyMeal.getStarter());
console.log("Main: " + healthyMeal.getMain());
console.log("Dessert: " + healthyMeal.getDessert());
console.log("Drink: " + healthyMeal.getDrink());
