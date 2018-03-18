package cn.itcast.usermanage.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.usermanage.domain.Goods;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
public class GoodsMapperTest {

	@Autowired
	private GoodsMapper goodsMapper;
	
	@Test
	public void goodsMapperTest() {
		int goodsId = 1;  
	    //根据相同的id查询出商品信息，赋给2个对象  
	    Goods goods1 = this.goodsMapper.getGoodsById(goodsId);  
	    Goods goods2 = this.goodsMapper.getGoodsById(goodsId);  
	      
	    //打印当前商品信息  
	    System.out.println(goods1);  
	    System.out.println(goods2);  
	      
	    //更新商品信息1  
	    goods1.setStatus(2);//修改status为2  
	    int updateResult1 = this.goodsMapper.updateGoodsUseCAS(goods1);  
	    System.out.println("修改商品信息1"+(updateResult1==1?"成功":"失败"));  
	      
	    //更新商品信息2  
	    goods2.setStatus(2);//修改status为2  
	    int updateResult2 = this.goodsMapper.updateGoodsUseCAS(goods2);  
	    System.out.println("修改商品信息2"+(updateResult2==1?"成功":"失败"));  
	}
}
