package com.mvc2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc2.model.GuestDao;

public class ListImp implements InterController {

	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		GuestDao dao= new GuestDao();
		req.setAttribute("alist", dao.selectAll());
		return "guest/list";
	}

}
