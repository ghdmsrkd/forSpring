package kr.inhatc.spring.take.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import kr.inhatc.spring.course.entity.Course;
import kr.inhatc.spring.lecture.entity.Lecture;
import kr.inhatc.spring.user.entity.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@SequenceGenerator(
		name="TAKE_SEQ_GENERATOR",
		sequenceName="TAKE_SEQ",
		initialValue = 1,
		allocationSize = 1
		)  
@Table(name ="take")
@NoArgsConstructor
@Data
public class Take {
	// primary key
	@Id
	@Column(name ="tak_id")
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, 
			generator = "TAKE_SEQ_GENERATOR") 
	private Long takId;
	
	// forign key to lecture
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="couId")
	private Course course;
	
	//LAZY(지연로딩) : 사용할 때 연관된 엔티티를 조회
	//EARGER(즉시로딩) : 연관된 엔티티를 즉시 조회
	
	// forign key to user
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id")
	private Users user;
 
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false, updatable = false,columnDefinition = "date default sysdate")
	private Date takeDate;
	
	
	
}
