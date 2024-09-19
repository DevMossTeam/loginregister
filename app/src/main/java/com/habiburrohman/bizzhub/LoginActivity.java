    package com.habiburrohman.bizzhub;

    import android.annotation.SuppressLint;
    import android.content.Intent;
    import android.os.Bundle;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.graphics.Insets;
    import androidx.core.view.ViewCompat;
    import androidx.core.view.WindowInsetsCompat;

    public class LoginActivity extends AppCompatActivity {  // Ubah nama class ke LoginActivity
        private EditText name, password;
        private Button btn_login;
        private TextView btn_masuk;

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            // Mengatur padding sesuai dengan system bar insets (status bar & navigation bar)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });

            // Inisialisasi komponen UI
            btn_masuk = findViewById(R.id.btn_masuk);
            name = findViewById(R.id.edt_name_login);
            password = findViewById(R.id.edt_password_login);
            btn_login = findViewById(R.id.btn_login);

            // Aksi ketika tombol 'Masuk' di klik (menuju ke Register Activity)
            btn_masuk.setOnClickListener(v -> {
                Intent register = new Intent(LoginActivity.this, register_Activity.class);  // Sesuaikan penamaan RegisterActivity
                startActivity(register);
            });

            btn_login.setOnClickListener(v -> {
                String nama = name.getText().toString();
                String pass = password.getText().toString();

                if (nama.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Nama atau Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();

                    // Update the intent to use HomeActivity
                    Intent intent = new Intent(LoginActivity.this, homeactivity.class);
                    startActivity(intent);
                }
            });
        }
    }
