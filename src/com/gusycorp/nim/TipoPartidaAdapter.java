package com.gusycorp.nim;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class TipoPartidaAdapter extends ArrayAdapter<TipoPartida> {

	public TipoPartidaAdapter(final Partidas context,
			final int resource, final List<TipoPartida> tipoPartidas) {
		super(context, resource, tipoPartidas);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			LayoutInflater vi = (LayoutInflater) getContext().getSystemService(
					Context.LAYOUT_INFLATER_SERVICE);
			convertView = vi.inflate(R.layout.row_partida, null);
		}

		TipoPartida tipoPartida = getItem(position);
		TextView oponente = (TextView) convertView.findViewById(R.id.nombre_rival);
		oponente.setText(tipoPartida.getOponent());
		TextView row1 = (TextView) convertView.findViewById(R.id.row1);
		row1.setText(tipoPartida.getRow1());
		TextView row2 = (TextView) convertView.findViewById(R.id.row2);
		row2.setText(tipoPartida.getRow2());
		TextView row3 = (TextView) convertView.findViewById(R.id.row3);
		row3.setText(tipoPartida.getRow3());
		CheckBox modoMiseria = (CheckBox) convertView.findViewById(R.id.modo_miseria);
		modoMiseria.setChecked(tipoPartida.isMisereGame());
		return convertView;
	}
}
