package id.sch.smktelkom_mlg.learn.checktourcom.Model;

import java.io.Serializable;

/**
 * Created by Rezki on 5/2/2018.
 */

public class HoneyMoonModel implements Serializable {
    public String judul, deskripsi, gambar;

    public HoneyMoonModel(String judul, String deskripsi, String gambar) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
    }
}
