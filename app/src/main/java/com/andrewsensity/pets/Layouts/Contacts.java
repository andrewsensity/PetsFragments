package com.andrewsensity.pets.Layouts;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.andrewsensity.pets.R;
import com.andrewsensity.pets.Pojos.SendMail;

public class Contacts extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText inputNombre;
    private TextInputEditText inputEmail;
    private TextInputEditText inputMensaje;

    private Button botonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        inputNombre = (TextInputEditText) findViewById(R.id.textInputNombre);
        inputEmail = (TextInputEditText) findViewById(R.id.textInputCorreo);
        inputMensaje = (TextInputEditText) findViewById(R.id.textInputMensaje);

        botonEnviar = (Button) findViewById(R.id.buttonEnviar);

        botonEnviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        sendEmail();
    }

    private void sendEmail() {
        String email = inputEmail.getText().toString().trim();
        String subject = "Andrewsensity Inc";
        String message = "Saludos " + inputNombre.getText().toString().trim() + ":\n" +  inputMensaje.getText().toString().trim();

        SendMail sendMail = new SendMail(this, email, subject, message);

        sendMail.execute();
    }

}