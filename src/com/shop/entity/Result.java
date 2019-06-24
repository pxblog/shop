package com.shop.entity;
public class Result {
	private Integer code;//状态码
	private Boolean isSuccess;//状态
	private String massege;//消息
	
	/**
	 * 无参构造器
	 */
	public Result(){
		super();
	}
	
	/**
	 * 只返回状态，状态码，消息
	 * @param statu
	 * @param code
	 * @param massege
	 */
	public Result(Boolean success, Integer code, String massege){
		super();
		this.isSuccess=success;
		this.code=code;
		this.massege=massege;
	}
	

	

	public Integer getCode() {
		return code;
	}
 
	public void setCode(Integer code) {
		this.code = code;
	}
 
	public Boolean getIsSuccess() {
		return isSuccess;
	}
 
	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
 
	public String getMassege() {
		return massege;
	}
 
	public void setMassege(String massege) {
		this.massege = massege;
	}

	
	
}

