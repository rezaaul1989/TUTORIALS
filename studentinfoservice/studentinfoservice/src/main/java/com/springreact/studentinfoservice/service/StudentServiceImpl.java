package com.springreact.studentinfoservice.service;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springreact.studentinfoservice.entity.Studentinfo;
import com.springreact.studentinfoservice.repo.StudentInfoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentInfoRepository stdRepo;

	@Override
	public Flux<Studentinfo> getAllStudents() {
		return stdRepo.findAll().delayElements(Duration.ofMillis(1000));
	}

	@Override
	public Mono<Studentinfo> getStudentById(Integer id) {
		return stdRepo.findById(id);
	}

	@Override
	public Mono<Studentinfo> getStudentByRoll(Integer roll) {
		return stdRepo.findAllByRoll(roll);
	}

	@Override
	public Flux<Studentinfo> getStudentsByDeptNo(Integer deptno) {
		return stdRepo.findAllByDeptno(deptno);
	}

	@Override
	public Mono<Studentinfo> save(Studentinfo std) {
		return stdRepo.saveStudent(std);
	}

	@Override
	public Mono<Void> delete(Integer roll) {
		
		Mono<Studentinfo> std = stdRepo.findAllByRoll(roll);
		std.flatMap(temp->{
			return stdRepo.delete(temp);
		});
		return null;
	}

	@Override
	public Mono<Studentinfo> edit(Studentinfo std) {
		return stdRepo.save(std);
	}

	@Override
	public Flux<Studentinfo> getStudentsByDeptNumber(Integer deptno) {
		return stdRepo.findAllByDeptNumber(deptno);
	}

	@Override
	public Mono<List<Studentinfo>> getListOfStudentsByDeptNo(Integer deptno) {
		Mono<List<Studentinfo>> stdListMono = stdRepo.findAllByDeptno(deptno).collectList().flatMap(Mono::just);
		return stdListMono;
	}

}
