package id.sch.smktelkom_mlg.learn.checktourcom.Model;

import java.io.Serializable;

/**
 * Created by Rezki on 5/2/2018.
 */

public class HoneyMoonModel implements Serializable {
    String deskripsi, destinasi, fasilitas, harga, idPacket, lokasi, url;

    public HoneyMoonModel() {
        this.deskripsi = deskripsi;
        this.destinasi = destinasi;
        this.fasilitas = fasilitas;
        this.harga = harga;
        this.idPacket = idPacket;
        this.lokasi = lokasi;
        this.url = url;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getDestinasi() {
        return destinasi;
    }

    public void setDestinasi(String destinasi) {
        this.destinasi = destinasi;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getIdPacket() {
        return idPacket;
    }

    public void setIdPacket(String idPacket) {
        this.idPacket = idPacket;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
