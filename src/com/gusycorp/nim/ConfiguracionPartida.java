package com.gusycorp.nim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class ConfiguracionPartida extends Activity implements OnClickListener{

	private TipoPartida tipoPartida;
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
		EditText txtRival = (EditText) findViewById(R.id.nombre_rival);
		String rival = txtRival.getText().toString();
		EditText txtFila1 = (EditText) findViewById(R.id.fila1);
		String fila1 = txtFila1.getText().toString();
		EditText txtFila2 = (EditText) findViewById(R.id.fila2);
		String fila2 = txtFila2.getText().toString();
		EditText txtFila3 = (EditText) findViewById(R.id.fila3);
		String fila3 = txtFila3.getText().toString();
		CheckBox txtModoMiseria = (CheckBox) findViewById(R.id.modo_miseria);
		boolean modoMiseria = txtModoMiseria.isChecked();
		
		tipoPartida = new TipoPartida(rival, fila1, fila2, fila3, modoMiseria);
		
		switch(v.getId())
		{
		case R.id.boton_grabar_configuracion:
			Intent intent = new Intent();
			intent.putExtra("TipoPartida", tipoPartida);
			setResult(RESULT_OK, intent);
			finish();
		}
		
	}

}
