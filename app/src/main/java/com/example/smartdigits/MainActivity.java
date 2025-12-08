package com.example.smartdigits;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    private ImageButton settingsButton;
    private EditText wifiNameInput;
    private EditText wifiPasswordInput;
    private ImageButton togglePasswordButton;
    private Button connectWifiButton;
    private Button resetPasswordButton;
    private Button proceedButton;
    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        settingsButton = findViewById(R.id.settingsButton);
        wifiNameInput = findViewById(R.id.wifiNameInput);
        wifiPasswordInput = findViewById(R.id.wifiPasswordInput);
        togglePasswordButton = findViewById(R.id.togglePasswordButton);
        connectWifiButton = findViewById(R.id.connectWifiButton);
        resetPasswordButton = findViewById(R.id.resetPasswordButton);
        proceedButton = findViewById(R.id.proceedButton);

        // Settings button click
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        // Toggle password visibility
        togglePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPasswordVisible) {
                    // Hide password
                    wifiPasswordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    togglePasswordButton.setImageResource(R.drawable.ic_eye);
                    isPasswordVisible = false;
                } else {
                    // Show password
                    wifiPasswordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    togglePasswordButton.setImageResource(R.drawable.ic_eye_off);
                    isPasswordVisible = true;
                }
                // Move cursor to end
                wifiPasswordInput.setSelection(wifiPasswordInput.getText().length());
            }
        });

        // Connect to WiFi button
        connectWifiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wifiName = wifiNameInput.getText().toString().trim();
                String wifiPassword = wifiPasswordInput.getText().toString().trim();

                if (wifiName.isEmpty() || wifiPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Please enter WiFi name and password",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,
                            "Connecting to " + wifiName + "...",
                            Toast.LENGTH_SHORT).show();
                    // Note: Actual WiFi connection requires system permissions and APIs
                    // This is a simulated connection for demonstration
                }
            }
        });

        // Reset password button
        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wifiPasswordInput.setText("");
                Toast.makeText(MainActivity.this,
                        "Password cleared",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Proceed to data entry button
        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wifiName = wifiNameInput.getText().toString().trim();

                if (wifiName.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Please connect to a WiFi network first",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,
                            "Proceeding to data entry...",
                            Toast.LENGTH_SHORT).show();
                    // You can add navigation to another activity here
                }
            }
        });
    }
}