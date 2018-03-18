package cn.itcast.usermanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.itcast.usermanage.domain.DatagridResult;
import cn.itcast.usermanage.domain.EasyUIResult;
import cn.itcast.usermanage.domain.User;
import cn.itcast.usermanage.mapper.UserMapper;
import cn.itcast.usermanage.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public EasyUIResult findAll(Integer page, Integer rows) {
		//设置分页参数
		PageHelper.startPage(page, rows);
		Example example = new Example(User.class);
		example.setOrderByClause("updated DESC");
		List<User> list = userMapper.selectByExample(example);
		PageInfo<User> pageInfo = new PageInfo<>(list);
		return new EasyUIResult((int)pageInfo.getTotal(), list);
	}

	@Override
	public void save(User model) {
		//this.userMapper.save(model);
		this.userMapper.insert(model);
		
	}

	@Override
	public void updateUser(User user) {
		this.userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public User findUserByUserId(Long id) {
		return this.userMapper.selectByPrimaryKey(id);
	}

	@Override
	public DatagridResult<User> queryListByPage(Integer page, Integer rows) {
		Long totalCount = this.userMapper.queryTotalCount();
		List<User> users = this.userMapper.queryUserListByPage((page-1)*rows,rows);
		return new DatagridResult<User>(totalCount, users);
	}

	@Override
	public void deleteByIds(Long[] ids) {
		this.userMapper.deleteByIds(ids);
		
	}

}
