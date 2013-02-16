package com.gusycorp.nim;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class Partidas extends ListActivity implements OnClickListener{

	private final List<String> partidas = new ArrayList<String>();
	private ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.partidas);
		
		Button btNuevaPartida = (Button) findViewById(R.id.boton_nueva_partida);
		btNuevaPartida.setOnClickListener(this);

		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, partidas);
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.partidas, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		switch(v.getId())
		{
		case R.id.boton_nueva_partida:
			intent.setClass(this, ConfiguracionPartida.class);
			startActivityForResult(intent, 1);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		switch(resultCode)
		{
		case RESULT_OK:
			partidas.add(data.getStringExtra("Rival"));
			adapter.notifyDataSetChanged();
		}
	}
}
