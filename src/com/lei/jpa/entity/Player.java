package com.lei.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="player")
@SequenceGenerator(name="player", sequenceName="sq_player", allocationSize=1)
public class Player 
{
	@Id
	@GeneratedValue(generator="player", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_username")
	private int id;
	
	@Column(name="ds_username", nullable=false, length=20)
	private String username;
	
	@Column(name="ds_password", nullable=false, length=50)
	private String password;
	
	@Column(name="ds_nickname", nullable=false, length=10)
	private String nickname;
	
	@Column(name="ds_email", nullable=false, length=50)
	private String email;
	
	@Column(name="dt_birthday", nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar birthday;
	
	@Column(name="dt_created", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar created;
	
	@Column(name="qt_wins", nullable=false)
	private int wins;
	
	@Column(name="qt_loses", nullable=false)
	private int loses;
	
	@Column(name="qt_tie", nullable=false)
	private int tie;
	
	@Column(name="ds_function")
	@Enumerated(EnumType.STRING)
	private PlayerFunction function;

	public Player() {}
	
	public Player(String username, String password, String nickname, String email, Calendar birthday,
			Calendar created, int wins, int loses, int tie, PlayerFunction function) 
	{
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
		this.birthday = birthday;
		this.created = created;
		this.wins = wins;
		this.loses = loses;
		this.tie = tie;
		this.function = function;
	}



	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public Calendar getBirthday() 
	{
		return birthday;
	}

	public void setBirthday(Calendar birthday) 
	{
		this.birthday = birthday;
	}

	public String getNickname() 
	{
		return nickname;
	}

	public void setNickname(String nickname) 
	{
		this.nickname = nickname;
	}

	public int getWins() 
	{
		return wins;
	}

	public void setWins(int wins) 
	{
		this.wins = wins;
	}

	public int getLoses() 
	{
		return loses;
	}

	public void setLoses(int loses) 
	{
		this.loses = loses;
	}

	public int getTie() 
	{
		return tie;
	}

	public void setTie(int tie) 
	{
		this.tie = tie;
	}

	public PlayerFunction getFunction() {
		return function;
	}

	public void setFunction(PlayerFunction function) {
		this.function = function;
	}
	
	
	
}
