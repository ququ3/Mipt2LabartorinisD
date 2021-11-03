package com.example.mipt2labartorinisd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spCounterOption;
    private EditText edEnteredText;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.spCounterOption = findViewById(R.id.spCounterOption);
        this.edEnteredText = findViewById(R.id.etEnteredText);
        this.tvResult = findViewById(R.id.tvResult);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.selection_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCounterOption.setAdapter(adapter);
    }

    public void btnClick(View view) {

        Toast.makeText(this, this.spCounterOption.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

        String spSelectedOption = this.spCounterOption.getSelectedItem().toString();
        String charString = getString(R.string.selection_chars);


        String wordString = getString(R.string.selection_words);
        String numberString = getString(R.string.selection_numbers);

        if(spSelectedOption.equalsIgnoreCase(charString)){
            String enteredUserText = this.edEnteredText.getText().toString();

            int charsCount = TextCounter.getCharsCount(enteredUserText);
            this.tvResult.setText(String.valueOf(charsCount));

        }
        else if(spSelectedOption.equalsIgnoreCase(wordString)){
            String enteredUserText = this.edEnteredText.getText().toString();
            int wordsCount = TextCounter.getWordsCount(enteredUserText);
            this.tvResult.setText(String.valueOf(wordsCount));

        }
        else if(spSelectedOption.equalsIgnoreCase(numberString)){
            String enteredUserText = this.edEnteredText.getText().toString();
            int numberCount = TextCounter.getNumbersCount(enteredUserText);
            this.tvResult.setText(String.valueOf(numberCount));
        }

    }
}