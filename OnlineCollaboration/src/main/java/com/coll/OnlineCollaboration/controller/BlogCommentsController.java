package com.coll.OnlineCollaboration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coll.OnlineCollaboration.model.BlogComments;
import com.coll.OnlineCollaboration.service.IBlogCommentsService;

@RestController  
@CrossOrigin(origins="http://localhost:4200")  
@RequestMapping(value="/api")  
public class BlogCommentsController {
	@Autowired 
	IBlogCommentsService blogcommentsService;
	
	@PostMapping("save-BlogComments")  
    public boolean saveBlog(@RequestBody BlogComments blogcomments) {  
        return blogcommentsService.addBlogComments(blogcomments);  
         
   }  
     
   @GetMapping("blogcomments-list")  
   public List<BlogComments> allBlogComments() {  
        return blogcommentsService.getAllBlogComments();  
         
   }  
     
   @DeleteMapping("delete-blogcomments/{blogcomments}")  
   public boolean deleteBlogComments(@PathVariable("BlogComments") BlogComments blogcommentsId) {  
       return blogcommentsService.deleteBlogComments(blogcommentsId);  
   }  
 
   @GetMapping("blogcomments/{blogcommentsId}")  
   public BlogComments BlogCommentsById(@PathVariable("blogcommentsId") int blogcommentsId) {  
        return blogcommentsService.getBlogCommentsById(blogcommentsId);  
         
   }  
}
	