package com.hansung.CMS;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String nick;
	private String sex;
	private String email;
	private String homepage;
	private String address;
	private String[] hobby;
	
	public Member() {
		super();
	}
	
	public Member(String id, String pw, String name, String nick, String sex, String email, String homepage, String address, String[] hobby) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.nick = nick;
		this.sex = sex;
		this.email = email;
		this.homepage = homepage;
		this.address = address;
		this.hobby = hobby;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHomepage() {
		return homepage;
	}
	public void sethomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String hob) {
		hobby = hob.split(" ");
		for(String s : hobby) {
			System.out.println(s);
		}
	}
	public String getHobbyString() {
		StringBuilder sb = new StringBuilder();
		for(String s : hobby) {
			sb.append(s);
			sb.append(" ");
			
		}
		
		return sb.toString();
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	
	
}
