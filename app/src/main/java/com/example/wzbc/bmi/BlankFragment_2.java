package com.example.wzbc.bmi;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.wzbc.bmi.com.xyz.util.WHR;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment_2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment_2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment_2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText mHeight;
    private EditText mWaist;
    private Button mCalculate;
    private TextView mWhr;
    private TextView mIdeal;
    private TextView mIdea_1;
    private TextView mIdea_2;
    private TextView mIdea_3;
    private TextView mIdea_4;
    private TextView mIdea_5;
    private TextView mIdea_6;
    private View Mview;
    private WHR whr1;
    private String  anwhr="";
    private String anidear="";
    private TextView mHeighttext;
    private TextView mWaisttext;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private void init(){
        mHeighttext=(TextView)Mview.findViewById(R.id.heightwenzi_b);
        mWaisttext=(TextView)Mview.findViewById(R.id.weightwenzi_b);
        mHeight=(EditText)Mview.findViewById(R.id.heightshuru_b);
        mWaist=(EditText)Mview.findViewById(R.id.weightshuru_b);
        mCalculate=(Button)Mview.findViewById(R.id.calculate_b);
        mWhr=(TextView)Mview.findViewById(R.id.yourwhr);
        mIdeal=(TextView)Mview.findViewById(R.id.ideal_advice);
        mIdea_1=(TextView)Mview.findViewById(R.id.pp);
        mIdea_2=(TextView)Mview.findViewById(R.id.ll);
        mIdea_3=(TextView)Mview.findViewById(R.id.mm);
        mIdea_4=(TextView)Mview.findViewById(R.id.oo);
        mIdea_5=(TextView)Mview.findViewById(R.id.kk);
        mIdea_6=(TextView)Mview.findViewById(R.id.nn);
    }

    private class calculete implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            whr1=new WHR(Double.parseDouble(mHeight.getText().toString()),Double.parseDouble(mWaist.getText().toString()));
            anwhr=whr1.getcalculate_whrString();
            anidear=whr1.getcalculate_idearString();
            String hh=mHeight.getText().toString();
            String ww=mWaist.getText().toString();
            if(hh.equals("") || ww.equals("")){
                Toast.makeText(getActivity(), "请填写正确的信息！", Toast.LENGTH_SHORT).show();
            }
            else {
                mWhr.setText("WHR:"+anwhr);
                mIdeal.setText("Your Ideal Waist:"+anidear);
                Double panduan=(Double.parseDouble(anwhr));
                if(panduan<=0.34){
                    mIdea_1.setBackgroundColor(Color.CYAN);
                    mIdea_2.setBackgroundColor(Color.WHITE);
                    mIdea_3.setBackgroundColor(Color.WHITE);
                    mIdea_4.setBackgroundColor(Color.WHITE);
                    mIdea_5.setBackgroundColor(Color.WHITE);
                    mIdea_6.setBackgroundColor(Color.WHITE);
                }else if(panduan>=0.35 && panduan<=0.42){
                    mIdea_1.setBackgroundColor(Color.WHITE);
                    mIdea_2.setBackgroundColor(Color.CYAN);
                    mIdea_3.setBackgroundColor(Color.WHITE);
                    mIdea_4.setBackgroundColor(Color.WHITE);
                    mIdea_5.setBackgroundColor(Color.WHITE);
                    mIdea_6.setBackgroundColor(Color.WHITE);
                }else if(panduan>=0.43 && panduan<=0.52){
                    mIdea_1.setBackgroundColor(Color.WHITE);
                    mIdea_2.setBackgroundColor(Color.WHITE);
                    mIdea_3.setBackgroundColor(Color.CYAN);
                    mIdea_4.setBackgroundColor(Color.WHITE);
                    mIdea_5.setBackgroundColor(Color.WHITE);
                    mIdea_6.setBackgroundColor(Color.WHITE);
                }else if(panduan>=0.53 && panduan<=0.57){
                    mIdea_1.setBackgroundColor(Color.WHITE);
                    mIdea_2.setBackgroundColor(Color.WHITE);
                    mIdea_3.setBackgroundColor(Color.WHITE);
                    mIdea_4.setBackgroundColor(Color.CYAN);
                    mIdea_5.setBackgroundColor(Color.WHITE);
                    mIdea_6.setBackgroundColor(Color.WHITE);
                }else if(panduan>=0.58 && panduan<=0.62){
                    mIdea_1.setBackgroundColor(Color.WHITE);
                    mIdea_2.setBackgroundColor(Color.WHITE);
                    mIdea_3.setBackgroundColor(Color.WHITE);
                    mIdea_4.setBackgroundColor(Color.WHITE);
                    mIdea_5.setBackgroundColor(Color.CYAN);
                    mIdea_6.setBackgroundColor(Color.WHITE);
                }else {mIdea_1.setBackgroundColor(Color.WHITE);
                    mIdea_2.setBackgroundColor(Color.WHITE);
                    mIdea_3.setBackgroundColor(Color.WHITE);
                    mIdea_4.setBackgroundColor(Color.WHITE);
                    mIdea_5.setBackgroundColor(Color.WHITE);
                    mIdea_6.setBackgroundColor(Color.CYAN);}
            }

        }
    }


//    public void english_1(){
//        mHeighttext.setText("Height(英寸)");
//        mWaisttext.setText("Waist(英寸)");
//    }
//
//    public void chinese_1(){
//        mHeighttext.setText("Height(厘米)");
//        mHeighttext.setText("Waist(厘米)");
//    }

    public BlankFragment_2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment_2.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment_2 newInstance(String param1, String param2) {
        BlankFragment_2 fragment = new BlankFragment_2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        mCalculate.setOnClickListener(new calculete());

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
        Mview=inflater.inflate(R.layout.fragment_blank_fragment_2, container, false);
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
