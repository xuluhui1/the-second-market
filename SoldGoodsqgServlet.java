package com.second_hand.demo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.second_hand.dao.GoodsqgDao;
import com.second_hand.dao.impl.GoodsqgDaoImpl;

import com.second_hand.wrapperClass.MySoldGoodsFList;

/**
 * Servlet implementation class SoldGoodsqgServlet
 */
public class SoldGoodsqgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SoldGoodsqgServlet() {
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
		if("showSoldGoodsqg_1List".equals(method)) {
			GoodsqgDao goodsqgDao=new GoodsqgDaoImpl();
			List<MySoldGoodsFList> list=goodsqgDao.selectGoodsqgDiffer("-1");
			request.setAttribute("goodsqgFInfoAll", list);
			request.getRequestDispatcher("showSoldGoodsqg_1List.jsp").forward(request, response);
		}else if("showSoldGoodsqg0List".equals(method)) {
			GoodsqgDao goodsqgDao=new GoodsqgDaoImpl();
			List<MySoldGoodsFList> list=goodsqgDao.selectGoodsqgDiffer("0");
			request.setAttribute("goodsqgFInfoAll", list);
			request.getRequestDispatcher("showSoldGoodsqg0List.jsp").forward(request, response);
		}else if("showSoldGoodsqg1List".equals(method)) {
			GoodsqgDao goodsqgDao=new GoodsqgDaoImpl();
			List<MySoldGoodsFList> list=goodsqgDao.selectGoodsqgDiffer("1");
			request.setAttribute("goodsqgFInfoAll", list);
			request.getRequestDispatcher("showSoldGoodsqg1List.jsp").forward(request, response);
		}else if("showSoldGoodsqg5List".equals(method)) {
			GoodsqgDao goodsqgDao=new GoodsqgDaoImpl();
			List<MySoldGoodsFList> list=goodsqgDao.selectGoodsqgDiffer("5");
			request.setAttribute("goodsqgFInfoAll", list);
			request.getRequestDispatcher("showSoldGoodsqg5List.jsp").forward(request, response);
		}else if("showSoldGoodsqg2List".equals(method)) {
			GoodsqgDao goodsqgDao=new GoodsqgDaoImpl();
			List<MySoldGoodsFList> list=goodsqgDao.selectGoodsqgDiffer("2");
			request.setAttribute("goodsqgFInfoAll", list);
			request.getRequestDispatcher("showSoldGoodsqg2List.jsp").forward(request, response);
		}else if("showSoldGoodsqg3List".equals(method)) {
			GoodsqgDao goodsqgDao=new GoodsqgDaoImpl();
			List<MySoldGoodsFList> list=goodsqgDao.selectGoodsqgDiffer("3");
			request.setAttribute("goodsqgFInfoAll", list);
			request.getRequestDispatcher("showSoldGoodsqg3List.jsp").forward(request, response);
		}else if("showSoldGoodsqg4List".equals(method)) {
			GoodsqgDao goodsqgDao=new GoodsqgDaoImpl();
			List<MySoldGoodsFList> list=goodsqgDao.selectGoodsqgDiffer("4");
			request.setAttribute("goodsqgFInfoAll", list);
			request.getRequestDispatcher("showSoldGoodsqg4List.jsp").forward(request, response);
		}else if("delete-1".equals(method)) {
			String goodsqgid=request.getParameter("id");
			GoodsqgDao goodsqgDao=new GoodsqgDaoImpl();
			goodsqgDao.removeGoodsqgById(Integer.parseInt(goodsqgid));
			
			List<MySoldGoodsFList> list=goodsqgDao.selectGoodsqgDiffer("-1");
			request.setAttribute("goodszrFInfoAll", list);
			request.getRequestDispatcher("showSoldGoodsqg_1List.jsp").forward(request, response);
		}else if("delete0".equals(method)) {
			String goodsqgid=request.getParameter("id");
			GoodsqgDao goodsqgDao=new GoodsqgDaoImpl();
			goodsqgDao.removeGoodsqgById(Integer.parseInt(goodsqgid));
			
			List<MySoldGoodsFList> list=goodsqgDao.selectGoodsqgDiffer("0");
			request.setAttribute("goodszrFInfoAll", list);
			request.getRequestDispatcher("showSoldGoodsqg0List.jsp").forward(request, response);
		}else if("delete1".equals(method)) {
			String goodsqgid=request.getParameter("id");
			GoodsqgDao goodsqgDao=new GoodsqgDaoImpl();
			goodsqgDao.removeGoodsqgById(Integer.parseInt(goodsqgid));
			
			List<MySoldGoodsFList> list=goodsqgDao.selectGoodsqgDiffer("1");
			request.setAttribute("goodszrFInfoAll", list);
			request.getRequestDispatcher("showSoldGoodsqg1List.jsp").forward(request, response);
		}else if("delete2".equals(method)) {
			String goodsqgid=request.getParameter("id");
			GoodsqgDao goodsqgDao=new GoodsqgDaoImpl();
			goodsqgDao.removeGoodsqgById(Integer.parseInt(goodsqgid));
			
			List<MySoldGoodsFList> list=goodsqgDao.selectGoodsqgDiffer("2");
			request.setAttribute("goodszrFInfoAll", list);
			request.getRequestDispatcher("showSoldGoodsqg2List.jsp").forward(request, response);
		}else if("delete3".equals(method)) {
			String goodsqgid=request.getParameter("id");
			GoodsqgDao goodsqgDao=new GoodsqgDaoImpl();
			goodsqgDao.removeGoodsqgById(Integer.parseInt(goodsqgid));
			
			List<MySoldGoodsFList> list=goodsqgDao.selectGoodsqgDiffer("3");
			request.setAttribute("goodszrFInfoAll", list);
			request.getRequestDispatcher("showSoldGoodsqg3List.jsp").forward(request, response);
		}else if("delete4".equals(method)) {
			String goodsqgid=request.getParameter("id");
			GoodsqgDao goodsqgDao=new GoodsqgDaoImpl();
			goodsqgDao.removeGoodsqgById(Integer.parseInt(goodsqgid));
			
			List<MySoldGoodsFList> list=goodsqgDao.selectGoodsqgDiffer("4");
			request.setAttribute("goodsqgInfoAll", list);
			request.getRequestDispatcher("showSoldGoodsqg4List.jsp").forward(request, response);
		}else if("delete5".equals(method)) {
			String goodsqgid=request.getParameter("id");
			GoodsqgDao goodsqgDao=new GoodsqgDaoImpl();
			goodsqgDao.removeGoodsqgById(Integer.parseInt(goodsqgid));
			
			List<MySoldGoodsFList> list=goodsqgDao.selectGoodsqgDiffer("5");
			request.setAttribute("goodsqgInfoAll", list);
			request.getRequestDispatcher("showSoldGoodsqg5List.jsp").forward(request, response);
		}else if("statuUpdate".equals(method)){
			GoodsqgDao goodsqgDao=new GoodsqgDaoImpl();
			String goodsqgid=request.getParameter("id");
			goodsqgDao.updateFStatusDiffer(Integer.parseInt(goodsqgid),"3");
			
			List<MySoldGoodsFList> list=goodsqgDao.selectGoodsqgDiffer("2");
			request.setAttribute("goodsqgInfoAll", list);
			
			request.getRequestDispatcher("showSoldGoodsqg2List.jsp").forward(request, response);
		}
	}

}
