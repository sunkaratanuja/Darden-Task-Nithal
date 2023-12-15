package com.example.staffpoc.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "project")
public class ProjectDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "staff_id", insertable = false, updatable = false, nullable = false)
    private StaffDetails staff;

	public ProjectDetails() {
		super();
	}

	public ProjectDetails(Long id, String name, StaffDetails staff) {
		super();
		this.id = id;
		this.name = name;
		this.staff = staff;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StaffDetails getStaff() {
		return staff;
	}

	public void setStaff(StaffDetails staff) {
		this.staff = staff;
	}
    
}
//@JoinColumn(name = "staff_id", insertable = false, updatable = false, nullable = false) specifies a database join column named "staff_id" in the "project" table, which references the primary key of the associated "staff" table. The options insertable = false and updatable = false indicate that the column is read-only, not included in SQL INSERT and UPDATE statements. nullable = false marks the column as non-nullable.






