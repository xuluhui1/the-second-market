package com.second_hand.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.second_hand.dao.RandomNumberDao;
import com.second_hand.dao.impl.RandomNumberDaoImpl;

/**
 * Servlet implementation class SendMessageServlet
 */
public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessageServlet() {
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
		// 用户名
		RandomNumberDao rn=new RandomNumberDaoImpl();
		String phone=request.getParameter("zipcode");
		String random=rn.getXiooByUUId();
		System.out.println(phone);
				String name="18862018297"; 
				// 密码
				String pwd="766BAB144F9CBADF080253BF627B"; 
				// 电话号码字符串，中间用英文逗号间隔
				StringBuffer mobileString=new StringBuffer(phone);
				// 内容字符串
				
				StringBuffer contextString=new StringBuffer("注册验证码："+random+"，请及时输入");
				// 签名
				String sign="天淼商务";
				// 追加发送时间，可为空，为空为及时发送
				String stime="";
				// 扩展码，必须为数字 可为空
				StringBuffer extno=new StringBuffer();
				
		        try {
					System.out.println(doPost(name, pwd, mobileString, contextString, sign, stime, extno));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        response.getWriter().print(random);
	}
	
	 public static String doPost(String name, String pwd, 
	    		StringBuffer mobileString, StringBuffer contextString,
	    		String sign, String stime, StringBuffer extno) throws Exception {
	    	StringBuffer param = new StringBuffer();
	    	param.append("name="+name);
	    	param.append("&pwd="+pwd);
	    	param.append("&mobile=").append(mobileString);
	    	param.append("&content=").append(URLEncoder.encode(contextString.toString(),"UTF-8"));
	    	param.append("&stime="+stime);
	    	param.append("&sign=").append(URLEncoder.encode(sign,"UTF-8"));
	    	param.append("&type=pt");
	    	param.append("&extno=").append(extno);
	        
	        URL localURL = new URL("http://web.cr6868.com/asmx/smsservice.aspx?");
	        URLConnection connection = localURL.openConnection();
	        HttpURLConnection httpURLConnection = (HttpURLConnection)connection;
	        
	        httpURLConnection.setDoOutput(true);
	        httpURLConnection.setRequestMethod("POST");
	        httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
	        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(param.length()));
	        
	        OutputStream outputStream = null;
	        OutputStreamWriter outputStreamWriter = null;
	        InputStream inputStream = null;
	        InputStreamReader inputStreamReader = null;
	        BufferedReader reader = null;
	        String resultBuffer = "";
	        
	        try {
	            outputStream = httpURLConnection.getOutputStream();
	            outputStreamWriter = new OutputStreamWriter(outputStream);
	            
	            outputStreamWriter.write(param.toString());
	            outputStreamWriter.flush();
	            
	            if (httpURLConnection.getResponseCode() >= 300) {
	                throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
	            }
	            
	            inputStream = httpURLConnection.getInputStream();
	            resultBuffer = convertStreamToString(inputStream);
	            
	        } finally {
	            
	            if (outputStreamWriter != null) {
	                outputStreamWriter.close();
	            }
	            
	            if (outputStream != null) {
	                outputStream.close();
	            }
	            
	            if (reader != null) {
	                reader.close();
	            }
	            
	            if (inputStreamReader != null) {
	                inputStreamReader.close();
	            }
	            
	            if (inputStream != null) {
	                inputStream.close();
	            }
	            
	        }

	        return resultBuffer;
	    }
		
		
		/**
		 * 转换返回值类型为UTF-8格式.
		 * @param is
		 * @return
		 */
		public static String convertStreamToString(InputStream is) {    
	        StringBuilder sb1 = new StringBuilder();    
	        byte[] bytes = new byte[4096];  
	        int size = 0;  
	        
	        try {    
	        	while ((size = is.read(bytes)) > 0) {  
	                String str = new String(bytes, 0, size, "UTF-8");  
	                sb1.append(str);  
	            }  
	        } catch (IOException e) {    
	            e.printStackTrace();    
	        } finally {    
	            try {    
	                is.close();    
	            } catch (IOException e) {    
	               e.printStackTrace();    
	            }    
	        }    
	        return sb1.toString();    
	    }

}
