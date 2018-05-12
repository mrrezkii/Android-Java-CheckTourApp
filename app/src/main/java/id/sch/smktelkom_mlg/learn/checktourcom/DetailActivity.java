package id.sch.smktelkom_mlg.learn.checktourcom;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    ImageView imageView;
    TextView tvDeskripsi, tvFasilitas, tvHarga, tvLokasi;
    Button btnBook;
    ImageView show, hide;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.toolbarTittle);
        setSupportActionBar(toolbar);

        imageView = findViewById(R.id.imageView);
        tvDeskripsi = findViewById(R.id.tvDeskripsiDetail);
        tvFasilitas = findViewById(R.id.tvFasilitasDetail);
        tvHarga = findViewById(R.id.tvHargaDetail);
        tvLokasi = findViewById(R.id.tvLokasiDetail);
        btnBook = findViewById(R.id.btnBook);
        show = findViewById(R.id.show);
        hide = findViewById(R.id.hide);


        Intent detailIntent = getIntent();

        String destinasi = detailIntent.getStringExtra("Destinasi");
        String gambar = detailIntent.getStringExtra("url");
        String deskripsi = detailIntent.getStringExtra("Deskripsi");
        String fasilitas = detailIntent.getStringExtra("Fasilitas");
        String harga = detailIntent.getStringExtra("Harga");
        String lokasi = detailIntent.getStringExtra("Lokasi");

        setTitle(destinasi);
        Glide.with(this)
                .load(gambar)
                .into(imageView);
        tvDeskripsi.setText(deskripsi);
        tvFasilitas.setText(fasilitas);
        tvHarga.setText(harga);
        tvLokasi.setText(lokasi);
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadPayment();
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readMoreDown();
            }
        });
        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readMoreUp();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }

    private void readMoreUp() {
        System.out.println("Hide button");
        hide.setVisibility(View.INVISIBLE);
        show.setVisibility(View.VISIBLE);
        tvDeskripsi.setMaxLines(3);
    }

    private void readMoreDown() {
        System.out.println("Show button");
        show.setVisibility(View.INVISIBLE);
        hide.setVisibility(View.VISIBLE);
        tvDeskripsi.setMaxLines(Integer.MAX_VALUE);
    }

    private void loadPayment() {

    }
}
