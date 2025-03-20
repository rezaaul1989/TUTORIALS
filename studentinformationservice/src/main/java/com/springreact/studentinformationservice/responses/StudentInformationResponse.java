package com.springreact.studentinformationservice.responses;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.springreact.studentinformationservice.models.Studentinfo;

@Component
public class StudentInformationResponse {
	public StudentInformationResponse(Integer deptno, String deptname, List<Studentinfo> studentinfo) {
		this.deptno = deptno;
		this.deptname = deptname;
		this.studentinfo = studentinfo;
	}
	public StudentInformationResponse() {
	}
	private Integer deptno;
	private String deptname;
	private List<Studentinfo> studentinfo;
	@Override
	public int hashCode() {
		return Objects.hash(deptname, deptno, studentinfo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentInformationResponse other = (StudentInformationResponse) obj;
		return Objects.equals(deptname, other.deptname) && Objects.equals(deptno, other.deptno)
				&& Objects.equals(studentinfo, other.studentinfo);
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public List<Studentinfo> getStudentinfo() {
		return studentinfo;
	}
	public void setStudentinfo(List<Studentinfo> studentinfo) {
		this.studentinfo = studentinfo;
	}
	
	
}
