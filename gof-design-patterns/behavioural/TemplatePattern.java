package com.patterns.behavioural;

public class TemplatePattern {

	public static void main(String[] args) {
        System.out.println("-----Making Veg Pizza-----");
        PizzaMaker vegPizzaMaker = new VegPizzaMaker();
        vegPizzaMaker.makePizza();
        System.out.println("-----Making Non Veg Pizza-----");
        PizzaMaker nonVegPizzaMaker = new NonVegPizzaMaker();
        nonVegPizzaMaker.makePizza();
        System.out.println("-----Making In-House Assorted Pizza-----");
        PizzaMaker inHouseAssortedPizzaMaker = new InHouseAssortedPizzaMaker();
        inHouseAssortedPizzaMaker.makePizza();

	}

}

/*
 * Abstract Class
 * Is an abstract class that contains a template method defining the skeleton of an algorithm. 
 * The template method calls methods to perform the steps of an algorithm. 
 * The methods can be both common across and specific to different algorithm implementations.
 */
abstract class PizzaMaker {
    public void makePizza() {
        preparePizzaDough();
        preBakeCrust();
        prepareIngredients();
        addToppings();
        bakePizza();
        if (customerWantsPackedPizza()) {
            packPizza();
        }
    }
    final void preparePizzaDough() {
        System.out.println("Preparing pizza dough with plain flour, dried yeast, caster sugar, salt, olive oil, and warm water.");
    }
    final void preBakeCrust() {
        System.out.println("Pre baking crust at 325 F for 3 minutes.");
    }
    abstract void prepareIngredients();
    abstract void addToppings();
    void bakePizza() {
        System.out.println("Baking pizza at 400 F for 12 minutes.");
    }
    void packPizza() {
        System.out.println("Packing pizza in pizza delivery box.");
    }
    boolean customerWantsPackedPizza() {
        return true;
    }
}

/*
 * Concrete Class
 * concrete subclasses of AbstractClass that implements the operations to carry out the algorithm-specific primitive steps.
 */
class VegPizzaMaker extends PizzaMaker {
    @Override
    public void prepareIngredients() {
        System.out.println("Preparing mushroom, tomato slices, onions, and fresh basil leaves.");
    }
    @Override
    public void addToppings() {
        System.out.println("Adding mozzerella cheese and tomato sauce along with ingredients to crust.");
    }
}

/*
 * Concrete Class
 * concrete subclasses of AbstractClass that implements the operations to carry out the algorithm-specific primitive steps.
 */
class NonVegPizzaMaker extends PizzaMaker {
    @Override
    public void prepareIngredients() {
        System.out.println("Preparing chicken ham, onion, chicken sausages, and smoked chicken");
    }
    @Override
    public void addToppings() {
        System.out.println("Adding cheese, pepper jelly, and BBQ sauce along with ingredients to crust.");
    }
}

/*
 * Concrete Class
 * concrete subclasses of AbstractClass that implements the operations to carry out the algorithm-specific primitive steps.
 */
class InHouseAssortedPizzaMaker extends PizzaMaker {
    @Override
    public void prepareIngredients() {
        System.out.println("Preparing sweet corns,chicken sausage, green chillies, and onions.");
    }
    @Override
    public void addToppings() {
        System.out.println("Adding cheddar cheese and  bechamel sauce along with ingredients to crust.");
    }
    @Override
    public boolean customerWantsPackedPizza() {
        return false;
    }
}
