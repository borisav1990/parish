package bp.adiutor.parish.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="patron")
public class Patron{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="patron_id")
	private Integer patronId;
	
	@Column(name="name")
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date celebration;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;
	
	@ManyToMany(mappedBy = "patrons")
	private List<Household> households;

	public Patron() {
	}
	
	public Patron(Integer patronId, String name, Date celebration, Date createdAt, Date updatedAt,
			List<Household> households) {
		super();
		this.patronId = patronId;
		this.name = name;
		this.celebration = celebration;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.households = households;
	}
	
	public Integer getPatronId() {
		return patronId;
	}

	public void setPatronId(Integer patronId) {
		this.patronId = patronId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCelebration() {
		return celebration;
	}

	public void setCelebration(Date celebration) {
		this.celebration = celebration;
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

	public List<Household> getHouseholds() {
		return households;
	}

	public void setHouseholds(List<Household> households) {
		this.households = households;
	}


}