package com.nsb.chengbah.animationandroidexamples.view;

import android.os.Parcel;
import android.os.Parcelable;

public class MyPoint implements Parcelable {
    private float x;
    private float y;

    public MyPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    protected MyPoint(Parcel in) {
        x = in.readFloat();
        y = in.readFloat();
    }

    public static final Creator<MyPoint> CREATOR = new Creator<MyPoint>() {
        @Override
        public MyPoint createFromParcel(Parcel in) {
//            return new MyPoint(in);
            MyPoint r = new MyPoint();
            r.readFromParcel(in);
            return r;
        }

        @Override
        public MyPoint[] newArray(int size) {
            return new MyPoint[size];
        }
    };

    private void readFromParcel(Parcel in) {
        x= in.readFloat();
        y = in.readFloat();
    }

    public MyPoint() {

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeFloat(x);
        out.writeFloat(y);
    }
}
