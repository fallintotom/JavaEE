/*章节表的业务逻辑层*/

package service;

import java.util.List;
import pojo.Chapter;

public interface ChapterService {
	public List<Chapter> queryAllChapters();
	public int updatechapter(String c_id,String c_name);
	public int deletechapter(String c_id);
	public List<Chapter> searchchapter(String c_name);
	public int insertchapter(String c_id,String c_name);
}
