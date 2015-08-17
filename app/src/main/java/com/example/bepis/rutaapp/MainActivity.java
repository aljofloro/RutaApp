package com.example.bepis.rutaapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    private EditText editDesde;
    private EditText editHasta;
    private Button btnTrazar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editDesde = (EditText)findViewById(R.id.editDesde);
        editHasta = (EditText)findViewById(R.id.editHasta);
        btnTrazar = (Button)findViewById(R.id.btnTrazar);

        btnTrazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if("".equals(editDesde.getText().toString().trim())){
                    Toast.makeText(MainActivity.this,"Ingresar coordenadas inciales",Toast.LENGTH_LONG).show();
                }else if("".equals(editHasta.getText().toString().trim())){
                    Toast.makeText(MainActivity.this,"Ingresar coordenadas finales",Toast.LENGTH_LONG).show();
                }else{
                    final Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                    intent.putExtra("DESDE",editDesde.getText().toString().trim());
                    intent.putExtra("HASTA",editHasta.getText().toString().trim());

                    MainActivity.this.startActivity(intent);
                }
            }
        });
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
