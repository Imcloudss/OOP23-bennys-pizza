package it.unibo.model.api;

/**
 * Interface of a preparation zone cleaner
 */
public interface Cleaner {
    
    /**
     * It cleans the preparation zone.
     * This cleaning is called only if the preparation zone is dirty
     * @param zone the preparation zone to clean
     */
    void clean(PreparationZone zone);

}