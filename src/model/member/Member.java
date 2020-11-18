package model.member;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import model.feed.Feed;


@Getter
@NoArgsConstructor
@Entity
public class Member {
	@Id
	@Column(length=50,nullable=false)
	private String id; //회원 아이디
	
	@Column(length=20, nullable = false)
	private String password;//회원 비밀 번호
	
	@Column(length=50,nullable=false)
	private String name; //회원 성함
	@Lob
	private String info;//회원 소개
	
	@OneToMany(mappedBy="memberId",fetch=FetchType.EAGER)
	private List<Feed> feeds;  //글목록
	
	@Builder
	public Member(String id, String password, String name, String info, List<Feed> feeds) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.info = info;
		this.feeds = feeds;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
}
