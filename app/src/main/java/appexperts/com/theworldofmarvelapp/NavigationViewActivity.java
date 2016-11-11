package appexperts.com.theworldofmarvelapp;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import appexperts.com.theworldofmarvelapp.Comic.ComicFragment;

import static io.fabric.sdk.android.services.network.UrlUtils.urlEncode;

public class NavigationViewActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    private static final String MARVEL_KEY = "144ae9a1d6261ea12ca170b8d47d6df3";
    private static final String MARVEL_SECRET = "75bc31531c853f8b865dd56109aef6689cd68144";
//    @BindView(R.id.imageView) ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        generateMarvelHash("144ae9a1d6261ea12ca170b8d47d6df3","75bc31531c853f8b865dd56109aef6689cd68144");

//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(NavigationViewActivity.this, CarouselActivity.class);
//                startActivity(intent);
//                finish();
//
//            }
//        });


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//
//                Intent intent = new Intent(NavigationViewActivity.this, LoginActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_profile:{
                        Log.e("String", "Comics");
                        ComicFragment comicFragment = new ComicFragment();
                        addFragment(comicFragment);
                        break;
                    }
                    case R.id.nav_characters:{
                        Log.e("String", "characters");

                        break;
                    }
                    case R.id.nav_save:{
                        Log.e("String", "characters");
                        ComicFragment comicFragment = new ComicFragment();
                        addFragment(comicFragment);
                        break;
                    }
                    case R.id.nav_tools:{
                        Log.e("String", "tools");
                        break;
                    }
                    case R.id.nav_share:{
                        Log.e("String", "share");
                        // Create intent using ACTION_VIEW and a normal Twitter url:
                        String tweetUrl = String.format("https://twitter.com/intent/tweet?text=%s&url=%s",
                                urlEncode("I've just found this awesome new app"),
                                urlEncode("https://www.google.fi/"));
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tweetUrl));

// Narrow down to official Twitter app, if available:
                        List<ResolveInfo> matches = getPackageManager().queryIntentActivities(intent, 0);
                        for (ResolveInfo info : matches) {
                            if (info.activityInfo.packageName.toLowerCase().startsWith("com.twitter")) {
                                intent.setPackage(info.activityInfo.packageName);
                            }
                        }

                        startActivity(intent);
                        break;
                    }
                    case R.id.nav_send:{
                        Log.e("String", "send");
                        break;
                    }

                }
                return true;
            }
        });



//        // TODO: Use a more specific parent
//        final ViewGroup parentView = (ViewGroup) getWindow().getDecorView().getRootView();
//        // TODO: Base this Tweet ID on some data from elsewhere in your app
//        long tweetId = 631879971628183552L;
//        TweetUtils.loadTweet(tweetId, new Callback<Tweet>() {
//            @Override
//            public void success(appexperts.com.theworldofmarvelapp.Comic.appexperts.com.theworldofmarvelapp.comicTest.Result<Tweet> result) {
//                TweetView tweetView = new TweetView(NavigationViewActivity.this, result.data);
//                parentView.addView(tweetView);
//            }
//
//            @Override
//            public void failure(TwitterException exception) {
//                Log.d("TwitterKit", "Load Tweet failure", exception);
//            }
//        });

    }

    public static String generateMarvelHash (String publicKey, String privateKey) {

        String marvelHash = "";

        try {

            String timeStamp    = getUnixTimeStamp();
            String marvelData   = timeStamp + privateKey + publicKey;

            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] hash = messageDigest.digest(marvelData.getBytes());

            StringBuilder stringBuilder = new StringBuilder(2 * hash.length);

            for (byte b : hash)
                stringBuilder.append(String.format("%02x", b&0xff));

            marvelHash = stringBuilder.toString();
            Log.e("Hash", marvelHash);
            Log.e("timestamp", timeStamp);


        } catch (NoSuchAlgorithmException e) {

            System.out.println("[DEBUG]" + " MarvelApiUtils generateMarvelHash - " +
                    "NoSuchAlgorithmException");
            Log.e("Hash", marvelHash);
        }

        return marvelHash;

    }

    public static String getUnixTimeStamp () {

        return String.valueOf(System.currentTimeMillis() / 1000L);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_view, menu);
            // Associate searchable configuration with the SearchView
            SearchManager searchManager =
                    (SearchManager) getSystemService(Context.SEARCH_SERVICE);
            SearchView searchView =
                    (SearchView) menu.findItem(R.id.action_search).getActionView();
            searchView.setSearchableInfo(
                    searchManager.getSearchableInfo(getComponentName()));


            return true;
        }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            return true;
        }
        if (id == R.id.action_settings) {
            return true;
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_signout) {
            Intent intent = new Intent(NavigationViewActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void addFragment(Fragment fragment){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fragmentHolder, fragment);
        ft.commit();

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            // Handle the camera action
        } else if (id == R.id.nav_characters) {

        } else if (id == R.id.nav_save) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
