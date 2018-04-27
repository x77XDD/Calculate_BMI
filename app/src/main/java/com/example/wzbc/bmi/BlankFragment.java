package com.example.wzbc.bmi;
import android.app.Fragment;

import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wzbc.bmi.com.xyz.util.BMI;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private EditText hight;
    private EditText wight;
    private TextView an;
    private TextView ad;
    private TextView shou;
    private TextView ganghao;
    private TextView pang;
    private RelativeLayout bgcolor;
    private String shenggaotext="";
    private String tizhongtext="";
    private String read_hight="1";
    private String read_wight="2";
    private View Mview;
    private TextView httext;
    private TextView wttext;


    int system=0;
    private BMI bmi1=new BMI(system);


    private void showSingleChoiceDialog() {
        AlertDialog.Builder builder;
        builder=new AlertDialog.Builder(getActivity());
//        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("pick a color");
        final String[] items={"red","green","blue"};
        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(items[i]==items[0]){
                    bgcolor.setBackgroundColor(Color.parseColor("#FF0000"));
                }else if(items[i]==items[1]){
                    bgcolor.setBackgroundColor(Color.parseColor("#90EE90"));
                }else {
                    bgcolor.setBackgroundColor(Color.parseColor("#98F5FF"));
                }
            }
        });
        builder.setCancelable(true);
        AlertDialog dialog=builder.create();
        dialog.show();
    }




    int yourChoice;
    private void showSingleChoiceDialog_1(){
        final String[] items  = new String[]{
                getString(R.string.gongzhi),
                getString(R.string.yingzhi)
        };

        yourChoice = -1;
        AlertDialog.Builder singleChoiceDialog =
                new AlertDialog.Builder(getActivity());
        singleChoiceDialog.setTitle(R.string.jldwxz);
        singleChoiceDialog.setSingleChoiceItems(items, 0,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        yourChoice = which;
                    }
                });
        singleChoiceDialog.setNegativeButton(R.string.cancel, null);
        singleChoiceDialog.setPositiveButton(R.string.ok,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TextView httext=(TextView)getActivity().findViewById(R.id.heightwenzi);
                        TextView wttext=(TextView)getActivity().findViewById(R.id.weightwenzi);
                        if (yourChoice != -1) {
                            if(yourChoice == 0){
                                bmi1.setSystem(0);
                                httext.setText("Height(厘米)");
                                wttext.setText("Weight(公斤)");
                            }if (yourChoice == 1){
                                bmi1.setSystem(1);
                                httext.setText("Height(英寸)");
                                wttext.setText("Weight(磅)");
                            }
                        }else {
                            bmi1.setSystem(0);
                            httext.setText("Height(厘米)");
                            wttext.setText("Weight(公斤)");
                        }
                    }
                });
        singleChoiceDialog.show();
    }

    public void init(){
        hight=(EditText)Mview.findViewById(R.id.heightshuru);
        wight=(EditText)Mview.findViewById(R.id.weightshuru);
        an=(TextView)Mview.findViewById(R.id.yourbim);
        ad=(TextView)Mview.findViewById(R.id.advice);
        shou=(TextView)Mview.findViewById(R.id.thin);
        ganghao=(TextView)Mview.findViewById(R.id.nornal);
        pang=(TextView)Mview.findViewById(R.id.havey);
        bgcolor=(RelativeLayout)Mview.findViewById(R.id.backcolor);
        httext=(TextView)Mview.findViewById(R.id.heightwenzi);
        wttext=(TextView)Mview.findViewById(R.id.weightwenzi);
    }

    private class backcolorclick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            showSingleChoiceDialog();
        }
    }

    private class xiugaijisuanfangshi_1 implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            showSingleChoiceDialog_1();
        }
    }

    private class click implements View.OnClickListener{
        String jieguo;
        @Override
        public void onClick(View view) {
            String hh=hight.getText().toString();
            String ww=wight.getText().toString();
            if(hh.equals("") || ww.equals("")){
                Toast.makeText(getActivity(), "请填写正确的信息！", Toast.LENGTH_SHORT).show();
            }else{
                String[] items = getResources().getStringArray(R.array.advice);
                double h=Double.parseDouble(hh);
                double w=Double.parseDouble(ww);
                BMI bmi=new BMI(h,w,bmi1.getSystem());
                double bim_res=bmi.getBmiValue();
                String bimvaluestr=bmi.getBmiValueOfString();
                int bimadvice=bmi.getBmiAdvice();
                if(bim_res<20){
                    jieguo=items[bimadvice];
                    shou.setBackgroundColor(Color.CYAN);
                    pang.setBackgroundColor(Color.WHITE);
                    ganghao.setBackgroundColor(Color.WHITE);
                }else if(bim_res>=20 && bim_res<=25){
                    jieguo=items[bimadvice];
                    ganghao.setBackgroundColor(Color.CYAN);
                    pang.setBackgroundColor(Color.WHITE);
                    shou.setBackgroundColor(Color.WHITE);
                }else{
                    jieguo=items[bimadvice];
                    pang.setBackgroundColor(Color.CYAN);
                    shou.setBackgroundColor(Color.WHITE);
                    ganghao.setBackgroundColor(Color.WHITE);
                }
                String str=getResources().getString(R.string.bim)+bimvaluestr;
                an.setText(str);
                String str1=getResources().getString(R.string.adv)+jieguo;
                ad.setText(str1);
            }
        }
    }

    private OnFragmentInteractionListener mListener;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
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
        Mview=inflater.inflate(R.layout.fragment_blank, container, false);
        return Mview;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button bt=(Button)getActivity().findViewById(R.id.calculate);
        Button sexsr=(Button)getActivity().findViewById(R.id.sexshuru);
        Button xiugaijisuan=(Button)getActivity().findViewById(R.id.xiugaijisuanfangshi);
