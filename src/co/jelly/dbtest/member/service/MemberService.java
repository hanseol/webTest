package co.jelly.dbtest.member.service;

import java.util.List;

import co.jelly.dbtest.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> selectMemberList();
	MemberVO selectMember(MemberVO vo);
	public int insertMember(MemberVO vo);
	public int updateMember(MemberVO vo);
	public int deleteMember(MemberVO vo);
	public MemberVO loginCheck(MemberVO vo);
//	MemberVO loginCheck(MemberVO vo); //로그인 성공시 다른 값을 나타낼 때
//	boolean loginChech(String id, String pw); //존재 유무만 확인
//	protected : 내 패키지 내에서만 사용. 
}
