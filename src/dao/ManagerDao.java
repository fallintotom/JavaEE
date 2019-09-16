/*以下是对管理员表的一些基本操作方法*/

package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Manager;

public interface ManagerDao {
	public Manager findByUsername(@Param("username")String username);         //用于检测管理员表是否有该用户
	public int managerfindpassword(@Param("idnumber")String idnumber,@Param("password")String password);
	//用于用户忘记密码时重置密码
}
