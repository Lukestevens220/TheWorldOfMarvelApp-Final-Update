package appexperts.com.theworldofmarvelapp;

//import android.app.ProgressDialog;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v4.widget.SwipeRefreshLayout;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import java.util.ArrayList;
//
//import samples.exoguru.materialtabs.adapter.SongAdapter;
//import samples.exoguru.materialtabs.model.Song;
//import samples.exoguru.materialtabs.mvp.SongActivityContract;
//import samples.exoguru.materialtabs.mvp.SongPresenter;
//
//import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Edwin on 15/02/2015.
 */
//public class Tab3 extends Fragment implements SongActivityContract.ViewContract {
//
//
//    private RecyclerView recyclerView;
//    private SongAdapter adapter;
//    private ProgressDialog progressDialog;
//    private SwipeRefreshLayout swipeRefreshLayout;
//    private SongCentre.onSongsDownloadedListener fragment;
//    SongActivityContract.PresenterContract presenterContract;
//    SongPresenter songPresenter;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View v =inflater.inflate(R.layout.tab_3,container,false);
//        initialiseRecyclerView(v);
//        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_refresh_layout);
//        songPresenter = new SongPresenter(this, SongCentre.ROCK);
//        songPresenter.getSongs();
//
//        return v;
//    }
//
//    public void setSongs(ArrayList<Song> songs){
//        SongAdapter adapter = new SongAdapter(getActivity(), songs);
//        recyclerView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//        hideProgressDialog();
//        swipeRefreshLayout.setRefreshing(false);
//    }
//
//    public void initialiseSwipeRefreshLayout() {
//
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                Log.i("SwipeRefreshLayout", "onRefresh called from SwipeRefreshLayout");
//                songPresenter.getSongs();
//
//            }
//        });
//    }
//
//    public void initialiseRecyclerView(View v) {
//        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//    }
//
//    public void initialiseProgressDialog() {
//        progressDialog = new ProgressDialog(getActivity());
//        progressDialog.setMessage("Loading...");
//        progressDialog.setCancelable(false);
//        progressDialog.show();
//
//    }
//
//    public void hideProgressDialog() {
//        if (progressDialog != null) {
//            progressDialog.dismiss();
//            progressDialog = null;
//        }
//
//    }
//
//    @Override
//    public void setPresenter(@NonNull SongActivityContract.PresenterContract presenterContract) {
//        this.presenterContract = checkNotNull(presenterContract);
//    }
//}
