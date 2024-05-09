package lv.venta.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "ProfessorTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Professor extends Person{
	@Column(name="IdP")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idP;
	
	@Column(name = "Degree")
	@NotNull
	private Degree degree;
	
	//gadījums, kad Profesoram dŗīkst būt vairāk kā viens kurss
	@ManyToMany(mappedBy = "professors")
	@ToString.Exclude
	private Collection<Course> courses = new ArrayList<Course>();
	

	
	public Professor(String name, String surname, Degree degree) {
		super(name, surname);
		setDegree(degree);
	}
	
	public void addCourse(Course course) {
		if(!courses.contains(course))
			courses.add(course);
		
	}
	
	public void removeCourse(Course course) {
		if(courses.contains(course))
			courses.remove(course);
	}
	
	
}