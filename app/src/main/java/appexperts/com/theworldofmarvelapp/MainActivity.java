package appexperts.com.theworldofmarvelapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

import io.fabric.sdk.android.Fabric;

/**
 * @version 1.1
 * @author Luke
 */
public class MainActivity extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "uukA3szldtWU2fIk1ljHsfLqh";
    private static final String TWITTER_SECRET = "YAPR3DanSeIi4tEFTwgQWDbtD9zdCMwJMSoZbrNXx2WMSI7WGT";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new TwitterCore(authConfig), new TweetComposer());
        setContentView(R.layout.activity_main);
    }
}
