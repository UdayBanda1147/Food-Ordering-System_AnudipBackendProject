package com.foodEntity;



import java.util.*;

import javax.persistence.*;


@Entity
@Table(name = "Food")
public class Food{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "foodID")
	private int foodID;

	@Column(name = "foodName")
	private String foodName;

	@Column(name = "foodPrice")
	private double foodPrice;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Food_Orders",
	joinColumns={@JoinColumn(name="FoodID")},
	inverseJoinColumns= {@JoinColumn(name="OrderID")}
	)
	private List<Orders> orderObj =new ArrayList<Orders>();

	
	public List<Orders> getOrderObj() {
		return orderObj;
	}
	public void setOrderObj(List<Orders> orderObj) {
		this.orderObj = orderObj;
	}
	public Food(int foodID,String foodName,double foodPrice) {
		this.foodID = foodID;
		this.foodName = foodName;
		this.foodPrice= foodPrice;

	}
	public Food() {

	}


	public int getFoodID() {
		return foodID;
	}



	public void setFoodID(int foodID) {
		this.foodID = foodID;
	}



	public String getFoodName() {
		return foodName;
	}



	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}



	public double getFoodPrice() {
		return foodPrice;
	}



	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

	@Override
	public String toString() {
		return "FoodItem {" +
				"foodID='" + foodID + '\'' +
				", foodName='" + foodName +
				", foodPrice='" + foodPrice + '\'' +
				'}';
	}
}