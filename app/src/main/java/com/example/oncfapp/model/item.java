package com.example.oncfapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.lifecycle.ViewModel;

public class item extends ViewModel implements Parcelable {
    private String Details , Date , Voiture , Code , Equipement;
    private boolean isExpandable;

    public item(){}

    public item (String Details , String Date, String Voiture , String Code,  String Equipement,  Boolean isExpandable){
        this.Details = Details ;
        this.Code=Code ;
        this.Date = Date;
        this.Voiture=Voiture;
        this.Equipement=Equipement ;
        this.isExpandable=isExpandable;

    }

    protected item(Parcel in) {
        Details = in.readString();
        Date = in.readString();
        Voiture = in.readString();
        Code = in.readString();
        Equipement = in.readString();
        isExpandable = in.readByte() != 0;
    }

    public static final Creator<item> CREATOR = new Creator<item>() {
        @Override
        public item createFromParcel(Parcel in) {
            return new item(in);
        }

        @Override
        public item[] newArray(int size) {
            return new item[size];
        }
    };

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public String getVoiture() {
        return Voiture;
    }

    public void setVoiture(String voiture) {
        Voiture = voiture;
    }

    public  String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getEquipement() {
        return Equipement;
    }

    public void setEquipement(String equipement) {
        this.Equipement = equipement;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Details);
        parcel.writeString(Date);
        parcel.writeString(Voiture);
        parcel.writeString(Code);
        parcel.writeString(Equipement);
        parcel.writeByte((byte) (isExpandable ? 1 : 0));
    }
}
