package cn.itcast.usermanage.mapper;

import cn.itcast.usermanage.domain.Goods;

public interface GoodsMapper {
	/** 
	 * updateGoodsUseCAS:使用CAS(Compare and set)更新商品信息. <br/> 
	 * @param goods 商品对象 
	 * @return 影响的行数 
	 */  
	int updateGoodsUseCAS(Goods goods);
	/**
	 * 查询出商品信息
	 * @param goodsId
	 * @return
	 */
	Goods getGoodsById(int goodsId);  

}
