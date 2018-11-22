package com.second_hand.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.second_hand.dao.UserDao;
import com.second_hand.dao.impl.UserDaoImpl;
import com.second_hand.wrapperClass.UserManage;

/**
 * Servlet implementation class UserListServlet
 */
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() {
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
		String method="show"/*request.getParameter("method")*/;
		if("show".equals(method)) {
			UserDao userDao=new UserDaoImpl();
			List<UserManage> list=userDao.selectUserList();
			request.setAttribute("userInfoAll", list);
			request.getRequestDispatcher("/jsp/table.jsp").forward(request, response);
		}
	}

}
