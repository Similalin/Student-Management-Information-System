package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TShipin;

/**
 * Data access object (DAO) for domain model class TShipin.
 * 
 * @see com.model.TShipin
 * @author MyEclipse Persistence Tools
 */

public class TShipinDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TShipinDAO.class);

	protected void initDao()
	{
		// do nothing
	}

	public void save(TShipin transientInstance)
	{
		log.debug("saving TShipin instance");
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

	public void delete(TShipin persistentInstance)
	{
		log.debug("deleting TShipin instance");
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

	public TShipin findById(java.lang.Integer id)
	{
		log.debug("getting TShipin instance with id: " + id);
		try
		{
			TShipin instance = (TShipin) getHibernateTemplate().get(
					"com.model.TShipin", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TShipin instance)
	{
		log.debug("finding TShipin instance by example");
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
		log.debug("finding TShipin instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TShipin as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll()
	{
		log.debug("finding all TShipin instances");
		try
		{
			String queryString = "from TShipin where del='no'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TShipin merge(TShipin detachedInstance)
	{
		log.debug("merging TShipin instance");
		try
		{
			TShipin result = (TShipin) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TShipin instance)
	{
		log.debug("attaching dirty TShipin instance");
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

	public void attachClean(TShipin instance)
	{
		log.debug("attaching clean TShipin instance");
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

	public static TShipinDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TShipinDAO) ctx.getBean("TShipinDAO");
	}
}