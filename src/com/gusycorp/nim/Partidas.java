package com.gusycorp.nim;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Partidas extends ListActivity implements OnClickListener {

	private final List<TipoPartida> partidas = new ArrayList<TipoPartida>();
	private TipoPartidaAdapter adapter;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.partidas);

		final Button nuevaPartida = (Button) findViewById(R.id.boton_nueva_partida);
		nuevaPartida.setOnClickListener(this);

		adapter = new TipoPartidaAdapter(this, R.layout.row_partida, partidas);
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		getMenuInflater().inflate(R.menu.partidas, menu);
		return true;
	}

	@Override
	public void onClick(final View v) {
		switch (v.getId()) {
		case R.id.boton_nueva_partida:
			startActivityForResult(
					new Intent(this, ConfiguracionPartida.class), 1);
		}
	}

	@Override
	protected void onActivityResult(final int requestCode,
			final int resultCode, final Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		switch (resultCode) {
		case RESULT_OK:
			partidas.add((TipoPartida) data
					.getSerializableExtra(ConfiguracionPartida.TIPO_PARTIDA));
			adapter.notifyDataSetChanged();
		}
	}
}
