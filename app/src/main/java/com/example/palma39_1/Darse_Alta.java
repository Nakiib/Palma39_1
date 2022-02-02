package com.example.palma39_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Darse_Alta extends AppCompatActivity {

    //DECLARAMOS VARIABLES
    TextView FechaRegistro;
    EditText Correo, Password, Nombres, Apellidos, Edad;
    Button Registrar;

    FirebaseAuth auth; // lo creas para poder crear cuenta  atraves de correo electronico

    ProgressDialog progressDialog; // esto hace que surja una pequeña animacion al momento de dar click en boton registrar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darse_alta);
        // inicializamos variables
        FechaRegistro = findViewById(R.id.FechaRegistro);
        Correo = findViewById(R.id.CorreoIn);
        Password = findViewById(R.id.PasswordIn);
        Nombres = findViewById(R.id.Nombre);
        Apellidos = findViewById(R.id.Apellidos);
        Edad =findViewById(R.id.Edad);

        Registrar = findViewById(R.id.Registrar);

        //CUIDAO!! HEMOS IMPORTADO CLASE Y PUEDE NO SER LA CORRECTA. hABIA DOS. COGIMOS LA PRIMERA!!
        Date date = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("d ' de 'MMM ' del ' yyyy"); // fecha del dia que toque 04/01/2022
        String SFecha = fecha.format(date); // con esto convertimos fecha a string
        FechaRegistro.setText(SFecha);

        // al hacer click en registarr

        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // convertimo a string los edit text de correo0 y contraseña para poder hacer las validaciones
                String correo = Correo.getText().toString();
                String pass = Password.getText().toString();

                // EMPIEZA LA VALIDACION DEL CORREO ELECTRONICO

                if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) { //Patterns.EMAIL_ADDRESS nos permite saber si lleva arroba y el .com
                    Correo.setError("Correo inválido");
                    Correo.setFocusable(true);// para que mantenga parpadeando la barra y pueda seguir escribiendo un correo el usuario
                }
                else if (pass.length()<6){
                    Password.setError("Contraseña debe ser mayor o igual que seis");
                    Password.setFocusable(true);
                }else {
                    RegistroAdministradores(Correo,pass);
                }
            }
        });

    }

    // metodo para registrar administradores
    private void RegistroAdministradores(EditText correo, String pass) {
        System.out.println("chupala");
    }
}