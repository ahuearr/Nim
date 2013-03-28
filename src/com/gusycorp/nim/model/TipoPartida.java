package com.gusycorp.nim.model;

import java.io.Serializable;

import com.parse.ParseObject;

public class TipoPartida implements Serializable {

	private static final long serialVersionUID = 1L;

	private int gameId;
	private String username1;
	private String username2;
	private int oponentType;
	private String row1Initial;
	private String row2Initial;
	private String row3Initial;
	private boolean miseryMode;
	private String row1;
	private String row2;
	private String row3;
	private String usernameWinner;
	private String usernamePlaying;

	public TipoPartida(final int gameId, final String username1, final String username2, final int oponentType,
			final String row1Initial,
			final String row2Initial, final String row3Initial, final boolean miseryMode, final String row1,
			final String row2, final String row3, final String usernameWinner, final String usernamePlaying) {
		this.setGameId(gameId);
		this.setUsername1(username1);
		this.setUsername2(username2);
		this.setOponentType(oponentType);
		this.setRow1Initial(row1Initial);
		this.setRow2Initial(row2Initial);
		this.setRow3Initial(row3Initial);
		this.setMiseryMode(miseryMode);
		this.setRow1(row1);
		this.setRow2(row2);
		this.setRow3(row3);
		this.setUsernameWinner(usernameWinner);
		this.setUsernamePlaying(usernamePlaying);
	}

	public TipoPartida(final String username2, final String row1Initial,
			final String row2Initial, final String row3Initial, final boolean miseryGame) {
		this.setUsername2(username2);
		this.setRow1Initial(row1Initial);
		this.setRow2Initial(row2Initial);
		this.setRow3Initial(row3Initial);
		this.setMiseryMode(miseryGame);
	}

	public String getUsername2() {
		return username2;
	}

	public void setUsername2(final String username2) {
		this.username2 = username2;
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

	public boolean isMiseryMode() {
		return miseryMode;
	}

	public void setMiseryMode(final boolean miseryMode) {
		this.miseryMode = miseryMode;
	}

	public String getUsername1() {
		return username1;
	}

	public void setUsername1(String username1) {
		this.username1 = username1;
	}

	public String getRow1Initial() {
		return row1Initial;
	}

	public void setRow1Initial(String row1Initial) {
		this.row1Initial = row1Initial;
	}

	public String getRow2Initial() {
		return row2Initial;
	}

	public void setRow2Initial(String row2Initial) {
		this.row2Initial = row2Initial;
	}

	public String getRow3Initial() {
		return row3Initial;
	}

	public void setRow3Initial(String row3Initial) {
		this.row3Initial = row3Initial;
	}

	public String getUsernameWinner() {
		return usernameWinner;
	}

	public void setUsernameWinner(String usernameWinner) {
		this.usernameWinner = usernameWinner;
	}

	public String getUsernamePlaying() {
		return usernamePlaying;
	}

	public void setUsernamePlaying(String usernamePlaying) {
		this.usernamePlaying = usernamePlaying;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public ParseObject guardarPartida()
	{
		ParseObject partida = new ParseObject("Partida");
		partida.put("gameid", this.gameId);
		partida.put("misery_mode", this.miseryMode);
		partida.put("oponent_type", this.oponentType);
		partida.put("row1", this.row1);
		partida.put("row1_initial", this.row1Initial);
		partida.put("row2", this.row2);
		partida.put("row2_initial", this.row2Initial);
		partida.put("row3", this.row3);
		partida.put("row3_initial", this.row3Initial);
		partida.put("username1", this.username1);
		partida.put("username2", this.username2);
		partida.put("username_playing", this.usernamePlaying);
		partida.put("username_winner", this.usernameWinner);

		return partida;
	}

	public int getOponentType() {
		return oponentType;
	}

	public void setOponentType(int oponentType) {
		this.oponentType = oponentType;
	}
}
