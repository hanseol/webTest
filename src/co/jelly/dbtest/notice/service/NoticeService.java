package co.jelly.dbtest.notice.service;

import java.util.List;

import co.jelly.dbtest.notice.vo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> noticeSelectList();
	NoticeVO noticeSelect(NoticeVO vo);
	int insertNotice(NoticeVO vo);
	int updateNotice(NoticeVO vo);
	int deleteNotice(NoticeVO vo);
	
}
