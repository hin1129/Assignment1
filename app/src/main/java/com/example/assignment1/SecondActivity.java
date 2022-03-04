package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.*;
import java.util.regex.Pattern;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.Assignment1.extra.REPLY";

    //button
    private Button button_next;
    //3text fields
    private EditText editText_email;
    private EditText editText_create_password;
    private EditText editText_repeat_password;

    //create password requirements
//    private static final Pattern Password_Requirement = Pattern.compile(
////            "(?=.*[a-zA-Z])" +
//            "(?=.*[a-z])" +
//            "(?=.*[A-Z])" +
//            "(?=.*[!@£$%^&*])"
//
//    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //register button+text fields with IDs
        button_next = findViewById(R.id.button_second);
        editText_email = findViewById(R.id.editText_email);
        editText_create_password = findViewById(R.id.editText_create_password);
        editText_repeat_password = findViewById(R.id.editText_repeat_password);

        //handle next button
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get text from edittext, turn into a string
                String emailAddress = editText_email.getText().toString();
                String createPassword = editText_create_password.getText().toString();
                String repeatPassword = editText_repeat_password.getText().toString();

                //validation
                if (!Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()){
                    Toast.makeText(getApplicationContext(),"email format incorrect", Toast.LENGTH_LONG).show();
                    editText_create_password.setError("Email format incorrect");
                }
                 if (createPassword.length() < 8 ){
                    Toast.makeText(getApplicationContext(),"Length is less than 8", Toast.LENGTH_LONG).show();
                    editText_create_password.setError("Length is less than 8");
                }
//                else if (!Password_Requirement.matcher(createPassword).matches()){
//                    Toast.makeText(getApplicationContext(),"Required UpCase+Symbol", Toast.LENGTH_LONG).show();
//                    editText_create_password.setError("Required UpCase+Symbol");
//                }
                 if(!createPassword.matches("(.*[A-Z])") && (!createPassword.matches("^(!@£$%.*$)"))){
                     Toast.makeText(getApplicationContext(),"Required UpCase+Symbol", Toast.LENGTH_LONG).show();
                     editText_create_password.setError("Required UpCase+Symbol");
                }
                 if (!repeatPassword.equals(createPassword)){
                    Toast.makeText(getApplicationContext(),"password not match", Toast.LENGTH_LONG).show();
                    editText_repeat_password.setError("Password not match");
                }
                else{
                    Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
//        mReply = findViewById(R.id.editText_email);
//        Intent intent = getIntent();
//        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
//        TextView textView = findViewById(R.id.text_message);
//        textView.setText(message);
    }
//    public void returnReply(View view) {
//        String reply = mReply.getText().toString();
//
//        Intent replyIntent = new Intent();
//        replyIntent.putExtra(EXTRA_REPLY, reply);
//        setResult(RESULT_OK,replyIntent);
//        finish();
//    }
}