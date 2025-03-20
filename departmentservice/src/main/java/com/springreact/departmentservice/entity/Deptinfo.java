package com.springreact.departmentservice.entity;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "deptinfo")
public class Deptinfo {
	
	@Id
	private Integer id;
	@Column("deptname")
	private String deptname;
	@Column("deptno")
	private Integer deptno;
	public Deptinfo() {
	}
	public Deptinfo(Integer id, String deptname, Integer deptno) {
		this.id = id;
		this.deptname = deptname;
		this.deptno = deptno;
	}
	@Override
	public int hashCode() {
		return Objects.hash(deptname, deptno, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deptinfo other = (Deptinfo) obj;
		return Objects.equals(deptname, other.deptname) && Objects.equals(deptno, other.deptno)
				&& Objects.equals(id, other.id);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return "Deptinfo [id=" + id + ", deptname=" + deptname + ", deptno=" + deptno + "]";
	}
	
	

}
