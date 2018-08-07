package com.viow;

public class Product {
	
	private int id;//id
	private String number;//���
	private String name;//����
	private double price;//�۸�
	private String date;//�ϼ�ʱ��
	private int state;//״̬
	
	public Product(){}

	public Product(int id, String number, String name, double price, String date, int state) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.price = price;
		this.date = date;
		this.state = state;
	}

	public Product(String number, String name, double price, String date) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	
}
