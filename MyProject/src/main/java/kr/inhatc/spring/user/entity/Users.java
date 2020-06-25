package kr.inhatc.spring.user.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import kr.inhatc.spring.course.entity.Course;
import kr.inhatc.spring.lecture.entity.Lecture;
import kr.inhatc.spring.take.entity.Take;
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
	
	//forign key to course
	//mappedBy = "user" Course에 만들어 놓은 Users class로 만든 객체 명을 입력한다. 
	//@OneToMany(mappedBy = "user")
	@OneToMany(mappedBy = "user")//, fetch = FetchType.EAGER)
	private List<Course> course = new ArrayList<Course>();
	
	@OneToMany(mappedBy = "user")//, fetch = FetchType.EAGER)
	private List<Take> take = new ArrayList<Take>();
	
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
	
	public void addCourse(Course course) {
		//System.out.println("==========================================="+this);
		
		this.getCourse().add(course);
		course.setUser(this);
	}
	
	public void addTake(Take take) {
		this.getTake().add(take);
		take.setUser(this);
		
	}
}