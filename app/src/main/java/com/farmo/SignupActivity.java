package com.farmo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.farmo.network.MessageResponse;
import com.farmo.network.RegisterRequest;
import com.farmo.network.RetrofitClient;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    private TextInputEditText etName, etPhone, etEmail, etPassword;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etName = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        Button btnSignup = findViewById(R.id.btn_signup);
        TextView tvLogin = findViewById(R.id.tv_login);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Creating account...");
        progressDialog.setCancelable(false);

        btnSignup.setOnClickListener(v -> performSignup());

        tvLogin.setOnClickListener(v -> finish());
    }

    private void performSignup() {
        String name = etName.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.show();
        RegisterRequest request = new RegisterRequest(name, phone, email, password);

        RetrofitClient.getApiService(this).register(request).enqueue(new Callback<MessageResponse>() {
            @Override
            public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()) {
                    Toast.makeText(SignupActivity.this, "Signup successful! Please login.", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(SignupActivity.this, "Signup failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MessageResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(SignupActivity.this, "Network error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
