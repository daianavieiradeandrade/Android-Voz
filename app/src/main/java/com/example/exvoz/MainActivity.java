package com.example.exvoz;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private EditText edMensagem;
    private TextToSpeech objetoVoz;
    private Button btFalar, btOuvir;
    private ListView lsPalavras;
    private Locale locale;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        objetoVoz = new TextToSpeech(MainActivity.this, MainActivity.this);
        edMensagem=findViewById(R.id.edtTexto);
        botoes();
    }

    private void botoes() {
        btFalar=findViewById(R.id.btnFalarTextoDigitado);
        btFalar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                String texto = edMensagem.getText().toString();
                objetoVoz.speak(texto, TextToSpeech.QUEUE_FLUSH, Bundle.EMPTY, "1");
            }
        });
    }

    @Override
    public void onInit(int status) {
        objetoVoz.setLanguage(Locale.JAPAN);
    }
}