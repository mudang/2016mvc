package com.struts.tutorial.action02;

import com.opensymphony.xwork2.ActionSupport;

public class Action03 extends ActionSupport{
	private String id,pw,msg;
	
	public void setId(String id) {
		this.id = id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public String getMsg() {
		return msg;
	}
	
	public String formView(){
		System.out.println("formView() run");
		return INPUT;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("execute() run");
		msg="id:"+id+",pw:"+pw+"로 로그인";
		return SUCCESS;
		
		
	}
	
	@Override
	public void validate() {
	if(id==null){
		addFieldError("id", "");
		
		}else if("".equals(id)){
			addFieldError("id", "id not null.");
		}else if(id.length()<4){
			addFieldError("id", "id는 4 자 이상");			
		}
	if(pw==null){
		
		addFieldError("pw", "");
		
		}else if("".equals(pw)){
			addFieldError("pw", "pw not null.");
		}else if(pw.length()<6){
			addFieldError("pw", "pw는 6 자 이상");			
		}
	}
}
