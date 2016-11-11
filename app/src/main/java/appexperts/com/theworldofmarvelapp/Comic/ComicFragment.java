package appexperts.com.theworldofmarvelapp.Comic;

/**
 * Created by TheAppExperts on 08/11/2016.
 */


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import appexperts.com.theworldofmarvelapp.R;

import static android.content.ContentValues.TAG;
import static com.google.common.base.Preconditions.checkNotNull;


/**
 * Created by TheAppExperts on 04/11/2016.
 */

public class ComicFragment extends Fragment implements ComicContract.ViewContract{

    private static final String CATEGORY_ID = "categoryId";

    private int categoryId;
    private RecyclerView comicRecyclerView;
    private ComicContract.PresenterContract presenterContract;
    private ComicPresenter presenter;
    private ArrayList<Result> comics;

    private ProgressDialog progressDialog;
    private SwipeRefreshLayout swipeRefreshLayout;

    public ComicFragment() {
        // Required empty public constructor
    }

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param categoryId Parameter 1.
//     * @return A new instance of fragment ProductsByCategoryFragment.
//     */
//    public static ComicFragment newInstance(String categoryId) {
//        ComicFragment fragment = new appexperts.com.theworldofmarvelapp.character.CharacterFragment();
////        Bundle args = new Bundle();
////        args.putString(CATEGORY_ID, categoryId);
////        fragment.setArguments(args);
//        return fragment;
//    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            categoryId = getArguments().getInt(CATEGORY_ID);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.tab_1, container, false);
        initialiseRecyclerView(v);
        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_refresh_layout);
        presenter = new ComicPresenter(getActivity(), this);
        presenter.start();


        return v;
    }

    private void initialiseRecyclerView(View v){
        comicRecyclerView = (RecyclerView) v.findViewById(R.id.comic_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        comicRecyclerView.setLayoutManager(linearLayoutManager);
//        SnapHelper snapHelper = new LinearSnapHelper();
//        snapHelper.attachToRecyclerView(productImageRecyclerView);
    }


    @Override
    public void startProgressDialog() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void initialiseSwipeRefreshLayout() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.i("SwipeRefreshLayout", "onRefresh called from SwipeRefreshLayout");
                presenter.getComics();

            }
        });
    }

    @Override
    public void dismissProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    @Override
    public void displayError() {
        Toast.makeText(getActivity(), "Problem fetching products", Toast.LENGTH_LONG).show();
    }

    @Override
    public void setComics(ArrayList<Result> comics) {
        Log.d(TAG, "setCategories starting");
        this.comics = comics;
        ComicAdapter adapter = new ComicAdapter(getActivity(),comics);
        comicRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        Log.d(TAG, "setCategories ending");
    }


    public void hideProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }

    }


    @Override
    public void setPresenter(@NonNull ComicContract.PresenterContract presenter) {
        Log.d(TAG, "setPresenter starting");
        this.presenterContract = checkNotNull(presenter);
        Log.d(TAG, "setPresenter ending");
    }
}
