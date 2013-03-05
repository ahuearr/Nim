package com.gusycorp.nim.activity;

import com.gusycorp.nim.R;
import com.gusycorp.nim.R.id;
import com.gusycorp.nim.R.layout;
import com.gusycorp.nim.model.Fila;
import com.gusycorp.nim.model.TipoPartida;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class ConfiguracionPartidaActivity extends Activity implements OnClickListener {

	public static final String TIPO_PARTIDA = "TipoPartida";
	public static final String FILA1 = "Fila1";
	public static final String FILA2 = "Fila2";
	public static final String FILA3 = "Fila3";
	public static final String MODO_MISERIA = "ModoMiseria";

	private ArrayAdapter<Fila> filas;
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.configuracion_partida);

		final Button grabarConfiguracion = (Button) findViewById(R.id.boton_grabar_configuracion);
		grabarConfiguracion.setOnClickListener(this);
		final EditText editRival = (EditText) findViewById(R.id.nombre_rival);
		final Spinner fila1 = (Spinner) findViewById(R.id.fila1);
		final Spinner fila2 = (Spinner) findViewById(R.id.fila2);
		final Spinner fila3 = (Spinner) findViewById(R.id.fila3);
		final CheckBox checkboxModoMiseria = (CheckBox) findViewById(R.id.modo_miseria);

		filas = new ArrayAdapter<Fila>(this, android.R.layout.simple_spinner_item, Fila.getTodasFilas());
		filas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		fila1.setAdapter(filas);
		fila2.setAdapter(filas);
		fila3.setAdapter(filas);
		
		SharedPreferences preferencias = getSharedPreferences("preferencias", MODE_PRIVATE);

		//Se recuperan los valores de las preferencias y se setean los spinners
		int posFila = 0;
		posFila=getPosicionSeleccionada(preferencias.getString(FILA1, ""));
		fila1.setSelection(posFila);
		posFila=getPosicionSeleccionada(preferencias.getString(FILA2, ""));
		fila2.setSelection(posFila);
		posFila=getPosicionSeleccionada(preferencias.getString(FILA3, ""));
		fila3.setSelection(posFila);
		checkboxModoMiseria.setChecked(preferencias.getBoolean(MODO_MISERIA, false));
	}

	@Override
	public void onClick(final View v) {

		final EditText editRival = (EditText) findViewById(R.id.nombre_rival);
		final Spinner fila1 = (Spinner) findViewById(R.id.fila1);
		final Spinner fila2 = (Spinner) findViewById(R.id.fila2);
		final Spinner fila3 = (Spinner) findViewById(R.id.fila3);
		final CheckBox checkboxModoMiseria = (CheckBox) findViewById(R.id.modo_miseria);

		final String rival = editRival.getText().toString();
		final String txtFila1 = fila1.getSelectedItem().toString();
		final String txtFila2 = fila2.getSelectedItem().toString();
		final String txtFila3 = fila3.getSelectedItem().toString();
		final boolean modoMiseria = checkboxModoMiseria.isChecked();

		final TipoPartida tipoPartida = new TipoPartida(rival, txtFila1, txtFila2,
				txtFila3, modoMiseria);

		SharedPreferences.Editor preferencias = getSharedPreferences("preferencias", MODE_PRIVATE).edit();

		preferencias.putString(FILA1,txtFila1);
		preferencias.putString(FILA2,txtFila2);
		preferencias.putString(FILA3,txtFila3);
		preferencias.putBoolean(MODO_MISERIA,modoMiseria);
		preferencias.commit();
		
		switch (v.getId()) {
		case R.id.boton_grabar_configuracion:
			final Intent intent = new Intent();
			intent.putExtra(TIPO_PARTIDA, tipoPartida);
			setResult(RESULT_OK, intent);
			finish();
		}

	}

	private int getPosicionSeleccionada(String filaPreferencia)
	{
		int posFila=0;
		for (int i=0;i<Fila.getTodasFilas().length;i++)
		{
			if(Fila.getTodasFilas()[i].toString().equals(filaPreferencia))
			{
				posFila = i;
				break;
			}
		}

		return posFila;
	}
}
