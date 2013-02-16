package com.gusycorp.nim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ConfiguracionPartida extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.configuracion_partida);
		
		Button btGrabarConfiguracion = (Button) findViewById(R.id.boton_grabar_configuracion);
		btGrabarConfiguracion.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		EditText nombreRival = (EditText) findViewById(R.id.nombre_rival);
		String rival = nombreRival.getText().toString();
		switch(v.getId())
		{
		case R.id.boton_grabar_configuracion:
			Intent intent = new Intent();
			intent.putExtra("Rival", rival);
			setResult(RESULT_OK, intent);
			finish();
		}
		
	}

}
