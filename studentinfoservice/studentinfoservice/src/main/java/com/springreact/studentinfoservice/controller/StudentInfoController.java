package com.springreact.studentinfoservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springreact.studentinfoservice.entity.Studentinfo;
import com.springreact.studentinfoservice.service.StudentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/studentinfo")
public class StudentInfoController {
	
	@Autowired
	private StudentService stdService;
	
	
	@GetMapping(value = "/findallstudents",produces = MediaType.TEXT_EVENT_STREAM_VALUE )
	public Flux<Studentinfo> findAllStudents(){
		return stdService.getAllStudents().log();
	}
	
	@GetMapping(value = "/findbyid/{id}")
	public Mono<Studentinfo> findStudentInfoById(@PathVariable("id") Integer id){
		return stdService.getStudentById(id);
	}
	
	@GetMapping(value = "/findbyroll/{roll}")
	public Mono<Studentinfo> findStudentInfoByRoll(@PathVariable("roll") Integer roll){
		return stdService.getStudentByRoll(roll);
	}
	
	@GetMapping(value = "/findbydeptno/{deptno}")
	public Flux<Studentinfo> findStudentInfoByDeptNo(@PathVariable("deptno") Integer deptno){
		return stdService.getStudentsByDeptNo(deptno);
	}
	
	@GetMapping(value = "/findbydeptnumber/{deptno}")
	public Flux<Studentinfo> findbydeptnumber(@PathVariable("deptno") Integer deptno){
		return stdService.getStudentsByDeptNumber(deptno);
	}
	
	@GetMapping(value = "/findListOfStudentsByDeptNo/{deptno}")
	public Mono<List<Studentinfo>> getListOfStudentsByDeptNo(@PathVariable("deptno") Integer deptno){
		return stdService.getListOfStudentsByDeptNo(deptno);
	}
	
	
	@PostMapping(value = "/save")
	public Mono<Studentinfo> save(@RequestBody Studentinfo stdinf){
		return stdService.save(stdinf);
	}
	
	@PostMapping(value = "/update")
	public Mono<Studentinfo> update(@RequestBody Studentinfo stdinf){
		return stdService.edit(stdinf);
	}
	
	@PostMapping(value = "/delete/{roll}")
	public Mono<Void> delete(@PathVariable Integer roll){
		return stdService.delete(roll);
	}

}
