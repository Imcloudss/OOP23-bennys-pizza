package it.unibo.model.impl;

import it.unibo.model.api.*;
import java.io.*;
import java.util.*;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MenuImpl implements Menu {

    private final static String SEP = File.separator;
    private static final String FILE_PATH = "src" + SEP +
                                            "main" + SEP +
                                            "resources" + SEP +
                                            "menu.json";

    private List<Pizza> menu;

    private void generateMenu() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.menu = mapper.readValue(new File(FILE_PATH), new TypeReference<List<Pizza>>() {});
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void show() {
        for(final Pizza pizza : this.menu) {
            System.out.println(pizza.getName()          + " " +
                                pizza.getIngredients()  + " " +
                                pizza.getCost()         + "\n"
                              );
        }
    }

    @Override
    public void update() {
        
    }

    /*
    public static void main(String[] args) {
        MenuImpl menu = new MenuImpl();
        menu.generateMenu();
        menu.show();
    }
    */
    
}