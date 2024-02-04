package it.unibo.model.api;

/**
 * Interface of an ingredient
 */
public interface Ingredient {
    /**
     * Increase the quantity of the ingredient to the maximum available.
     */
    void supply();

    /**
     * Decrease the quantity of the ingredient when it is put on a pizza.
     * NOTE: the quantity is different for each ingredient.
     * @param toReduce the quantity to reduce
     */
    void reduce(int toReduce);

    /**
     * @return the price of the ingredient
     */
    double getPrice();

    /**
     * @return the path of the image of the ingredient
     */
    String getImagePath();
}