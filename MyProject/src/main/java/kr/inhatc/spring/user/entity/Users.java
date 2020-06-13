package kr.inhatc.spring.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="users")
@NoArgsConstructor
@Data
public class Users {
	@Id
	@Column(name ="USER_ID")
	private String id;
	private String pw;
	private String name;
	private String email;
	
	private String school;
	private String department;
	private String grade;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
	private Date joinDate;
	
	@Column(insertable = false, columnDefinition = "char(1) default 'Y'")
	private String enabled;
	private String role;
	
	
	
}