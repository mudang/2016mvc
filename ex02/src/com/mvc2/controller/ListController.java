package com.mvc2.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mvc2.model.GuestDao;

public class ListController implements DMDimp{
	private GuestDao dao;
	
	public ListController(GuestDao dao){
		this.dao=dao;
	}
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POJO클래스 실행-list");
		
		
		request.setAttribute("list", dao.selectAll());
		
		return "list";
	}
	
}
