package com.example.nagendra.movie.Models;

public class TheatreModel {

    private String usermailid,moviename,theatrename,noofseats;

    public TheatreModel() {
    }

    public TheatreModel(String usermailid, String moviename, String theatrename, String noofseats) {
        this.usermailid = usermailid;
        this.moviename = moviename;
        this.theatrename = theatrename;
        this.noofseats = noofseats;
    }

    public String getUsermailid() {
        return usermailid;
    }

    public void setUsermailid(String usermailid) {
        this.usermailid = usermailid;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getTheatrename() {
        return theatrename;
    }

    public void setTheatrename(String theatrename) {
        this.theatrename = theatrename;
    }

    public String getNoofseats() {
        return noofseats;
    }

    public void setNoofseats(String noofseats) {
        this.noofseats = noofseats;
    }
}
