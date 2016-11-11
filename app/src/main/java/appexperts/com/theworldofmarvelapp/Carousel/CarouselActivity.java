package appexperts.com.theworldofmarvelapp.Carousel;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import appexperts.com.theworldofmarvelapp.R;

public class CarouselActivity extends AppCompatActivity {

    ViewPager viewPager;
    CustomSwip customSwip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carousel);
        viewPager= (ViewPager)findViewById(R.id.viewPager);
        customSwip = new CustomSwip(this);
        viewPager.setAdapter(customSwip);
    }
}
