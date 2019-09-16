/*问题表的业务逻辑层*/

package service;

import java.util.Date;
import java.util.List;
import pojo.Question;

public interface QuestionService {
	public List<Question> queryAllQuestions();
	public int insertQuestion(String q_id,String title,String c_id,Date q_time,String type,String q_username);
	public List<Question> searchQuestion(String q_id,String title,String c_id,Date q_time,String type,String q_username);
	public int deleteQuestion(String q_id);
	public int updateQuestion(String q_id,String title,String c_id,Date q_time,String type,String q_username);
}
