package com.app.core.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "package")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Package extends BaseEntity{
	
	@Column(name = "package_name")
	private String packageName;
	
	@Column(name = "package_price")
	private double packagePrice;
	
	@Column(name = "package_description",length = 70)
	private String packageDescription;
	

}
