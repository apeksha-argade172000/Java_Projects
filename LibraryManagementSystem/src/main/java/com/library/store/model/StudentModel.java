package com.library.store.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "student")
public class StudentModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "s_Id")
	private Integer sid;

	@Column(name = "s_Name")
	private String sname;

	@Column(name = "s_Branch")
	private String sbranch;

	@Column(name = "s_Address")
	private String saddress;

	@Column(name = "s_Contact")
	private Long scontact;

	@Column(name = "s_Email")
	private String semail;


}

