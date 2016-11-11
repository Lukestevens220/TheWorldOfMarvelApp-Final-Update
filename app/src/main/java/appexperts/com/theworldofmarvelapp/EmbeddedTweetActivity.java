package appexperts.com.theworldofmarvelapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.TimelineResult;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

/**
 * Created by TheAppExperts on 02/11/2016.
 */

public class EmbeddedTweetActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline);

        final SwipeRefreshLayout swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName("Luke_stevens220")
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(this)
                .setTimeline(userTimeline)
                .build();

        setListAdapter(adapter);

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeLayout.setRefreshing(true);
                adapter.refresh(new Callback<TimelineResult<Tweet>>() {
                    @Override
                    public void success(Result<TimelineResult<Tweet>> result) {
                        swipeLayout.setRefreshing(false);
                    }

                    @Override
                    public void failure(TwitterException exception) {
                        // Toast or some other action
                    }
                });
            }
        });


//        File myImageFile = new File("/path/to/image");
//        Uri myImageUri = Uri.fromFile(myImageFile);
//
//        TweetComposer.Builder builder = new TweetComposer.Builder(this)
//                .text("just setting up my Fabric.")
//                .image(myImageUri);
//        builder.show();


//        // TODO: Use a more specific parent
//        final ViewGroup parentView = (ViewGroup) getWindow().getDecorView().getRootView();
//        // TODO: Base this Tweet ID on some data from elsewhere in your app
//        long tweetId = 631879971628183552L;
//        TweetUtils.loadTweet(tweetId, new Callback<Tweet>() {
//            @Override
//            public void success(appexperts.com.theworldofmarvelapp.Comic.appexperts.com.theworldofmarvelapp.comicTest.Result<Tweet> result) {
//                TweetView tweetView = new TweetView(EmbeddedTweetActivity.this, result.data);
//                parentView.addView(tweetView);
//            }
//            @Override
//            public void failure(TwitterException exception) {
//                Log.d("TwitterKit", "Load Tweet failure", exception);
//            }
//        });


    }}
