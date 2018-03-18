package cn.itcast.usermanage.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.usermanage.domain.DatagridResult;
import cn.itcast.usermanage.domain.User;
import cn.itcast.usermanage.service.UserService;

@RequestMapping("/rest/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value="hello")
    public ModelAndView hello(ModelAndView mv) {
    	System.out.println("ssafsafasd");
    	mv.setViewName("hello");
        return mv;
    }
    
    @RequestMapping("{pageName}")
    public String toUsers(@PathVariable("pageName") String pageName) {
        return pageName;
    }

   /* @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<EasyUIResult> queryUserList(@RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows) {
    	EasyUIResult result;
		try {
			result = this.userService.findAll(page,rows);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }*/
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public DatagridResult<User> queryUserList(@RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows) {
    		
    		return userService.queryListByPage(page,rows);
    }
    
    /**
     * 保存
     * @param model
     * @return
     */
    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> saveUser(User model){
    	try {
    		User user = this.userService.findUserByUserId(model.getId());
    		if(user != null){
    			this.userService.updateUser(user);
    			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    		}else{
    			this.userService.save(model);
    			return ResponseEntity.status(HttpStatus.CREATED).build();
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
    @RequestMapping(value="exportExcel",method=RequestMethod.POST)
    @ResponseBody
    public ModelAndView exportExcel(ModelAndView mv,
    		                                                  @RequestParam(value="page",defaultValue="1") Integer page,
    		                                                  @RequestParam(value="rows",defaultValue="5") Integer rows ){
    	mv.setViewName("excelView");
    	mv.addObject("userList",this.userService.findAll(page, rows).getRows());
    	return mv;
    }
    
    @RequestMapping(method=RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Void> edit(User user){
    	if(user == null){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    	}
    	try {
			this.userService.updateUser(user);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
    @RequestMapping(value="/delete",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Integer> delete(@RequestParam("ids") Long[] ids){
    	Map<String,Integer> result = new HashMap<String, Integer>();
    	try {
			this.userService.deleteByIds(ids);
			result.put("status", 200);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", 500);
		}
    	return result;
    }
   
}
