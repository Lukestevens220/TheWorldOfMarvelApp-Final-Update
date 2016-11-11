package appexperts.com.theworldofmarvelapp.constants;

/**
 * Created by TheAppExperts on 28/10/2016.
 */

public class Constants {

    //Base URL
    public static final String BASE_URL = "https://gateway.marvel.com";
    //Fetches lists of characters
    public static final String CHARACTERS_URL = "/v1/public/characters";
    // Fetches lists of comics filtered by a character id
    public static final String COMICS_URL = "/v1/public/characters/{characterId}/comics";
    public static final String SERIES_URL = "/v1/public/series";
    public static final String STORIES_URL = "/v1/public/stories";
}
