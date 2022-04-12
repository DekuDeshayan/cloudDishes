package com.ujc.clouddishes.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ujc.clouddishes.model.enums.District;
import com.ujc.clouddishes.model.enums.Neighborhood;
import com.ujc.clouddishes.model.enums.Province;

import lombok.Data;

@Data
@Entity
@Table(name = "restaurant")
public class Restaurant {

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
	private LocalDateTime creatTime;

	@OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
	private Set<Order> order;

	@OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
	private Set<Reservation> reservation;

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

	public Restaurant(long id, String name, Province province, District district, Neighborhood neighborhood,
			String imageTitle, Integer openTime, Integer closeTime, LocalDateTime creatTime) {
		super();
		this.id = id;
		this.name = name;
		setProvince(province);
		setDistrict(district);
		setNeighborhood(neighborhood);
		this.imageTitle = imageTitle;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.creatTime = creatTime;
	}

	public Restaurant() {
		super();
	}

}
