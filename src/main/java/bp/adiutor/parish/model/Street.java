package bp.adiutor.parish.model;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="street")
public class Street implements Serializable{
    
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="street_id")
	private Integer streetId;
	
	@Column(name="name")
	private String name;
	
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="rectory_id")
	private Rectory rectory;
	
	@JsonIgnore
	@OneToMany(mappedBy="street")
	private List<Household> households;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name="created_at" , nullable = false, updatable = false)
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name="updated_at")
	private Date updatedAt;

	public Street() {
	}
	
	public Street(Integer streetId, String name, City city, Rectory rectory, List<Household> households, Date createdAt,
			Date updatedAt) {
		super();
		this.streetId = streetId;
		this.name = name;
		this.city = city;
		this.rectory = rectory;
		this.households = households;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getStreetId() {
		return streetId;
	}

	public void setStreetId(Integer streetId) {
		this.streetId = streetId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	public Rectory getRectory() {
		return rectory;
	}

	public void setRectory(Rectory rectory) {
		this.rectory = rectory;
	}

	public List<Household> getHouseholds() {
		return households;
	}

	public void setHouseholds(List<Household> households) {
		this.households = households;
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

	public Household addHousehold(Household household) {
		getHouseholds().add(household);
		household.setStreet(this);

		return household;
	}

	public Household removeHousehold(Household household) {
		getHouseholds().remove(household);
		household.setStreet(null);

		return household;
	}

}