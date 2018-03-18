package cn.itcast.mapper;

import com.github.abel533.mapper.Mapper;

import cn.itcast.usermanage.domain.User;

public interface UserMapper extends Mapper<User>{

	public User selectUserByID(int id);
}
