package kucharka.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kucharka.api.CommentService;
import kucharka.model.Comment;

/**
 * Implementace tridy pro ukladani komentaru do DB
 * @author Jakub Josef
 */
public class DBCommentServiceImpl implements CommentService{
    private final String JDBC_URL = "jdbc:derby://localhost:1527/kucharka";
    private Connection conn = null;
    
    public DBCommentServiceImpl(){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            conn = DriverManager.getConnection(JDBC_URL,null,null);
   
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBCommentServiceImpl.class.getName()).log(Level.SEVERE, "Nepodarilo se vytvorit SQL pripojeni!", ex);
        }
   
    }

    @Override
    public void addComment(Comment comment) {
        if(conn!=null){
            String sql = "INSERT INTO comment(author,text,rating,recipe_id,inserted) VALUES(?,?,?,?,?)";
            try {
                try (PreparedStatement st = conn.prepareStatement(sql)) {
                    st.setString(1, comment.getAuthor());
                    st.setString(2, comment.getText());
                    st.setInt(3, comment.getRating());
                    st.setInt(4, comment.getRecipeId());
                    st.setTimestamp(5, new Timestamp(comment.getInserted().getTime()));
                    
                    st.execute();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBCommentServiceImpl.class.getName()).log(Level.SEVERE, "Nepodarilo se pridat komentar!", ex);
            }
        }
    }

    @Override
    public void deleteComment(int commentID) {
        if(conn!=null){
            try{
                String sql = "DELETE FROM comment WHERE id=?";
                try (PreparedStatement st = conn.prepareCall(sql)) {
                    st.setInt(1, commentID);
                    st.execute();
                }
            }catch(SQLException ex){
               Logger.getLogger(DBCommentServiceImpl.class.getName()).log(Level.SEVERE, "Nepodarilo se smazat komentar!", ex);
            }
        }
    }
    

    /**
     * Metoda ziska komentare pro jednotlivy recept
     * @param recipeID
     * @return
     */
    @Override
    public List<Comment> getComments(int recipeID) {
        List<Comment> result = new ArrayList<>();
        if (conn!=null){
        try{
            String sql = "SELECT * FROM comment WHERE recipe_id=? ORDER BY inserted DESC";
                try (PreparedStatement st = conn.prepareCall(sql)) {
                    st.setInt(1, recipeID);
                    
                    ResultSet data = st.executeQuery();
                    while(data.next()){
                        result.add(getComment(data));
                    }
                    data.close();
                }
        }catch(SQLException ex){
            Logger.getLogger(DBCommentServiceImpl.class.getName()).log(Level.SEVERE,"Nepodarilo se ziskat komentare!",ex);
        }
        
        return result;
        }
        return null;
    }
    /**
     * Metoda ziska hodnoceni daneho receptu
     * @param recipeID
     * @return hodnoceni daneho receptu
     */
    @Override
    public float getRating(int recipeID) {
        float rating = 0;
        if(conn!=null){
            try{
                String sql = "SELECT avg(Cast(rating as Float)) FROM comment WHERE recipe_id=?";
                try (PreparedStatement st=conn.prepareCall(sql)){
                    st.setInt(1, recipeID);
                    
                    ResultSet data = st.executeQuery();
                    while(data.next()){
                        BigDecimal bd = new BigDecimal(data.getFloat(1)).setScale(2,RoundingMode.HALF_EVEN);
                        rating = bd.floatValue();
                    }
                }
            
            }catch(SQLException ex){
                Logger.getLogger(DBCommentServiceImpl.class.getName()).log(Level.SEVERE,"Nepodarilo se ziskat rating",ex);
            }
        }
        return rating;
    }
    
    
    private Comment getComment(ResultSet data) throws SQLException{
        Comment c = new Comment();
        c.setRecipeId(data.getInt("recipe_id"));
        c.setInserted(data.getTimestamp("inserted"));
        c.setRating(data.getByte("rating"));
        c.setAuthor(data.getString("author"));
        c.setText(data.getString("text"));
        return c;
    }
    
    
}
