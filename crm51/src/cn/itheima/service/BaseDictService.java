package cn.itheima.service;

import java.util.List;

import cn.itheima.pojo.BaseDict;

public interface BaseDictService {

	List<BaseDict> findBaseDictList(String custSource);

}
