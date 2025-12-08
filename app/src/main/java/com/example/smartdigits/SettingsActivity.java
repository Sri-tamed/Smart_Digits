package com.example.smartdigits;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private EditText ipAddressInput;
    private EditText portNumberInput;
    private Button enterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Set title for the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Settings");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ipAddressInput = findViewById(R.id.ipAddressInput);
        portNumberInput = findViewById(R.id.portNumberInput);
        enterButton = findViewById(R.id.enterButton);

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ipAddress = ipAddressInput.getText().toString().trim();
                String port = portNumberInput.getText().toString().trim();

                if (ipAddress.isEmpty() || port.isEmpty()) {
                    Toast.makeText(SettingsActivity.this,
                            "Please enter both IP address and port number",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                // Construct the URL
                String url = "http://" + ipAddress + ":" + port;

                // Open in browser
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                try {
                    startActivity(browserIntent);
                } catch (Exception e) {
                    Toast.makeText(SettingsActivity.this,
                            "Unable to open browser",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}