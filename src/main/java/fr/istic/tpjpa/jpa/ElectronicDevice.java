package fr.istic.tpjpa.jpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("ElectronicDevice")
public class ElectronicDevice extends Peripherique{
	//private int id;
	private Long conso;
	private Person person;
	
	public ElectronicDevice(){}

	public ElectronicDevice(Long conso, Person person) {
		super(conso);
		this.person=person;
	}

	/*@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}*/

	public Long getConso() {
		return conso;
	}

	public void setConso(Long conso) {
		this.conso = conso;
	}
	
	@ManyToOne
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public String toString() {
		return "ElectronicDevice [conso=" + conso + "]";
	}
}
