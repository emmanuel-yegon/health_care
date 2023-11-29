package com.emmanuel_yegon.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.emmanuel_yegon.healthcare.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    EditText edUsername,edEmail,edPassword,edConfirmPassword;
    Button btn;
    TextView tv;
    private ActivityRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       binding = ActivityRegisterBinding.inflate(getLayoutInflater());
       setContentView(binding.getRoot());


        edUsername = findViewById(R.id.editTextRegUsername);
        edEmail = findViewById(R.id.editTextRegEmail);
        edPassword = findViewById(R.id.editTextRegPassword);
        edConfirmPassword = findViewById(R.id.editTextRegConfirmPassword);
        btn = findViewById(R.id.buttonRegister);
        tv = findViewById(R.id.textViewRegLogin);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirmPassword = edConfirmPassword.getText().toString();

                Database db =new Database(getApplicationContext(),"healthcare",null,1);

                if (username.length()==0 || email.length()==0 || password.length()==0 || confirmPassword.length()==0){
                    Toast.makeText(getApplicationContext(),"Please fill All Details",Toast.LENGTH_SHORT).show();
                }else {
                    if (password.compareTo(confirmPassword)==0){
                        if (isValid(password)){
                            db.register(username,email,password);
                            Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                        }else {
                            Toast.makeText(getApplicationContext(),"Password must contain at least 8 characters;having letter,digit and special symbol",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(),"Password and Confirm Password do not match!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    public static boolean isValid(String passwordHere){
        int f1=0, f2=0, f3=0;
        if (passwordHere.length()<8){
            return false;
        }else {
            for (int p =0; p< passwordHere.length();p++){
                if (Character.isLetter(passwordHere.charAt(p))){
                    f1=1;
                }
            }
            for (int r=0;r<passwordHere.length();r++){
                if (Character.isDigit(passwordHere.charAt(r))){
                    f2=1;
                }
            }
            for (int s= 0; s < passwordHere.length();s++){
                char c = passwordHere.charAt(s);
                if(c>=33&&c<=46||c==64){
                    f3=1;
                }
            }
            if (f1==1&&f2==1&&f3==1)
                return true;
            return false;
        }
    }


}