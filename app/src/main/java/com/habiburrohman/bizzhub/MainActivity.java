package com.habiburrohman.bizzhub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private MaterialButton btn_register_main;
    private MaterialButton btn_login_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_register_main = findViewById(R.id.btn_register_main);
        btn_register_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, register_Activity.class);
                startActivity(intent);
                finish();
            }
        });
        btn_login_main = findViewById(R.id.btn_login_main);
        btn_login_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, loginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        ToastShow("On Start");
    }
    @Override
    protected void onResume() {
        super.onResume();
        ToastShow("On Resume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        ToastShow("On Pause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        ToastShow("On Stop");
    }
    public void ToastShow(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
