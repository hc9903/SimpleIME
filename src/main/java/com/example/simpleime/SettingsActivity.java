package com.example.simpleime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final EditText button1Name = findViewById(R.id.button1_name);
        final EditText button1Text = findViewById(R.id.button1_text);

        final EditText button2Name = findViewById(R.id.button2_name);
        final EditText button2Text = findViewById(R.id.button2_text);

        final EditText button3Name = findViewById(R.id.button3_name);
        final EditText button3Text = findViewById(R.id.button3_text);

        final EditText button4Name = findViewById(R.id.button4_name);
        final EditText button4Text = findViewById(R.id.button4_text);

        Button saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("buttonSettings", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("button1Name", button1Name.getText().toString().equals("") ? "姓名" : button1Name.getText().toString());
                editor.putString("button1Text", button1Text.getText().toString().equals("") ? "姓名" : button1Text.getText().toString());
                editor.putString("button2Name", button2Name.getText().toString().equals("") ? "学号" : button2Name.getText().toString());
                editor.putString("button2Text", button2Text.getText().toString().equals("") ? "学号" : button2Text.getText().toString());
                editor.putString("button3Name", button3Name.getText().toString().equals("") ? "QQ号码" : button3Name.getText().toString());
                editor.putString("button3Text", button3Text.getText().toString().equals("") ? "QQ号码" : button3Text.getText().toString());
                editor.putString("button4Name", button4Name.getText().toString().equals("") ? "电话号码" : button4Name.getText().toString());
                editor.putString("button4Text", button4Text.getText().toString().equals("") ? "电话号码" : button4Text.getText().toString());
                editor.apply();
                finish();
            }
        });

        Button openInputMethodSettingsButton = findViewById(R.id.open_input_method_settings);
        openInputMethodSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS);
                startActivity(intent);
            }
        });
    }
}
