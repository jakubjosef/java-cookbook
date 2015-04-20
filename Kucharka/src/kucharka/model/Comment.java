package kucharka.model;

import java.util.Date;

public class Comment {
    
    private int id;
     private String author;
    private String text;
    private int recipeId;
    private byte rating;
    private Date inserted;

    public Comment() {
    }
    public Comment(String author, String text, byte rating,Date inserted) {
        this.author = author;
        this.text = text;
        this.rating = rating;
        this.inserted=inserted;
    }   
    public Comment(String author, String text, byte rating,Date inserted, int recipeId) {
        this.author = author;
        this.text = text;
        this.rating = rating;
        this.inserted=inserted;
        this.recipeId=recipeId;
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
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the recipeId
     */
    public int getRecipeId() {
        return recipeId;
    }

    /**
     * @param recipeId the recipeId to set
     */
    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    /**
     * @return the rating
     */
    public byte getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(byte rating) {
        this.rating = rating;
    }

    /**
     * @return the inserted
     */
    public Date getInserted() {
        return inserted;
    }

    /**
     * @param inserted the inserted to set
     */
    public void setInserted(Date inserted) {
        this.inserted = inserted;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", author=" + author + ", text=" + text + ", recipeId=" + recipeId + ", rating=" + rating + ", inserted=" + inserted + '}';
    }



}
