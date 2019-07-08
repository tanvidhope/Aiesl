package com.example.user.airindiaengg;

import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import static android.content.ContentValues.TAG;

import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.example.user.airindiaengg.Adapter.CustomExpandableListAdapter;
import com.example.user.airindiaengg.Helper.FragmentNavigationManager;
import com.example.user.airindiaengg.Interface.NavigationManager;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class drawer extends AppCompatActivity {

    //--------------------------------------------------------------------------
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;
    private String[] items;

    private ExpandableListView expandableListView;
    private ExpandableListAdapter adapter;
    private List<String> lstTitle;
    private Map<String, List<String>> lstChild;
    private NavigationManager navigationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle=getTitle().toString();
        expandableListView=(ExpandableListView)findViewById(R.id.navList);
        navigationManager= FragmentNavigationManager.getnInstance(this);

        initItems();

        View listHeaderView = getLayoutInflater().inflate(R.layout.nav_header, null,false);
        expandableListView.addHeaderView(listHeaderView);

        getData();

        addDrawersItem();
        setupDrawer();

        if(savedInstanceState==null){
            selectFirstItemAsDefault();
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("AIESL");

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    private void selectFirstItemAsDefault() {

        if(navigationManager!=null)
        {
            String firstItem=lstTitle.get(0);
            navigationManager.showFragment(firstItem);
            //getSupportActionBar().setTitle(firstItem);

        }
    }

    private void setupDrawer() {
        mDrawerToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close)
        {
            @Override
            public void onDrawerOpened(View drawerView){
                super.onDrawerOpened(drawerView);
                //getSupportActionBar().setTitle("AirIndia--AI");
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView){
                super.onDrawerClosed(drawerView);
                //getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu();

            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    private void addDrawersItem() {
        try{
        adapter=new CustomExpandableListAdapter(this, lstTitle,lstChild);
        expandableListView.setAdapter(adapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                //getSupportActionBar().setTitle(lstTitle.get(groupPosition).toString());

            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                //getSupportActionBar().setTitle("AirIndia(AI)");
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int ChildPosition, long l) {
                String selectedItem=((List)lstChild.get(lstTitle.get(groupPosition))).get(ChildPosition).toString();
                //getSupportActionBar().setTitle(selectedItem);
                Log.d("going into if->"+items[0]+"->"+lstTitle.get(groupPosition)+items[0].equals("Air India"), "   ------------------------------if statement follows ---------------------------------------------------");

                //if(items[0].equals(lstTitle.get(groupPosition)))
                if(true)
                    navigationManager.showFragment(selectedItem);
                else
                    throw new IllegalArgumentException("-------------------------Not supported fragment-------------------------------------");
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });}
        catch (Exception e){
        //String e;
                Log.d(e.toString(), "   ------------------------------addDrawersItem: ---------------------------------------------------");
        }
    }

    private void getData() {
        List<String> title= Arrays.asList("About Us","Services","Approvals & Capabilities","Contact Us");
        List<String> childitem1=Arrays.asList("Organization", "Facilities", "Clients", "Accreditation");
        List<String> childitem2=Arrays.asList("MRO", "Engineering Training", "Specialized Services", "Allied Services");
        List<String> childitem3=Arrays.asList("Approvals", "Aircraft Capabilities", "Component Capabilities", "MRO Capabilities");
        List<String> childitem4=Arrays.asList("Reach Us", "Tenders", "Careers", "Licence");


        lstChild=new TreeMap<>();
        lstChild.put(title.get(0),childitem1);
        lstChild.put(title.get(1),childitem2);
        lstChild.put(title.get(2),childitem3);
        lstChild.put(title.get(3), childitem4);
        Log.d(TAG, "getData: approvals: "+ (lstChild).get(""));

        //lstChild.put(title.get(3),childitem4);


        lstTitle=new ArrayList<>(lstChild.keySet());
    }

    private void initItems() {

        items=new String[]{"Air India ", "AIESL", "AirIndia Express"};
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return  true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();

        if(mDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
}
