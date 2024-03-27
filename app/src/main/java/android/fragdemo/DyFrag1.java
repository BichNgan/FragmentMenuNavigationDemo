package android.fragdemo;



import android.os.Bundle;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DyFrag1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DyFrag1 extends Fragment {

    Button btnDy1;
    EditText edtIp;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DyFrag1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DyFrag1.
     */
    // TODO: Rename and change types and number of parameters
    public static DyFrag1 newInstance(String param1, String param2) {
        DyFrag1 fragment = new DyFrag1();
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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dy_frag1,container,false);
        btnDy1 = (Button) view.findViewById(R.id.btnDy1);
        edtIp=(EditText)view.findViewById(R.id.edtIp);
        btnDy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity().getApplicationContext(),"DyFrag1 đang thực thi!", Toast.LENGTH_LONG).show();
                String st = String.valueOf(edtIp.getText());
                Bundle bundle = new Bundle();
                bundle.putString("key1",st);
                bundle.putString("key2","Hello");
                FragmentManager fm=getParentFragmentManager();
                fm.setFragmentResult("keyMain",bundle);
            }
        });
        return view;
    }
}