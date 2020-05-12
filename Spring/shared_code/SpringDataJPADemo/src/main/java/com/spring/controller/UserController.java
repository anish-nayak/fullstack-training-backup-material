package com.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.json.PostAdd;
import com.spring.json.User;

@RestController
@RequestMapping("/advt")
public class UserController {

	boolean loginStatus=false;
	List <PostAdd> postList = new CopyOnWriteArrayList<PostAdd>();
	PostAdd pp1=null;
	PostAdd pp2=null;

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody User user) {
//		User u = new User(username, password);
		if (user.getUsername().equals("anand") && user.getPassword().equals("anand123")) {
			loginStatus = true;
			return "login Successfull " + user.getUsername();
		} else {

			return "failed";
		}
	}

	@RequestMapping(headers = { "auth_token" }, value = "/logout", method = RequestMethod.DELETE)
	public String logout(@RequestHeader String auth_token) {
		if (auth_token.isEmpty()) // equals("true")
			return "failed to logout";
		else {

			return "Logout Succcessfully....";
		}
	}
	
	
	@RequestMapping(value="/categories", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> getAllCategory()
	{
		//PostAdd pa = new PostAdd(1,"open","Laptop Sale", "Sukan", "Hardware", "intel core 3", 2, "a.jpg", "b.jpg");
		//PostAdd pa2 = new PostAdd(2,"open","Laptop Sale", "Sukan", "Soft", "intel core 3", 2, "a.jpg", "b.jpg");
		 pp1 = new PostAdd(1,"open","Laptop Sale", "Sukan", "Hardware", "intel core 3", 2, "a.jpg", "b.jpg");
		 pp2 = new PostAdd(2,"open","Laptop Sale", "Sukan", "Soft", "intel core 3", 2, "a.jpg", "b.jpg");
		 postList.add(pp1);
		 postList.add(pp2);
		List <String> l = new ArrayList<String>();
		l.add(pp1.getCategory());
		l.add(pp2.getCategory());
		
		return l;
	}
	
	//postAdd
	@RequestMapping(value="/postAdd", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public PostAdd postAdd(@RequestBody PostAdd pa)
	{
			postList.add(pa);
			System.out.println("Add Posted..."+pa);
			return pa;
	}
	
	//Update existing advertise
	@RequestMapping(value="/postAdd", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public PostAdd updatePostAdd(@RequestBody PostAdd pa)
	{
	
			System.out.println("Add Posted..."+pa);
			return pa;
	}
	
	//All Ad by Logged In User
	@RequestMapping(value="/posts/{uname}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PostAdd> posts(@PathVariable(value="uname") String username)
	{
		System.out.println("param username : "+username+" | "+loginStatus);
		List<PostAdd> l = new ArrayList<PostAdd>();
		if(loginStatus==true)
		{
			System.out.println("pp1 username : "+pp1.getName());
			if(pp1.getName().equals(username))
			{
				l.add(pp1);
			}
			if(pp2.getName().equals(username))
			{
				l.add(pp2);
			}
		}
		return l;
		
	}
	
	//Delete Specific Ad
	@RequestMapping(value="/post/{uname}/{title}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String post(@PathVariable(value="uname") String username, @PathVariable(value="title") String title)
	{
		if(loginStatus==true)
		{
			for(PostAdd p : postList)
			{
				if(p.getTitle().equals(title))
				{
					postList.remove(p);
				}
			}
			
		}
		
		return null;
	}
	
///////////////////////////////////////
	/*@Autowired
	private UserService registrationService;

	@GetMapping("/user")
	public List<User> getAllUsers() {
		return registrationService.getAllUsers();
	}

	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable(value = "id") String userId) {
		return registrationService.getUserById(userId);
	}

	@PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User registerUser(@RequestBody User user) {
		return registrationService.save(user);
	}

	@PutMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User updateUser(@RequestBody User user, @PathVariable(value = "id") String id) {
		return registrationService.update(user, id);
	}

	@DeleteMapping(value = "/user/{id}")
	public boolean deleteUser(@PathVariable(value = "id") String id) {
		return registrationService.delete(id);
	}

	@GetMapping("/user/firstname/{firstName}")
	public List<User> getUsersByFirstName(@PathVariable(value = "firstName") String firstName) {
		return registrationService.getUsersByFirstName(firstName);
	}

	@GetMapping("/user/firstname/sort/asc")
	public List<User> getUsersByOrderByFirstNameAsc() {
		return registrationService.getUsersByOrderByFirstNameAsc();
	}

	@GetMapping("/user/firstname/sort/desc")
	public List<User> getUsersByOrderByFirstNameDesc() {
		return registrationService.getUsersByOrderByFirstNameDesc();
	}*/
}
