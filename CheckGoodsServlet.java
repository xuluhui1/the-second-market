package com.second_hand.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.second_hand.dao.GoodsqgDao;
import com.second_hand.dao.GoodszrDao;
import com.second_hand.dao.impl.GoodsqgDaoImpl;
import com.second_hand.dao.impl.GoodszrDaoImpl;
import com.second_hand.wrapperClass.MySoldGoodsFList;

/**
 * Servlet implementation class CheckGoodsServlet
 */
public class CheckGoodsServlet extends HttpServlet {//转让商品
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckGoodsServlet() {
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
		if("show".equals(method)) {
			GoodszrDao goodszrDao=new GoodszrDaoImpl(); 
			GoodsqgDao goodsqgDao=new GoodsqgDaoImpl();
			List<MySoldGoodsFList> list1=goodszrDao.selectGoodszr0();
			List<MySoldGoodsFList> list2=goodsqgDao.selectGoodsqgDiffer("0");
			request.setAttribute("goodszrCheckInfoAll", list1);
			request.setAttribute("goodsqgCheckInfoAll", list2);
			request.getRequestDispatcher("/jsp/checkgoods.jsp").forward(request, response);
		}else if("zrPass".equals(method)){
			GoodszrDao goodszrDao=new GoodszrDaoImpl(); 
			GoodsqgDao goodsqgDao=new GoodsqgDaoImpl();
			String goodszrid=request.getParameter("id");
			goodszrDao.updateFStatus01(Integer.parseInt(goodszrid));
			List<MySoldGoodsFList> list1=goodszrDao.selectGoodszr0();
			List<MySoldGoodsFList> list2=goodsqgDao.selectGoodsqgDiffer("0");
			request.setAttribute("goodszrCheckInfoAll", list1);
			request.setAttribute("goodsqgCheckInfoAll", list2);
			request.getRequestDispatcher("/jsp/checkgoods.jsp").forward(request, response);
		}else if("zrNo".equals(method)){
			GoodszrDao goodszrDao=new GoodszrDaoImpl(); 
			GoodsqgDao goodsqgDao=new GoodsqgDaoImpl();
			String goodszrid=request.getParameter("id");
			goodszrDao.updateFStatus_10(Integer.parseInt(goodszrid));
			List<MySoldGoodsFList> list1=goodszrDao.selectGoodszr0();
			List<MySoldGoodsFList> list2=goodsqgDao.selectGoodsqgDiffer("0");
			request.setAttribute("goodszrCheckInfoAll", list1);
			request.setAttribute("goodsqgCheckInfoAll", list2);
			request.getRequestDispatcher("/jsp/checkgoods.jsp").forward(request, response);
		}else if("qgPass".equals(method)){
			GoodszrDao goodszrDao=new GoodszrDaoImpl(); 
			GoodsqgDao goodsqgDao=new GoodsqgDaoImpl();
			int goodsqgid=Integer.parseInt(request.getParameter("id"));
			goodsqgDao.updateFStatusDiffer(goodsqgid, "1");
			List<MySoldGoodsFList> list1=goodszrDao.selectGoodszr0();
			List<MySoldGoodsFList> list2=goodsqgDao.selectGoodsqgDiffer("0");
			request.setAttribute("goodszrCheckInfoAll", list1);
			request.setAttribute("goodsqgCheckInfoAll", list2);
			request.getRequestDispatcher("/jsp/checkgoods.jsp").forward(request, response);
		}else if("qgNo".equals(method)){
			GoodszrDao goodszrDao=new GoodszrDaoImpl(); 
			GoodsqgDao goodsqgDao=new GoodsqgDaoImpl();
			int goodsqgid=Integer.parseInt(request.getParameter("id"));
			goodsqgDao.updateFStatusDiffer(goodsqgid, "-1");
			List<MySoldGoodsFList> list1=goodszrDao.selectGoodszr0();
			List<MySoldGoodsFList> list2=goodsqgDao.selectGoodsqgDiffer("0");
			request.setAttribute("goodszrCheckInfoAll", list1);
			request.setAttribute("goodsqgCheckInfoAll", list2);
			request.getRequestDispatcher("/jsp/checkgoods.jsp").forward(request, response);
		}
	}

}
