package com.second_hand.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.second_hand.dao.BbsDao;
import com.second_hand.dao.SearchDao;
import com.second_hand.dao.impl.BbsDaoImpl;
import com.second_hand.dao.impl.SearchDaoImpl;
import com.second_hand.model.Bbs;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		if("search".equals(method)){
			SearchDao searchDao=new SearchDaoImpl();
			BbsDao bbsDao=new BbsDaoImpl();
			String keyword=request.getParameter("keyword");
			List<Bbs> list=null;
			if(keyword!="") {
				list=searchDao.SearchBbsString(keyword);
			}else
			{
				list=bbsDao.selectBbs();
			}
			request.setAttribute("bbsInfoAll", list);
			request.getRequestDispatcher("/jsp/bbsmanage.jsp").forward(request, response);
		}else if("show".equals(method)) {
			BbsDao bbsDao=new BbsDaoImpl();
			List<Bbs> list=bbsDao.selectBbs();
			request.setAttribute("bbsInfoAll", list);
			request.getRequestDispatcher("/jsp/bbsmanage.jsp").forward(request, response);
		}else if("delete".equals(method)){
			String id= request.getParameter("id");
	    	System.out.println("delete id value:"+id);
	    	BbsDao bbsDao= new  BbsDaoImpl();
	    	bbsDao.removeBbsById(Integer.parseInt(id));
	    	 
	 		List<Bbs> list= bbsDao.selectBbs();
	 		request.setAttribute("bbsInfoAll", list);
	    	request.getRequestDispatcher("/jsp/bbsmanage.jsp").forward(request, response);
		}
	}


}
