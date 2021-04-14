package com.coll.OnlineCollaboration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coll.OnlineCollaboration.dao.IBlogDao;
import com.coll.OnlineCollaboration.model.Blog;
import com.coll.OnlineCollaboration.service.IBlogService;

@Service  
@Transactional 
public class BlogServiceImpl implements IBlogService {
	
	@Autowired
	IBlogDao blogDao;

	@Override
	public List<Blog> getAllBlogs() {
		return blogDao.getAllBlogs();
	}

	@Override
	public List<Blog> getBlogsByStatus(String status) {
		return blogDao.getBlogsByStatus(status);
	}

	@Override
	public List<Blog> getUsersBlogs(int id) {
		return blogDao.getUsersBlogs(id);
	}

	@Override
	public List<Blog> mainList() {
		return blogDao.mainList();
	}

	@Override
	public Blog getBlogById(int blogId) {
		return blogDao.getBlogById(blogId);
	}

	@Override
	public boolean addBlog(Blog blog) {
		return blogDao.addBlog(blog);
	}

	@Override
	public boolean updateBlog(Blog blog) {
		return blogDao.updateBlog(blog);
	}

	@Override
	public boolean deleteBlog(Blog blog) {
		return blogDao.deleteBlog(blog);
	}

}
