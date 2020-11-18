
package model.feed;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.member.Member;
import util.PublicCommon;

public class FeedDAO {
	public static boolean writeFeed(Feed fed) throws SQLException {
		EntityManager em = PublicCommon.getManager();
		EntityTransaction tx = em.getTransaction();
		Member member = fed.getMemberId();
		tx.begin();
		try {
			em.persist(fed);
			member.getFeeds().add(fed);
			tx.commit();
		} catch (IllegalArgumentException e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}

		return true;
	}

	//한 개 글
	public static Feed getFeed(int fno) throws SQLException {
		EntityManager em = PublicCommon.getManager();
		EntityTransaction tx = em.getTransaction();
		Feed cmt = null;
		tx.begin();
		try {
			cmt = em.find(Feed.class, fno);
			tx.commit();
		} catch (IllegalArgumentException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return cmt;
	}

	public static boolean deleteFeed(int fno) throws SQLException {
		EntityManager em = PublicCommon.getManager();
		EntityTransaction tx = em.getTransaction();
		boolean result = false;
		tx.begin();
		try {
			Feed cmt = em.find(Feed.class, fno);
			cmt.getMemberId().getFeeds().remove(cmt);
			tx.commit();
		} catch (IllegalArgumentException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return result;
	}

	public static boolean updateFeed(Feed fed) throws SQLException {
		EntityManager em = PublicCommon.getManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			Feed cmt = em.find(Feed.class, fed.getFno());
			cmt.setContent(fed.getContent());
			cmt.setWriteday(new Date());
			tx.commit();
		} catch (IllegalArgumentException e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
		return true;
	}
	

	public static Feed getContent(int fno) throws SQLException{
		EntityManager em = PublicCommon.getManager();
		Feed cmt = null;
		try {
			cmt = em.find(Feed.class,fno);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return cmt;
	}
	
	public static ArrayList<Feed> getAllFeed() throws SQLException {
		EntityManager em = PublicCommon.getManager();
		try {
			return (ArrayList<Feed>) em.createNamedQuery("Feed.allList").getResultList();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();		
		} finally {
			em.close();
		}
		
		return null;
		}
	
	 public static Feed updateLike(int feedNo, boolean thumbUp) throws SQLException{            
	      EntityManager em = PublicCommon.getManager();
	      EntityTransaction tx = em.getTransaction();
	      Feed nLike = null;
	      tx.begin();
	      
	      try {
	         nLike = em.find(Feed.class, feedNo);
	         
	         if(thumbUp){
	            nLike.setThumbUp(nLike.getThumbUp()+1);
	         }
	         tx.commit();
	      } catch (IllegalArgumentException e) {
	         tx.rollback();
	         e.printStackTrace();   
	      } finally {
	         em.close();
	      }
	      
	      return nLike;
	   }
	
}