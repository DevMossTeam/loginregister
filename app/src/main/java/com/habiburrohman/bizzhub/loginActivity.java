package com.habiburrohman.bizzhub;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class loginActivity extends AppCompatActivity {
    private EditText name,password;
    private Button btn_login;
    private TextView btn_masuk;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_masuk = findViewById(R.id.btn_masuk);
        btn_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(loginActivity.this, register_Activity.class);
                startActivity(register);
            }
        });


        name = findViewById(R.id.edt_name_login);
        password = findViewById(R.id.edt_password_login);
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = name.getText().toString();
                String pass = password.getText().toString();

                if(nama.isEmpty() || pass.isEmpty()){
                    Toast.makeText(loginActivity.this, "Nama atau Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(loginActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}