package com.coll.OnlineCollaboration.dao;

import java.util.List;

import com.coll.OnlineCollaboration.model.BlogComments;

public interface IBlogCommentsDao {

	List<BlogComments> getAllBlogComments();
	BlogComments getBlogCommentsById(int blogCommentId);
	boolean addBlogComments(BlogComments blogComments);
	boolean updateBlogComments(BlogComments blogComments);
	boolean deleteBlogComments(BlogComments blogComments);
}
