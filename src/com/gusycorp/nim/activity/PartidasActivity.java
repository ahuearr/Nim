package com.gusycorp.nim.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.gusycorp.nim.R;
import com.gusycorp.nim.adapter.TipoPartidaAdapter;
import com.gusycorp.nim.model.TipoPartida;

public class PartidasActivity extends ListActivity implements OnClickListener {

	private TipoPartidaAdapter adapter;
	private final String usernameLogin = "Agustin";

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.partidas);

		final Button nuevaPartida = (Button) findViewById(R.id.boton_nueva_partida);
		nuevaPartida.setOnClickListener(this);

		Nim nim = (Nim) getApplication();

		nim.setUsernameLogin(usernameLogin);

		adapter = new TipoPartidaAdapter(this, R.layout.row_partida, nim.getTipoPartida());
		setListAdapter(adapter);

		/*		Parse.initialize(this, "3835wvpH2P4Jqn5dpNkVnowm8yrQ9AG7W9x3icRV", "UJacZAQf1rJut6SyTC8PTvdTv5ogJSJNaRmTP8Mg");

		ParseObject testObject = new ParseObject("TestObject");
		testObject.put("foo", "bar");
		testObject.saveInBackground();
		 */
	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.partidas, menu);
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

	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		switch(item.getItemId())
		{
		case R.id.nueva_partida:
			Toast.makeText(this, "Pulsado nueva partida", Toast.LENGTH_SHORT).show();
			break;
		case R.id.configuracion:
			Toast.makeText(this, "Pulsado configuracion", Toast.LENGTH_SHORT).show();
			break;
		}
		return true;

	}
}
