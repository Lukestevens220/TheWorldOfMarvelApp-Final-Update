package appexperts.com.theworldofmarvelapp.Comic;

import java.util.ArrayList;

import appexperts.com.theworldofmarvelapp.mvp.BasePresenter;
import appexperts.com.theworldofmarvelapp.mvp.BaseView;

/**
 * Created by TheAppExperts on 08/11/2016.
 */

public interface ComicContract {

    interface PresenterContract extends BasePresenter {

        void start();
        void getComics();

    }

    interface ViewContract extends BaseView<PresenterContract> {

        void startProgressDialog();
        void initialiseSwipeRefreshLayout();
        void dismissProgressDialog();
        void displayError();
        void setComics(ArrayList<Result> comics);

    }
}
