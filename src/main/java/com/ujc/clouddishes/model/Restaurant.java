package com.ujc.clouddishes.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ujc.clouddishes.model.enums.District;
import com.ujc.clouddishes.model.enums.Neighborhood;
import com.ujc.clouddishes.model.enums.Province;

import lombok.Data;

@Data
@Entity
@Table(name = "restaurant")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Restaurant {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String name;

	private Integer province;

	private Integer district;

	private Integer neighborhood;
	
	private String email;
	
	private String phone;

	@Column(nullable = false)
	private Integer openTime;

	@Column(nullable = false)
	private Integer closeTime;

	@Column(nullable = false)
	private LocalDateTime createTime;

	
	@Column(name = "user_id", nullable = false)
	private Long user_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;
	
	
	@Column(length = 100)
	private String imageName;
	
	@Column
	private String imageUrl;

	
	public Restaurant() {
		super();
	}

	
	public Restaurant(long id, String name, Integer province, Integer district, Integer neighborhood,
			String email, String phone, Integer openTime, Integer closeTime, LocalDateTime createTime, Long user_id) {
		super();
		this.id = id;
		this.name = name;
		this.province = province;
		this.district = district;
		this.neighborhood = neighborhood;
		this.email = email;
		this.phone = phone;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.createTime = createTime;
		this.user_id = user_id;
	}

	public Province getProvince() {
		return Province.valueOf(this.province);
	}



	public District getDistrict() {
		return District.valueOf(this.district);
	}



	
	public Neighborhood getNeighborhood() {
		return Neighborhood.valueOf(this.neighborhood);
	}



	

}
