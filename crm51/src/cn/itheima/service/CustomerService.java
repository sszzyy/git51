package cn.itheima.service;

import cn.itheima.pojo.Customer;
import cn.itheima.pojo.QueryVo;
import cn.itheima.utils.Page;

public interface CustomerService {

	Page<Customer> findCustomerByVo(QueryVo vo);

	//根据id 查询对象
	Customer findCustomerById(Integer id);

	//修改保存
	void updateCustomer(Customer customer);

	//根据ID删除
	void deleteCustomerById(Integer id);

	


}
