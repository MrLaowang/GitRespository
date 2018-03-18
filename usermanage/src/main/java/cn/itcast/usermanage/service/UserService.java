package cn.itcast.usermanage.service;

import org.springframework.web.bind.annotation.RequestParam;

import cn.itcast.usermanage.domain.DatagridResult;
import cn.itcast.usermanage.domain.EasyUIResult;
import cn.itcast.usermanage.domain.User;

public interface UserService {

	public EasyUIResult findAll(Integer page, Integer rows);

	public void save(User model);

	public void updateUser(User user);

	public User findUserByUserId(Long id);

	public DatagridResult<User> queryListByPage(Integer page, Integer rows);

	public void deleteByIds(Long[] ids);
	
}
