package appexperts.com.theworldofmarvelapp.Carousel;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import appexperts.com.theworldofmarvelapp.R;

/**
 * Created by TheAppExperts on 06/11/2016.
 */

public class CustomSwip extends PagerAdapter {
    private int[] imageResources = {R.drawable.imagess, R.drawable.images2, R.drawable.images3, R.drawable.images4, R.drawable.images5, R.drawable.images6, R.drawable.images7, R.drawable.images8, R.drawable.images9, R.drawable.images10, R.drawable.images11, R.drawable.images12, R.drawable.images13};
    private Context context;
    private LayoutInflater layoutInflater;

    public CustomSwip(Context c) {
        context = c;
    }

    @Override
    public int getCount() {
        return imageResources.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.activity_custom_swip, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.swip_image_view);
        final TextView textView = (TextView) itemView.findViewById(R.id.imageCount);
        imageView.setImageResource(imageResources[position]);
        textView.setText("image counter: " + position);
        container.addView(itemView);
        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ImageView i = (ImageView)v;
                if(position == 0)
                {
                   textView.setText("Iron Man");
                }
                if(position == 1){
                    textView.setText("Iron Man");
                }
                //...

            }
        });

        return itemView;
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }
}
