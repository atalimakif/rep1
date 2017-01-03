package makaleYonetimiPackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author akif
 */
public class makale {

    private String id;
    private String title;
    private String authors;
    private String venue;
    private int year;
    private String context;

    public makale() {
    }

    
    public makale(String id, String title, String authors, String venue, int year) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.venue = venue;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
    
    @Override
    public String toString() {
        return "makale{" + "id=" + id + ", title=" + title + ", authors=" + authors + ", venue=" + venue + ", year=" + year + ", context=" + context + '}';
    }

  
}
