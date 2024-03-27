package android.fragdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class DemoDyFrg extends AppCompatActivity {

    Button btnOpenDy1, btnOpenDy2;
    FrameLayout frameDyFrag;
    ArrayList<String> arr=new ArrayList<>();

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
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.replace(R.id.frameDyFrag,fragment);
        ft.commit();
    }
}