/*业务逻辑层问题表的继承实现类*/

package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.QuestionDao;
import pojo.Question;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	QuestionDao questionDao;
	@Override
	public List<Question> queryAllQuestions() {
		// TODO Auto-generated method stub
		return questionDao.queryAllQuestions();
	}

	@Override
	public int insertQuestion(String q_id, String title, String c_id, Date q_time,String type,String q_username) {
		// TODO Auto-generated method stub
		return questionDao.insertQuestion(q_id, title, c_id,q_time, type,q_username);
	}

	@Override
	public List<Question> searchQuestion(String q_id, String title, String c_id, Date q_time,String type,String q_username) {
		// TODO Auto-generated method stub
		return questionDao.searchQuestion(q_id, title, c_id, q_time,type,q_username);
	}

	@Override
	public int deleteQuestion(String q_id) {
		// TODO Auto-generated method stub
		return questionDao.deleteQuestion(q_id);
	}

	@Override
	public int updateQuestion(String q_id, String title, String c_id, Date q_time, String type,String q_username) {
		// TODO Auto-generated method stub
		return questionDao.updateQuestion(q_id, title, c_id, q_time, type,q_username);
	}

}
