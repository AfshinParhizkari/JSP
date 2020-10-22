package com.afshin;

public class Userpas {

    int id;
    String usr;
    String pws;
    String locate;

    public Userpas() {
    }

    public Userpas(int id, String usr, String pws, String locate) {
        this.id = id;
        this.usr = usr;
        this.pws = pws;
        this.locate = locate;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsr() {
        return this.usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPws() {
        return this.pws;
    }

    public void setPws(String pws) {
        this.pws = pws;
    }

    public String getLocate() {
        return this.locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

    
}
