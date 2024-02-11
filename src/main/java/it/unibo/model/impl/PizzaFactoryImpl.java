package it.unibo.model.impl;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.unibo.model.api.PizzaFactory;

public class PizzaFactoryImpl implements PizzaFactory{

    private final List<IngredientImpl> addedIngredients = new ArrayList<>();

    @Override
    public void addIngredient(final IngredientImpl ingredientToAdd) {
        if (!this.addedIngredients.contains(ingredientToAdd)) {
            this.addedIngredients.add(ingredientToAdd);
            ingredientToAdd.reduce();
        }
    }

    @Override
    public boolean equals(final List<IngredientImpl> requestedIngredients) {
        return this.addedIngredients.size() != requestedIngredients.size() 
            ? false 
            : requestedIngredients.stream()
                .filter(this.addedIngredients::contains)
                .count() == requestedIngredients.size();
    }

    @Override
    public List<IngredientImpl> getAddedIngredients() {
        return Collections.unmodifiableList(this.addedIngredients);
    }

}
=======
import it.unibo.model.api.Ingredient;
import it.unibo.model.api.PizzaFactory;

public class PizzaFactoryImpl implements PizzaFactory {

    @Override
    public void addIngredient(Ingredient ingredientToAdd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addIngredient'");
    }

}
>>>>>>> suppliesLogic
