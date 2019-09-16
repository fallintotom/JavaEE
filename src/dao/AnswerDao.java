/*以下是答案表的基本操作方法*/

package dao;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.Answer;

public interface AnswerDao {
	public List<Answer> queryAllAnswers();          //对答案表的全查询,以下是对答案表的增、删、查(这里用到条件查询和模糊查询)、改、操作方法声明。
	public int insertAnswer(@Param("a_id")String a_id,@Param("q_id")String q_id,@Param("user_id")String user_id,@Param("content")String content,@Param("a_time")Date a_time,@Param("type")String type,@Param("picturepath")String picturepath);
	public List<Answer> searchAnswer(@Param("a_id")String a_id,@Param("q_id")String q_id,@Param("user_id")String user_id,@Param("content")String content,@Param("a_time")Date a_time,@Param("type")String type);
	public int updateAnswer(@Param("a_id")String a_id,@Param("q_id")String q_id,@Param("user_id")String user_id,@Param("content")String content,@Param("a_time")Date a_time,@Param("type")String type,@Param("picturepath")String picturepath);
	public int deleteAnswer(@Param("a_id")String a_id);
}
