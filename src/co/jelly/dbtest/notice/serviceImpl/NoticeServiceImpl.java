package co.jelly.dbtest.notice.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.jelly.dbtest.common.DAO;
import co.jelly.dbtest.notice.service.NoticeService;
import co.jelly.dbtest.notice.vo.NoticeVO;

public class NoticeServiceImpl extends DAO implements NoticeService {

	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<NoticeVO> noticeSelectList() {
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		NoticeVO vo;
		String sql = "select * from notice order by id";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new NoticeVO();
				vo.setId(rs.getInt("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWdate(rs.getDate("wdate"));
				vo.setHit(rs.getInt("hit"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		String sql = "select * from notice where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWdate(rs.getDate("wdate"));
				vo.setHit(rs.getInt("hit"));
				hitCount(vo.getId()); // 조회수 증가.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return vo;
	}

	@Override
	public int insertNotice(NoticeVO vo) {
		int n = 0;
		try {
			// 시퀀스 조회
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select notice_seq.nextval from dual");
			rs.next();
			int id = rs.getInt(1);
			vo.setId(id);
			//등록
			String sql = "insert into notice (id,title,content) values (?, ? ,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}

	@Override
	public int updateNotice(NoticeVO vo) {
		String sql = "update notice set content =? , title=? where id = ?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getContent());
			psmt.setString(2, vo.getTitle());
			psmt.setInt(3, vo.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int deleteNotice(NoticeVO vo) {
		String sql = "delete from notice where id = ?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void hitCount(int key) {
		String sql = "update notice set hit = hit+1 where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, key);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
