package bp.adiutor.parish.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="person")
public class Person{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="person_id")
	private Integer personId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobile")
	private String mobile;
	
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	@Column(name="vocation")
	private String vocation;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_at")
	private Date updateAt;
	
	@ManyToOne
	@JoinColumn(name="household_id")
	private Household household;

	@ManyToOne
	@JoinColumn(name="kinship_id")
	private Kinship kinship;

	public Person() {
	}
	
	public Person(Integer personId, String firstName, String lastName, String email, String mobile, Date birthday,
			String vocation, Date createdAt, Date updateAt, Household household, Kinship kinship) {
		super();
		this.personId = personId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.birthday = birthday;
		this.vocation = vocation;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
		this.household = household;
		this.kinship = kinship;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getVocation() {
		return vocation;
	}

	public void setVocation(String vocation) {
		this.vocation = vocation;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Household getHousehold() {
		return household;
	}

	public void setHousehold(Household household) {
		this.household = household;
	}

	public Kinship getKinship() {
		return kinship;
	}

	public void setKinship(Kinship kinship) {
		this.kinship = kinship;
	}

	
	
}