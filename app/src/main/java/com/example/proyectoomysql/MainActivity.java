package com.example.proyectoomysql;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnGuardar, btnConsultar1, btnConsultar2, btnBorrar, btnEditar;
    private EditText et1, et2, et3;
    private TextView tvResultado;

    boolean aviso1 = false;
    boolean aviso2 = false;
    boolean aviso3 = false;
    boolean estadoGuarda = false;

MantenimientoMYSQL manto = new MantenimientoMYSQL();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));
        toolbar.setTitleTextColor(getResources().getColor(R.color.mycolor2));
        toolbar.setTitleMargin(0, 0, 0, 0);
        toolbar.setSubtitle("CRUD SQLite");
        toolbar.setSubtitleTextColor(getResources().getColor(R.color.mycolor));
        toolbar.setTitle("Luis Reyes");
        setSupportActionBar(toolbar);

        //y esto para pantalla completa (oculta incluso la barra de estado)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnConsultar1 = (Button) findViewById(R.id.btnConsultar1);
        btnConsultar2 = (Button) findViewById(R.id.btnConsultar2);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);
        btnEditar = (Button) findViewById(R.id.btnEditar);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        tvResultado = (TextView) findViewById(R.id.tvResultado);

        btnGuardar.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                if (et1.getText().toString().length() == 0) {

                    et1.setError("NO PUEDE QUEDAR VACIO");
                    aviso1 = false;
                } else {
                    aviso1 = true;

                }
                if (et2.getText().toString().length() == 0) {

                    et2.setError("NO PUEDE QUEDAR VACIO");
                    aviso2 = false;
                } else {
                    aviso2 = true;
                }
                if (et3.getText().toString().length() == 0) {

                    et3.setError("NO PUEDE QUEDAR VACIO");
                    aviso3 = false;
                } else {
                    aviso3 = true;
                }
                if (aviso1 && aviso2 && aviso3) {

                    String codigo = et1.getText().toString();
                    String descripcion = et2.getText().toString();
                    String precio = et3.getText().toString();

                    manto.guardar(MainActivity.this, codigo, descripcion, precio);
                    if(estadoGuarda){
                        Toast.makeText(MainActivity.this, "Registro almacenado correctamente.", Toast.LENGTH_LONG);

                        limpiarDatos();
                    }

                }
            }
        });

    }

    public void limpiarDatos(){
        et1.setText(null);
        et2.setText(null);
        et3.setText(null);
        et1.requestFocus();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
