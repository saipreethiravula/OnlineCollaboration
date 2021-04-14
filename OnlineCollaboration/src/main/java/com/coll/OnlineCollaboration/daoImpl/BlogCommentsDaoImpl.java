package com.coll.OnlineCollaboration.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.OnlineCollaboration.dao.IBlogCommentsDao;
import com.coll.OnlineCollaboration.model.BlogComments;

@Repository("blogcommentsDao")
@Transactional

public class BlogCommentsDaoImpl implements IBlogCommentsDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<BlogComments> getAllBlogComments() {
		return  sessionFactory.getCurrentSession().createQuery("from BlogComments",BlogComments.class).getResultList();
	}

	@Override
	public BlogComments getBlogCommentsById(int blogCommentId) {
		return sessionFactory.getCurrentSession().get(BlogComments.class, Integer.valueOf(blogCommentId));
	}

	@Override
	public boolean addBlogComments(BlogComments blogComments) {
		try {
			sessionFactory.getCurrentSession().save(blogComments);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		return false;
	  }
	}


	@Override
	public boolean updateBlogComments(BlogComments blogComments) {
		try {
			sessionFactory.getCurrentSession().update(blogComments);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteBlogComments(BlogComments blogComments) {
		try {
			sessionFactory.getCurrentSession().delete(blogComments);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		return false;
	}
  }

}
