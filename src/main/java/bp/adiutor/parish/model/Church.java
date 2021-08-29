package bp.adiutor.parish.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.Date;
import java.util.List;

@Entity
@Table(name="church")
public class Church{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="church_id")
	private Integer churchId;
	
	@Column(name="saint")
	private String saint;
	
	@ManyToOne
	@JoinColumn(name="eparchy_id")
	private Eparchy eparchy;

	@OneToMany(mappedBy="church")
	@JsonIgnore
	private List<User> users;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	

	public Church() {
		super();
	}

	public Church(Integer churchId, String saint, Eparchy eparchy, List<User> users, Date createdAt, Date updatedAt) {
		super();
		this.churchId = churchId;
		this.saint = saint;
		this.eparchy = eparchy;
		this.users = users;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getChurchId() {
		return churchId;
	}

	public void setChurchId(Integer churchId) {
		this.churchId = churchId;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getSaint() {
		return this.saint;
	}

	public void setSaint(String saint) {
		this.saint = saint;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Eparchy getEparchy() {
		return this.eparchy;
	}

	public void setEparchy(Eparchy eparchy) {
		this.eparchy = eparchy;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setChurch(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setChurch(null);

		return user;
	}

}