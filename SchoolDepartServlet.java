package com.second_hand.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.second_hand.dao.DepartDao;
import com.second_hand.dao.SchoolDao;
import com.second_hand.dao.impl.DepartDaoImpl;
import com.second_hand.dao.impl.SchoolDaoImpl;
import com.second_hand.model.Depart;
import com.second_hand.model.School;

/**
 * Servlet implementation class SchoolDepartServlet
 */
public class SchoolDepartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchoolDepartServlet() {
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
		String method=request.getParameter("method");
		String schoolname=request.getParameter("schoolname");
		String departname=request.getParameter("departname");
		if("show".equals(method)) {
			SchoolDao schoolDao=new SchoolDaoImpl();
			DepartDao departDao=new DepartDaoImpl();
			List<School> slist=schoolDao.selectSchool();
			List<Depart> dlist=departDao.selectDepart();
			request.setAttribute("schoolInfoAll", slist);
			request.setAttribute("departInfoAll", dlist);
			request.getRequestDispatcher("/jsp/showSchoolDepart.jsp").forward(request, response);
		}else if("insertSchool".equals(method)) {
			SchoolDao schoolDao=new SchoolDaoImpl();
			DepartDao departDao=new DepartDaoImpl();
			School school=new School();
			school.setSchoolname(schoolname);
			int resultSchool=schoolDao.insertSchool(school);
			if(resultSchool!=0) {
				List<School> slist=schoolDao.selectSchool();
				List<Depart> dlist=departDao.selectDepart();
				request.setAttribute("schoolInfoAll", slist);
				request.setAttribute("departInfoAll", dlist);
				request.getRequestDispatcher("/jsp/showSchoolDepart.jsp").forward(request, response);
			}
		}else if("insertDepart".equals(method)) {
			SchoolDao schoolDao=new SchoolDaoImpl();
			DepartDao departDao=new DepartDaoImpl();
			Depart depart=new Depart();
			depart.setDepartname(departname);
			int resultDepart=departDao.insertDepart(depart);
			if(resultDepart!=0) {
				List<School> slist=schoolDao.selectSchool();
				List<Depart> dlist=departDao.selectDepart();
				request.setAttribute("schoolInfoAll", slist);
				request.setAttribute("departInfoAll", dlist);
				request.getRequestDispatcher("/jsp/showSchoolDepart.jsp").forward(request, response);
			}
		}
	}

}
