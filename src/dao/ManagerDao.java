/*�����ǶԹ���Ա���һЩ������������*/

package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Manager;

public interface ManagerDao {
	public Manager findByUsername(@Param("username")String username);         //���ڼ�����Ա���Ƿ��и��û�
	public int managerfindpassword(@Param("idnumber")String idnumber,@Param("password")String password);
	//�����û���������ʱ��������
}
