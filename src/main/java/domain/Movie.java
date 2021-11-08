package domain;

public class Movie {
    private int id;
    private String name;
    private String genre;
    private boolean premier;

    public Movie(int id, String name, String genre, boolean premier) {
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getGenre() {

        return genre;
    }

    public void setGenre(String genre) {

        this.genre = genre;
    }

    public boolean isPremier() {

        return premier;
    }

    public void setPremier(boolean premier) {

        this.premier = premier;
    }
}
