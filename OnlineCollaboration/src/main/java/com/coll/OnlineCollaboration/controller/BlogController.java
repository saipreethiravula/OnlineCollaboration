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

import com.coll.OnlineCollaboration.model.Blog;
import com.coll.OnlineCollaboration.service.IBlogService;

@RestController  
@CrossOrigin(origins="http://localhost:4200")  
@RequestMapping(value="/api")  

public class BlogController {

	@Autowired 
	IBlogService blogService;
	
	@PostMapping("save-blog")  
    public boolean saveUser(@RequestBody Blog blog) {  
         return blogService.addBlog(blog);  
	}
         
         @GetMapping("blog-list")  
         public List<Blog> allBlogs() {  
              return blogService.getAllBlogs();  
               
         }  
           
         @DeleteMapping("delete-blog/{blogId}")  
         public boolean deleteBlog(@PathVariable("blog") Blog blog) {  
             return blogService.deleteBlog(blog);  
         }  
       
         @GetMapping("blog/{blogId}")  
         public Blog blogById(@PathVariable("blogId") int blogId) {  
              return blogService.getBlogById(blogId);  
               
         }  
           
         @PostMapping("update-blog/{blogId}")  
         public boolean updateBlog(@RequestBody Blog blog,@PathVariable("blogId") int BlogId) {  
             blog.setBlogId(BlogId);  
             return blogService.updateBlog(blog);  
         } 
}
         
        
        

