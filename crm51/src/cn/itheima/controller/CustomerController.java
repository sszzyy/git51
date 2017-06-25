package cn.itheima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itheima.pojo.BaseDict;
import cn.itheima.pojo.Customer;
import cn.itheima.pojo.QueryVo;
import cn.itheima.service.BaseDictService;
import cn.itheima.service.CustomerService;
import cn.itheima.utils.Page;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private BaseDictService baseDictService;
	
	@Value(value="${d.custSource}")
	private String ft;
	@Value(value="${d.custIndustry}")
	private String it;
	@Value(value="${d.custLevel}")
	private String lt;
	
	
	
	@RequestMapping(value="/list.action")
	public String list(QueryVo vo,Model model){
		//条件查询之下拉列表
		List<BaseDict> fromType=baseDictService.findBaseDictList(ft);
		model.addAttribute("fromType", fromType);
		List<BaseDict> industryType=baseDictService.findBaseDictList(it);
		model.addAttribute("industryType", industryType);
		List<BaseDict> levelType=baseDictService.findBaseDictList(lt);
		model.addAttribute("levelType", levelType);
		
		//点击查询功能条件查询
		Page<Customer> page=customerService.findCustomerByVo(vo);
		
		model.addAttribute("page", page);
		
		//查询框回显
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		
		return "customer";
	}
	
	
//修改数据回显
	@RequestMapping("/edit.action")
	public @ResponseBody Customer edit(Integer id){
		Customer customer=customerService.findCustomerById(id);
		
		return customer;
		
	}
	

//修改保存
	@RequestMapping("/update.action")
	public @ResponseBody String update(Customer customer){
		customerService.updateCustomer(customer);
		
		return "ok";
	}
	
//删除
	@RequestMapping("/delete.action")
	public @ResponseBody String delete(Integer id){
		customerService.deleteCustomerById(id);
		
		return "ok";
	}

	
}
