package com.lei.jpa.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.lei.jpa.dao.impl.PlayerDAOImpl;
import com.lei.jpa.entity.Player;
import com.lei.jpa.entity.PlayerFunction;
import com.lei.jpa.singleton.EntityManagerFactorySingleton;

public class GenericDAORegister 
{
	public static void main(String[] args)
	{
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager manager = factory.createEntityManager();
		/*Scanner scan = new Scanner(System.in);
		System.out.println("Type your desired username: ");
		String username = scan.next();
		System.out.println("Type your desired password: ");
		String password = scan.next();
		System.out.println("Type your desired nickname: ");
		String nickname = scan.next();
		System.out.println("Type your personal email: ");
		String email = scan.next();
		System.out.println("Type your birthday date: ");
		String birthday = scan.next();*/
		Player p = new Player("Alpha", "kernel", "Alpha", "alpha@hashworld.com", 
				new GregorianCalendar(1999, Calendar.FEBRUARY, 21), Calendar.getInstance()
				, 1, 1, 1, PlayerFunction.DEVELOPER);
		PlayerDAOImpl dao = new PlayerDAOImpl(manager);
		try
		{
			dao.register(p);
			dao.commit();
			System.out.println("You're successfully registred. Enjoy the game!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		/*try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(sdf.parse("1999-02-21"));
			PlayerDAOImpl dao = new PlayerDAOImpl(manager);
			//Player p = new Player(username, password, nickname, email, cal, Calendar.getInstance()
					//
			Player p = new Player("Alpha", "kernel", "Alpha", "alpha@hashworld.com", 
					new GregorianCalendar(1999, Calendar.FEBRUARY, 21), Calendar.getInstance()
					, 0, 0, 0, PlayerFunction.DEVELOPER);
			try
			{
				dao.register(p);
				dao.commit();
				System.out.println("You're successfully registred. Enjoy the game!");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		manager.close();
		factory.close();
	}
}
