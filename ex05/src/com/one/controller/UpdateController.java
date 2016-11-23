package com.one.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.model.GuestDao;

import sun.util.BuddhistCalendar;

@WebServlet("/edit.do")
public class UpdateController extends HttpServlet {

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String> map = new HashMap<String, String>();
		BufferedReader br= new BufferedReader(new InputStreamReader(request.getInputStream()));
		String data = br.readLine();//sabun=1111&name=aaaa&pay=1000
		System.out.println(data);
		StringTokenizer st = new StringTokenizer(data,"&");
		String[] params = new String[3];
		int cnt=0;
		while(st.hasMoreTokens()){
			params[cnt] = st.nextToken();
			params[cnt]= params[cnt].substring(params[cnt].indexOf("=")+1);
			cnt++;
		}
//		for(int i=0; i<params.length;i++){
//			System.out.println(params[i]);
//		}
		Object[] obj= {params[0],params[1],params[2]}; 
		GuestDao dao = new GuestDao();
		dao.updateOne(obj);
	}
	

}
