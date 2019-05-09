package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TDoc;

/**
 * Data access object (DAO) for domain model class TDoc.
 * 
 * @see com.model.TDoc
 * @author MyEclipse Persistence Tools
 */

public class TDocDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TDocDAO.class);

	// property constants
	public static final String MINGCHENG = "mingcheng";

	public static final String FUJIAN = "fujian";

	public static final String FUJIAN_YUANSHIMING = "fujianYuanshiming";

	public static final String DEL = "del";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TDoc transientInstance)
	{
		log.debug("saving TDoc instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TDoc persistentInstance)
	{
		log.debug("deleting TDoc instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TDoc findById(java.lang.Integer id)
	{
		log.debug("getting TDoc instance with id: " + id);
		try
		{
			TDoc instance = (TDoc) getHibernateTemplate().get("com.model.TDoc",
					id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TDoc instance)
	{
		log.debug("finding TDoc instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TDoc instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TDoc as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMingcheng(Object mingcheng)
	{
		return findByProperty(MINGCHENG, mingcheng);
	}

	public List findByFujian(Object fujian)
	{
		return findByProperty(FUJIAN, fujian);
	}

	public List findByFujianYuanshiming(Object fujianYuanshiming)
	{
		return findByProperty(FUJIAN_YUANSHIMING, fujianYuanshiming);
	}

	public List findByDel(Object del)
	{
		return findByProperty(DEL, del);
	}

	public List findAll()
	{
		log.debug("finding all TDoc instances");
		try
		{
			String queryString = "from TDoc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TDoc merge(TDoc detachedInstance)
	{
		log.debug("merging TDoc instance");
		try
		{
			TDoc result = (TDoc) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TDoc instance)
	{
		log.debug("attaching dirty TDoc instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TDoc instance)
	{
		log.debug("attaching clean TDoc instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TDocDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TDocDAO) ctx.getBean("TDocDAO");
	}
}