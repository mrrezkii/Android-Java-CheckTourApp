package id.sch.smktelkom_mlg.learn.checktourcom;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.security.MessageDigest;
import java.util.Random;


public class NoteActivity extends AppCompatActivity {
    public static final String DATA = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static Random RANDOM = new Random();
    static String myString1 = "";
    TextView tvVoucher;
    Random r = new Random();

    public static String myEncrypt(String data1) {
        StringBuffer sb = new StringBuffer();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(data1.getBytes("UTF-8"));
            byte[] digestBytes = messageDigest.digest();

            String hex = null;
            for (int i = 0; i < digestBytes.length; i++) {
                hex = Integer.toHexString(0xFF & digestBytes[i]);
                if (hex.length() < 2)
                    sb.append("0");
                sb.append(hex);
            }
            myString1 = sb.toString();
            System.out.println(myString1);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new String(sb);
    }

    public static String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);

        for (int i = 0; i < len; i++) {
            sb.append(DATA.charAt(RANDOM.nextInt(DATA.length())));
        }

        return sb.toString();
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);


        tvVoucher = findViewById(R.id.tvVoucher);
        tvVoucher.setText(myEncrypt(randomString(10)));
        tvVoucher.setMaxLines(1);


        Intent noteIntent = getIntent();
        String namaBank = noteIntent.getStringExtra("namaBank");
        String namaPemilik = noteIntent.getStringExtra("namaPemilik");
        String jumlah = noteIntent.getStringExtra("namaJumlah");


    }

    @Override
    public void onBackPressed() {

    }
}
