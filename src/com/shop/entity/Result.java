package com.shop.entity;
public class Result {
	private Integer code;//״̬��
	private Boolean isSuccess;//״̬
	private String massege;//��Ϣ
	
	/**
	 * �޲ι�����
	 */
	public Result(){
		super();
	}
	
	/**
	 * ֻ����״̬��״̬�룬��Ϣ
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

