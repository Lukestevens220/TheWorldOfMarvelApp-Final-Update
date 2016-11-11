package appexperts.com.theworldofmarvelapp.character;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.gson.Gson;

import appexperts.com.theworldofmarvelapp.database.DatabaseHelper;
import appexperts.com.theworldofmarvelapp.models.Hero;
import appexperts.com.theworldofmarvelapp.rest.ApiClient;
import appexperts.com.theworldofmarvelapp.rest.ApiInterface;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by TheAppExperts on 03/11/2016.
 */

public class CharacterPresenter implements CharacterContract.PresenterContract {
    private CharacterContract.ViewContract fragment;
    private ApiInterface observables;
    private Context context;
    private int productId;
    private static final String TAG = "StoriesPresenter";

    public CharacterPresenter(Context context, CharacterContract.ViewContract fragment) {
        this.context = context;
        this.fragment = fragment;
        connectToService();
    }

    @Override
    public void start() {

        fragment.setPresenter(this);
    }

    @Override
    public void getComics(int productId) {
        fragment.startProgressDialog();
        this.productId = productId;
    }


    private void connectToService() {
        Log.d(TAG, "ConnectToService starting");
        observables = ApiClient.getClient();
        Log.d(TAG, "ConnectToService ending");
    }

//    private void getProductDetailsFromInternet() {
//        Log.d(TAG, "getProductDetailsFromInternet starting");
//        Log.i(TAG, "Product ID is " + productId);
//
//        observables.getComics(productId)
//                .onBackpressureBuffer()
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Hero.appexperts.com.theworldofmarvelapp.comic.appexperts.com.theworldofmarvelapp.comic.appexperts.com.theworldofmarvelapp.series.appexperts.com.theworldofmarvelapp.series.appexperts.com.theworldofmarvelapp.series.appexperts.com.theworldofmarvelapp.stories.Data.appexperts.com.theworldofmarvelapp.comic.appexperts.com.theworldofmarvelapp.comic.appexperts.com.theworldofmarvelapp.series.appexperts.com.theworldofmarvelapp.series.appexperts.com.theworldofmarvelapp.series.appexperts.com.theworldofmarvelapp.stories.Result>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        fragment.displayError();
//                        fragment.dismissProgressDialog();
//                        Log.d(TAG, e.toString());
//                    }
//
//                    @Override
//                    public void onNext(Hero.appexperts.com.theworldofmarvelapp.comic.appexperts.com.theworldofmarvelapp.comic.appexperts.com.theworldofmarvelapp.series.appexperts.com.theworldofmarvelapp.series.appexperts.com.theworldofmarvelapp.series.appexperts.com.theworldofmarvelapp.stories.Data.appexperts.com.theworldofmarvelapp.comic.appexperts.com.theworldofmarvelapp.comic.appexperts.com.theworldofmarvelapp.series.appexperts.com.theworldofmarvelapp.series.appexperts.com.theworldofmarvelapp.series.appexperts.com.theworldofmarvelapp.stories.Result comics) {
//                        Log.d(TAG, "onNext starting");
//
//                        updateResultsInDatabase(comics);
//                        processResults(comics);
//                    }
//
//                });
//        Log.d(TAG, "getProductDetailsFromInternet ending");
//    }

    private void getProductDetailsFromDatabase() {
        DatabaseHelper dbHelper = DatabaseHelper.getInstance(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ComicDatabaseEntry entry = cupboard().withDatabase(db).get(ComicDatabaseEntry.class, productId);
        if (entry != null) {
            Gson gson = new Gson();
            Hero.Data.Result results = gson.fromJson(entry.entryString, Hero.Data.Result.class);
            processResults(results);
        } else {
            fragment.displayError();
            fragment.dismissProgressDialog();
        }

    }
    private void processResults(Hero.Data.Result results) {
        if (results != null) {
            fragment.setProductDetails(results);
        } else {
            fragment.displayError();
        }

        fragment.dismissProgressDialog();
    }

    private void updateResultsInDatabase(Hero.Data.Result results) {
        DatabaseHelper dbHelper = DatabaseHelper.getInstance(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Gson gson = new Gson();
        String entryString = gson.toJson(results);
        ComicDatabaseEntry entry = new ComicDatabaseEntry(productId, entryString);
        cupboard().withDatabase(db).put(entry);
    }

    public static class ComicDatabaseEntry {

        private long _id;
        private String entryString;

        public ComicDatabaseEntry() {

        }

        public ComicDatabaseEntry(int id, String entryString){
            this._id = id;
            this.entryString = entryString;
        }

    }


}
