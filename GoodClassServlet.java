package com.second_hand.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.second_hand.dao.GoodsclassDao;
import com.second_hand.dao.impl.GoodsclassDaoImpl;
import com.second_hand.model.Goodsclass;


/**
 * Servlet implementation class GoodClassServlet
 */
public class GoodClassServlet extends HttpServlet {//商品页面分类
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodClassServlet() {
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
		String classname=request.getParameter("classname");
		if("insert".equals(method)) {
			GoodsclassDao goodsclassDao=new GoodsclassDaoImpl();
			Goodsclass goodsclass=new Goodsclass();
			goodsclass.setClassname(classname);
			int resultclass=goodsclassDao.insertGoodsclass(goodsclass);
			if(resultclass!=0) {
				List<Goodsclass> list=goodsclassDao.selectGoodsclass();
				request.setAttribute("goodsclassInfoAll", list);
				request.getRequestDispatcher("/jsp/showClassList.jsp").forward(request, response);
			}
		}else if("show".equals(method)) {
			GoodsclassDao goodsclassDao=new GoodsclassDaoImpl();
			List<Goodsclass> list=goodsclassDao.selectGoodsclass();
			request.setAttribute("goodsclassInfoAll", list);
			request.getRequestDispatcher("/jsp/showClassList.jsp").forward(request, response);
		}else if("delete".equals(method)){
			String id= request.getParameter("id");
			GoodsclassDao goodsclassDao=new GoodsclassDaoImpl();
			goodsclassDao.removeGoodsclassById(Integer.parseInt(id));
			List<Goodsclass> list=goodsclassDao.selectGoodsclass();
			request.setAttribute("goodsclassInfoAll", list);
			request.getRequestDispatcher("/jsp/showClassList.jsp").forward(request, response);
		}
	}

}
