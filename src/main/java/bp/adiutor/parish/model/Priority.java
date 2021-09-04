package bp.adiutor.parish.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="priority")
public class Priority {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="priority_id")
	private Integer priorityId;
	
	@Column(name="name")
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;
	
	@OneToMany(mappedBy="priority")
	private List<Household> households;
	
	public Priority() {
		super();
	}
	
	public Priority(Integer priorityId, String name, Date createdAt, Date updatedAt, List<Household> households) {
		super();
		this.priorityId = priorityId;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.households = households;
	}
    
	public Integer getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(Integer priorityId) {
		this.priorityId = priorityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
