import domain.Movie;
import manager.MovieManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieManagerTest {
    MovieManager manager = new MovieManager();
    Movie first = new Movie(1, "Блэдшот", "Фантастика", false);
    Movie second = new Movie(2, "Вперед", "Мультфильм", false);
    Movie third = new Movie(3, "Отель Белград", "Комедия", false);
    Movie fourth = new Movie(4, "Ходячий замок", "Аниме", false);
    Movie fifth = new Movie(5, "Веном 2", "Фантастика", true);
    Movie sixth = new Movie(6, "Босс-молокос 2", "Мультфильм", false);
    Movie seventh = new Movie(7, "Дэвид", "Короткий метр/Драма", true);
    Movie eighth = new Movie(8, "Спасите ральфа", "Короткий метр/Мультфильм", false);
    Movie ninth = new Movie(9, "Дура", "Драма", false);
    Movie tenth = new Movie(10, "Любовь и голуби", "Комедия", false);
    Movie eleventh = new Movie(11, "Оно", "Ужасы", false);

    @Test
    public void shouldAddFilm() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        int expected = 10;
        int actual = manager.getMovies().length;

        assertEquals(expected, actual);

    }

    @Test
    public void shouldGiveLastFilm() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Movie[] actual = manager.giveLastFilm();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGiveLastFilmOverLimit() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        Movie[] actual = manager.giveLastFilm();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGiveLastFilmLimit0() {
        MovieManager manager = new MovieManager(-1);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        Movie[] actual = manager.giveLastFilm();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGiveLastFilmOverLimit11() {
        MovieManager manager = new MovieManager(11);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        Movie[] actual = manager.giveLastFilm();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGiveLastFilmInLimit() {
        MovieManager manager = new MovieManager(5);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        Movie[] actual = manager.giveLastFilm();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth};
        assertArrayEquals(expected, actual);
    }
}


