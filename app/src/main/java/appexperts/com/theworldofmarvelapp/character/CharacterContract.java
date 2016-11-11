package appexperts.com.theworldofmarvelapp.character;

import appexperts.com.theworldofmarvelapp.models.Hero;
import appexperts.com.theworldofmarvelapp.mvp.BasePresenter;
import appexperts.com.theworldofmarvelapp.mvp.BaseView;

/**
 * Created by TheAppExperts on 03/11/2016.
 */

public interface CharacterContract {

    interface PresenterContract extends BasePresenter {

        void start();
        void getComics(int productId);

    }

    interface ViewContract extends BaseView<PresenterContract> {

        void startProgressDialog();
        void dismissProgressDialog();
        void displayError();
        void setProductDetails(Hero.Data.Result productDetails);

    }
}