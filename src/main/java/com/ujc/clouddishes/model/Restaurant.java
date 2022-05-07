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
	
	public Restaurant() {
		super();
	}

	
	public Restaurant(long id, String name, Province province, District district, Neighborhood neighborhood,
			String imageTitle, Integer openTime, Integer closeTime, LocalDateTime createTime, Long user_id) {
		super();
		this.id = id;
		this.name = name;
		setProvince(province);
		setDistrict(district);
		setNeighborhood(neighborhood);
		this.imageTitle = imageTitle;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.createTime = createTime;
		this.user_id = user_id;
	}
		

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, length = 100)
	private String name;

	private Integer province;

	private Integer district;

	private Integer neighborhood;

	@Column(nullable = false, length = 100)
	private String imageTitle;

	@Column(nullable = false)
	private Integer openTime;

	@Column(nullable = false)
	private Integer closeTime;

	@Column(nullable = false)
	private LocalDateTime createTime;
	
	//fk- é a criacao da foreign key como no mysql: user_id int
	@Column(nullable = false)
	private Long user_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;

	
	/*
		@OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
		private Set<Meal> meal;
	*/
	

	public Province getProvince() {
		return Province.valueOf(this.province);
	}

	public void setProvince(Province province) {

		if (province != null) {
			this.province = province.getCode();
		}

	}

	public District getDistrict() {
		return District.valueOf(this.district);
	}

	public void setDistrict(District district) {

		if (district != null) {
			this.district = district.getCode();
		}

	}
	
	public Neighborhood getNeighborhood() {
		return Neighborhood.valueOf(this.neighborhood);
	}

	public void setNeighborhood(Neighborhood neighborhood) {

		if (neighborhood != null) {
			this.neighborhood = neighborhood.getCode();
		}

	}
	

	

}
