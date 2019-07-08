package com.example.user.airindiaengg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class home extends AppCompatActivity {
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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //-------

        CarouselView carouselView=findViewById(R.id.carousel);
        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);
            }
        });

        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(home.this,mImageTitle[position],Toast.LENGTH_SHORT).show();

            }
        });



        //-------
        Button button1=(Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(home.this, drawer.class);
                startActivity(intent);
            }
        });

    }



}
