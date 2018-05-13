package id.sch.smktelkom_mlg.learn.checktourcom;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class BookNowActivity extends AppCompatActivity {

    RadioButton rbPaket;
    EditText etBank, etNama, etJumlah;
    Button btnSubmit;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_now);

        rbPaket = findViewById(R.id.rbPacket);
        etBank = findViewById(R.id.etBank);
        etNama = findViewById(R.id.etNama);
        etJumlah = findViewById(R.id.etJumlah);
        btnSubmit = findViewById(R.id.submit);

        Intent bookIntent = getIntent();
        String destinasi = bookIntent.getStringExtra("Destinasi");
        String harga = bookIntent.getStringExtra("Harga");

        rbPaket.setText("" + destinasi + " " + harga);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSubmit();
            }
        });
    }

    private void sendSubmit() {
        String tuBank = etBank.getText().toString();
        String tuNama = etNama.getText().toString();
        String tuJumlah = etJumlah.getText().toString();

        Intent noteIntent = new Intent(BookNowActivity.this, NoteActivity.class);
        noteIntent.putExtra("namaBank", tuBank);
        noteIntent.putExtra("namaPemilik", tuNama);
        noteIntent.putExtra("jumlah", tuJumlah);
        startActivity(noteIntent);
        finish();


    }
}
