/*业务逻辑层答案表的继承实现类*/

package service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.AnswerDao;
import pojo.Answer;

@Service
public class AnswerServiceImpl implements AnswerService {
	@Autowired
	AnswerDao answerDao;
	@Override
	public List<Answer> queryAllAnswers() {
		// TODO Auto-generated method stub
		return answerDao.queryAllAnswers();
	}

	@Override
	public int insertAnswer(String a_id, String q_id, String user_id, String content, Date a_time,String type,String picturepath) {
		// TODO Auto-generated method stub
		return answerDao.insertAnswer(a_id, q_id, user_id, content, a_time,type,picturepath);
	}

	@Override
	public List<Answer> searchAnswer(String a_id, String q_id, String user_id, String content, Date a_time,String type) {
		// TODO Auto-generated method stub
		return answerDao.searchAnswer(a_id, q_id, user_id, content, a_time,type);
	}

	@Override
	public int updateAnswer(String a_id, String q_id, String user_id, String content, Date a_time, String type,String picturepath) {
		// TODO Auto-generated method stub
		return answerDao.updateAnswer(a_id, q_id, user_id, content, a_time, type,picturepath);
	}

	@Override
	public int deleteAnswer(String a_id) {
		// TODO Auto-generated method stub
		return answerDao.deleteAnswer(a_id);
	}

}
