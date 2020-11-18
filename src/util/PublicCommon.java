package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// jdbc의 DBUtil.java 처럼 공통 코드로만 구현
public class PublicCommon {
	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("SNSProject");
	}
	
	public static EntityManager getManager() {
		return emf.createEntityManager();
	}
	
	public static void close() {
		emf.close();
	}
}
