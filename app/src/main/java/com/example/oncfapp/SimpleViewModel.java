package com.example.oncfapp;
// An object that  hold our data

import androidx.annotation.NonNull;

public class SimpleViewModel {

    private String code , Details, date , Voiture , equipement ;
    private boolean isExpandable ;

    public SimpleViewModel() {}

    public SimpleViewModel (String code , String details , String date , String voiture , String equipement , boolean isExpandable){
        this.code = code ;
        this.Details = details ;
        this.Voiture = voiture ;
        this.equipement = equipement;
        this.date = date;
        this.isExpandable = isExpandable ;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String Details) {
        this.Details = Details;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVoiture() {
        return Voiture;
    }

    public void setVoiture(String Voiture) {
        this.Voiture = Voiture;
    }

    public String getEquipement() {
        return equipement;
    }

    public void setEquipement(String equipement) {
        this.equipement = equipement;
    }
}
