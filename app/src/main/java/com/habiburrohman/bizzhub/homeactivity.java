package com.habiburrohman.bizzhub;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class homeactivity extends AppCompatActivity {

    private Spinner spinnerRegion;
    private EditText phoneNumber, messageText;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); // Ensure this layout exists

        // Initialize UI components
        spinnerRegion = findViewById(R.id.spinnerRegion);
        phoneNumber = findViewById(R.id.phoneNumber);
        messageText = findViewById(R.id.messageText);
        sendButton = findViewById(R.id.sendButton);

        // Set up the button click listener
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageStr = messageText.getText().toString().trim();
                String phoneStr = phoneNumber.getText().toString().trim();

                if (!messageStr.isEmpty() && !phoneStr.isEmpty()) {
                    if (isWhatsAppInstalled()) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=" + phoneStr + "&text=" + Uri.encode(messageStr)));
                        startActivity(intent);
                        messageText.setText("");
                        phoneNumber.setText("");
                    } else {
                        // Redirect to browser to download WhatsApp
                        Toast.makeText(homeactivity.this, "WhatsApp is not installed. Opening browser to download.", Toast.LENGTH_SHORT).show();
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.whatsapp.com/download/"));
                        startActivity(browserIntent);
                    }
                } else {
                    Toast.makeText(homeactivity.this, "Please fill in the phone number and message; they can't be empty", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean isWhatsAppInstalled() {
        PackageManager packageManager = getPackageManager();
        boolean whatsappInstalled = false;

        try {
            packageManager.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
            whatsappInstalled = true;
            Log.d("WhatsAppCheck", "WhatsApp is installed");
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("WhatsAppCheck", "WhatsApp not found: " + e.getMessage());
        }

        try {
            packageManager.getPackageInfo("com.whatsapp.w4b", PackageManager.GET_ACTIVITIES);
            whatsappInstalled = true;
            Log.d("WhatsAppCheck", "WhatsApp Business is installed");
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("WhatsAppCheck", "WhatsApp Business not found: " + e.getMessage());
        }

        return whatsappInstalled;
    }
}
