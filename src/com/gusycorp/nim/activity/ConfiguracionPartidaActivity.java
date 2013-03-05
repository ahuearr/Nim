package com.gusycorp.nim.activity;

import com.gusycorp.nim.R;
import com.gusycorp.nim.R.id;
import com.gusycorp.nim.R.layout;
import com.gusycorp.nim.model.TipoPartida;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class ConfiguracionPartidaActivity extends Activity implements OnClickListener {

	public static final String TIPO_PARTIDA = "TipoPartida";

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.configuracion_partida);

		final Button grabarConfiguracion = (Button) findViewById(R.id.boton_grabar_configuracion);
		grabarConfiguracion.setOnClickListener(this);
	}

	@Override
	public void onClick(final View v) {

		final EditText editRival = (EditText) findViewById(R.id.nombre_rival);
		final String rival = editRival.getText().toString();
		final EditText txtFila1 = (EditText) findViewById(R.id.fila1);
		final String fila1 = txtFila1.getText().toString();
		final EditText txtFila2 = (EditText) findViewById(R.id.fila2);
		final String fila2 = txtFila2.getText().toString();
		final EditText txtFila3 = (EditText) findViewById(R.id.fila3);
		final String fila3 = txtFila3.getText().toString();
		final CheckBox checkboxModoMiseria = (CheckBox) findViewById(R.id.modo_miseria);
		final boolean modoMiseria = checkboxModoMiseria.isChecked();

		final TipoPartida tipoPartida = new TipoPartida(rival, fila1, fila2,
				fila3, modoMiseria);

		switch (v.getId()) {
		case R.id.boton_grabar_configuracion:
			final Intent intent = new Intent();
			intent.putExtra(TIPO_PARTIDA, tipoPartida);
			setResult(RESULT_OK, intent);
			finish();
		}

	}

}
