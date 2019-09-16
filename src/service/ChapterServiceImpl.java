/*业务逻辑层章节表的继承实现类*/
package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.ChapterDao;
import pojo.Chapter;

@Service
public class ChapterServiceImpl implements ChapterService {
	@Autowired
    ChapterDao chapterDao;
	@Override
	public List<Chapter> queryAllChapters() {
		// TODO Auto-generated method stub
		return chapterDao.queryAllChapters();
	}
	@Override
	public int updatechapter(String c_id, String c_name) {
		// TODO Auto-generated method stub
		return chapterDao.updatechapter(c_id, c_name);
	}
	@Override
	public int deletechapter(String c_id) {
		// TODO Auto-generated method stub
		return chapterDao.deletechapter(c_id);
	}
	@Override
	public List<Chapter> searchchapter(String c_name) {
		// TODO Auto-generated method stub
		return chapterDao.searchchapter(c_name);
	}
	@Override
	public int insertchapter(String c_id, String c_name) {
		// TODO Auto-generated method stub
		return chapterDao.insertchapter(c_id, c_name);
	}

}
