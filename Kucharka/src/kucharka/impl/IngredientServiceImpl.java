package kucharka.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kucharka.api.IngredientService;

/**
 *
 * @author josefja1
 */
public class IngredientServiceImpl implements IngredientService{

    @Override
    public List<String> loadIngredients() {
        ArrayList<String> res= new ArrayList<>();
        BufferedReader bfReader=null;
        try {
             bfReader= new BufferedReader(new FileReader("src/kucharka/res/data/ingredients.csv"));
            String line;
            while((line=bfReader.readLine()) != null){
                res.add(parseIngredient(line));
            }
        } catch (Exception ex) {
            Logger.getLogger(IngredientServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(bfReader!=null){
                try {
                    bfReader.close();
                } catch (IOException ex) {
                    Logger.getLogger(IngredientServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return res;
    }

    private String parseIngredient(String line) {
        return line.split(";")[0];
    }
    
}
