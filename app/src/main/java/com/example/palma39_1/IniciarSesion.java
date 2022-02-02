package com.example.palma39_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IniciarSesion extends AppCompatActivity {
    EditText CorreoIn, PasswordIn;
    Button Iniciar_sesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);


        //definimos las variables
        Iniciar_sesion=findViewById(R.id.Iniciar_Sesion);
        CorreoIn = findViewById(R.id.CorreoIn);
        PasswordIn = findViewById(R.id.PasswordIn);


        Iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //metemos el contenido en las variables
                String correoIn=CorreoIn.getText().toString();
                String passwordIn=PasswordIn.getText().toString();
                if (!Patterns.EMAIL_ADDRESS.matcher(correoIn).matches()) { //Patterns.EMAIL_ADDRESS nos permite saber si lleva arroba y el .com
                    CorreoIn.setError("Correo inválido");
                    CorreoIn.setFocusable(true);// para que mantenga parpadeando la barra y pueda seguir escribiendo un correo el usuario
                }
                else if (PasswordIn.length()<6){
                    PasswordIn.setError("Contraseña debe ser mayor o igual que seis");
                    PasswordIn.setFocusable(true);
                }else {
                    System.out.println("chupala");
                }
            }
        });

    }
}