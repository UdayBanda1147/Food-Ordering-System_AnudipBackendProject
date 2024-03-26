package com.foodDao;

import java.util.List;

import javax.persistence.*;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.foodEntity.Customer;
import com.foodEntity.Orders;
import org.hibernate.query.*;


public class CustomerDao {
	private Session session;
	public CustomerDao(Session session) {
		this.session=session;
	}

	public void insert(Customer cObj) {
		
		try {
			Transaction tx = session.beginTransaction();
			session.save(cObj);
			tx.commit();

			//System.out.println(cObj);
			System.out.println("----------| SUCCESSFULLY ACCOUNT WAS CREATED |---------");		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(int customerID, String customerName, String customerEmail, String customerPassword,String customerAddress, String customerPhone) {

		try {
			Customer customerid = session.find(Customer.class, customerID);
			if (customerid == null)
				System.out.print("Detail not found");
			else {
				customerid.setCustomerName(customerName);
				customerid.setCustomerEmail(customerEmail);
				customerid.setCustomerPassword(customerPassword);
				customerid.setCustomerAddress(customerAddress);
				customerid.setCustomerPhone(customerPhone);
				Transaction tx = session.beginTransaction();
				session.merge(customerid);
				tx.commit();
				System.out.println(customerid);
				System.out.println(" Detail updated into CustomerTable");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public Orders getTotal(Query customerID) {
		Orders total;
		try {
			 total = (Orders) session.createQuery("from sun(amount) from Orders where customerID=:customerID ",Orders.class);
				
		}catch(Exception e) {
			return (Orders) null;
		}
		return total;
		
	}
	
	
	public Query getCustomerID(Customer customer) {
		try {
			
			 customer = (Customer) session.createQuery("from Customer where customerID =:customerID",Customer.class);
			return (Query) customer;
			
		}catch(NoResultException e) {
			return null;
		}
		
	}
	
	
	 public Customer getCustomerByEmailAndPassword(String customerName, String customerPassword) {
	        try {
	            Customer customer = session.createQuery("from Customer where customerName = :customerName and customerPassword = :customerPassword", Customer.class)
	                    .setParameter("customerName", customerName)
	                    .setParameter("customerPassword", customerPassword)
	                    .getSingleResult();

	            return customer;

	        } catch (NoResultException e) {
	            // Handle case where no customer is found
	            return null;
	        }
	    }
	 
	 public List<Customer> select() {
			
			Transaction tx = session.beginTransaction();
			Query qobj = session.createQuery("select cObj from Customer cObj");
			@SuppressWarnings("unchecked")
			List<Customer> list = (List<Customer>) qobj.getResultList();
			tx.commit();
			return list;
		}
}
