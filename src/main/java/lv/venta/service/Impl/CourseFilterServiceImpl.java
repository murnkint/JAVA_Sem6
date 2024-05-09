package lv.venta.service.Impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Course;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.ICourseFilterService;

@Service
public class CourseFilterServiceImpl implements ICourseFilterService {

	@Autowired
	private ICourseRepo courseRepo;
	
	@Autowired
	private IProfessorRepo profRepo;
	
	@Autowired
	private IStudentRepo studRepo;
	
	@Override
	public ArrayList<Course> selectCoursesByCP(int cp) throws Exception {
		if(cp < 0 || cp > 20) throw new Exception("Cp should be between 0 and 20");
		
		
		ArrayList<Course> result = courseRepo.findByCp(cp);
		
		if(result.isEmpty())
			throw new Exception("There is no course with " + cp + " creditpoints");
		
		return result;
	}

	@Override
	public ArrayList<Course> selectCoursesByProfessorId(int id) throws Exception {
		if(id <= 0) throw new Exception("Id should be positive");
		
		if(!profRepo.existsById(id))
			throw new Exception("Professor with id (" + id + ") doesn't exist");
		
		ArrayList<Course> result = courseRepo.findByProfessorsIdP(id);
		
		if(result.isEmpty())
			throw new Exception("There is no linkage between this professor and course");		

		return result;
	}

	@Override
	public ArrayList<Course> selectCoursesByStudentId(int id) throws Exception {
		if(id <= 0) throw new Exception("Id should be positive");
		
		if(!studRepo.existsById(id)) throw new Exception("Student with id (" + id + ") doesn't exist");
		
		
		ArrayList<Course> result = courseRepo.findByGradesStudentIdS(id);

		if(result.isEmpty()) throw new Exception("There is no linkage between this student and course");		

		
		return result;
	}

}