package com.stone.simple.member.common;

import java.io.IOException;
import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class Member {
	int no;
	String name;
	MultipartFile profileFile;
	byte[] profile;
	String tel;
	String post;
	String address;
	String detailAddress;
	String id;
	String password;
	String email;
	char state;//상태:정상1,휴면2,탈퇴3
	Date rdate;//등록일
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getProfileFile() {
		return profileFile;
	}
	public void setProfileFile(MultipartFile profileFile) {
		this.profileFile = profileFile;
	}

	public byte[] getProfile() {
		try {
			if (getProfileFile() != null && !getProfileFile().isEmpty()){
				return getProfileFile().getBytes();
			} }catch (IOException e) {e.printStackTrace();}
			return null;
	}
	public void setProfile(byte[] profile) {
		this.profile = profile;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char getState() {
		return state;
	}
	public void setState(char state) {
		this.state = state;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
}
