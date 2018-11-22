package com.second_hand.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.second_hand.dao.SearchDao;
import com.second_hand.dao.SuggestionDao;
import com.second_hand.dao.impl.SearchDaoImpl;
import com.second_hand.dao.impl.SuggestDaoImpl;
import com.second_hand.model.Suggestion;

/**
 * Servlet implementation class SearchSuggestionServlet
 */
public class SearchSuggestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSuggestionServlet() {
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
			SuggestionDao suggestionDao=new SuggestDaoImpl();
			SearchDao searchDao=new SearchDaoImpl();
			String keyword=request.getParameter("keyword");
			List<Suggestion> list=null;
			if(keyword!="") {
				list=searchDao.SearchSuggestionString(keyword);
			}else
			{
				list=suggestionDao.selectSuggestion();
			}
			request.setAttribute("suggestionInfoAll", list);
			request.getRequestDispatcher("/jsp/suggestionmanage.jsp").forward(request, response);
		}else if("show".equals(method)) {
			SuggestionDao suggestionDao=new SuggestDaoImpl();
			List<Suggestion> list=suggestionDao.selectSuggestion();
			request.setAttribute("suggestionInfoAll", list);
			request.getRequestDispatcher("/jsp/suggestionmanage.jsp").forward(request, response);
		}else if("delete".equals(method)){
			String id= request.getParameter("id");
	    	System.out.println("delete id value:"+id);
	    	SuggestionDao suggestionDao=new SuggestDaoImpl();
	    	suggestionDao.removeSuggestionById(Integer.parseInt(id));
	    	List<Suggestion> list=suggestionDao.selectSuggestion();
	 		request.setAttribute("suggestionInfoAll", list);
	    	request.getRequestDispatcher("/jsp/suggestionmanage.jsp").forward(request, response);
		}else if("Areply".equals(method)){
			String sid=request.getParameter("sid");
			String message=new String(request.getParameter("message").getBytes("ISO-8859-1"),"UTF-8"); 
			String receiverid=request.getParameter("receiverid");
			SuggestionDao suggestionDao=new SuggestDaoImpl();
			Suggestion suggestion=new Suggestion();
			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date currentTime = new java.util.Date();
			String talktime = formatter.format(currentTime);
			suggestion.setSuggestioncontent(message);
			suggestion.setTalktime(talktime);
			suggestion.setReceiverid(receiverid);
			suggestion.setSenderid("0");
			suggestion.setSuggestionstatus(1);
			suggestionDao.insertASuggestion(suggestion);
			suggestionDao.updateStatus(Integer.parseInt(sid));
			List<Suggestion> list=suggestionDao.selectSuggestion();
			request.setAttribute("suggestionInfoAll", list);
			request.getRequestDispatcher("/jsp/suggestionmanage.jsp").forward(request, response);
		    }

	}

}
