/*�����Ǵ𰸱�Ļ�����������*/

package dao;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.Answer;

public interface AnswerDao {
	public List<Answer> queryAllAnswers();          //�Դ𰸱��ȫ��ѯ,�����ǶԴ𰸱������ɾ����(�����õ�������ѯ��ģ����ѯ)���ġ���������������
	public int insertAnswer(@Param("a_id")String a_id,@Param("q_id")String q_id,@Param("user_id")String user_id,@Param("content")String content,@Param("a_time")Date a_time,@Param("type")String type,@Param("picturepath")String picturepath);
	public List<Answer> searchAnswer(@Param("a_id")String a_id,@Param("q_id")String q_id,@Param("user_id")String user_id,@Param("content")String content,@Param("a_time")Date a_time,@Param("type")String type);
	public int updateAnswer(@Param("a_id")String a_id,@Param("q_id")String q_id,@Param("user_id")String user_id,@Param("content")String content,@Param("a_time")Date a_time,@Param("type")String type,@Param("picturepath")String picturepath);
	public int deleteAnswer(@Param("a_id")String a_id);
}
