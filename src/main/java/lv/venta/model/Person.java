package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "PersonTable")
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)//no katras kalses veidojas sava tabula, bet bazes tabula ir tukša
//@Inheritance(strategy = InheritanceType.JOINED)//viedojas 3 tabulas, Personas dati būs personas tabulā, bet Profesora individuāli dati būs profesoru tabula ar id uz personas tabulas. tapat ar Student
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//visi bērnu dati galbājāš bāzes tabulā
public class Person {
	@Column(name="Idpe")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idpe;
	
	@Column(name = "Name")
	@NotNull
	@Size(min = 2, max = 20)
	@Pattern(regexp = "[A-Z]{1}[a-z]+") //TODO nokopēt no cita seminaŗa ar mīkstinajumiem un garumzīmem
	private String name;
	
	@Column(name = "Surname")
	@NotNull
	@Size(min = 2, max = 40)
	@Pattern(regexp = "[A-Z]{1}[a-z]+") //TODO nokopēt no cita seminaŗa ar mīkstinajumiem un garumzīmem
	private String surname;
	
	public Person(String name, String surname) {
		setName(name);
		setSurname(surname);
	}
	
	
	
}