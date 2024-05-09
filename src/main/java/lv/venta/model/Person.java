package lv.venta.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@MappedSuperclass
public class Person {
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
