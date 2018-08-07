package com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.shopBO;
import com.viow.Product;

/**
 * Servlet implementation class shopServlet
 */
@WebServlet("/shopServlet")
public class shopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		shopBO bo = new shopBO();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		
        String action = request.getParameter("action");

        if (action.equals("list")) {
  		  //获得所有用户
        	
        	String result="[";
    		String link = "";
            for (Product pro : bo.findAll()) {
                result+=link+"{\"id\":"+pro.getId()+",\"number\":\""+pro.getNumber()+"\",\"name\":\""+pro.getName()+"\",\"price\":\""+pro.getPrice()+"\",\"time\":\""+pro.getDate()+"\",\"state\":\""+pro.getState()+"\"}";
                link=",";
            }
            result+="]";
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            response.getWriter().print(result);
        }else if (action.equals("add")) {
        	String number = request.getParameter("number");
        	String name = request.getParameter("name");
        	double price = Double.parseDouble(request.getParameter("price"));
        	String time = request.getParameter("time");
			int count = bo.insert(new Product(number,name,price,time));
			if(count >0){
				response.getWriter().print("{\"msg\":\"添加成功\"}");
			}
        }else if (action.equals("del")) {
        	int id = Integer.parseInt(request.getParameter("id"));
        	int count = bo.delete(id);
			if(count >0){
				response.getWriter().print("{\"msg\":\"删除成功\"}");
			}
        }else if (action.equals("update")) {
        	String number = request.getParameter("number");
        	String name = request.getParameter("name");
        	double price = Double.parseDouble(request.getParameter("price"));
        	String time = request.getParameter("time");
        	int id = Integer.parseInt(request.getParameter("id"));
			int count = bo.update(new Product(id,number,name,price,time,1));
			if(count >0){
				response.getWriter().print("{\"msg\":\"修改成功\"}");
			}
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
