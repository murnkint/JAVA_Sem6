package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "GradeTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Grade {
	@Column(name="IdG")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idG;
	
	@Min(0)
	@Max(10)
	@Column(name="Grvalue")
	private int grvalue;
	
	
	@ManyToOne
	@JoinColumn(name="IdC")
	private Course course;
	
	@ManyToOne
	@JoinColumn(name="IdS")
	private Student student;
	
	public Grade(Student student, Course course, int grvalue)
	{
		setStudent(student);
		setCourse(course);
		setGrvalue(grvalue);
	}
	
	//TODO
	//1. uztaisīt saiti starp Grade un Student
	//2. uztaisīt konstruktoru
	//3. uzlikt @ToSTring.Exclude 
	//4. izveidot katrai modeļu klasei savu repo
	//5. izveidot CommandLineRunner funkciju, 
	//kura pārbaudīt visu tabulu izveidi
	
	
	
	
	
}