package com.coll.OnlineCollaboration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coll.OnlineCollaboration.model.BlogComments;
import com.coll.OnlineCollaboration.service.IBlogCommentsService;

@Service  
@Transactional 

public class BlogCommentsServiceImpl implements IBlogCommentsService {
	
	@Autowired
	IBlogCommentsService blogcommentsService;

	@Override
	public List<BlogComments> getAllBlogComments() {
		return blogcommentsService.getAllBlogComments();
	}

	@Override
	public BlogComments getBlogCommentsById(int blogComemntId) {
		return blogcommentsService.getBlogCommentsById(blogComemntId);
	}

	@Override
	public boolean addBlogComments(BlogComments blogComments) {
		return blogcommentsService.addBlogComments(blogComments);
	}

	@Override
	public boolean updateBlogComments(BlogComments blogComments) {
		return blogcommentsService.updateBlogComments(blogComments);
	}

	@Override
	public boolean deleteBlogComments(BlogComments blogComments) {
		return blogcommentsService.deleteBlogComments(blogComments);
	}

}
