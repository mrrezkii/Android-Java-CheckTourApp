package id.sch.smktelkom_mlg.learn.checktourcom.Model;

import java.io.Serializable;

/**
 * Created by Rezki on 5/2/2018.
 */

public class HoneyMoonModel implements Serializable {
    private String Deskripsi, Destinasi, Fasilitas, Harga, IDPacket, Lokasi, url;

    public HoneyMoonModel() {
    }

    public HoneyMoonModel(String deskripsi, String destinasi, String fasilitas, String harga, String IDPacket, String lokasi, String url) {
        Deskripsi = deskripsi;
        Destinasi = destinasi;
        Fasilitas = fasilitas;
        Harga = harga;
        this.IDPacket = IDPacket;
        Lokasi = lokasi;
        this.url = url;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public String getDestinasi() {
        return Destinasi;
    }

    public String getFasilitas() {
        return Fasilitas;
    }

    public String getHarga() {
        return Harga;
    }

    public String getIDPacket() {
        return IDPacket;
    }

    public String getLokasi() {
        return Lokasi;
    }

    public String getUrl() {
        return url;
    }
}
