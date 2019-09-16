/*答案表的业务逻辑层*/

package service;

import java.util.Date;
import java.util.List;
import pojo.Answer;

public interface AnswerService {
	public List<Answer> queryAllAnswers();
	public int insertAnswer(String a_id,String q_id,String user_id,String content,Date a_time,String type,String picturepath);
	public List<Answer> searchAnswer(String a_id,String q_id,String user_id,String content,Date a_time,String type);
	public int updateAnswer(String a_id,String q_id,String user_id,String content,Date a_time,String type,String picturepath);
	public int deleteAnswer(String a_id);
}
