package com.example.finalproject;

public class Data {
    private String id,listnama, listalamat;

    public Data(){
    }

    public Data(String id,String listnama, String listalamat){
        this.id = id;
        this.listnama = listnama;
        this.listalamat = listalamat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getListnama() {
        return listnama;
    }

    public void setListnama(String listnama) {
        this.listnama = listnama;
    }

    public String getListalamat() {
        return listalamat;
    }

    public void setListalamat(String listalamat) {
        this.listalamat = listalamat;
    }
}
