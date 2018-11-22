package com.second_hand.demo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.second_hand.dao.GoodszrDao;
import com.second_hand.dao.impl.GoodszrDaoImpl;
import com.second_hand.wrapperClass.MySoldGoodsFList;

/**
 * Servlet implementation class SoldGoodsDServlet
 */
@WebServlet("/SoldGoodsDServlet")
public class SoldGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SoldGoodsServlet() {
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
		if("showSoldGoods_1List".equals(method)) {
			GoodszrDao goodszrFDao=new GoodszrDaoImpl();
			List<MySoldGoodsFList> list=goodszrFDao.selectGoodszr_1();
			request.setAttribute("goodszrFInfoAll", list);
			request.getRequestDispatcher("showSoldGoods_1List.jsp").forward(request, response);
		}else if("showSoldGoods0List".equals(method)) {
			GoodszrDao goodszrFDao=new GoodszrDaoImpl();
			List<MySoldGoodsFList> list=goodszrFDao.selectGoodszr0();
			request.setAttribute("goodszrFInfoAll", list);
			request.getRequestDispatcher("showSoldGoods0List.jsp").forward(request, response);
		}else if("showSoldGoods1List".equals(method)) {
			GoodszrDao goodszrFDao=new GoodszrDaoImpl();
			List<MySoldGoodsFList> list=goodszrFDao.selectGoodszr1();
			request.setAttribute("goodszrFInfoAll", list);
			request.getRequestDispatcher("showSoldGoods1List.jsp").forward(request, response);
		}else if("showSoldGoods2List".equals(method)) {
				GoodszrDao goodszrFDao=new GoodszrDaoImpl();
				List<MySoldGoodsFList> list=goodszrFDao.selectGoodszr2();
				request.setAttribute("goodszrFInfoAll", list);
				request.getRequestDispatcher("showSoldGoods2List.jsp").forward(request, response);
		}else if("delete-1".equals(method)) {
			String goodszrid=request.getParameter("id");
			GoodszrDao goodszrFDao=new GoodszrDaoImpl();
			goodszrFDao.removeGoodszrById(Integer.parseInt(goodszrid));
			
			List<MySoldGoodsFList> list=goodszrFDao.selectGoodszr_1();
			request.setAttribute("goodszrFInfoAll", list);
			request.getRequestDispatcher("showSoldGoods_1List.jsp").forward(request, response);
		}else if("delete0".equals(method)) {
			String goodszrid=request.getParameter("id");
			GoodszrDao goodszrFDao=new GoodszrDaoImpl();
			goodszrFDao.removeGoodszrById(Integer.parseInt(goodszrid));
			
			List<MySoldGoodsFList> list=goodszrFDao.selectGoodszr0();
			request.setAttribute("goodszrFInfoAll", list);
			request.getRequestDispatcher("showSoldGoods0List.jsp").forward(request, response);
		}else if("delete1".equals(method)) {
			String goodszrid=request.getParameter("id");
			GoodszrDao goodszrFDao=new GoodszrDaoImpl();
			goodszrFDao.removeGoodszrById(Integer.parseInt(goodszrid));
			
			List<MySoldGoodsFList> list=goodszrFDao.selectGoodszr1();
			request.setAttribute("goodszrFInfoAll", list);
			request.getRequestDispatcher("showSoldGoods1List.jsp").forward(request, response);
		}else if("delete2".equals(method)) {
			String goodszrid=request.getParameter("id");
			GoodszrDao goodszrFDao=new GoodszrDaoImpl();
			goodszrFDao.removeGoodszrById(Integer.parseInt(goodszrid));
			
			List<MySoldGoodsFList> list=goodszrFDao.selectGoodszr2();
			request.setAttribute("goodszrFInfoAll", list);
			request.getRequestDispatcher("showSoldGoods2List.jsp").forward(request, response);
		}else if("delete3".equals(method)) {
			String goodszrid=request.getParameter("id");
			GoodszrDao goodszrFDao=new GoodszrDaoImpl();
			goodszrFDao.removeGoodszrById(Integer.parseInt(goodszrid));
			
			List<MySoldGoodsFList> list=goodszrFDao.selectGoodszr3();
			request.setAttribute("goodszrFInfoAll", list);
			request.getRequestDispatcher("showSoldGoods3List.jsp").forward(request, response);
		}else if("delete4".equals(method)) {
			String goodszrid=request.getParameter("id");
			GoodszrDao goodszrFDao=new GoodszrDaoImpl();
			goodszrFDao.removeGoodszrById(Integer.parseInt(goodszrid));
			
			List<MySoldGoodsFList> list=goodszrFDao.selectGoodszr4();
			request.setAttribute("goodszrFInfoAll", list);
			request.getRequestDispatcher("showSoldGoods4List.jsp").forward(request, response);
		}else if("statuUpdate".equals(method)){
			GoodszrDao goodszrFDao=new GoodszrDaoImpl();
			String goodszrid=request.getParameter("id");
			goodszrFDao.updateFStatus23(Integer.parseInt(goodszrid));
			
			List<MySoldGoodsFList> list=goodszrFDao.selectGoodszr2();
			request.setAttribute("goodszrFInfoAll", list);
			
			request.getRequestDispatcher("showSoldGoods2List.jsp").forward(request, response);
		}else if("showSoldGoods3List".equals(method)) {
			GoodszrDao goodszrFDao=new GoodszrDaoImpl();
			List<MySoldGoodsFList> list=goodszrFDao.selectGoodszr3();
			request.setAttribute("goodszrFInfoAll", list);
			request.getRequestDispatcher("showSoldGoods3List.jsp").forward(request, response);
		}else if("showSoldGoods4List".equals(method)) {
			GoodszrDao goodszrFDao=new GoodszrDaoImpl();
			List<MySoldGoodsFList> list=goodszrFDao.selectGoodszr4();
			request.setAttribute("goodszrFInfoAll", list);
			request.getRequestDispatcher("showSoldGoods4List.jsp").forward(request, response);
		}
	}
}
