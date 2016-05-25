package com.joxad.easydatabinding.utils;

import android.databinding.BaseObservable;
import android.databinding.BindingConversion;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/***
 *
 */
public class ObservableString extends BaseObservable implements Parcelable, Serializable {
    static final long serialVersionUID = 1L;
    private String string;

    public ObservableString(String value) {
        this.string = value;
    }

    /***
     * Create an empty string
     */
    public ObservableString() {
        string = "";
    }

    public static final Creator<ObservableString> CREATOR = new Creator<ObservableString>() {
        public ObservableString createFromParcel(Parcel source) {
            return new ObservableString(source.readString());
        }

        public ObservableString[] newArray(int size) {
            return new ObservableString[size];
        }
    };


    public String get() {
        return this.string;
    }

    public void set(String value) {
        if (!equals(value, this.string)) {
            this.string = value;
            this.notifyChange();
        }

    }

    public static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.string);
    }

    public boolean isEmpty() {
        return string == null || string.isEmpty();
    }

    @BindingConversion
    public static String convertToString(ObservableString s) {
        return s.get();
    }
}