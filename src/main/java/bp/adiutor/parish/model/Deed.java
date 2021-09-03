package bp.adiutor.parish.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="deed")
public class Deed {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="deed_id")
	private Integer deedId;

	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="deed")
	private List<Doing> doings;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;
    
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	public Deed() {
	}

	public Deed(Integer deedId, String name, List<Doing> doings, Date createdAt, Date updatedAt) {
		super();
		this.deedId = deedId;
		this.name = name;
		this.doings = doings;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getDeedId() {
		return deedId;
	}

	public void setDeedId(Integer deedId) {
		this.deedId = deedId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Doing> getDoings() {
		return doings;
	}

	public void setDoings(List<Doing> doings) {
		this.doings = doings;
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
	
	
	

	

}