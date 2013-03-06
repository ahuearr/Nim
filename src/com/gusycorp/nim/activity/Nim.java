package com.gusycorp.nim.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Application;

import com.gusycorp.nim.model.TipoPartida;

public class Nim extends Application {

	private static final String TAG = "NIM";
	private final List<TipoPartida> partidas = new ArrayList<TipoPartida>();

	public List<TipoPartida> getTipoPartida() 
	{
		return partidas;
	}
}
