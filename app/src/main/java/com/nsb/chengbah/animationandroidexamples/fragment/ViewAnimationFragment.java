package com.nsb.chengbah.animationandroidexamples.fragment;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.nsb.chengbah.animationandroidexamples.R;
import com.nsb.chengbah.animationandroidexamples.utils.TweenAnimationsUtil;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ViewAnimationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ViewAnimationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewAnimationFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Context mContext;

    private ImageView imageView,imgDrawable;
    private Button btAlpha,btRotate,btScale,btTranslate,btComplex,btFrameAnim,btFrameAnimStop;
    AnimationDrawable animationDrawable;

    private OnFragmentInteractionListener mListener;

    public ViewAnimationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewAnimationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewAnimationFragment newInstance(String param1, String param2) {
        ViewAnimationFragment fragment = new ViewAnimationFragment();
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
//        return inflater.inflate(R.layout.fragment_view_animation, container, false);
        View view = inflater.inflate(R.layout.fragment_view_animation, container, false);

        initView(view);
        initEvent();
        return view;
    }

    private void initEvent() {
        initListener();
    }

    private void initListener() {
        btAlpha.setOnClickListener(this);
        btRotate.setOnClickListener(this);
        btScale.setOnClickListener(this);
        btTranslate.setOnClickListener(this);
        btComplex.setOnClickListener(this);
        btFrameAnim.setOnClickListener(this);
        btFrameAnimStop.setOnClickListener(this);
    }

    private void initView(View view) {
        imageView = view.findViewById(R.id.imageView);
        imgDrawable = view.findViewById(R.id.img_drawable);
        btAlpha = view.findViewById(R.id.bt_alpha);
        btRotate = view.findViewById(R.id.bt_rotate);
        btScale = view.findViewById(R.id.bt_scale);
        btTranslate = view.findViewById(R.id.bt_translate);
        btComplex = view.findViewById(R.id.bt_complex);
        btFrameAnim = view.findViewById(R.id.bt_frame);
        btFrameAnimStop = view.findViewById(R.id.bt_frame_stop);
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
        mContext = context;
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
            case R.id.bt_alpha:
                TweenAnimationsUtil.alphaAnimation(imageView);    //java 代码
                Animation animation = AnimationUtils.loadAnimation(mContext,R.anim.alpha);
                imageView.setAnimation(animation);  //xml 不会立即执行动画，有条件的（when the view is added to the viewGroup,animation will be called.when the view has been added,the animation will not be called）
                imageView.startAnimation(animation);  //xml 会立即执行动画
                break;
            case R.id.bt_rotate:
                TweenAnimationsUtil.roateAnimation(imageView);
//                imageView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.rotate));
                break;
            case R.id.bt_scale:
                TweenAnimationsUtil.scaleAnimation(imageView);
//                imageView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.scale));
                break;
            case R.id.bt_translate:
//                imageView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.translate));
                TweenAnimationsUtil.translateAnimation(imageView);
                break;
            case R.id.bt_complex:
//                imageView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.complex));
                TweenAnimationsUtil.complexAnimation(imageView);
            case R.id.bt_frame:
                startDrawableAnimation();
                break;
            case R.id.bt_frame_stop:
                stopDrawableAnimation();
                break;
            default:
                break;
        }
    }

    private void stopDrawableAnimation() {
        animationDrawable.stop();
    }

    private void startDrawableAnimation() {
        imgDrawable.setBackgroundResource(R.drawable.anim_draw_loading);
        animationDrawable = (AnimationDrawable) imgDrawable.getBackground();
        animationDrawable.setOneShot(false);    //设置是否只执行一次
        animationDrawable.stop();
        animationDrawable.start();
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
