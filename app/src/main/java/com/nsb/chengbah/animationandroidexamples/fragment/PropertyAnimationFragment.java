package com.nsb.chengbah.animationandroidexamples.fragment;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nsb.chengbah.animationandroidexamples.R;
import com.nsb.chengbah.animationandroidexamples.myclass.MyAnimObject;
import com.nsb.chengbah.animationandroidexamples.myclass.MyAnimObjectEvaluator;
import com.nsb.chengbah.animationandroidexamples.utils.PropertyAnimatorUtil;
import com.nsb.chengbah.animationandroidexamples.view.MyPoint;
import com.nsb.chengbah.animationandroidexamples.view.PointView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PropertyAnimationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PropertyAnimationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PropertyAnimationFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Context mContext;

    private OnFragmentInteractionListener mListener;


    private TextView textView;
    private ImageView imageView;
    private Button btStartImageValueAnimator, btStopImageValueAnimator,btStartObjValueAnimator;
    private ValueAnimator valueAnimator;

    private Button bt_start_anim01,bt_start_anim02,bt_start_anim03,bt_start_anim04,bt_start_anim05,bt_start_anim06,bt_start_anim07,bt_start_anim08,bt_start_anim09,bt_start_anim10;
    private ImageView iv_image01,iv_image02,iv_image03,iv_image04,iv_image05,iv_image06,iv_image07,iv_image08;
    private PointView point_view09,point_view10;

    private ImageView[] iv_images = {iv_image01,iv_image02,iv_image03,iv_image04,iv_image05,iv_image06,iv_image07,iv_image08};
    private int[] iv_image_ids = {R.id.iv_image01,R.id.iv_image02,R.id.iv_image03,R.id.iv_image04,R.id.iv_image05,R.id.iv_image06,R.id.iv_image07,R.id.iv_image08,R.id.point_view09,R.id.point_view10};
    private Button[] bt_start_anims = {bt_start_anim01,bt_start_anim02,bt_start_anim03,bt_start_anim04,bt_start_anim05,bt_start_anim06,bt_start_anim07,bt_start_anim08,bt_start_anim09,bt_start_anim10};
    private int[] bt_start_anims_id = {R.id.bt_start_anim01,R.id.bt_start_anim02,R.id.bt_start_anim03,R.id.bt_start_anim04,R.id.bt_start_anim05,R.id.bt_start_anim06,R.id.bt_start_anim07,R.id.bt_start_anim08,R.id.bt_start_anim09,R.id.bt_start_anim10};

    public PropertyAnimationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PropertyAnimationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PropertyAnimationFragment newInstance(String param1, String param2) {
        PropertyAnimationFragment fragment = new PropertyAnimationFragment();
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
//        return inflater.inflate(R.layout.fragment_property_animation, container, false);
        View view = inflater.inflate(R.layout.fragment_property_animation, container, false);
        initView(view);
        initEvent();
        return view;
    }

    private void initEvent() {
        btStartImageValueAnimator.setOnClickListener(this);
        btStopImageValueAnimator.setOnClickListener(this);
        btStartObjValueAnimator.setOnClickListener(this);

        for (int i = 0;i<10;i++){
            bt_start_anims[i].setOnClickListener(this);
        }
    }

    private void initView(View view) {
        textView = view.findViewById(R.id.textView);
        imageView = view.findViewById(R.id.imageview);
        btStartImageValueAnimator = view.findViewById(R.id.bt_start_value_animator);
        btStopImageValueAnimator = view.findViewById(R.id.bt_stop_value_animator);
        btStartObjValueAnimator = view.findViewById(R.id.bt_obj_value_anim);

        for (int i=0;i<10;i++){
            if (i<8){
                iv_images[i] = view.findViewById(iv_image_ids[i]);
            }
            bt_start_anims[i] = view.findViewById(bt_start_anims_id[i]);
        }
        point_view09 = view.findViewById(R.id.point_view09);
        point_view10 = view.findViewById(R.id.point_view10);

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
            case R.id.bt_start_value_animator:
//                valueAnimator = PropertyAnimatorUtil.startImageValueAnimator(imageView);    //java code
                valueAnimator = PropertyAnimatorUtil.startXmlValueAnimator(mContext,imageView); //xml
                break;
            case R.id.bt_stop_value_animator:
                PropertyAnimatorUtil.stopImageValueAnimator(valueAnimator);
                break;
            case R.id.bt_obj_value_anim:
                PropertyAnimatorUtil.startObjValueAnimator(textView,new MyAnimObjectEvaluator(),new MyAnimObject(0),new MyAnimObject(20));

            case R.id.bt_start_anim01:
                startAlphaAnim();
                break;
            case R.id.bt_start_anim02:
                startRotationAnim();
                break;
            case R.id.bt_start_anim03:
                startRotationXAnim();
                break;
            case R.id.bt_start_anim04:
                startRotationYAnim();
                break;
            case R.id.bt_start_anim05:
                startTranslationXAnim();
                break;
            case R.id.bt_start_anim06:
                startTranslationYAnim();
                break;
            case R.id.bt_start_anim07:
                startScaleXAnim();
                break;
            case R.id.bt_start_anim08:
                startScaleYAnim();
                break;
            case R.id.bt_start_anim09:
                startColorGradientAnim();
                break;
            case R.id.bt_start_anim10:
                //自定义view的动画
//                point_view10.setMove(new MyPoint(50,50));   //设置初始动画位置,默认就是(50,50)
                point_view10.moveBell(2000L,new MyPoint(50,50), new MyPoint(100,100),new MyPoint(200,200));
                break;
            default:
                break;
        }
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


    /**
     * 启动透明动画
     */
    private void startAlphaAnim() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv_images[0], "alpha", 1, 0, 1);
        animator.setDuration(2400);
        animator.start();
    }

    /**
     * 启动旋转动画
     */
    private void startRotationAnim() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv_images[1], "rotation", 0, 180, 0);
        animator.setDuration(2400);
        animator.start();
    }

    /**
     * 启动绕X轴旋转动画
     */
    private void startRotationXAnim() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv_images[2], "rotationX", 0, 270, 0);
        animator.setDuration(2400);
        animator.start();
    }

    /**
     * 启动绕Y轴旋转动画
     */
    private void startRotationYAnim() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv_images[3], "rotationY", 0, 180, 0);
        animator.setDuration(2400);
        animator.start();
    }

    /**
     * 启动沿X轴移动动画
     */
    private void startTranslationXAnim() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv_images[4], "translationX", 0, 250, -250, 0);
        animator.setDuration(2400);
        animator.start();
    }

    /**
     * 启动沿Y轴移动动画
     */
    private void startTranslationYAnim() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv_images[5], "translationY", 0, 200, 0);
        animator.setDuration(2400);
        animator.start();
    }

    /**
     * 启动沿X轴伸缩动画
     */
    private void startScaleXAnim() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv_images[6], "scaleX", 1, 4, 1);
        animator.setDuration(2400);
        animator.start();
    }

    /**
     * 启动沿Y轴伸缩动画
     */
    private void startScaleYAnim() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv_images[7], "scaleY", 1, 4, 1);
        animator.setDuration(2400);
        animator.start();
    }

    /**
     * 启动颜色渐变动画
     */
    private void startColorGradientAnim() {
        ObjectAnimator animator = ObjectAnimator.ofInt(point_view09, "BackgroundColor", 0XFF7B68EE, 0XFF00FA9A, 0XFF7B68EE);
        animator.setDuration(5000);
        animator.setEvaluator(new ArgbEvaluator());
        animator.start();
    }
}
