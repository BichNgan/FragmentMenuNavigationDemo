package android.fragdemo;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class Bai3Fragment extends AppCompatActivity {

    Button btnFrg1, btnFrg2;
    FrameLayout frameFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3_fragment);
        addControls();
        addEvents();

    }
    public  void addControls()
    {
        btnFrg1=(Button) findViewById(R.id.btnFrg1);
        btnFrg2=(Button) findViewById(R.id.btnFrg2);
        frameFragment=(FrameLayout) findViewById(R.id.frameFragment);

    }
    public void addEvents()
    {
        btnFrg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new DynamicFrag1());
            }
        });
        btnFrg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new DynamicFrag2());
            }
        });
    }
    public void loadFragment(Fragment fragment)
    {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.replace(R.id.frameFragment,fragment);
        ft.commit();
    }
}