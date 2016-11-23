package com.struts.tutorial.action;

public class TutorialAction03 {
	private String msg;
	
	//파라미터 값 받을때
	public void setMsg(String msg){
		this.msg=msg;
	}
	
	//뷰에 전달할 때
	public String getMsg() {
		return msg;
	}
	public String execute(){
		
		System.out.println(msg);
		return "success";
	}
}
