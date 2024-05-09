package lv.venta.service.Impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Grade;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IGradeFilterService;

@Service
public class GradeFilterServiceImpl implements IGradeFilterService{

	@Autowired
	private IGradeRepo gradeRepo;
	
	@Autowired
	private IStudentRepo studRepo;
	
	@Autowired
	private ICourseRepo courseRepo;
	
	@Override
	public ArrayList<Grade> selectGradesByStudentId(int id) throws Exception {
		if(id <= 0) throw new Exception("Id should be positive");
		
		if(!studRepo.existsById(id)) throw new Exception("Student with id (" + id + ") doesn't exist");
		
		ArrayList<Grade> result = gradeRepo.findByStudentIdpe(id);
		
		if(result.isEmpty()) throw new Exception("There is no linkage between this student and grades");		
		
		return result;
	}

	@Override
	public ArrayList<Grade> selectFailedGradesByStudentId(int id) throws Exception {
		if(id <= 0) throw new Exception("Id should be positive");
		
		if(!studRepo.existsById(id)) throw new Exception("Student with id (" + id + ") doesn't exist");

		ArrayList<Grade> result = gradeRepo.findByStudentIdpeAndGrvalueLessThan(id, 4);
		
		if(result.isEmpty()) throw new Exception("There is no failed grade for this student");		
		
		return result;
	}

	@Override
	public float calculateAVGGradeInCourseById(int id) throws Exception {
		if(id <= 0) throw new Exception("Id should be positive");
		
		if(!courseRepo.existsById(id)) throw new Exception("Course with id (" + id + ") doesn't exist");
		
		float result = gradeRepo.calculateAVGByCourseId(id);
		
		if(result==0) throw new Exception("There is no linkage between this course and grades") ;
		
		return result;
	}

}