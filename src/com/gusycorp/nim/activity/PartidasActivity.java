package com.gusycorp.nim.activity;

import java.util.ArrayList;
import java.util.List;

import com.gusycorp.nim.R;
import com.gusycorp.nim.R.id;
import com.gusycorp.nim.R.layout;
import com.gusycorp.nim.R.menu;
import com.gusycorp.nim.adapter.TipoPartidaAdapter;
import com.gusycorp.nim.model.TipoPartida;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PartidasActivity extends ListActivity implements OnClickListener {

	private TipoPartidaAdapter adapter;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.partidas);

		final Button nuevaPartida = (Button) findViewById(R.id.boton_nueva_partida);
		nuevaPartida.setOnClickListener(this);

		Nim nim = (Nim) getApplication();

		adapter = new TipoPartidaAdapter(this, R.layout.row_partida, nim.getTipoPartida());
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		MenuItem nuevaPartida = menu.add(0, 1, 0, getString(R.string.bt_nueva_partida));
		MenuItem configuracionPartida = menu.add(0, 2, 1, getString(R.string.bt_grabar_configuracion));
		return true;
	}

	@Override
	public void onClick(final View v) {
		switch (v.getId()) {
		case R.id.boton_nueva_partida:
			startActivityForResult(
					new Intent(this, ConfiguracionPartidaActivity.class), 1);
		}
	}

	@Override
	protected void onActivityResult(final int requestCode,
			final int resultCode, final Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		Nim nim = (Nim) getApplication();
		

		switch (resultCode) {
		case RESULT_OK:
			nim.getTipoPartida().add((TipoPartida) data
					.getSerializableExtra(ConfiguracionPartidaActivity.TIPO_PARTIDA));
			adapter.notifyDataSetChanged();
		}
	}
}
