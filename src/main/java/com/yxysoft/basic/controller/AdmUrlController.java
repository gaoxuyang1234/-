package com.yxysoft.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/adm")
public class AdmUrlController {

	
	
	
	
	
	@RequestMapping("manage")
	public String view_manage(){
		return "view/manage";
	}
	@RequestMapping("banci")
	public String banci(){
		return "view/banci";
	}
	
	
	@RequestMapping("baobiao")
	public String baobiao(){
		return "view/baobiao";
	}
	
	@RequestMapping("buka")
	public String buka(){
		return "view/buka";
	}
	
	@RequestMapping("jiaban")
	public String jiaban(){
		return "view/jiaban";
	}
	
	@RequestMapping("kaoqin")
	public String kaoqin(){
		return "view/kaoqin";
	}
	
	@RequestMapping("qingjia")
	public String qingjia(){
		return "view/qingjia";
	}

	
	@RequestMapping("yuangong")
	public String yuangong(){
		return "view/yuangong";
	}
	
//======================================
	
	 @RequestMapping(value ="/wxlogin1")
	    public String wxlogin(){
	        return "weixindaka/login";

	    }

	 
	//gxy
	    @RequestMapping("zhuye")
		public String zhuye(){
			return "weixindaka/index";
		}
	//gxy
		@RequestMapping("qiandao")
		public String qiandao(){
			
			return "weixindaka/signin";
		}
	//gxy
		@RequestMapping("signout")
		public String signout(){
			
			return "weixindaka/signout";
		}
	 
	    @RequestMapping(value = "/wxdetails")
	    public String wxdetails(){
	        return "weixindaka/details";

	    }


	    @RequestMapping(value = "/wxcard")
	    public String wxcard(){
	        return "weixindaka/card-replacement";

	    }

	    @RequestMapping(value = "/wxleave")
	    public String wxleave(){
	        return "weixindaka/ask-for-leave";

	    }

}


