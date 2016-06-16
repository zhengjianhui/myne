package cn.tedu.entity;

import java.io.Serializable;
import java.sql.Timestamp;


@SuppressWarnings("serial")
public class Admin implements Serializable{
	
	// id
	private Integer id;
	private String code;
	private String password;
	private	String name;
	private String telephone;
	private String email;
	// 创建时间
	private Timestamp enrolldate;
	
	// 自定义变量
	private String valid;
	
	
	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer admin_id) {
		this.id = admin_id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String admin_code) {
		this.code = admin_code;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getEnrolldate() {
		return enrolldate;
	}
	public void setEnrolldate(Timestamp enrolldate) {
		this.enrolldate = enrolldate;
	}
	
	
		
}
