package DAO.Entity;

/**
 * Created by 1 on 02.06.2015.
 */
public class News extends ABaseEntity {

    private String captionNews = null;
    private String textNews = null;
    private int countLike;
    private String dateNews = null;

    public News(){}

    public News(String captionNews, String textNews){
        this.captionNews = captionNews;
        this.textNews = textNews;
    }

    public String getCaptionNews() {
        return captionNews;
    }

    public void setCaptionNews(String captionNews) {
        this.captionNews = captionNews;
    }

    public String getTextNews() {
        return textNews;
    }

    public void setTextNews(String textNews) {
        this.textNews = textNews;
    }

    public int getCountLike() {
        return countLike;
    }

    public void setCountLike(int countLike) {
        this.countLike = countLike;
    }

    public String getDateNews() {
        return dateNews;
    }

    public void setDateNews(String dateNews) {
        this.dateNews = dateNews;
    }
}
