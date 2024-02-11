package it.unibo.model.impl.IngredientsImpl;

import it.unibo.model.impl.IngredientImpl;

/**
 * Class that emulates the tomato sauce
 */
public class TomatoSauce extends IngredientImpl{

    private final static int QUANTITY_TO_REDUCE = 12;
    private final static double PRICE = 0.4;
    private final static String IMAGE_NAME = "TomatoeSauce.png";

    public TomatoSauce() {
        super(PRICE, IMAGE_NAME);
    }

    @Override
    public void reduce() {
        super.reduceIngredient(QUANTITY_TO_REDUCE);
    }
    
}