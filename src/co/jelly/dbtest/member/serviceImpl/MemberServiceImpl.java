package co.jelly.dbtest.member.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.jelly.dbtest.common.DAO;
import co.jelly.dbtest.member.service.MemberService;
import co.jelly.dbtest.member.vo.MemberVO;

public class MemberServiceImpl extends DAO implements MemberService {
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<MemberVO> selectMemberList() {
		return null;
	}

	@Override
	public MemberVO selectMember(MemberVO vo) {
		return null;
	}

	@Override
	public int insertMember(MemberVO vo) {
		String sql = "insert into member values (?,?,?,?)";
		int n=0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());
			psmt.setString(3, vo.getMemberName());
			psmt.setString(4, vo.getMemberAddress());
			n=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}

	@Override
	public int updateMember(MemberVO vo) {
		return 0;
	}

	@Override
	public int deleteMember(MemberVO vo) {
		return 0;
	}

	@Override
	public MemberVO loginCheck(MemberVO vo) {
		String sql = "select * from member where memberid=? and memberpassword=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberAddress(rs.getString("memberaddress"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	public boolean idCheck(String id) {
		boolean isId = false;
		
		String sql = "select memberid from member where memberid =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				isId = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return isId;
	}
	private void close() {
		try {
			if (rs != null) rs.close();
			if (psmt != null) psmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
