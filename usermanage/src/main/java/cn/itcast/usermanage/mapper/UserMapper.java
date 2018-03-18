package cn.itcast.usermanage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.abel533.mapper.Mapper;

import cn.itcast.usermanage.domain.User;

public interface UserMapper extends Mapper<User>{

	public List<User> findAll();

	public void save(User model);

	public Long queryTotalCount();

	public List<User> queryUserListByPage(Integer page, Integer rows);

	public void deleteByIds(@Param("ids")Long[] ids);

}
