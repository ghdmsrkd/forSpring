package kr.inhatc.spring.course.entity;

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

import kr.inhatc.spring.lecture.entity.Lecture;
import kr.inhatc.spring.take.entity.Take;
import kr.inhatc.spring.user.entity.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@SequenceGenerator(
		name="COURSE_SEQ_GENERATOR",
		sequenceName="COURSE_SEQ",
		initialValue = 1,
		allocationSize = 1
		)  
@Table(name ="course")
@NoArgsConstructor
@Data
public class Course {
	// primary key
	@Id
	@Column(name ="cou_id")
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, 
			generator = "COURSE_SEQ_GENERATOR") 
	private Long couId;
	
	// forign key to lecture
	@OneToMany(mappedBy = "course")//, fetch = FetchType.EAGER)
	//@OneToMany(mappedBy = "course")
	private List<Lecture> lecture = new ArrayList<Lecture>();
	
	//LAZY(지연로딩) : 사용할 때 연관된 엔티티를 조회
	//EARGER(즉시로딩) : 연관된 엔티티를 즉시 조회
	
	// forign key to user
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id")
	private Users user;
	
	@OneToMany(mappedBy = "course"  )
	List<Take> take = new ArrayList<Take>();
	
	private String couTitle;
	private String couOutline;
 
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false, updatable = false,columnDefinition = "date default sysdate")
	private Date couResgistDate;
	
	public void addLecture(Lecture lecture) {
		//System.out.println("==========================================="+this);
		
		getLecture().add(lecture);
		lecture.setCourse(this);
	}
	
	public void addTake(Take take) {
		getTake().add(take);
		take.setCourse(this);
	}
	
	
	
	
}