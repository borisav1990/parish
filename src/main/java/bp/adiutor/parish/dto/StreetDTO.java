package bp.adiutor.parish.dto;

import javax.persistence.*;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class StreetDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer streetId;

	private String name;

	private String city;
	
	
	

	public StreetDTO() {
		super();
	}

	public StreetDTO(Integer streetId, String name, String city) {
		super();
		this.streetId = streetId;
		this.name = name;
		this.city = city;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	

}