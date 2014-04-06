package org.gdufs.ims;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder; 
import java.util.Random;

public class HttpFetcher {

	HttpFetcher(){  
	}
	
	
	public void run() throws InterruptedException, UnsupportedEncodingException{
		 String termString[] = { "中国", "日本", "韩国", "美国", "俄国", "英美" };    
		    String pathString = "";  
		    for (int i = 0; i < termString.length; i++) {  
		        for (int j = 0; j < 50; j++) {//对每个term（搜索关键字），取50页的内容  
		            pathString = "http://s.weibo.com/weibo/"  
		                    + URLEncoder.encode(termString[i], "UTF-8") + "&page="  
		                    + (j + 1);  
		            try {  
		                OutputStream os = null;  
		                InputStreamReader isr = null;  
		                URL url = new URL(pathString);  
		                HttpURLConnection httpConn = (HttpURLConnection) url  
		                        .openConnection();  
		                httpConn.setRequestMethod("POST");  
		                httpConn.setConnectTimeout(60000);  
		                httpConn.setReadTimeout(60000);  
		                httpConn.setRequestProperty(
		                		"User-Agent", 
		                		"Mozilla/12.0 (compatible; MSIE 8.0; Windows NT)");  
		                httpConn.setRequestProperty(
		                		"Content-Type", 
		                		"application/x-www-form-urlencoded");  
		                httpConn.setDoOutput(true);  
		                httpConn.setDoInput(true);  
		                os = httpConn.getOutputStream();  
		                os.flush();  
		                isr = new InputStreamReader(httpConn.getInputStream());  
		                StringBuffer content = new StringBuffer();  
		                int c;  
		                while ((c = isr.read()) != -1) {  
		                    content.append((char) c);  
		                }  
		                System.out.println( content.toString() );  
		            } catch (Exception e) {  
		                e.printStackTrace();  
		            }  
		             Random random = new Random();  
		             int slpmillsecs = 40000 + random.nextInt(20000) + 1;  
		             Thread.sleep(slpmillsecs);// 停40~60s  
		        }  
		    }  
	}
}
