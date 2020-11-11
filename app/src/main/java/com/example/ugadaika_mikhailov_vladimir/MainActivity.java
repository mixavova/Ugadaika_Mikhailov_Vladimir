package com.example.ugadaika_mikhailov_vladimir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Переменные
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    int guess;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Связываем наши переменные
        tvInfo = (TextView)findViewById(R.id.textView2);
        etInput = (EditText)findViewById(R.id.edittext2);
        bControl = (Button)findViewById(R.id.button2);

        guess = (int)(Math.random()*100);
        gameFinished = false;

    }

    public void onClick(View v) {

        if (!gameFinished) {
            int inp = Integer.parseInt(etInput.getText().toString());
            // Если введенное число больше загаданного
            if (inp > guess)
                tvInfo.setText(getResources().getString(R.string.ahead));
            // Если введенное число меньше загаданного
            if (inp < guess)
                tvInfo.setText(getResources().getString(R.string.behind));
            // Если введенное число совпало с загаданным
            if (inp == guess) {
                tvInfo.setText(getResources().getString(R.string.hit));
                bControl.setText(getResources().getString(R.string.play_more));
                gameFinished = true;
                etInput.setText("Молодец!");
            }
            // Если введенное число не входит в интервал от 0 до 100
            if (inp > 100 || inp < 0)
                tvInfo.setText("Число должно быть от 0 до 100");

        }
        else {
            guess = (int)Math.random()*100;
            bControl.setText(getResources().getText(R.string.input_value));
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            gameFinished = false;
        }

    }
}