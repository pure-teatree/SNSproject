package model.member;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import util.PublicCommon;

public class MemberDAO {
	public static boolean joinMember(Member member) throws SQLException {
		EntityManager em = PublicCommon.getManager();
		EntityTransaction tx = em.getTransaction();
		boolean result = false;
		tx.begin();

		try {
			em.persist(member);
			tx.commit();
			result = true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return result;
	}

	public static Member getMember(String id) throws SQLException {
		EntityManager em = PublicCommon.getManager();
		Member member = null;

		try {
			member = em.find(Member.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return member;
	}

	public static boolean updateMember(Member newMember) throws SQLException {
		EntityManager em = PublicCommon.getManager();
		EntityTransaction tx = em.getTransaction();
		boolean result = false;
		tx.begin();

		try {
			Member member = em.find(Member.class, newMember.getId());

			member.setName(newMember.getName());
			member.setPassword(newMember.getPassword());
			member.setInfo(newMember.getInfo());

			tx.commit();
			result = true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return result;
	}

	public static boolean deleteMember(String id, String password) throws SQLException {
		EntityManager em = PublicCommon.getManager();
		EntityTransaction tx = em.getTransaction();
		boolean result = false;
		tx.begin();

		try {
			Member member = em.find(Member.class, id);
			if (member.getPassword().equals(password)) {
				em.remove(member);
				result = true;
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return result;
	}

}
