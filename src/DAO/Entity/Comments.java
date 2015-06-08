package DAO.Entity;

/**
 * Created by 1 on 02.06.2015.
 */
public class Comments extends ABaseEntity {

    private String textComment = null;
    private String dateComment = null;

    public Comments(){}

    public Comments(String textComment){
        this.textComment = textComment;
    }

    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    public String getDateComment() {
        return dateComment;
    }

    public void setDateComment(String dateComment) {
        this.dateComment = dateComment;
    }
}
