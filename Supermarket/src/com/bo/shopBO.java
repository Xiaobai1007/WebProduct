package com.bo;

import java.util.List;

import com.dao.shopDAO;
import com.viow.Product;

public class shopBO {
	shopDAO dao = new shopDAO();
	
	public List<Product> findAll() {
		return dao.findAll();
	}
	public int insert(Product model) {
		return dao.insert(model);
	}
	public int update(Product model) {
		return dao.update(model);
	}
	public int delete(int id) {
		return dao.delete(id);
	}
	
}
