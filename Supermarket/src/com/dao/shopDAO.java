package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.viow.Product;

public class shopDAO {
	public List<Product> findAll() {
		String sql = "select * from shop";
		ResultSet rs = DBUtil.executeQuery(sql);
		List<Product> modelList = new ArrayList<Product>();
		Product model = null;
		try {
			while(rs.next()) {
				model = new Product(
						rs.getInt("id"),
						rs.getString("number"),
						rs.getString("name"),
						rs.getDouble("price"),
						rs.getString("date"),
						rs.getInt("state")
					);
				modelList.add(model);
			}
			DBUtil.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
	public int insert(Product model) {
		String sql = "insert into shop(number,name,price,date) values(?,?,?,?) ";
		Object[] in = {model.getNumber(),model.getName(),model.getPrice(),model.getDate()};
		return DBUtil.executeUpdate(sql, in);
	}
	public int update(Product model) {
		String sql = "update shop set number=?,name=?,price=?,[date] =? where id=? ";
		Object[] in = {model.getNumber(),model.getName(),model.getPrice(),model.getDate(),model.getId()};
		return DBUtil.executeUpdate(sql, in);
	}
	public int delete(int id) {
		String sql = "delete from shop where id=? ";
		Object[] in = {id};
		return DBUtil.executeUpdate(sql, in);
	}
}
