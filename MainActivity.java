package com.uts_agnes;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //Deklarasi Variable Pendukung
    private TextView Hasil;
    private EditText Masukan;
    private Button Eksekusi;

    //Deklarasi dan Inisialisasi SharedPreferences
    private SharedPreferences preferences;

    //Digunakan Untuk Konfigurasi SharedPreferences
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Masukan = (EditText) findViewById(R.id.input);
        Hasil = (TextView) findViewById(R.id.output);
        Eksekusi = (Button) findViewById(R.id.save);
        //Membuat File Baru Beserta Modifiernya
        preferences = getSharedPreferences("Belajar_SharedPreferences", Context.MODE_PRIVATE);
        Eksekusi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                getData();
                Toast.makeText(getApplicationcontext(), "Data Tersimpan", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getData() {
        //mendapatkan Input Dari User
        String getkonten = Masukan.getText().toString();
        //Digunakan untuk pengaturan konfigurasi sharedpreferences
        editor = preferences.edit();
        //memasukkan data pada editor sharespreferences dengan key(Daya_saya)
        editor.putString("data_saya", getkonten);
        //menjalankan operasi
        editor.apply();
        //Menampilkan output
        Hasil.setText("Output Data:" + preferences.getString("data_saya", null));
    }
}
