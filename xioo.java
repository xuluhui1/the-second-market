package com.second_hand.message;
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

/*
����:		web.cr6868.com HTTP�ӿ� ���Ͷ���

˵��:		http://web.cr6868.com/asmx/smsservice.aspx?name=��¼��&pwd=�ӿ�����&mobile=�ֻ�����&content=����&sign=ǩ��&stime=����ʱ��&type=pt&extno=�Զ�����չ��
*/
public class xioo {
	
	public static void main(String[] args) throws Exception {
		
		// �û���
		String name="18862018297"; 
		// ����
		String pwd="766BAB144F9CBADF080253BF627B"; 
		// �绰�����ַ������м���Ӣ�Ķ��ż��
		StringBuffer mobileString=new StringBuffer("18862016223");
		// �����ַ���
		StringBuffer contextString=new StringBuffer("ע����֤�룺654321���뼰ʱ����");
		// ǩ��
		String sign="�������";
		// ׷�ӷ���ʱ�䣬��Ϊ�գ�Ϊ��Ϊ��ʱ����
		String stime="";
		// ��չ�룬����Ϊ���� ��Ϊ��
		StringBuffer extno=new StringBuffer();
		
        System.out.println(doPost(name, pwd, mobileString, contextString, sign, stime, extno));
    }
	
	/**
	 * ���Ͷ���
	 * 
	 * @param name			�û���
	 * @param pwd			����
	 * @param mobileString	�绰�����ַ������м���Ӣ�Ķ��ż��
	 * @param contextString	�����ַ���
	 * @param sign			ǩ��
	 * @param stime			׷�ӷ���ʱ�䣬��Ϊ�գ�Ϊ��Ϊ��ʱ����
	 * @param extno			��չ�룬����Ϊ���� ��Ϊ��
	 * @return				
	 * @throws Exception
	 */
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
	 * ת������ֵ����ΪUTF-8��ʽ.
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
