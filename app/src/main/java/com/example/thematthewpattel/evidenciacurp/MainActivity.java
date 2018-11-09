package com.example.thematthewpattel.evidenciacurp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvReciclar;
    private LinearLayoutManager lmManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner)findViewById(R.id.iEntidad);

        @SuppressLint("ResourceType") ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.id.iEntidadLista, R.layout.support_simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        Button button = (Button) findViewById(R.id.iBuscarCURP);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          openActivity2();
                                      }
                                  }
        );

    }

    public void initReciclar() {
        rvReciclar = (RecyclerView) findViewById(R.id.iReciclar);
        rvReciclar.setHasFixedSize(true);

        lmManage = new LinearLayoutManager(this);
        rvReciclar.setLayoutManager(lmManage);
    }

    public void openActivity2() {

        user curp = new user();
        curp.sApellidoP = ((EditText)findViewById(R.id.iApellidoP)).getText().toString();
        curp.sApellidoM = ((EditText)findViewById(R.id.iApellidoM)).getText().toString();
        curp.sNombres = ((EditText)findViewById(R.id.iNombres)).getText().toString();
        curp.sSexo = ((RadioButton)findViewById(((RadioGroup)findViewById(R.id.iSexo)).getCheckedRadioButtonId())).getText().toString();
        curp.sFecha = ((EditText)findViewById(R.id.iFecha)).getText().toString();
        curp.sEntidad = ((Spinner)findViewById(R.id.iEntidad)).getSelectedItem().toString();

        Intent Actividad = new Intent(this, Activity2.class);
        Actividad.putExtra("CURP", curp);
        startActivity(Actividad);
    }
}
