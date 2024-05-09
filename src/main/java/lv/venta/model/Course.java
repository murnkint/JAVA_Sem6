package lv.venta.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "CourseTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {
	@Column(name="IdC")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idC;
	
	@NotNull
	@Size(min = 4, max = 50)
	@Pattern(regexp = "[A-Za-z ]+") //TODO nokopēt no cita seminaŗa ar mīkstinajumiem un garumzīmem
	@Column(name="Title")
	private String title;
	
	@Min(0)
	@Max(20)
	@Column(name="Cp")
	private int cp;
	
	//gadījums, ka vienu kursu var pasniegt vairāk kā viens professors
	@ManyToMany
	@JoinTable(name = "CourseProfessorLinkageTable",
	joinColumns = @JoinColumn(name = "IdC"),
	inverseJoinColumns = @JoinColumn(name = "IdP"))
	private Collection<Professor> professors = new ArrayList<>();
	
	@OneToMany(mappedBy = "course")
	@ToString.Exclude
	private Collection<Grade> grades;
	

	public Course(String title, int cp, Professor ... professors) {
		setTitle(title);
		setCp(cp);
		
		for(Professor tempP: professors)
			addProfessor(tempP);
	}
	
	
	public void addProfessor(Professor professor) {
		if(!professors.contains(professor))
			professors.add(professor);
	}
	
	public void removeProfessor(Professor professor) {
		if(professors.contains(professor))
			professors.remove(professor);
	}
	
	
	
	
	
	
	
	
	
}