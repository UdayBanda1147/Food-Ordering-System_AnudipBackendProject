package com.foodDao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.foodEntity.Food;





public class FoodDao {
private Session session;
	
	public FoodDao(Session session){
		this.session=session;
	}
	public void insert(Food fObj){
		try {
			Transaction tx = session.beginTransaction();
			session.save(fObj);
			tx.commit();

			//System.out.println(fObj);
			System.out.println("------- FOOD ADDED TO MENU --------");		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public List<Food> select(){
		Transaction tx = session.beginTransaction();
		Query qobj = session.createQuery("select fObj from Food fObj");
		@SuppressWarnings("unchecked")
		List<Food> list = (List<Food>) qobj.getResultList();
		tx.commit();
		return list;
	}

	public void search(int foodID){
		try{
			Food fObj = session.find(Food.class, foodID);
			if (fObj == null)
				System.out.print("Record not found");
			else
				System.out.println(fObj);
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	public void delete(int foodID){
		try{
			Food fObj = session.find(Food.class, foodID);
			if (fObj == null)
				System.out.print("Record not found");
			else {
				Transaction tx = session.beginTransaction();
				session.remove(fObj);
				tx.commit();
				System.out.println(fObj);
				System.out.println("----- FOOD REMOVED FROM MENU -----");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
