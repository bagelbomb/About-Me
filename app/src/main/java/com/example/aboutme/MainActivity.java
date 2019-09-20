package com.example.aboutme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button doneButton;
    EditText editText;
    TextView nicknameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doneButton = findViewById(R.id.done_button);
        editText = findViewById(R.id.nickname_edit);
        nicknameTextView = findViewById(R.id.nickname_text);

        // Needs Java 8 (1.8) compatibility
        doneButton.setOnClickListener(e -> {
            addNickname(doneButton);
        });

    }

    private void addNickname(Button doneButton) {
        nicknameTextView.setText(editText.getText());

        editText.setVisibility(View.GONE);
        doneButton.setVisibility(View.GONE);
        nicknameTextView.setVisibility(View.VISIBLE);
    }

}
