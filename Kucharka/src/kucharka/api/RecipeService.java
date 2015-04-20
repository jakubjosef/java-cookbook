package kucharka.api;

import java.util.List;
import kucharka.model.Recipe;


/**
 *
 * @author Jakub Josef
 */
public interface RecipeService {
    
    //po sobe jmeno, suroviny a operace
    public List<Recipe> search(String nazev) throws Exception;
    public List<Recipe> searchBySurovina(List<String> suroviny, boolean priznak) throws Exception;
    public List<Recipe> searchByNazevSurovina(String nazev,List<String> suroviny, boolean priznak) throws Exception;
    public Recipe searchById(String id) throws Exception;
    
    
}
