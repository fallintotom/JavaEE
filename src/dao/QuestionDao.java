/*以下是对问题表的基本操作方法声明*/

package dao;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.Question;

public interface QuestionDao {
	public List<Question> queryAllQuestions();//以下方法是针对问题表的增、删、查、改操作。
	public int insertQuestion(@Param("q_id")String q_id,@Param("title")String title,@Param("c_id")String c_id,@Param("q_time")Date q_time,@Param("type")String type,@Param("q_username")String q_username);
	public List<Question> searchQuestion(@Param("q_id")String q_id,@Param("title")String title,@Param("c_id")String c_id,@Param("q_time")Date q_time,@Param("type")String type,@Param("q_username")String q_username);
	public int deleteQuestion(@Param("q_id")String q_id);
	public int updateQuestion(@Param("q_id")String q_id,@Param("title")String title,@Param("c_id")String c_id,@Param("q_time")Date q_time,@Param("type")String type,@Param("q_username")String q_username);
}
