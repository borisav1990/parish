package bp.adiutor.parish.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="rectory")
public class Rectory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rectory_id")
	private Integer rectoryId;
	
	@Column(name="rectory_name")
	private String rectoryName;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	public Rectory() {
		super();
	}

	public Rectory(Integer rectoryId, String rectoryName, User user, Date createdAt, Date updatedAt) {
		super();
		this.rectoryId = rectoryId;
		this.rectoryName = rectoryName;
		this.user = user;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getRectoryId() {
		return rectoryId;
	}

	public void setRectoryId(Integer rectoryId) {
		this.rectoryId = rectoryId;
	}

	public String getRectoryName() {
		return rectoryName;
	}

	public void setRectoryName(String rectoryName) {
		this.rectoryName = rectoryName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
