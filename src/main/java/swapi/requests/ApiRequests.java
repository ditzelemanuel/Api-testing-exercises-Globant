package swapi.requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiRequests {
    private static final String BASE_URL = "https://swapi.dev/";

    public static Response getPeopleById(int id) {
        return RestAssured.get(BASE_URL + "api/people/" + id + "/");
    }

    public static Response getFilmByUrl(String url) {
        return RestAssured.get(url);
    }

    public static Response getPlanetByUrl(String url) {
        return RestAssured.get(url);
    }

    public static Response getFilmById(int id) {
        return RestAssured.get(BASE_URL + "api/films/" + id + "/");
    }
}

