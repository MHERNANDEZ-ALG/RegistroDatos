package algorithm.mhernandez.registrodatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText txtNombre;
    private TextInputEditText txtFecha;
    private TextInputEditText txtTelefono;
    private TextInputEditText txtEmail;
    private TextInputEditText txtDescripcion;
    private MaterialButton btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (TextInputEditText) findViewById(R.id.txtNombre);
        txtFecha = (TextInputEditText) findViewById(R.id.txtFecha);
        txtTelefono = (TextInputEditText) findViewById(R.id.txtTelefono);
        txtEmail = (TextInputEditText) findViewById(R.id.txtEmail);
        txtDescripcion = (TextInputEditText) findViewById(R.id.txtDescripcion);
        btnSiguiente = (MaterialButton) findViewById(R.id.btnSiguiente);

        //Calendario Fecha
        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText("Fecha de Nacimiento");
        final MaterialDatePicker materialDatePicker = builder.build();

        txtFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialDatePicker.show(getSupportFragmentManager(), "Nacimiento");
            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                txtFecha.setText(materialDatePicker.getHeaderText());
            }
        });
        //Calendario fecha fin

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ValidarDatos.class);
                i.putExtra(getResources().getString(R.string.pnombre), txtNombre.getText().toString());
                i.putExtra(getResources().getString(R.string.pfecha), txtFecha.getText().toString());
                i.putExtra(getResources().getString(R.string.ptelefono), txtTelefono.getText().toString());
                i.putExtra(getResources().getString(R.string.pemail), txtEmail.getText().toString());
                i.putExtra(getResources().getString(R.string.pdescripcion), txtDescripcion.getText().toString());
                startActivity(i);
            }
        });
    }
}