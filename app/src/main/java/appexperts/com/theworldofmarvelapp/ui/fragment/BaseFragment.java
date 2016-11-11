package appexperts.com.theworldofmarvelapp.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Base fragment created to be extended by every fragment in this application. This class provides
 * dependency injection configuration, ButterKnife Android library configuration and some methods
 * common to every fragment.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public abstract class BaseFragment extends Fragment {

    @Override public void onAttach(Activity activity) {
        super.onAttach(activity);
        injectDependencies();
    }

    /**
     * Every fragment has to inflate a layout in the onCreateView method. We have added this method to
     * avoid duplicate all the inflate code in every fragment. You only have to return the layout to
     * inflate in this method when extends BaseFragment.
     */
    protected abstract int getFragmentLayout();

    /**
     * Replace every field annotated using @Inject annotation with the provided dependency specified
     * inside a Dagger module value.
     */
    public void injectDependencies() {
        // ((AppApplication) getApplicationContext()).inject(this);

    }

    /**
     * Replace every field annotated with ButterKnife annotations like @InjectView with the proper
     * value.
     *
     * @param view to extract each widget injected in the fragment.
     */
    public void bindViews(final View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(getFragmentLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view, savedInstanceState);
    }

    /**
     * Use this method to initialize view components.
     */
    public void initView(View view, Bundle savedInstanceState) {
        bindViews(view);
    }

    @Override
    public void onDestroyView() {
        unbindViews();
        super.onDestroyView();
    }

    public void unbindViews() {
        //ButterKnife.unbind(this);
    }



}