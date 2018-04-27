package com.example.wzbc.bmi;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wzbc.bmi.com.xyz.util.PAT;
import com.example.wzbc.bmi.com.xyz.util.WHR;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment_3.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment_3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment_3 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ImageView mSexImage;
    private View Mview;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private BlankFragment_4 bf4;

    private EditText mHeight;
    private EditText mWaist;
    private EditText mNeck;
    private PAT pat1;
    private TextView yourbfr;
    private String anbfr;

    private TextView mIdea_1;
    private TextView mIdea_2;
    private TextView mIdea_3;
    private TextView mIdea_4;
    private TextView mIdea_5;

    private Button button;

    public void init(){
        mSexImage=(ImageView)Mview.findViewById(R.id.sexshuru_c);
        mHeight=(EditText)Mview.findViewById(R.id.neckshuru_c);
        mWaist=(EditText)Mview.findViewById(R.id.waistshuru_c);
        mNeck=(EditText)Mview.findViewById(R.id.heightshuru_c);
        yourbfr=(TextView)Mview.findViewById(R.id.yourbfr);
        mIdea_1=(TextView)Mview.findViewById(R.id.bfr_1);
        mIdea_2=(TextView)Mview.findViewById(R.id.bfr_2);
        mIdea_3=(TextView)Mview.findViewById(R.id.bfr_3);
        mIdea_4=(TextView)Mview.findViewById(R.id.bfr_4);
        mIdea_5=(TextView)Mview.findViewById(R.id.bfr_5);
        button=(Button) Mview.findViewById(R.id.calculate_c);
        mSexImage .setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ft=fm.beginTransaction();
                ft.replace(R.id.content,bf4);
                ft.commit();
            }
        });
    }

    private class calculete implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            pat1=new PAT(Double.parseDouble(mHeight.getText().toString()),Double.parseDouble(mWaist.getText().toString()),Double.parseDouble(mNeck.getText().toString()));
            anbfr=pat1.getcalculate_manbfrString();
            String hh=mHeight.getText().toString();
            String ww=mWaist.getText().toString();
            String nn=mNeck.getText().toString();
            if(hh.equals("") || ww.equals("")||nn.equals("")){
                Toast.makeText(getActivity(), "请填写正确的信息！", Toast.LENGTH_SHORT).show();
            }
            else {
                yourbfr.setText("BFR:"+anbfr);
                Double panduan=(Double.parseDouble(anbfr))*0.01;
                if(panduan<=0.05){
                    mIdea_1.setBackgroundColor(Color.CYAN);
                    mIdea_2.setBackgroundColor(Color.WHITE);
                    mIdea_3.setBackgroundColor(Color.WHITE);
                    mIdea_4.setBackgroundColor(Color.WHITE);
                    mIdea_5.setBackgroundColor(Color.WHITE);
                }else if(panduan>=0.06 && panduan<=0.13){
                    mIdea_1.setBackgroundColor(Color.WHITE);
                    mIdea_2.setBackgroundColor(Color.CYAN);
                    mIdea_3.setBackgroundColor(Color.WHITE);
                    mIdea_4.setBackgroundColor(Color.WHITE);
                    mIdea_5.setBackgroundColor(Color.WHITE);
                }else if(panduan>=0.14 && panduan<=0.17){
                    mIdea_1.setBackgroundColor(Color.WHITE);
                    mIdea_2.setBackgroundColor(Color.WHITE);
                    mIdea_3.setBackgroundColor(Color.CYAN);
                    mIdea_4.setBackgroundColor(Color.WHITE);
                    mIdea_5.setBackgroundColor(Color.WHITE);
                }else if(panduan>=0.18 && panduan<=0.25){
                    mIdea_1.setBackgroundColor(Color.WHITE);
                    mIdea_2.setBackgroundColor(Color.WHITE);
                    mIdea_3.setBackgroundColor(Color.WHITE);
                    mIdea_4.setBackgroundColor(Color.CYAN);
                    mIdea_5.setBackgroundColor(Color.WHITE);
                }else {mIdea_1.setBackgroundColor(Color.WHITE);
                    mIdea_2.setBackgroundColor(Color.WHITE);
                    mIdea_3.setBackgroundColor(Color.WHITE);
                    mIdea_4.setBackgroundColor(Color.WHITE);
                    mIdea_5.setBackgroundColor(Color.CYAN);}
            }

        }
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bf4=new BlankFragment_4();
        fm =getFragmentManager();
        init();
        button.setOnClickListener(new calculete());
    }

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public BlankFragment_3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment_3.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment_3 newInstance(String param1, String param2) {
        BlankFragment_3 fragment = new BlankFragment_3();
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
        Mview=inflater.inflate(R.layout.fragment_blank_fragment_3, container, false);
        return Mview;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
