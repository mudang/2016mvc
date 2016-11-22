package com.mvc2.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mvc2.controller.DetailImp;
import com.mvc2.controller.DeteleImp;
import com.mvc2.controller.IndexImp;
import com.mvc2.controller.InsertOneImp;
import com.mvc2.controller.InterController;
import com.mvc2.controller.ListImp;
import com.mvc2.controller.UpdateImp;


public class DispatcherServlet extends HttpServlet {
	static Logger logger = Logger.getLogger("com.mvc2.core.DispatcherServlet");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDo(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doDo(request, response);
		
	}
	protected void doDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
//		logger.debug(path);
//		logger.info(path);
//		logger.warn(path);
//		logger.error(path);
//		logger.fatal(path);

		InterController ic=null;
		if(path.equals("/")){
			ic=new IndexImp();
		}else if (path.equals("/list.do")){
			ic= new ListImp();
		}else if (path.equals("/add.do")){
			ic= new InsertOneImp();
		}else if (path.equals("/detail.do")){
			ic= new DetailImp();
		}else if (path.equals("/update.do")){
			ic= new UpdateImp();
		}else if (path.equals("/delete.do")){
			ic= new DeteleImp();
		}else{
			//���� /img/aaa.jpg
			
			return;
		}
		String prefix="/WEB-INF/page/";
		String suffix=".jsp";
		String url=ic.execute(request,response);
		if(url.endsWith(".do")){
			System.out.println("�����̷�Ʈ ����");
			
//			response.sendRedirect(url);
//			return;
		}else{
			url=prefix+url+suffix;
		}
		
		
//		request.getRequestDispatcher(prefix+url+suffix).forward(request, response);
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
