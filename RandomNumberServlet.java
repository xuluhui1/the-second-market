package com.second_hand.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.second_hand.dao.RandomNumberDao;
import com.second_hand.dao.impl.RandomNumberDaoImpl;

/**
 * Servlet implementation class RandomNumberServlet
 */
public class RandomNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomNumberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RandomNumberDao rnDao=new RandomNumberDaoImpl();
		String rn=rnDao.getOrderIdByUUId();
		request.setAttribute("randomNumber", rn);
		request.getRequestDispatcher("RandomNumberDemo.jsp").forward(request, response);
	}

}
