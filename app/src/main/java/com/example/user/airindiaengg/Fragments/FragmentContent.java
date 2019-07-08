package com.example.user.airindiaengg.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.airindiaengg.R;
import com.example.user.airindiaengg.home;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.zip.Inflater;

public class FragmentContent extends Fragment {

    private int[] mImages =new int[]{
            R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5
    };

    private String[] mImageTitle=new String[]{
            "Major maintenance",
            "Line maintenance",
            "Engine",
            "Landing gear",
            "Avionics"

    };

    //-------------------------------------------------------------------

    private static final String KEY_TITLE="Content";

    public FragmentContent() {
        // Required empty public constructor

    }


    public static FragmentContent newInstance(String param1) {
        FragmentContent fragment = new FragmentContent();
        Bundle args = new Bundle();
        args.putString(KEY_TITLE, param1);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //View view=getView();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        //----------------------------------------------
        return inflater.inflate(R.layout.fragment_fragment_content, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        //View view1 =  inflater.inflate(R.layout.fragment_fragment_content, container, false);
        CarouselView carouselView= view.findViewById(R.id.carousel);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);
            }
        });

        carouselView.setPageCount(mImages.length);


        String title= getArguments().getString(KEY_TITLE);
        ((TextView)view.findViewById(R.id.title)).setText(title);

        //click listener for line maintaince
        ImageView lm = (ImageView) view.findViewById(R.id.lmCard);
        lm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create new fragment and transaction
                Fragment newFragment = new LmFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack if needed
                transaction.replace(R.id.container, newFragment);
                transaction.addToBackStack(null);

// Commit the transaction
                transaction.commit();
            }
        });

        //click listener for base maintaince
        ImageView bm = (ImageView) view.findViewById(R.id.bmCard);
        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment = new BmFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });


        //click listener for APU and Engine
        ImageView ae = (ImageView) view.findViewById(R.id.aeCard);
        ae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment = new ApuFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });


        //click listener for component
        ImageView com = (ImageView) view.findViewById(R.id.comCard);
        com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment = new ComponentFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        ImageView aa = (ImageView) view.findViewById(R.id.aaCard);
        aa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment = new AvionicFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        ImageView lg = (ImageView) view.findViewById(R.id.lgCard);
        lg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment = new LgFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });


        ImageView et = (ImageView) view.findViewById(R.id.etCard);
        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment = new EtFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });


        ImageView ss = (ImageView) view.findViewById(R.id.ssCard);
        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment = new SsFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });



    }

    public void openAct()
    {

    }

}
