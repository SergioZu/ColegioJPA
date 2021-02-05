package com.kike.colegio.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBUtils {

	private static SessionFactory sessionFactory; // las variables estáticas son las que pertenecen a la clase y no al
													// objeto.
	// Es decir, esta variable es compartida por todos los objetos que
	// se creen de esta clase

//Implantamos el patrón singleton, lo cual nos garantiza que solo haya un objeto creado de SessionFactory en nuestra app

	public static SessionFactory creadorSessionFactory() {

		if (sessionFactory == null) {
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
			} catch (Throwable ex) {
				System.err.println("Error al crear el objeto SessionFactory" + ex);
				throw new ExceptionInInitializerError(ex);
			}

		}

		return sessionFactory;
	}

	public static Connection DBConnection() {

		Context ctx = null;
		Connection connection = null;
		try {
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/colegio");
			connection = ds.getConnection();

		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;

	}

}
