package com.second_hand.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.second_hand.dao.AdministratorDao;
import com.second_hand.dao.impl.AdministratorDaoImpl;
import com.second_hand.model.Administrator;

/**
 * Servlet implementation class LoginServlet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String ausername=request.getParameter("name");
		String apassword=request.getParameter("password");
		Administrator admin=new Administrator();
		admin.setAusername(ausername);
		admin.setApassword(apassword);
		AdministratorDao adminDao=new AdministratorDaoImpl();
		Administrator resultAdmin=adminDao.login(admin);
		if(resultAdmin!=null) {
			session.setAttribute("admin", resultAdmin);
			request.getRequestDispatcher("/jsp/here.jsp").forward(request, response);
		}else {
			request.setAttribute("message", 0);
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}
	}

}
