package com.foodDao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.foodEntity.*;


public class OrderDao {
	private Session session;
	public OrderDao(Session session) {
		this.session=session;
	}

	public void insert(Orders order) {

		try {
			Transaction tx = session.beginTransaction();
			session.save(order);
			tx.commit();

			//System.out.println(order);
			System.out.println("----| YOUR FOOD SELECTED |----");		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


//	public List<Orders> select() {
//		try {
//			Transaction tx =  null;
//			if(!session.getTransaction().isActive()) {
//				 tx = session.beginTransaction();
//			}
//			
//			Query qobj = session.createQuery("select order from Orders order");
//			@SuppressWarnings("unchecked")
//			List<Orders> list = (List<Orders>) qobj.getResultList();
//			tx.commit();
//			return list;
//		}catch(Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	
	public List<Orders> select(){
		Transaction tx = session.beginTransaction();
		Query qobj = session.createQuery("SELECT oObj FROM Orders oObj");
		@SuppressWarnings("unchecked")
		List<Orders> list = (List<Orders>) qobj.getResultList();
		tx.commit();
		
		return list;
		
	}
}
