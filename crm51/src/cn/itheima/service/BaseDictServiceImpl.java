package cn.itheima.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itheima.dao.BasedictMapper;
import cn.itheima.pojo.BaseDict;

@Service
public class BaseDictServiceImpl implements BaseDictService {

	@Autowired
	private BasedictMapper basedictMapper;
	
	@Override
	public List<BaseDict> findBaseDictList(String custSource) {
		
		return basedictMapper.findBaseDictList(custSource);
	}

	
}
