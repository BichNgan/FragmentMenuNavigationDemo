package android.fragdemo;

import android.os.Bundle;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DyFrag2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DyFrag2 extends Fragment {

    Button btnDy2;
    TextView tvOp;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DyFrag2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DyFrag2.
     */
    // TODO: Rename and change types and number of parameters
    public static DyFrag2 newInstance(String param1, String param2) {
        DyFrag2 fragment = new DyFrag2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        FragmentManager fm= getParentFragmentManager();
        fm.setFragmentResultListener("keyMain", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String st1 = result.getString("key1");
                String st2 = result.getString("key2");
                tvOp.setText(st1 + " "+ st2);

            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dy_frag2, container, false);
        btnDy2=(Button) view.findViewById(R.id.btnDy2);
        tvOp=(TextView)view.findViewById(R.id.tvOp);
        btnDy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),"Đây là DyFrag 2!", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}