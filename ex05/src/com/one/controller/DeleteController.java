package com.one.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.model.GuestDao;

@WebServlet("/delete.do")
public class DeleteController extends HttpServlet {
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(request.getInputStream()));
		String data = br.readLine();//sabun=1111&name=aaaa&pay=1000
		StringTokenizer st = new StringTokenizer(data,"=");
		st.nextElement();
		int sabun = Integer.parseInt((String)st.nextElement());
		
		GuestDao dao = new GuestDao();
		dao.deleteOne(sabun);
	}

}
