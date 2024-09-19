package com.habiburrohman.bizzhub;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.button.MaterialButton;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import com.habiburrohman.bizzhub.LoginActivity;

public class register_Activity extends AppCompatActivity {

    private EditText datePickerEditText;
    private EditText fullname, name, email, phone, alamat, password, konfirmpassword;
    private Spinner spiner_gender;
    private MaterialButton btnRegister;
    private TextView btn_masuk;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        // Menambahkan insets untuk sistem bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_masuk =findViewById(R.id.btn_masuk);
        btn_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(register_Activity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        // Event handler untuk tombol Register
        fullname = findViewById(R.id.edt_fullname_register);
        name = findViewById(R.id.edt_name);
        email = findViewById(R.id.edt_email);
        datePickerEditText = findViewById(R.id.datePicker);
        spiner_gender = findViewById(R.id.gender);
        phone = findViewById(R.id.editTextNumber);
        alamat = findViewById(R.id.edt_alamat_register);
        password = findViewById(R.id.edt_password_register);
        konfirmpassword = findViewById(R.id.edt_konfirmpassword_register);
        btnRegister = findViewById(R.id.btn_register);

        String[] genderOptions = getResources().getStringArray(R.array.gender_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, genderOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiner_gender.setAdapter(adapter);

        btnRegister.setOnClickListener(v -> {
            String fullName = fullname.getText().toString();
            String Nama = name.getText().toString();
            String TglLahir = datePickerEditText.getText().toString();  // Ambil data dari datePickerEditText
            String Phone = phone.getText().toString();
            String Alamat = alamat.getText().toString();
            String Email = email.getText().toString();
            String Password = password.getText().toString();
            String konfPassword = konfirmpassword.getText().toString();
            String selectedGender = spiner_gender.getSelectedItem().toString();

            if(!Password.equals(konfPassword)) {
                Toast.makeText(register_Activity.this, "Password tidak sama", Toast.LENGTH_SHORT).show();
                return;
            }

            if (fullName.isEmpty() || Email.isEmpty() || Password.isEmpty() || Nama.isEmpty() || TglLahir.isEmpty() || selectedGender.isEmpty() || Phone.isEmpty() || Alamat.isEmpty()) {
                Toast.makeText(register_Activity.this, "Tolong isikan semua data!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(register_Activity.this, "Register Berhasil!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(register_Activity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        datePickerEditText.setOnClickListener(v -> showDatePickerDialog());
    }
    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    Calendar selectedDate = Calendar.getInstance();
                    selectedDate.set(selectedYear, selectedMonth, selectedDay);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                    datePickerEditText.setText(dateFormat.format(selectedDate.getTime()));  // Set hasil ke datePickerEditText
                },
                year,month,day
        );
        datePickerDialog.show();
    }
}
