package bp.adiutor.parish.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="city")
public class City implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="city_id")
	private Integer cityId;
	
	@Column(name="name")
	private String name;

	@OneToMany(mappedBy="city")
	@JsonIgnore
	private List<Street> streets;
    
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	public City() {
	}
	
	
	public City(Integer cityId, String name, List<Street> streets, Date createdAt, Date updatedAt) {
		super();
		this.cityId = cityId;
		this.name = name;
		this.streets = streets;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Street> getStreets() {
		return streets;
	}
	public void setStreets(List<Street> streets) {
		this.streets = streets;
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
	
	public Street addStreet(Street street) {
		getStreets().add(street);
		street.setCity(this);

		return street;
	}
    public Street removeStreet(Street street) {
		getStreets().remove(street);
		street.setCity(null);

		return street;
	}

}