//        Button next=(Button)getActivity().findViewById(R.id.next);
        init();
        bt.setOnClickListener(new click());
        sexsr.setOnClickListener(new backcolorclick());
        xiugaijisuan.setOnClickListener(new xiugaijisuanfangshi_1());
//        next.setOnClickListener(new nextpage());
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
//
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

    public void english(){
        bmi1.setSystem(1);
        httext.setText("Height(英寸)");
        wttext.setText("Weight(磅)");
    }

    public void chinese(){
        bmi1.setSystem(0);
        httext.setText("Height(厘米)");
        wttext.setText("Weight(公斤)");
    }



    //    public  void saveUserInfo(Context context,String sg,String tz){
//        shenggaotext = hight.getText().toString();
//        tizhongtext =  wight.getText().toString();
//        SharedPreferences sPreferences=context.getSharedPreferences("config", MODE_PRIVATE);
//        SharedPreferences.Editor editor=sPreferences.edit();
//        editor.putString(sg,shenggaotext);
//        editor.putString(tz,tizhongtext);
//        editor.commit();
//    }
//
//    public void readuser(){
//        SharedPreferences sPreferences=getActivity().getSharedPreferences("config", MODE_PRIVATE);
//        String sg=sPreferences.getString(read_hight,"");
//        String tz =sPreferences.getString(read_wight, "");
//        hight.setText(sg);
//        wight.setText(tz);
//    }






//
//
//    @Override
//    protected void onDestroy() {
//        Log.d("test", "SecondActivity_onDestroy");
//        super.onDestroy();
//    }
//
//    @Override
//    protected void onPause() {
//        saveUserInfo(SecondActivity.this ,read_hight,read_wight);
//        Log.d("test", "SecondActivity_onPause");
//        super.onPause();
//    }
//
//    @Override
//    protected void onRestart() {
//        Log.d("test", "SecondActivity_onRestart");
//        super.onRestart();
//    }
//
//    @Override
//    protected void onResume() {
//        readuser();
//        Log.d("test", "SecondActivity_onResume");
//        super.onResume();
//    }
//
//    @Override
//    protected void onStart() {
//        Log.d("test", "SecondActivity_onStart");
//        super.onStart();
//    }
//
//    @Override
//    protected void onStop() {
//        Log.d("test", "SecondActivity_onStop");
//        super.onStop();
//    }
//
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putString("bim", an.getText().toString());
//        outState.putString("advice", ad.getText().toString());
//        Log.d("test","save");
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        an.setText(savedInstanceState.getString("bim"));
//        ad.setText(savedInstanceState.getString("advice"));
//        Log.d("test","out");
//    }
}
