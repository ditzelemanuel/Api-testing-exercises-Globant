package SWAPITest;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ApiTests {
    @Test
    public void getPeopleById() {
        Response response = ApiRequests.getPeopleById(2);
        Assert.assertEquals(response.getStatusCode(), 200);

        Person person = response.as(Person.class);
        Assert.assertEquals(person.getSkin_color(),"gold");
        Assert.assertEquals(person.getFilms().size(), 6);
    }

    @Test
    public void getSecondFilm() {
        Response peopleResponse = ApiRequests.getPeopleById(2);
        Person person = peopleResponse.as(Person.class);

        Response filmResponse = ApiRequests.getFilmByUrl(person.getFilms().get(1));
        Film film = filmResponse.as(Film.class);

        Assert.assertEquals(filmResponse.getStatusCode(), 200, "Connection error");
        Assert.assertNotNull(film.getRelease_date());
        System.out.println(film.getRelease_date()); // Correct Date
        Assert.assertTrue(film.getPlanets().size() > 1);
        Assert.assertTrue(film.getCharacters().size() > 1);
        Assert.assertTrue(film.getSpecies().size() > 1);
        Assert.assertTrue(film.getVehicles().size() > 1);
    }

    @Test
    public void checkGravityAndTerrainsLevels() {
        Response peopleResponse = ApiRequests.getPeopleById(2);
        Person person = peopleResponse.as(Person.class);

        Response filmResponse = ApiRequests.getFilmByUrl(person.getFilms().get(1));
        Film film = filmResponse.as(Film.class);

        Response planetResponse = ApiRequests.getPlanetByUrl(film.getPlanets().get(1));
        Planet planet = planetResponse.as(Planet.class);

        System.out.println(planet.getName());
        Assert.assertEquals(planet.getTerrain(), Fixtures.TERRAIN);
        Assert.assertEquals(planet.getGravity(), Fixtures.GRAVITY);
    }

    @Test
    public void checkUrlIsTheSameAsTheRequest() {
        Response peopleResponse = ApiRequests.getPeopleById(2);
        Person person = peopleResponse.as(Person.class);

        Response filmResponse = ApiRequests.getFilmByUrl(person.getFilms().get(1));
        Film film = filmResponse.as(Film.class);

        Response planetResponse = ApiRequests.getPlanetByUrl(film.getPlanets().get(0));
        Planet planet = planetResponse.as(Planet.class);

        String planetFromResponse = planet.getUrl();
        Response secondPlanetResponse = ApiRequests.getPlanetByUrl(planetFromResponse);
        Planet secondPlanet = secondPlanetResponse.as(Planet.class);

        Assert.assertEquals(planet, secondPlanet);
    }

    @Test
    public void requestFilmAndCheck404CodeResponse() {
        Response response = ApiRequests.getFilmById(7);
        Assert.assertEquals(response.getStatusCode(),404);
    }
}
