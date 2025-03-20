package com.springreact.studentinfoservice.entity;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "studentinfo")
public class Studentinfo {
	
	@Id
	private Integer id;
	@Column("fname")
	private String fname;
	@Column("lname")
	private String lname;
	@Column("age")
	private Integer age;
	@Column("deptno")
	private Integer deptno;
	@Column("roll")
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
