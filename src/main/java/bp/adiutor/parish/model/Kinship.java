package bp.adiutor.parish.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="kinship")
public class Kinship {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="kinship_id")
	private Integer kinshipId;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="kinship")
	private List<Person> persons;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	public Kinship() {
	}
	
	public Kinship(Integer kinshipId, String name, List<Person> persons, Date createdAt, Date updatedAt) {
		super();
		this.kinshipId = kinshipId;
		this.name = name;
		this.persons = persons;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	
	public Integer getKinshipId() {
		return kinshipId;
	}

	public void setKinshipId(Integer kinshipId) {
		this.kinshipId = kinshipId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setKinship(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setKinship(null);

		return person;
	}

}