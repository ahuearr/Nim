package com.gusycorp.nim.model;

import java.io.Serializable;

public class TipoPartida implements Serializable {

	private static final long serialVersionUID = 1L;

	private String oponent;
	private String row1;
	private String row2;
	private String row3;
	private boolean misereGame;

	public TipoPartida(final String oponent, final String row1,
			final String row2, final String row3, final boolean misereGame) {
		this.setOponent(oponent);
		this.setRow1(row1);
		this.setRow2(row2);
		this.setRow3(row3);
		this.setMisereGame(misereGame);
	}

	public String getOponent() {
		return oponent;
	}

	public void setOponent(final String oponent) {
		this.oponent = oponent;
	}

	public String getRow1() {
		return row1;
	}

	public void setRow1(final String row1) {
		this.row1 = row1;
	}

	public String getRow2() {
		return row2;
	}

	public void setRow2(final String row2) {
		this.row2 = row2;
	}

	public String getRow3() {
		return row3;
	}

	public void setRow3(final String row3) {
		this.row3 = row3;
	}

	public boolean isMisereGame() {
		return misereGame;
	}

	public void setMisereGame(final boolean misereGame) {
		this.misereGame = misereGame;
	}

}
