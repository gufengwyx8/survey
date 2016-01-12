package com.survey.util;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

@SuppressWarnings("unchecked")
public class PagerCallBack implements HibernateCallback {

	private int pageNo;
	private int pageSize;
	private String hql;
	private Object[] values;

	public PagerCallBack(int pageNo, int pageSize, String hql, Object... values) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.hql = hql;
		this.values = values;
	}

	public Object doInHibernate(Session session) throws HibernateException,
			SQLException {
		Query q = session.createQuery(hql);
		for (int i = 0; i < values.length; i++) {
			q.setParameter(i, values[i]);
		}
		q.setFirstResult((pageNo - 1) * pageSize);
		q.setMaxResults(pageSize);
		return q.list();
	}

}
