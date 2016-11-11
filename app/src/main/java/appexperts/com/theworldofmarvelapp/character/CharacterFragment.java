//package appexperts.com.theworldofmarvelapp.character;
//
//import android.app.ProgressDialog;
//import android.content.Context;
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.LinearSnapHelper;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.SnapHelper;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import appexperts.com.theworldofmarvelapp.R;
//import appexperts.com.theworldofmarvelapp.models.Hero;
//
//import static android.content.ContentValues.TAG;
//import static com.google.common.base.Preconditions.checkNotNull;
//
///**
// * Created by TheAppExperts on 03/11/2016.
// */
//
//public class CharacterFragment extends Fragment implements CharacterContract.ViewContract {
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String PRODUCT_ID = "productId";
//
//    // TODO: Rename and change types of parameters
//    private int productId;
//    private CharacterContract.PresenterContract mPresenter;
//    private CharacterPresenter comicListPresenter;
//    private Hero heroDetails;
//
//
//    //private OnFragmentInteractionListener mListener;
//
//    public CharacterFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param productId Parameter 1.
//     * @return A new instance of fragment ProductDetailsFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static CharacterFragment newInstance(int productId) {
//        CharacterFragment fragment = new CharacterFragment();
//        Bundle args = new Bundle();
//        args.putInt(PRODUCT_ID, productId);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            productId = getArguments().getInt(PRODUCT_ID);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View v = inflater.inflate(R.layout.fragment_product_details, container, false);
//        productNameTextView = (TextView) v.findViewById(R.id.product_name);
//        productDescriptionTextView = (TextView) v.findViewById(R.id.product_description_textview);
//
//        initialiseRecyclerView(v);
//
//        presenter = new CharacterPresenter(getActivity(), this);
//        presenter.start();
//        presenter.getComics(productId);
//
//        return v;
//    }
//
//    // TODO: Rename method, update argument and hook method into UI event
//    /*public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }*/
//
//    private void initialiseRecyclerView(View v) {
//        productImageRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        productImageRecyclerView.setLayoutManager(linearLayoutManager);
//        SnapHelper snapHelper = new LinearSnapHelper();
//        snapHelper.attachToRecyclerView(productImageRecyclerView);
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        /*if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }*/
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        //mListener = null;
//    }
//
//    @Override
//    public void startProgressDialog() {
//        progressDialog = new ProgressDialog(getActivity());
//        progressDialog.setMessage("Loading...");
//        progressDialog.setCancelable(false);
//        progressDialog.show();
//    }
//
//    @Override
//    public void dismissProgressDialog() {
//        if (progressDialog != null) {
//            progressDialog.dismiss();
//            progressDialog = null;
//        }
//    }
//
//    @Override
//    public void setProductDetails(Hero.appexperts.com.theworldofmarvelapp.series.appexperts.com.theworldofmarvelapp.stories.Data.appexperts.com.theworldofmarvelapp.series.appexperts.com.theworldofmarvelapp.stories.Result productDetails) {
//        Log.d(TAG, "setProductDetails starting");
//        this.productDetails = productDetails;
////        setProductImages();
////        setProductTextInfo();
//        Log.d(TAG, "setProducts ending");
//    }
////
////    private void setProductTextInfo() {
////        productNameTextView.setText(productDetails.getName());
////        StringBuilder stringBuilder = new StringBuilder();
////        stringBuilder.append("Brand: ").append(productDetails.getId())
////                .append("\nColour: ").append(productDetails.getColour())
////                .append("\nSize: ").append(productDetails.getSize())
////                .append("\nPrice: ").append(productDetails.getCurrentPrice());
////        productDescriptionTextView.setText(stringBuilder.toString());
////
////    }
////
////    private void setProductImages() {
////        ArrayList<Hero.appexperts.com.theworldofmarvelapp.comic.appexperts.com.theworldofmarvelapp.comic.appexperts.com.theworldofmarvelapp.series.appexperts.com.theworldofmarvelapp.series.appexperts.com.theworldofmarvelapp.series.appexperts.com.theworldofmarvelapp.stories.Data.appexperts.com.theworldofmarvelapp.comic.appexperts.com.theworldofmarvelapp.comic.appexperts.com.theworldofmarvelapp.series.appexperts.com.theworldofmarvelapp.series.appexperts.com.theworldofmarvelapp.series.appexperts.com.theworldofmarvelapp.stories.Result> productImageUrls = new ArrayList<>();
////        productImageUrls.addAll(productDetails.get());
////        CharacterAdapter adapter = new ProductDetailsAdapter(getActivity(), productImageUrls);
////        productImageRecyclerView.setAdapter(adapter);
////        adapter.notifyDataSetChanged();
////    }
//
//    @Override
//    public void setPresenter(CharacterContract.PresenterContract presenter) {
//        Log.d(TAG, "setPresenter starting");
//        this.presenterContract = checkNotNull(presenter);
//        Log.d(TAG, "setPresenter ending");
//
//    }
//
//    public void displayError() {
//        Toast.makeText(getActivity(), "Problem fetching product information", Toast.LENGTH_LONG).show();
//    }
//
//}