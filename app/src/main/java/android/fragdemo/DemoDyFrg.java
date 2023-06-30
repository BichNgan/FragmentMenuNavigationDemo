package android.fragdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class DemoDyFrg extends AppCompatActivity {

    Button btnOpenDy1, btnOpenDy2;
    FrameLayout frameDyFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_dy_frg);
        addControl();
        addEvent();
    }

    public void addControl()
    {
        btnOpenDy1 =(Button)findViewById(R.id.btnOpenDy1) ;
        btnOpenDy2 =(Button)findViewById(R.id.btnOpenDy2) ;
        frameDyFrag = (FrameLayout) findViewById(R.id.frameDyFrag);
    }
    public void addEvent()
    {
        btnOpenDy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new DyFrag1());
            }
        });
        btnOpenDy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new DyFrag2());
            }
        });

    }
    public void loadFragment (Fragment fragment)
    {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.replace(R.id.frameDyFrag,fragment);
        ft.commit();
    }
}