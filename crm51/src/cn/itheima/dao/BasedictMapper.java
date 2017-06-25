package cn.itheima.dao;

import java.util.List;

import cn.itheima.pojo.BaseDict;

public interface BasedictMapper {
	public List<BaseDict> findBaseDictList(String custSource);

}
