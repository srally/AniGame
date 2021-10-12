package com.example.game4;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ViewGroup ml;
    private ImageView ia;
    private int dx;
    private int dy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ml = (RelativeLayout) findViewById(R.id.main);
        ia = (ImageView) findViewById(R.id.ia);
        ia.setOnTouchListener(otl());
    }

    private OnTouchListener otl(){
        return new OnTouchListener(){
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent me){
                final int x=(int) me.getRawX();
                final int y=(int) me.getRawY();
                switch (me.getAction() & MotionEvent.ACTION_MASK){
                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams P = (RelativeLayout.LayoutParams)
                                v.getLayoutParams();
                        dx=x-P.leftMargin;
                        dy=y-P.topMargin;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams P2=(RelativeLayout.LayoutParams)
                                v.getLayoutParams();
                        P2.leftMargin=x-dx;
                        P2.topMargin=y-dy;
                        P2.rightMargin=0;
                        P2.bottomMargin=0;
                        v.setLayoutParams(P2);
                        break;
                }
                mainLayout.invalidate();
                return true;
            }
        }
    }
}