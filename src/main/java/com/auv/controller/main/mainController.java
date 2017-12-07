package com.auv.controller.main;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auv.service.serviceInterface.userBasicService;


@Controller
public class mainController {
	@Autowired
	userBasicService userBasicService;
	@RequestMapping(value="auv/main")
	@ResponseBody
	public Map<String, Object> pageQuery(Integer pageNumber,Integer pageSize) {
//		User user = userBasicService.getUserByIdService(1);
//		System.out.println(request);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", (pageNumber-1)*pageSize);
		params.put("size", pageSize);
		return userBasicService.pageQueryService(params);
	}
	@RequestMapping("select")
	@ResponseBody
    public  Map<String,Object> selectByFy(int pageSize,int pageNumber,String name,Integer age){
        /*所需参数*/
        Map<String, Object> param=new HashMap<String, Object>();
        int a=(pageNumber-1)*pageSize;
        int b=pageSize;
        param.put("a", a);
        param.put("b", b);
        param.put("name", name);
        param.put("age", age);
        return userBasicService.pageQueryService(param);
    } 
	@RequestMapping("test")
	public String testpagequery() {
//		System.out.println(pageNumber);
		return "pageQuery";
	}
}
