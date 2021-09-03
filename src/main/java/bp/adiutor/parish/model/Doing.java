package bp.adiutor.parish.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="doings")
public class Doing {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="doings_id")
	private Integer doingsId;
	
	@Column(name="place")
	private String place;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reserved_at")
	private Date reservedAt;
	
	@ManyToOne
	@JoinColumn(name="deed_id")
	private Deed deed;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="household_id")
	private Household household;

	@ManyToOne
	@JoinColumn(name="rectory_id")
	private Rectory rectory;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	public Doing() {
	}

	public Doing(Integer doingsId, String place, Date reservedAt, Deed deed, String description, Household household,
			Rectory rectory, Date createdAt, Date updatedAt) {
		super();
		this.doingsId = doingsId;
		this.place = place;
		this.reservedAt = reservedAt;
		this.deed = deed;
		this.description = description;
		this.household = household;
		this.rectory = rectory;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getDoingsId() {
		return doingsId;
	}

	public void setDoingsId(Integer doingsId) {
		this.doingsId = doingsId;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getReservedAt() {
		return reservedAt;
	}

	public void setReservedAt(Date reservedAt) {
		this.reservedAt = reservedAt;
	}

	public Deed getDeed() {
		return deed;
	}

	public void setDeed(Deed deed) {
		this.deed = deed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Household getHousehold() {
		return household;
	}

	public void setHousehold(Household household) {
		this.household = household;
	}

	public Rectory getRectory() {
		return rectory;
	}

	public void setRectory(Rectory rectory) {
		this.rectory = rectory;
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