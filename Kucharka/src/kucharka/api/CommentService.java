package kucharka.api;

import java.util.List;
import kucharka.model.Comment;

/** Rozhrani definujici chovani sluzby pro komentare
  * @author Jakub Josef
 */
public interface CommentService {
    /**
     * Pridani komentare
     * @param comment 
     */
    public void addComment(Comment comment);
    /**
     * Vymazani komentare
     * @param commentID 
     */
    public void deleteComment(int commentID);
    /**
     * Ziskani dostupnych komentaru
     * @param recipeID
     * @return kolekce komentaru pro dany recept
     */
    public List<Comment> getComments(int recipeID);
    
    /**
     * Ziskani hodnoceni pro dany recept
     * @param recipeID
     * @return hodnoceni
     */
    public float getRating(int recipeID);
}
