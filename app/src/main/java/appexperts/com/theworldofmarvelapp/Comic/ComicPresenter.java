package appexperts.com.theworldofmarvelapp.Comic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import appexperts.com.theworldofmarvelapp.Comic.ComicContract;
import appexperts.com.theworldofmarvelapp.Comic.Result;
import appexperts.com.theworldofmarvelapp.database.DatabaseHelper;
import appexperts.com.theworldofmarvelapp.models.Hero;
import appexperts.com.theworldofmarvelapp.rest.ApiClient;
import appexperts.com.theworldofmarvelapp.rest.ApiInterface;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by TheAppExperts on 03/11/2016.
 */

public class ComicPresenter implements ComicContract.PresenterContract {
    private ComicContract.ViewContract fragment;
    private ApiInterface observables;
    private Context context;
    private int productId;
    private static final String TAG = "ComicPresenter";

    public ComicPresenter(Context context, ComicContract.ViewContract fragment) {
        this.context = context;
        this.fragment = fragment;
        connectToService();
    }

    @Override
    public void start() {

        fragment.setPresenter(this);
        fragment.initialiseSwipeRefreshLayout();
        getComics();
    }

    @Override
    public void getComics() {
        Log.d(TAG, "comics starting");
        fragment.startProgressDialog();
        Log.d(TAG, "comics ending");
        getProductDetailsFromInternet();
        this.productId = productId;
    }


    private void connectToService() {
        Log.d(TAG, "ConnectToService starting");
        observables = ApiClient.getClient();
        Log.d(TAG, "ConnectToService ending");
    }

    private void getProductDetailsFromInternet() {
        Log.d(TAG, "getProductDetailsFromInternet starting");
//        Log.i(TAG, "Product ID is " + productId);

//        Observable<ComicResults> getComicObservables = (Observable<ComicResults>)
//                ApiClient.getPreparedObservable(observables.getComics(), ComicResults.class, true, true);

        observables.getComics()
                .onBackpressureBuffer()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ComicResults>() {
                    @Override
                    public void onCompleted() {
//                        fragment.dismissProgressDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        fragment.displayError();
                        //fragment.dismissProgressDialog();
                        Log.d(TAG, e.toString());
                    }

                    @Override
                    public void onNext(ComicResults comics) {
                        Log.d(TAG, "onNext starting");

                        updateResultsInDatabase(comics);
                        processResults(comics);

                    }

                });
        Log.d(TAG, "getProductDetailsFromInternet ending");
    }

//    private void getProductDetailsFromDatabase() {
//        DatabaseHelper dbHelper = DatabaseHelper.getInstance(context);
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        ComicDatabaseEntry entry = cupboard().withDatabase(db).get(ComicDatabaseEntry.class, productId);
//        if (entry != null) {
//            Gson gson = new Gson();
//            ArrayList<appexperts.com.theworldofmarvelapp.comicTest.Result> results = gson.fromJson(entry.entryString, appexperts.com.theworldofmarvelapp.comicTest.Result.class);
//            processResults(results);
//        } else {
//            fragment.displayError();
//            fragment.dismissProgressDialog();
//        }

    //    }
    private void processResults(ComicResults results) {
        Data data = results.getData();
        ArrayList<Result> categories = new ArrayList<Result>();
        categories.addAll(data.getResults());

        Log.i("MainActivityPresenter", "Size of categories array is " + categories.size());

        if (categories.size() > 0) {
            fragment.setComics(categories);
        } else {
            fragment.displayError();
        }

        fragment.dismissProgressDialog();
    }

    private void updateResultsInDatabase(ComicResults results) {
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
