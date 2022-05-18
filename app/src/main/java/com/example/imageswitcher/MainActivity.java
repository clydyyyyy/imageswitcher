package com.example.imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    private ImageSwitcher switcher;
    private Button next,prev;
    private int position = 0;
    private int[] images = {R.drawable.zelda1,R.drawable.zelda2,R.drawable.zelda3,R.drawable.zelda4,R.drawable.zelda5,R.drawable.zelda6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switcher = findViewById(R.id.imageSwitcher);
        next = findViewById(R.id.nextbtn);
        prev = findViewById(R.id.prevbtn);

        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(images[position]);
                return imageView;
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position>=0 && position<images.length-1){
                    position++;
                    switcher.setImageResource(images[position]);
                }if(position == images.length-1){
                    next.setEnabled(false);
                    switcher.setImageResource(images[position]);
                }
                prev.setEnabled(true);

            }
        });
        prev.setEnabled(false);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(position>=1 && position<images.length){
                    prev.setEnabled(true);
                    position--;
                    switcher.setImageResource(images[position]);
                }if(position==0){
                    prev.setEnabled(false);
                }
                next.setEnabled(true);


            }
        });
    }
}