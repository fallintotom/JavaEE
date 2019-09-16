/*业务逻辑层管理员表的继承实现类*/

package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.ManagerDao;
import pojo.Manager;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	ManagerDao managerDao;
	@Override
	public Manager CheckLogin(String username, String password) {
		// TODO Auto-generated method stub
		Manager manager=managerDao.findByUsername(username);
		if(manager!=null && manager.getPassword().equals(password)){
			return manager;
		}
		return null;
	}
	@Override
	public Manager CheckManagerExist(String username, String idnumber) {
		// TODO Auto-generated method stub
		Manager manager=managerDao.findByUsername(username);
		if(manager != null && manager.getIdnumber().equals(idnumber)){	
			return manager;
		}
		return null;
	}
	@Override
	public int managerfindpassword(String idnumber, String password) {
		// TODO Auto-generated method stub
		return managerDao.managerfindpassword(idnumber, password);
	}
	@Override
	public Manager findByUsername(String username) {
		// TODO Auto-generated method stub
		Manager manager=managerDao.findByUsername(username);
		if(manager != null){	
			return manager;
		}
		return null;
	}
}
