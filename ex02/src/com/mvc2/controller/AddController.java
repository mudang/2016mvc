package com.mvc2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mvc2.model.GuestDao;

public class AddController implements DMDimp {
	private GuestDao dao;
	
	public AddController(GuestDao dao) {
		this.dao = dao;
	}
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POJOŬ���� ����-Add");
		
		
		
		
		return "detail";
	}
	
}
