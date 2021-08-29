package bp.adiutor.parish.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@JsonIgnoreType
public class User{
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	@Column(name="first_name")
    private String firstName;
	
	@Column(name="last_name")
    private String lastName;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@ManyToOne
	@JoinColumn(name="church_id")
	private Church church;
	
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<Rectory> rectory;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;
    
    @ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "user_role", joinColumns = {
			@JoinColumn(name = "USER_ID", referencedColumnName = "user_id") }, inverseJoinColumns = {
					@JoinColumn(name = "ROLE_ID", referencedColumnName = "role_id") })
	private List<Role> roles;

	public User(Integer userId, String firstName, String lastName, String mobile, String email, String password,
			Church church, List<Rectory> rectory, Date createdAt, Date updatedAt, List<Role> roles) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.church = church;
		this.rectory = rectory;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.roles = roles;
	}

	public User() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Church getChurch() {
		return church;
	}

	public void setChurch(Church church) {
		this.church = church;
	}

	public List<Rectory> getRectory() {
		return rectory;
	}

	public void setRectories(List<Rectory> rectory) {
		this.rectory = rectory;
	}
	
	
	

	





}