package com.morales.alarmakm;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner hora_spinner, minuto_spinner;
    private Button btn_crear_alarma;
    private EditText mensaje_de_la_alarma;
    private int SET_HORA;
    private int SET_MIN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        minuto_spinner = findViewById(R.id.MINUTO_SPINNER);
        hora_spinner = findViewById(R.id.HORA_SPINNER);
        mensaje_de_la_alarma = findViewById(R.id.MENSAJE_ALARMA);
        btn_crear_alarma =findViewById(R.id.BUTTON_ALARM);




// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.HORA_ARRAY, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        hora_spinner.setAdapter(adapter);
        hora_spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);


// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterT = ArrayAdapter.createFromResource(this, R.array.MINUTOS_ARRAY, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        minuto_spinner.setAdapter(adapterT);
        minuto_spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);


        btn_crear_alarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAlarm(mensaje_de_la_alarma.getText().toString(),SET_HORA, SET_MIN );
            }
        });

    }

    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        String get_hora = hora_spinner.getSelectedItem().toString();
        String get_minuto = minuto_spinner.getSelectedItem().toString();

        SET_HORA = Integer.parseInt(get_hora);
        SET_MIN = Integer.parseInt(get_minuto);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }


}


