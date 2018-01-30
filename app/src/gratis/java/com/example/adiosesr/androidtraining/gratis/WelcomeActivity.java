package com.example.adiosesr.androidtraining.gratis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.adiosesr.androidtraining.MainActivity;
import com.example.adiosesr.androidtraining.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeActivity extends AppCompatActivity {


    @BindView(R.id.etName)
    EditText etName;

    @BindView(R.id.etDni)
    EditText etDni;

    @BindView(R.id.etPhone)
    EditText etPhone;

    @BindView(R.id.btnBuy)
    Button btnBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btnBuy)
    public void Buy()
    {
        if(etDni.getText().toString().trim().length()<8)
        {
            Toast.makeText(this, "DNI debe ser de 8 digitos", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if (etPhone.getText().toString().trim().length()<9)
            {
                Toast.makeText(this, "El número debe ser de 9 digitos", Toast.LENGTH_SHORT).show();
            }
            else
            {
                if(etName.getText().toString().equals("Everis") && etDni.getText().toString().equals("12345678") && etPhone.getText().toString().equals("123456789"))
                {
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(this, "Ingrese correctamente sus credenciales", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }
}