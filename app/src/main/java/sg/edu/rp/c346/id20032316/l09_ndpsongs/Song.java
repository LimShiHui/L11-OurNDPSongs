package sg.edu.rp.c346.id20032316.l09_ndpsongs;

import java.io.Serializable;

public class Song implements Serializable {

    private int _id;
    private String title;
    private String singers;
    private int year;
    private float stars;

    public Song(int _id, String title, String singers, int year, float stars) {
        this._id = _id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public Song(String title, String singers, int year, float stars) {
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public int get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getSingers() {
        return singers;
    }

    public int getYear() {
        return year;
    }

    public float getStars() {
        return stars;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSingers(String singers) {
        this.singers = singers;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }

//    @Override
//    public String toString() {
//
//        String starString = "";
//        if (stars == 5) {
//            starString = "*****";
//        } else if (stars == 4) {
//            starString = "****";
//        } else if (stars == 3) {
//            starString = "***";
//        }else if (stars == 2) {
//            starString = "**";
//        }else if (stars == 1) {
//            starString = "*";
//        }
//
//        return title + "\n" + singers + " - " + year + "\n" + starString;
//    }
}
