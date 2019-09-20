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

    private MyName myName = new MyName("Tanner", "");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setMyName(myName);

        // Needs Java 8 (1.8) compatibility
        binding.doneButton.setOnClickListener(e -> {
            addNickname(binding.doneButton);
        });

    }

    private void addNickname(Button doneButton) {

        // Looks like I can't do the .apply in Java
        myName.setNickname(binding.nicknameEdit.getText().toString());
        binding.nicknameEdit.setVisibility(View.GONE);
        binding.doneButton.setVisibility(View.GONE);
        binding.nicknameText.setVisibility(View.VISIBLE);
        binding.invalidateAll();

        // hide the keyboard
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(doneButton.getWindowToken(), 0);
    }

}
