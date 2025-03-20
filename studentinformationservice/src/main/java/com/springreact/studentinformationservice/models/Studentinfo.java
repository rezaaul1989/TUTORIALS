package com.springreact.studentinformationservice.models;

import java.util.Objects;


public class Studentinfo {
	
	
	private Integer id;
	private String fname;
	private String lname;
	private Integer age;
	private Integer deptno;
	private Integer roll;
	
	public Studentinfo() {
	}
	public Studentinfo(Integer id, String fname, String lname, Integer age, Integer deptno, Integer roll) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.deptno = deptno;
		this.roll = roll;
	}
	public Integer getRoll() {
		return roll;
	}
	public void setRoll(Integer roll) {
		this.roll = roll;
	}
	@Override
	public String toString() {
		return "Studentinfo [id=" + id + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", deptno=" + deptno
				+ ", roll=" + roll + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, deptno, fname, id, lname, roll);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studentinfo other = (Studentinfo) obj;
		return Objects.equals(age, other.age) && Objects.equals(deptno, other.deptno)
				&& Objects.equals(fname, other.fname) && Objects.equals(id, other.id)
				&& Objects.equals(lname, other.lname) && Objects.equals(roll, other.roll);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

}
