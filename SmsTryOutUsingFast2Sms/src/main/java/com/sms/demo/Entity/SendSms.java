package com.sms.demo.Entity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

public class SendSms {
	
	public static void sendSms(String message,String number) {
		
//		System.out.println(message);
//		System.out.println(number);
		
		
		try {
		String apikey="umIjtSeUR4bxwTiz6KLA9pZM8EOJXrqN7daDv3nkFcBglfYy1h9b3YBQqdMhe62PjmrNtol7KOLcAUg0";
	    String sendId="FSTSMS";
	    message= URLEncoder.encode(message,"UTF-8");
	   String language="english";
	   String route="dlt";
	   String myUrl="//www.fast2sms.com/dev/bulk?authorization="+apikey+"&sender_id="+sendId+"&message="+message+"&language"+language+"&route"+route+"&number"+number;
//	   System.out.println(myUrl);
	//   System.out.println(message);
	   
	   
	   ///sending get request
	   
	   URL url=new URL(myUrl);
	   
	   HttpsURLConnection con=(HttpsURLConnection)url.openConnection();
	   
	   con.setRequestMethod("GET");
	   
	   
	   con.setRequestProperty("user-Agent", "Mozilla/5.0");
	   con.setRequestProperty("cache-control", "no-cache");
	   
	   System.out.println("wait.........................");
	   int Code = con.getResponseCode();
	   
	   
	   System.out.println("Response code:"+Code);
	   
	   StringBuffer response = new StringBuffer();
	   BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	   
	   while (true) {
	    String line=br.readLine();
	    if (line==null) {
			break;
		}
	    response.append(line);
	}
	   System.out.println(response);
	   
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("program started.....");
		
		SendSms.sendSms("this message using java code..."+new Date().toLocaleString(), "7845400370");
		
	}
}
