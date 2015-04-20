package kucharka.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kucharka.api.RecipeService;
import kucharka.model.Recipe;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;


public class RecipeServiceImpl implements RecipeService{
    private final String RECEPTURL = "http://www.ceskahospodynka.cz/recepty-api/recepty?nazev=";
    private final String SUROVINYURL = "http://www.ceskahospodynka.cz/recepty-api/recepty?suroviny=";
    private final String IDURL = "http://www.ceskahospodynka.cz/recepty-api/recept/";
    private final String SPOJKAAND = "&logSpojkaSuroviny=AND";
    private final String SPOJKAOR = "&logSpojkaSuroviny=OR";
    SAXReader reader;
    
    public RecipeServiceImpl(){
    }
    /**
     *
     * @param suroviny
     * @param priznak
     * @return
     */
    @Override
    public List<Recipe> searchBySurovina(List<String> suroviny, boolean priznak){
        List<Recipe> recepty = new ArrayList<>();
        String adresa = spojURL(suroviny, priznak);
      
        try {
            Document doc = new SAXReader().read(new URL(adresa));
            List<Node> recept = doc.selectNodes("//recepty/recept");     
            for (Iterator<Node> it = recept.iterator(); it.hasNext();) {         
            Node node = it.next();
            recepty.add(vratRecept(node));
        }
        
        } catch (MalformedURLException | DocumentException e) {
            Logger.getLogger(RecipeServiceImpl.class.getName()).log(Level.SEVERE,null,e);
        }
        
        return recepty;
    }
        /**
     *
     * @param id id receptu
     * @return
     * @throws Exception
     */
    @Override
    public Recipe searchById(String id) throws Exception {
        List<Recipe> recepty = new ArrayList<>();
        String adresa = IDURL + id;
        Recipe recept = new Recipe();
        
        try {
            Document doc = new SAXReader().read(new URL(adresa));
            recept = vratRecept(doc.selectSingleNode("recept"));
        } catch (MalformedURLException | DocumentException e) {
        }
        return recept;
    }
        
    /**
     *
     * @param nazev receptu
     * @return
     * @throws Exception
     */
    @Override
    public List<Recipe> search(String nazev) throws Exception {
        List<Recipe> recepty = new ArrayList<>();
        String adresa = RECEPTURL + nazev;
        
        Document doc = new SAXReader().read(new URL(adresa));
        
        List<Node> recept = doc.selectNodes("//recepty/recept");
  
        for (Iterator<Node> it = recept.iterator(); it.hasNext();) {         
            Node node = it.next();
            recepty.add(vratRecept(node));
        }
        return recepty;//kolekce receptu vyhledanych prirazenych
    }

    private Recipe vratRecept(Node nod){
        Recipe recept = new Recipe();
        //část kde parsuji recept
        recept.setId(Integer.parseInt(nod.selectSingleNode("id").getStringValue()));
        recept.setName(nod.selectSingleNode("nazev").getStringValue());
        recept.setCategory(nod.selectSingleNode("kategorie").getStringValue());
        recept.setProcess(nod.selectSingleNode("postup").getStringValue());
        //zde si nalistuji vsechny suroviny
        List<Node> suroviny = nod.selectNodes("suroviny/surovina");
        List<String> sur = new ArrayList<>();
        for (Iterator<Node> it = suroviny.iterator(); it.hasNext();) {
            Node node = it.next();
            sur.add(node.getStringValue());
        }
        recept.setIngredience(sur);//prirazeni seznamu ingredienci
        recept.setObrazek(nod.selectSingleNode("obrazek").getStringValue());
        
        /**
         * ZDE SE JESTE MUSI DODELAT OBRAZEK, HLAVNI SUROVINA
         */   
        return recept;
    }

    private String spojURL(List<String> suroviny, boolean priznak) {
 
        String adresa = SUROVINYURL;
         for (int i = 0; i < suroviny.size(); i++) {
             if (i != suroviny.size()-1) {
                 adresa += suroviny.get(i);
                 adresa += ","; 
             } else {
                 adresa += suroviny.get(i);
             }      
        }
        if (priznak == false) {
            adresa += SPOJKAAND;
        } else {
            adresa += SPOJKAOR;
        }             
        return adresa;
    }
        private String spojURL(String nazev, List<String> suroviny, boolean priznak) {
 
        String adresa = RECEPTURL + nazev+"&suroviny=";
         for (int i = 0; i < suroviny.size(); i++) {
             if (i != suroviny.size()-1) {
                 adresa += suroviny.get(i);
                 adresa += ","; 
             } else {
                 adresa += suroviny.get(i);
             }      
        }
        if (priznak == false) {
            adresa += SPOJKAAND;
        } else {
            adresa += SPOJKAOR;
        }             
        return adresa;
    }

    @Override
    public List<Recipe> searchByNazevSurovina(String nazev, List<String> suroviny, boolean priznak) throws Exception {
        List<Recipe> recepty = new ArrayList<>();
        String adresa = spojURL(nazev,suroviny, priznak);
        Document doc = new SAXReader().read(new URL(adresa));
        List<Node> recept = doc.selectNodes("//recepty/recept");     
        for (Iterator<Node> it = recept.iterator(); it.hasNext();) {         
             Node node = it.next();
             recepty.add(vratRecept(node));
        }
        return recepty; 
    }


    
}
