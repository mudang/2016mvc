package com.mvc2.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mvc2.controller.IndexImp;
import com.mvc2.controller.InsertOneImp;
import com.mvc2.controller.InterController;
import com.mvc2.controller.ListImp;


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
		logger.debug(path);
		logger.info(path);
		logger.warn(path);
		logger.error(path);
		logger.fatal(path);

		InterController ic=null;
		if(path.equals("/")){
			ic=new IndexImp();
		}else if (path.equals("/list.do")){
			ic= new ListImp();
		}else if (path.equals("/add.do")){
			ic= new InsertOneImp();
		}
		String url=ic.execute(request,response);
		String prefix="/WEB-INF/page/";
		String suffix=".jsp";
		
		request.getRequestDispatcher(prefix+url+suffix).forward(request, response);
		
	}

}
