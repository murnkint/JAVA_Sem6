package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Course;

public interface ICourseRepo extends CrudRepository<Course, Integer>{

	//public abstract pēc nosklusejuma
	ArrayList<Course> findByCp(int cp);
	//public abstract pēc nosklusejuma
	ArrayList<Course> findByProfessorIdP(int id);
	//public abstract pēc nosklusejuma
	ArrayList<Course> findByGradesStudentIdS(int id);
}