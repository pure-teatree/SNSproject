package model.feed;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import model.member.Member;
@Getter
@NoArgsConstructor
@ToString
@NamedQuery(query="select f from Feed f order by f.fno desc", name="Feed.allList")
@Entity
public class Feed {
	@Id
	@GeneratedValue(generator="Feed_id_gen")
	@SequenceGenerator(name="Feed_id_gen", sequenceName="Feed_id_seq", allocationSize=1)
	private int fno;						// 글 번호
	@Lob
	private String content;				// 글 내용
	@Temporal(TemporalType.DATE)
	@Column(nullable =false)
	private Date writeday;			//작성일 
	
	@Column(length=10, nullable = false)
	private int thumbUp;			//좋아요
	
	
	@ManyToOne
	@JoinColumn(name="memberId")
	private Member memberId;		//Member id참조

	@Builder
	public Feed(String content, Date writeday, int thumbUp, Member memberId) {
		super();
		this.content = content;
		this.writeday = writeday;
		this.thumbUp = thumbUp;
		this.memberId = memberId;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setWriteday(Date writeday) {
		this.writeday = writeday;
	}


	public void setMember(Member memberId) {
		this.memberId = memberId;
	}

	public void setThumbUp(int thumbUp) {
		this.thumbUp = thumbUp;
	}
	
	
	
}
