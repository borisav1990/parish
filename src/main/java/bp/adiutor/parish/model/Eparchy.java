package bp.adiutor.parish.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.Date;
import java.util.List;

@Entity
@Table(name="eparchy")
public class Eparchy {
	
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="eparchy_id")
	private Integer eparchyId;
	
	@Column(name="name")
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@OneToMany(mappedBy="eparchy")
	@JsonIgnore
	private List<Church> churches;

	public Eparchy(Integer eparchyId, String name, Date createdAt, Date updatedAt, List<Church> churches) {
		super();
		this.eparchyId = eparchyId;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.churches = churches;
	}

	public Eparchy() {
	}

	public Integer getEparchyId() {
		return eparchyId;
	}

	public void setEparchyId(Integer eparchyId) {
		this.eparchyId = eparchyId;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Church> getChurches() {
		return this.churches;
	}

	public void setChurches(List<Church> churches) {
		this.churches = churches;
	}

	public Church addChurch(Church church) {
		getChurches().add(church);
		church.setEparchy(this);
        return church;
	}

	public Church removeChurch(Church church) {
		getChurches().remove(church);
		church.setEparchy(null);
		return church;
	}

}