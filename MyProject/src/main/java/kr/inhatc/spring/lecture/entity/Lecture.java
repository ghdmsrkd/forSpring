package kr.inhatc.spring.lecture.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Nationalized;

import kr.inhatc.spring.course.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@SequenceGenerator(
		name="LECTURE_SEQ_GENERATOR",
		sequenceName="LECTURE_SEQ",
		initialValue = 1,
		allocationSize = 1
		)
@Table(name ="lecture")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Lecture {
	// 주키 설정 자동 증가 long타입
	@Id
	@Column(name ="lec_id")
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, 
			generator = "LECTURE_SEQ_GENERATOR") 
	private Long lecId;
	
	//	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cou_id")
	private Course course;
	
	@OneToOne
	private LectureContent lectureContent;
	
	private String lecTitle;
	
	// 강의 리스트 불러올때 강의 내용이 너무 커서 로딩이 거림
	// 테이블을 두개로 나누어 해결헌더.
//	@Lob
//	@Nationalized
//	private String lecContent;
 
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false, updatable = false,columnDefinition = "date default sysdate")
	private Date joinDate;
	
	public void addLectureContent(LectureContent lectureContent) {
		//System.out.println("==========================================="+this);		
		addLectureContent(lectureContent);
	}
	
	public Lecture(Long lecId, Course course, String lecTitle, Date joinDate) {
		this.lecId = lecId;
		this.course = course;
		this.lecTitle = lecTitle;
		this.joinDate = joinDate;
	}
}
