package algorithm.mhernandez.registrodatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class ValidarDatos extends AppCompatActivity {

    private TextView txtNombre;
    private TextView txtFecha;
    private TextView txtTelefono;
    private TextView txtEmail;
    private TextView txtDescripcion;
    private MaterialButton btnEditar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validar_datos);

        txtNombre       = (TextView) findViewById(R.id.txtINombre);
        txtFecha        = (TextView) findViewById(R.id.txtIFecha);
        txtTelefono     = (TextView) findViewById(R.id.txtITelefono);
        txtEmail        = (TextView) findViewById(R.id.txtIEmail);
        txtDescripcion  = (TextView) findViewById(R.id.txtIDescripcion);
        btnEditar       = (MaterialButton) findViewById(R.id.btnMEditar);

        Bundle parametros   = getIntent().getExtras();
        String Nombre       = parametros.getString(getResources().getString(R.string.pnombre));
        String Fecha        = parametros.getString(getResources().getString(R.string.pfecha));
        String Telefono     = parametros.getString(getResources().getString(R.string.ptelefono));
        String Email        = parametros.getString(getResources().getString(R.string.pemail));
        String Descripcion  = parametros.getString(getResources().getString(R.string.pdescripcion));

        txtNombre.setText(Nombre);
        txtFecha.setText("Fecha Nacimiento: "+Fecha);
        txtTelefono.setText("Telefono: "+Telefono);
        txtEmail.setText("Email: "+Email);
        txtDescripcion.setText("Descripcion: "+Descripcion);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}