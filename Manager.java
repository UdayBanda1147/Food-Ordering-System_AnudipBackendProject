package com.foodEntity;


import java.util.List;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Table(name = "Manager")
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int managerID;

	private String managerName;

	private String managerEmail;

	private String managerPWD;

	private String managerPhone;
	

	public Manager(int managerID,String managerName,String managerEmail, String managerPWD, String managerPhone) {
		this.managerID = managerID;
		this.managerName = managerName;
		this.managerEmail = managerEmail;
		this.managerPWD = managerPWD;
		this.managerPhone = managerPhone;
	}
	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public String getManagerPWD() {
		return managerPWD;
	}

	public void setManagerPWD(String managerPWD) {
		this.managerPWD = managerPWD;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	@Override
	public String toString() {
		return "Manager{" +
				"managerID='" + managerID + '\'' +
				", managerName='" + managerName +
				", managerEmail='" + managerEmail + '\'' +
				", managerPWD ='" +managerPWD + '\'' +
				", managerPhone='" + managerPhone + '\'' +
				'}';
	}
}