/*����Ա���ҵ���߼���*/

package service;

import pojo.Manager;


public interface ManagerService {
	public Manager CheckLogin(String username,String password);
	public Manager CheckManagerExist(String username,String idnumber);
	public int managerfindpassword(String idnumber,String password);
	public Manager findByUsername(String username);
}
