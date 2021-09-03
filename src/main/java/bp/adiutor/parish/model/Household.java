package bp.adiutor.parish.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="household")
public class Household {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="household_id")
	private Integer householdId;
	
	@Column(name="doorway")
	private String doorway;
	
	@Column(name="floor")
	private String floor;

	@Column(name="apartment")
	private String apartment;
	
	@ManyToOne
	@JoinColumn(name="street_id")
	private Street street;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "household_patron", joinColumns = {@JoinColumn(name = "household_id", referencedColumnName = "household_id") }, 
	inverseJoinColumns = {@JoinColumn(name = "patron_id", referencedColumnName = "patron_id") })
	private List<Patron> patrons;
	
	@ManyToOne
	@JoinColumn(name="rectory_id")
	private Rectory rectory;
	
	@OneToMany(mappedBy="household")
	private List<Doing> doings;

	@OneToMany(mappedBy="household")
	private List<Person> persons;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;
	
	@Column(name="easter")
	private boolean easter;

	
	public Household() {
	}
	
	
	
	public Household(Integer householdId, String doorway, String floor, String apartment, Street street,
			List<Patron> patrons, Rectory rectory, List<Doing> doings, List<Person> persons, Date createdAt,
			Date updatedAt, boolean easter) {
		super();
		this.householdId = householdId;
		this.doorway = doorway;
		this.floor = floor;
		this.apartment = apartment;
		this.street = street;
		this.patrons = patrons;
		this.rectory = rectory;
		this.doings = doings;
		this.persons = persons;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.easter = easter;
	}



	public Integer getHouseholdId() {
		return householdId;
	}


	public void setHouseholdId(Integer householdId) {
		this.householdId = householdId;
	}


	public String getDoorway() {
		return doorway;
	}


	public void setDoorway(String doorway) {
		this.doorway = doorway;
	}


	public String getFloor() {
		return floor;
	}


	public void setFloor(String floor) {
		this.floor = floor;
	}


	public String getApartment() {
		return apartment;
	}


	public void setApartment(String apartment) {
		this.apartment = apartment;
	}


	public Street getStreet() {
		return street;
	}


	public void setStreet(Street street) {
		this.street = street;
	}

	public List<Patron> getPatrons() {
		return patrons;
	}

	public void setPatrons(List<Patron> patrons) {
		this.patrons = patrons;
	}



	public Rectory getRectory() {
		return rectory;
	}


	public void setRectory(Rectory rectory) {
		this.rectory = rectory;
	}


	public List<Doing> getDoings() {
		return doings;
	}


	public void setDoings(List<Doing> doings) {
		this.doings = doings;
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

	public boolean isEaster() {
		return easter;
	}


	public void setEaster(boolean easter) {
		this.easter = easter;
	}
}