package appexperts.com.theworldofmarvelapp.rest;

import appexperts.com.theworldofmarvelapp.Comic.ComicResults;
import appexperts.com.theworldofmarvelapp.constants.Constants;
import appexperts.com.theworldofmarvelapp.models.Hero;
import retrofit2.http.GET;
import rx.Observable;


public interface ApiInterface {
    @GET(Constants.CHARACTERS_URL)
    Observable<Hero> getCharacters();

    @GET(Constants.COMICS_URL)
    //Observable<appexperts.com.theworldofmarvelapp.Comic.appexperts.com.theworldofmarvelapp.comicTest.Result> getComics(@Query("catid") int id);
    Observable<ComicResults> getComics();

//
//    @GET(Constants.PRODUCTS_BY_CATEGORY_URL)
//    Observable<ProductsByCategoryResult> getProductsByCategory(@Query("catid") String id);




}
