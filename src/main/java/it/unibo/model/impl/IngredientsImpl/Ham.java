package it.unibo.model.impl.IngredientsImpl;

import it.unibo.model.impl.IngredientImpl;

/**
 * Class that emulates a slice of ham
 */
public class Ham extends IngredientImpl{

    private final static int QUANTITY_TO_REDUCE = 6;
    private final static double PRICE = 0.8;
    private final static String IMAGE_PATH = "";

    public Ham() {
        super(PRICE, IMAGE_PATH);
    }

    public void reduce() {
        super.reduce(QUANTITY_TO_REDUCE);
    }
    
}