package appexperts.com.theworldofmarvelapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.mapbox.mapboxsdk.MapboxAccountManager;
import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

public class SimpleMapViewActivity extends AppCompatActivity {

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Mapbox access token is configured here. This needs to be called either in your application
        // object or in the same activity which contains the mapview.
        MapboxAccountManager.start(this, getString(R.string.access_token));

        // This contains the MapView in XML and needs to be called after the account manager
        setContentView(R.layout.activity_basic_simple_mapview);

        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                // Create an Icon object for the marker to use
                IconFactory iconFactory = IconFactory.getInstance(SimpleMapViewActivity.this);
                Drawable iconDrawable = ContextCompat.getDrawable(SimpleMapViewActivity.this, R.drawable.purple_marker);
                Drawable iconDrawableRed = ContextCompat.getDrawable(SimpleMapViewActivity.this, R.drawable.red_marker);
                Drawable iconDrawableGreen = ContextCompat.getDrawable(SimpleMapViewActivity.this, R.drawable.green_marker);
                Drawable iconDrawableGrey = ContextCompat.getDrawable(SimpleMapViewActivity.this, R.drawable.grey_marker);
                Drawable iconDrawableOrange = ContextCompat.getDrawable(SimpleMapViewActivity.this, R.drawable.orange_marker);
                Drawable iconDrawablePink = ContextCompat.getDrawable(SimpleMapViewActivity.this, R.drawable.pink_marker);
                Drawable iconDrawableYellow = ContextCompat.getDrawable(SimpleMapViewActivity.this, R.drawable.yellow_marker);
                Icon icon = iconFactory.fromDrawable(iconDrawable);
                Icon icon1 = iconFactory.fromDrawable(iconDrawableRed);
                Icon icon2 = iconFactory.fromDrawable(iconDrawableGreen);
                Icon icon3 = iconFactory.fromDrawable(iconDrawableGrey);
                Icon icon4 = iconFactory.fromDrawable(iconDrawableOrange);
                Icon icon5 = iconFactory.fromDrawable(iconDrawablePink);
                Icon icon6 = iconFactory.fromDrawable(iconDrawableYellow);

                // Add the custom icon marker to the map
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(51.50895249999999, -0.06936328124997715))
                        .title("Location")
                        .snippet("You are currently here")
                        .icon(icon));


                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(51.513016, -0.121536))
                        .title("Aquaman convention")
                        .snippet("126 Shaftsbury Ave, London W1D 5ET")
                        .icon(icon1));

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(51.507397, -0.136395))
                        .title("Mr Fantastic book signing")
                        .snippet("14 St James's Square, St. James's, London SW1Y 4LG")
                        .icon(icon2));

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(51.517793, -0.080159))
                        .title("Captain America Museum")
                        .snippet("182 Bishopsgate, London EC2M 4NJ")
                        .icon(icon3));

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(51.503756, 0.047532))
                        .title("Iron man impersonator contest")
                        .snippet("Hartmann Rd, London E16 2PX")
                        .icon(icon4));
//
//                mapboxMap.addMarker(new MarkerOptions()
//                        .position(new LatLng(51.525083, 0.136355))
//                        .title("Phoenix ")
//                        .snippet(" 235 Euston Rd, Fitzrovia, London NW1 2BU")
//                        .icon(icon5));
                // Customize map with markers, polylines, etc.

            }
        });
    }

    // Add the mapView lifecycle to the activity's lifecycle methods
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }


}
