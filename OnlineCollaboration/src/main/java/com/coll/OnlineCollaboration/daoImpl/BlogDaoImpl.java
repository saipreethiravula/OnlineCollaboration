package com.coll.OnlineCollaboration.daoImpl;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.OnlineCollaboration.dao.IBlogDao;
import com.coll.OnlineCollaboration.model.Blog;

@Repository("blogDao")
@Transactional
public class BlogDaoImpl implements IBlogDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Blog> getAllBlogs() {
		return  sessionFactory.getCurrentSession().createQuery("from Blog",Blog.class).getResultList();
	}

	@Override
	public List<Blog> getBlogsByStatus(String status) {
			String q="from Blog where status='"+status+"'";
			Query query=sessionFactory.getCurrentSession().createQuery(q);
			return query.getResultList();
		}
	
	@Override
	public List<Blog> getUsersBlogs(int id) {
		return (List<Blog>) sessionFactory.getCurrentSession().get(Blog.class, Integer.valueOf(id));
	}

	@Override
	public List<Blog> mainList() {
		return sessionFactory.getCurrentSession().createQuery("from Blog",Blog.class).getResultList();
	}

	@Override
	public Blog getBlogById(int blogId) {
		return sessionFactory.getCurrentSession().get(Blog.class, Integer.valueOf(blogId));
	}

	@Override
	public boolean addBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().save(blog);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		return false;
	  }
	}

	@Override
	public boolean updateBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		return false;
	}
}
}