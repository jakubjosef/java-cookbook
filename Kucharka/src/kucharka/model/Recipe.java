/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kucharka.model;

import java.awt.Image;
import java.net.URL;
import java.util.List;

/**
 *
 * @author Michael
 */
public class Recipe {
    private String name = "";
    private int id;
    private String category = "";
    private String process = "";
    private List<String> ingredience;
    private String obrazek;

    
    
    public Recipe(){
        
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {                     
        this.id = id;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the process
     */
    public String getProcess() {
        return process;
    }

    /**
     * @param process the process to set
     */
    public void setProcess(String process) {
        this.process = process;
    }

    /**
     * @return the ingredience
     */
    public List<String> getIngredience() {
        return ingredience;
    }

    /**
     * @param ingredience the ingredience to set
     */
    public void setIngredience(List<String> ingredience) {
        this.ingredience = ingredience;
    }

    /**
     * @return the obrazek
     */
    public String getObrazek() {
        return obrazek;
    }

    /**
     * @param obrazek the obrazek to set
     */
    public void setObrazek(String obrazek) {
            this.obrazek = obrazek;
    }

    @Override
    public String toString() {
        return "Recipe{" + "name=" + name + ", id=" + id + ", category=" + category + ", process=" + process + ", ingredience=" + ingredience + ", obrazek=" + obrazek + '}';
    }

    
}
