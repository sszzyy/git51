package cn.itheima.dao;

import java.util.List;

import cn.itheima.pojo.Customer;
import cn.itheima.pojo.QueryVo;

public interface CustomerMapper {
	//查询总的记录数
	public Integer findCount();
	
	//分页查询总的记录数
	public List<Customer> findCustomerByVo(QueryVo vo);
	
	//根据id查询对象
	public Customer findCustomerById(Integer id);
	
	//修改保存
	public void updateCustomer(Customer customer);
	
	//根据ID删除
	public void deleteCustomerById(Integer id);

}
