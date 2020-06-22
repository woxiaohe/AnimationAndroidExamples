package com.nsb.chengbah.animationandroidexamples.fragment;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.nsb.chengbah.animationandroidexamples.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PropertyValuesHolderFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PropertyValuesHolderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PropertyValuesHolderFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private ImageView imageView;
    private Button btStartAnim;

    public PropertyValuesHolderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PropertyValuesHolderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PropertyValuesHolderFragment newInstance(String param1, String param2) {
        PropertyValuesHolderFragment fragment = new PropertyValuesHolderFragment();
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
//        return inflater.inflate(R.layout.fragment_property_values_holder, container, false);
        View view = inflater.inflate(R.layout.fragment_property_values_holder, container, false);
        initView(view);
        initEvent();
        return view;
    }

    private void initEvent() {
        btStartAnim.setOnClickListener(this);
    }

    private void initView(View view) {
        imageView = view.findViewById(R.id.image_view);
        btStartAnim = view.findViewById(R.id.bt_start_anim);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_start_anim:
                startAnim01();
                break;
            default:
                break;
        }
    }


    /**
     * 使用PropertyValuesHolder 设置复杂动画
     */ private void startAnim01() {
         PropertyValuesHolder rotationHolder = PropertyValuesHolder.ofFloat("rotation", 50f, -50f, 30f, -30f, 20f, -20f, 10f, -10f, 0f);
         PropertyValuesHolder scaleXHolder = PropertyValuesHolder.ofFloat("scaleX", 1f, 2f,1f);
         PropertyValuesHolder scaleYHolder = PropertyValuesHolder.ofFloat("scaleY", 1f, 2f,1f);
         ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(imageView, rotationHolder, scaleXHolder, scaleYHolder);
         animator.setDuration(2000);
         animator.setInterpolator(new AccelerateInterpolator());
         animator.start();
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
