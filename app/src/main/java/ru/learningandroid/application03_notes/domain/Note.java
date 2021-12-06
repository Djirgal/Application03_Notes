package ru.learningandroid.application03_notes.domain;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.StringRes;

import java.util.Date;

public class Note implements Parcelable {

    @StringRes
    private final int header;

    private Date creationDate;

    private Date modificationDate;

    @StringRes
    private final int body;

    public Note(int header, int body) {
        this.header = header;
        this.body = body;
    }

    protected Note(Parcel in){
        header = in.readInt();
        body = in.readInt();
    }

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(header);
        dest.writeInt(body);
    }
    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public int getHeader() {
        return header;
    }

    public int getBody() {

        return body;
    }
}
