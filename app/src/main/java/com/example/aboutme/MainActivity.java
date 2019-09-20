package com.example.aboutme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.aboutme.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    //Button doneButton;
    //EditText editText;
    //TextView nicknameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //doneButton = findViewById(R.id.done_button);
        //editText = findViewById(R.id.nickname_edit);
        //nicknameTextView = findViewById(R.id.nickname_text);

        // Needs Java 8 (1.8) compatibility
//        doneButton.setOnClickListener(e -> {
//            addNickname(doneButton);
//        });

        binding.doneButton.setOnClickListener(e -> {
            addNickname(binding.doneButton);
        });

    }

    private void addNickname(Button doneButton) {

        // Looks like I can't do the .apply in Java
        //binding.apply {
            binding.nicknameText.setText(binding.nicknameEdit.getText());
            binding.nicknameEdit.setVisibility(View.GONE);
            binding.doneButton.setVisibility(View.GONE);
            binding.nicknameText.setVisibility(View.VISIBLE);
            binding.invalidateAll();
        //}

//        nicknameTextView.setText(editText.getText());
//        editText.setVisibility(View.GONE);
//        doneButton.setVisibility(View.GONE);
//        nicknameTextView.setVisibility(View.VISIBLE);

        // hide the keyboard
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(doneButton.getWindowToken(), 0);
    }

}
