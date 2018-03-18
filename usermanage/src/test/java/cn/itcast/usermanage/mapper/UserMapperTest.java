package cn.itcast.usermanage.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.usermanage.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testSelectOne() {
		User user = new User();
		user.setId(1L);
		User one = this.userMapper.selectOne(user);
		System.out.println(one);
	}

	@Test
	public void testSelect() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByPrimaryKey() {
		User user = this.userMapper.selectByPrimaryKey(8L);
		System.out.println(user);
	}

	@Test
	public void testInsert() {
		User record = new User();
		record.setId(11L);
		record.setAge(20);
		this.userMapper.insert(record);
	}

	@Test
	public void testInsertSelective() {
		User record = new User();
		record.setAge(20);
		this.userMapper.insertSelective(record);
	}

	@Test
	public void testDelete() {
		
		User user = new User();
		user.setId(9L);
		this.userMapper.delete(user);
	}

	@Test
	public void testDeleteByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKey() {
		User user = new User();
		user.setId(8L);
		user.setAge(200);
		user.setPassword("123456");
		User user2 = this.userMapper.selectByPrimaryKey(1L);
		user2.setPassword("123456");
		//若user中的某些属性没有值的话 都会被置为null
		this.userMapper.updateByPrimaryKey(user);
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		User user = new User();
		user.setId(7L);
		user.setAge(100);
		//只会更新非空的字段 其他的字段维持之前的状态  推荐使用
		this.userMapper.updateByPrimaryKeySelective(user);
	}

	@Test
	public void testSelectCountByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByExampleSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByExample() {
		fail("Not yet implemented");
	}

}
