package com.sample.mvc.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.domain.MyBean;

@Controller
@RequestMapping("/rest")
public class RestController {
	Map<String, MyBean> map = new HashMap<String, MyBean>();
	
	@RequestMapping(value="/{name}", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody MyBean get(@PathVariable String name){
		return map.get(name);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json")
	public @ResponseBody MyBean put(@RequestBody MyBean bean){
		return map.put(bean.getName(), bean);
	}
	
	@RequestMapping(value="/{name}", method = RequestMethod.DELETE)
	public @ResponseBody MyBean delete(@PathVariable String name){
		return map.remove(name);
	}
}
