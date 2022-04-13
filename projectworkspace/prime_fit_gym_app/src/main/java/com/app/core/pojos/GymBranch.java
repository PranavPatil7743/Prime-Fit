package com.app.core.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gym_branch")
public class GymBranch extends BaseEntity{

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int branchId;
	
	@Column(name = "branch_name")
	private String branchName;
	
	@Column(length = 20)
	private String locality;
	
	@Column(length = 20)
	private String city;
	
	@Column(length = 20)
	private String state;
	
	@Column(length = 10)
	private int zipCode;
	
	@Column(length = 20)
    private int phone;

//	@JsonIgnore
//	@OneToMany(mappedBy = "branch", cascade = CascadeType.ALL,orphanRemoval = true)
//	private List<User> users=new ArrayList<>();
//	
//	@JsonIgnore
//	@OneToMany(mappedBy = "branch" ,cascade = CascadeType.ALL,orphanRemoval = true)
//	private List<Batch> batches=new ArrayList<>();
//
//	public void addUser(User u) {
//		users.add(u);
//		u.setBranch(this);
//	}
//	
//	public void removeUser(User u) {
//		users.remove(u);
//		u.setBranch(null);
//	}
//	
//	public void addBatch(Batch b) {
//		batches.add(b);
//		b.setBranch(this);
//	}
//	
//	public void removeBatch(Batch b) {
//		batches.remove(b);
//		b.setBranch(null);
//	}

}
