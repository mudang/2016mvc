package com.mvc2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc2.model.GuestDao;

public class DeteleImp implements InterController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String param = req.getParameter("idx");
		int sabun=Integer.parseInt(param);
		GuestDao dao = new GuestDao();
		dao.deleteOne(sabun);
		return "guest/result";
	}

}
