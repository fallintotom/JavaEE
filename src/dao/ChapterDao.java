/*以下是对章节表的基本操作方法*/

package dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.Chapter;

public interface ChapterDao {
	public List<Chapter> queryAllChapters();      //对章节表的全查询
	public int updatechapter(@Param("c_id")String c_id,@Param("c_name")String c_name);
	public int deletechapter(@Param("c_id")String c_id);
	public List<Chapter> searchchapter(@Param("c_name")String c_name);
	public int insertchapter(@Param("c_id")String c_id,@Param("c_name")String c_name);
}
