package com.edwin.HorizontalRV;

import android.os.Parcel;
import android.os.Parcelable;

public class DataModel implements Parcelable {

    private String title;
    private String detail;
    private int poster;
    private String color;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public DataModel(String title, String detail, int poster, String color) {
        this.title = title;
        this.detail = detail;
        this.poster = poster;
        this.color = color;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeInt(this.poster);
        dest.writeString(this.detail);
        dest.writeString(this.color);

    }

    protected DataModel(Parcel in) {
        this.title = in.readString();
        this.poster = in.readInt();
        this.detail = in.readString();
        this.color = in.readString();
    }

    public static final Parcelable.Creator<DataModel> CREATOR = new Parcelable.Creator<DataModel>() {
        @Override
        public DataModel createFromParcel(Parcel source) {
            return new DataModel(source);
        }

        @Override
        public DataModel[] newArray(int size) {
            return new DataModel[size];
        }
    };
}
