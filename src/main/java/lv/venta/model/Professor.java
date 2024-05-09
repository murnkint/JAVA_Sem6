package lv.venta.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

//TODO
//izveidot personas kalsi ar vārdu un uzvardu
//papaildinat ar vajadzīgam anotācijam
//stuednts klasi mantot no sis personas kalses
//propfesora klasi mantot no šis klases
//apskjatīties apmacibu par mantosanu ar Spring

@Table(name = "ProfessorTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Professor extends Person {
	
	@Column(name = "Degree")
	@NotNull
	private Degree degree;
	
	//gadījums, kad Profesoram dŗīkst būt tikai viens kurss
	@OneToOne(mappedBy = "professor")
	@ToString.Exclude
	private Course course;
	

	
	public Professor(String name, String surname, Degree degree) {
		super(name, surname);
		setDegree(degree);
	}
}