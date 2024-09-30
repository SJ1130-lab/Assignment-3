package com.example.assignment3;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private EditText etUsername, etEmail, etPassword, etConfirmPassword, etMobile;
    private Button btnRegister, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etUsername = findViewById(R.id.et_register_username);
        etEmail = findViewById(R.id.et_register_email);
        etPassword = findViewById(R.id.et_register_password);
        etConfirmPassword = findViewById(R.id.et_register_confirm_password);
        etMobile = findViewById(R.id.et_register_mobile);

        btnRegister = findViewById(R.id.btn_sign_up_register);
        btnLogin = findViewById(R.id.btn_sign_up_login);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validateForm()) {
                    // Proceed with registration logic
                    Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Login Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private boolean validateForm() {
        String username = etUsername.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();
        String mobile = etMobile.getText().toString().trim();


        if (TextUtils.isEmpty(username)) {
            etUsername.setError("Please enter username");
            etUsername.requestFocus();
            return false;
        }


        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Please enter email");
            etEmail.requestFocus();
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Please enter a valid email address");
            etEmail.requestFocus();
            return false;
        }


        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Please enter password");
            etPassword.requestFocus();
            return false;
        } else if (password.length() < 6) {
            etPassword.setError("Password must be at least 6 characters long");
            etPassword.requestFocus();
            return false;
        }

        // Validate confirm password
        if (TextUtils.isEmpty(confirmPassword)) {
            etConfirmPassword.setError("Please confirm password");
            etConfirmPassword.requestFocus();
            return false;
        } else if (!password.equals(confirmPassword)) {
            etConfirmPassword.setError("Passwords do not match");
            etConfirmPassword.requestFocus();
            return false;
        }


        if (TextUtils.isEmpty(mobile)) {
            etMobile.setError("Please enter mobile number");
            etMobile.requestFocus();
            return false;
        } else if (mobile.length() != 11) {
            etMobile.setError("Please enter a valid mobile number");
            etMobile.requestFocus();
            return false;
        }


        return true;
    }
}
