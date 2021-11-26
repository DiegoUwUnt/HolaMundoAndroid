package com.diego.villagran.salazar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KmActivity extends AppCompatActivity {

    private EditText editTextKm;
    private EditText editTextM;
    private Button buttonDesplegar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_km);
        editTextKm = findViewById( R.id.editTextNumberKm);
        editTextM= findViewById( R.id.editTextNumberM);
        editTextM.setEnabled( false );
        buttonDesplegar = findViewById(R.id.buttonDesplegar );
        buttonDesplegar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizaOperacion( );
            }
        });
    }
    private void realizaOperacion()
    {
        int total = 0;
        if( editTextKm.getText().toString() != null )
        {
            if( isEntero( editTextKm.getText().toString() ) )
            {
                total = getEntero( editTextKm.getText().toString() ) * 1000 ;
            }
        }
        editTextM.setText( String.valueOf(total) ,TextView.BufferType.SPANNABLE );
        editTextM.setEnabled( false );
    }

    private int getEntero(String entero)
    {
        try
        {
            return Integer.parseInt( entero );
        }
        catch( NumberFormatException ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }

    private boolean isEntero(String entero)
    {
        try
        {
            if( entero == null || entero.length() == 0)
            {
                return false;
            }
            Integer.parseInt( entero );
            return true;
        }
        catch( NumberFormatException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }
}
