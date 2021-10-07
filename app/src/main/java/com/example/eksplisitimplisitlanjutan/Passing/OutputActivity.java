package com.example.eksplisitimplisitlanjutan.Passing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.eksplisitimplisitlanjutan.R;

public class OutputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        TextView Nama = (TextView) findViewById(R.id.tv_Nama);
        TextView NIM = (TextView) findViewById(R.id.tv_NIM);
        TextView Prodi = (TextView) findViewById(R.id.tv_Prodi);

        if (getIntent().getExtras()!=null){
            Bundle bundle = getIntent().getExtras();
            Nama.setText(bundle.getString("Nama"));
            NIM.setText(bundle.getString("NIM"));
            Prodi.setText(bundle.getString("Prodi"));
        }else {
            Nama.setText(getIntent().getStringExtra("Nama"));
            NIM.setText(getIntent().getStringExtra("NIM"));
            Prodi.setText(getIntent().getStringExtra("Prodi"));
        }
    }
}