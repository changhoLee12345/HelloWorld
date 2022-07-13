package com.edu;

import java.util.ArrayList;
import java.util.List;

public class MemberApp implements MemberService {

	List<Member> members = new ArrayList<Member>();

	public void execute() {
		// 메뉴: 1.등록 2.수정 3.전체리스트 9.종료
		// 1)도서반=>기본정보+도서반장,강의실이름
		// 축구반=>기본정보+코치이름,락커룸이름
		// 수영반=>기본정보+강사이름,수영등급
	}

	@Override
	public void addMember(Member member) {

	}

	@Override
	public void modifyMember(Member member) {

	}

	@Override
	public List<Member> memberList() {

		return null;
	}
}
