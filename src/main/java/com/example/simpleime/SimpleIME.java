package com.example.simpleime;

import android.content.SharedPreferences;
import android.inputmethodservice.InputMethodService;
import android.view.KeyEvent;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;

import android.view.View;
import android.widget.Button;

public class SimpleIME extends InputMethodService {

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        InputConnection ic = getCurrentInputConnection();

        switch (keyCode) {
            case KeyEvent.KEYCODE_1:
                ic.commitText("你的预定义文本1", 1);
                return true;
            case KeyEvent.KEYCODE_2:
                ic.commitText("你的预定义文本2", 1);
                return true;
            case KeyEvent.KEYCODE_3:
                ic.commitText("你的预定义文本3", 1);
                return true;
            case KeyEvent.KEYCODE_4:
                ic.commitText("你的预定义文本4", 1);
                return true;
            default:
                return super.onKeyDown(keyCode, event);
        }
    }

    private Button button1, button2, button3, button4, buttonClear;

    @Override
    public View onCreateInputView() {
        View keyboardView = getLayoutInflater().inflate(R.layout.keyboard, null);

        button1 = keyboardView.findViewById(R.id.button1);
        button2 = keyboardView.findViewById(R.id.button2);
        button3 = keyboardView.findViewById(R.id.button3);
        button4 = keyboardView.findViewById(R.id.button4);
        buttonClear = keyboardView.findViewById(R.id.button_clear);


        SharedPreferences sharedPreferences = getSharedPreferences("buttonSettings", MODE_PRIVATE);
        button1.setText(sharedPreferences.getString("button1Name", "Button 1"));
        final String button1Text = sharedPreferences.getString("button1Text", "预定义文本1");
        button1.setOnClickListener(v -> commitText(button1Text));
        button2.setText(sharedPreferences.getString("button2Name", "Button 2"));
        final String button2Text = sharedPreferences.getString("button2Text", "预定义文本2");
        button2.setOnClickListener(v -> commitText(button2Text));
        button3.setText(sharedPreferences.getString("button3Name", "Button 3"));
        final String button3Text = sharedPreferences.getString("button3Text", "预定义文本3");
        button3.setOnClickListener(v -> commitText(button3Text));
        button4.setText(sharedPreferences.getString("button4Name", "Button 4"));
        final String button4Text = sharedPreferences.getString("button4Text", "预定义文本4");
        button4.setOnClickListener(v -> commitText(button4Text));
        buttonClear.setOnClickListener(v -> clearInput());


        return keyboardView;
    }

    private void commitText(String text) {
        InputConnection ic = getCurrentInputConnection();
        if (ic != null) {
            ic.commitText(text, 1);
        }
    }

    private void clearInput() {
        InputConnection ic = getCurrentInputConnection();
        if (ic != null) {
            CharSequence currentText = ic.getExtractedText(new ExtractedTextRequest(), 0).text;
            ic.deleteSurroundingText(currentText.length(), 0);
        }
    }
}
