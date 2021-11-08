package manager;

import domain.Movie;

public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int limit;

    public int getLimit() {

        return limit;
    }

    public Movie[] getMovies() {

        return movies;
    }

    public MovieManager() {

        this.limit = 10;
    }

    public MovieManager(int limit) {
        if (limit <= 0) {
            this.limit = 10;
        } else {
            this.limit = limit;
        }
    }

    public void add(Movie film) {
        int length = movies.length + 1;
        Movie[] newFilm = new Movie[length];
        for (int i = 0; i < movies.length; i++) {
            newFilm[i] = movies[i];
        }
        int lastIndex = length - 1;
        newFilm[lastIndex] = film;
        movies = newFilm;

    }

    public Movie[] giveLastFilm() {
        int resultLength;
        if (this.getLimit() > movies.length) {
            resultLength = movies.length;
        } else {
            resultLength = this.getLimit();
        }
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }


}
