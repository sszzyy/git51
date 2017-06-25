package cn.itheima.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itheima.dao.CustomerMapper;
import cn.itheima.pojo.Customer;
import cn.itheima.pojo.QueryVo;
import cn.itheima.utils.Page;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public Page<Customer> findCustomerByVo(QueryVo vo) {
		Page<Customer> page=new Page<Customer>();
//		private int total;//总条数
		Integer total=customerMapper.findCount();
		page.setTotal(total);

//		private int page;//当前页
		if(vo.getPage()==null){
			page.setPage(1);
		}else{
			page.setPage(vo.getPage());
		}
//		private int size;//每页显示条数
		page.setSize(5);
		vo.setSize(5);
		
		vo.setStart((vo.getPage()-1)*vo.getSize());
		
//	    private List<T> rows;//总数据
		List<Customer> customerList=customerMapper.findCustomerByVo(vo);
		page.setRows(customerList);
	
		return page;
	}

	
//根据ID查询对象
	@Override
	public Customer findCustomerById(Integer id) {
		
		return customerMapper.findCustomerById(id);
	}


//修改保存
	@Override
	public void updateCustomer(Customer customer) {
		
		customerMapper.updateCustomer(customer);
	}


//根据ID删除
	@Override
	public void deleteCustomerById(Integer id) {
		customerMapper.deleteCustomerById(id);
		
	}

	
}
