package com.gusycorp.nim.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Application;

import com.gusycorp.nim.model.TipoPartida;

public class Nim extends Application {

	private static final String TAG = "NIM";
	private final List<TipoPartida> partidas = new ArrayList<TipoPartida>();
	private String usernameLogin = "";

	public List<TipoPartida> getTipoPartida()
	{
		return partidas;
	}

	public String getUsernameLogin() {
		return usernameLogin;
	}

	public void setUsernameLogin(String usernameLogin) {
		this.usernameLogin = usernameLogin;
	}
}
