package util;

import java.sql.Clob;

import org.hibernate.LobHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Util {
	
	SessionFactory sessionFactory;
	
	
	
		public Util() {
	}


		public Util(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


		public Clob getClob(String s){
			Session session = sessionFactory.openSession();
			LobHelper helper = session.getLobHelper();
			Clob clob = helper.createClob(s);
			sessionFactory.close();
			session.close();
			return clob;
		}


		public SessionFactory getSessionFactory() {
			return sessionFactory;
		}


		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

	
}
