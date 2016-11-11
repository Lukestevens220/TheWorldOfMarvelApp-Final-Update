package appexperts.com.theworldofmarvelapp;//package appexperts.com.theworldofmarvelapp;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import appexperts.com.theworldofmarvelapp.Carousel.CarouselActivity;


/**
 * @author Adil Soomro
 *
 */
public class TabSample extends TabActivity {

//	Toolbar toolbar;
//	ViewPager pager;
//	ViewPagerAdapter adapter;
//	SlidingTabLayout tabs;
//	CharSequence Titles[]={"Home","Comics","appexperts.com.theworldofmarvelapp.Comic.appexperts.com.theworldofmarvelapp.comicTest.Series", "Find Superheroes", "appexperts.com.theworldofmarvelapp.Comic.appexperts.com.theworldofmarvelapp.comicTest.Stories"};
//	int Numboftabs =5;
//	/** Called when the activity is first created. */
//
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setTabs() ;
//		// Creating The Toolbar and setting it as the Toolbar for the activity
//
//
//		// Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
//		adapter =  new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);
//
//		// Assigning ViewPager View and setting the adapter
//		pager = (ViewPager) findViewById(R.id.pager);
//		pager.setAdapter(adapter);
//
//		// Assiging the Sliding Tab Layout View
//		tabs = (SlidingTabLayout) findViewById(R.id.tabs);
//		tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width
//
//		// Setting Custom Color for the Scroll bar indicator of the Tab View
//		tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
//			@Override
//			public int getIndicatorColor(int position) {
//				return getResources().getColor(R.color.tabsScrollColor);
//			}
//		});
//
//		// Setting the ViewPager For the SlidingTabsLayout
//		tabs.setViewPager(pager);
	}
	private void setTabs()
	{
		addTab("Home", R.drawable.tab_home, NavigationViewActivity.class);
		addTab("Comics", R.drawable.tab_search, MainActivity.class);
		addTab("Character", R.drawable.tab_home, CarouselActivity.class);
		addTab("Find Superheroes", R.drawable.tab_search, SimpleMapViewActivity.class);
		addTab("Twitter", R.drawable.tab_home, EmbeddedTweetActivity.class);
	}

	private void addTab(String labelId, int drawableId, Class<?> c)
	{
		TabHost tabHost = getTabHost();
		Intent intent = new Intent(this, c);
		TabHost.TabSpec spec = tabHost.newTabSpec("tab" + labelId);

		View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, getTabWidget(), false);
		TextView title = (TextView) tabIndicator.findViewById(R.id.title);
		title.setText(labelId);
		ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
		icon.setImageResource(drawableId);

		spec.setIndicator(tabIndicator);
		spec.setContent(intent);
		tabHost.addTab(spec);



	}

//	private void addFragment(Fragment fragment){
//	FragmentManager fragmentManager= getSupportFragmentManager();
//		FragmentTransaction ft = fragmentManager.beginTransaction();
//		ft.replace(R.id.fragmentHolder, fragment);
//		ft.commit();
//
//	}
}

//import android.app.TabActivity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TabHost;
//import android.widget.TextView;
//
//import appexperts.com.theworldofmarvelapp.Carousel.CarouselActivity;
//
//public class TabSample extends TabActivity {
//	/** Called when the activity is first created. */
//
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.main);
//		setTabs() ;
//	}
//	private void setTabs()
//	{
//		addTab("Home", R.drawable.tab_home, NavigationViewActivity.class);
//		addTab("Search", R.drawable.tab_search, CarouselActivity.class);
//		addTab("Home", R.drawable.tab_home, NavigationViewActivity.class);
//		addTab("Search", R.drawable.tab_search, NavigationViewActivity.class);
//	}
//
//	private void addTab(String labelId, int drawableId, Class<?> c)
//	{
//		TabHost tabHost = getTabHost();
//		Intent intent = new Intent(this, c);
//		TabHost.TabSpec spec = tabHost.newTabSpec("tab" + labelId);
//
//		View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, getTabWidget(), false);
//		TextView title = (TextView) tabIndicator.findViewById(R.id.title);
//		title.setText(labelId);
//		ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
//		icon.setImageResource(drawableId);
//
//		spec.setIndicator(tabIndicator);
//		spec.setContent(intent);
//		tabHost.addTab(spec);
//	}
//}