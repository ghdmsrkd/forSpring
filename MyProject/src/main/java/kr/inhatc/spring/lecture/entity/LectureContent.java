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
		name="LECTURE_CONTENT_SEQ_GENERATOR",
		sequenceName="LECTURE_CONTENT_SEQ",
		initialValue = 1,
		allocationSize = 1
		)
@Table(name ="lecture_content")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LectureContent {
	// 주키 설정 자동 증가 long타입
	@Id
	@Column(name ="lec_content_id")
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, 
			generator = "LECTURE_CONTENT_SEQ_GENERATOR") 
	private Long lecContentId;
	
	// lecture와의 외래키	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="lec_id")
	private Lecture lecture;
		
	@Lob
	@Nationalized
	private String lecContent;
 
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false, updatable = true,columnDefinition = "date default sysdate")
	private Date updateDate;
	

}