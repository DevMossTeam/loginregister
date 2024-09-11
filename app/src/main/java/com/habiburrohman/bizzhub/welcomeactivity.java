package com.habiburrohman.bizzhub;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appcompat.app.AppCompatActivity;

public class welcomeactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);  // Pastikan layout file sesuai

        // Menghubungkan titik-titik dengan id
        View dot1 = findViewById(R.id.dot1);
        View dot2 = findViewById(R.id.dot2);
        View dot3 = findViewById(R.id.dot3);

        // Memulai animasi bounce
        Animation bounce1 = AnimationUtils.loadAnimation(this, R.anim.bounce1);
        Animation bounce2 = AnimationUtils.loadAnimation(this, R.anim.bounce2);
        Animation bounce3 = AnimationUtils.loadAnimation(this, R.anim.bounce3);

        dot1.startAnimation(bounce1);
        dot2.startAnimation(bounce2);
        dot3.startAnimation(bounce3);

        // Menggunakan Handler untuk berpindah ke MainActivity setelah 2 detik
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(welcomeactivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Menutup welcome_page untuk tidak kembali ke halaman ini saat menekan tombol kembali
            }
        }, 2000); // 2000 milidetik = 2 detik
    }
}
