package com.example.eksplisitimplisitlanjutan.Passing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eksplisitimplisitlanjutan.R;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        final EditText Nama = findViewById(R.id.etNama);
        final EditText NIM = findViewById(R.id.etNim);
        final EditText Prodi = findViewById(R.id.etProdi);
        Button btnBundle = (Button) findViewById(R.id.btn_bundle);
        Button btnIntent = (Button) findViewById(R.id.btn_intent);

        btnBundle.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("Nama", Nama.getText().toString());
            bundle.putString("NIM", NIM.getText().toString());
            bundle.putString("Prodi", Prodi.getText().toString());
            Intent intent = new Intent(InputActivity.this,OutputActivity.class);
            Toast.makeText(this,"Passing data menggunakan bundle berhasil",Toast.LENGTH_SHORT).show();
            intent.putExtras(bundle);
            startActivity(intent);
        });

        btnIntent.setOnClickListener(v -> {
            Intent intent = new Intent(InputActivity.this,OutputActivity.class);
            intent.putExtra("Nama",Nama.getText().toString());
            intent.putExtra("NIM",NIM.getText().toString());
            intent.putExtra("Prodi",Prodi.getText().toString());
            Toast.makeText(this, "Passing data menggunakan intent berhasil", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });
    }
}