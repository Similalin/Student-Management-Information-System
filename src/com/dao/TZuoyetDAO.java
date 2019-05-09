package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TZuoyet;

/**
 * A data access object (DAO) providing persistence and search support for
 * TZuoyet entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TZuoyet
 * @author MyEclipse Persistence Tools
 */

public class TZuoyetDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TZuoyetDAO.class);
	// property constants
	public static final String MINGCHENG = "mingcheng";
	public static final String FUJIAN = "fujian";
	public static final String BEIZHU = "beizhu";
	public static final String FABUSHI = "fabushi";
	public static final String TEA_ID = "teaId";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TZuoyet transientInstance)
	{
		log.debug("saving TZuoyet instance");
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

	public void delete(TZuoyet persistentInstance)
	{
		log.debug("deleting TZuoyet instance");
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

	public TZuoyet findById(java.lang.Integer id)
	{
		log.debug("getting TZuoyet instance with id: " + id);
		try
		{
			TZuoyet instance = (TZuoyet) getHibernateTemplate().get(
					"com.model.TZuoyet", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TZuoyet instance)
	{
		log.debug("finding TZuoyet instance by example");
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
		log.debug("finding TZuoyet instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TZuoyet as model where model."
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

	public List findByBeizhu(Object beizhu)
	{
		return findByProperty(BEIZHU, beizhu);
	}

	public List findByFabushi(Object fabushi)
	{
		return findByProperty(FABUSHI, fabushi);
	}

	public List findByTeaId(Object teaId)
	{
		return findByProperty(TEA_ID, teaId);
	}

	public List findAll()
	{
		log.debug("finding all TZuoyet instances");
		try
		{
			String queryString = "from TZuoyet";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TZuoyet merge(TZuoyet detachedInstance)
	{
		log.debug("merging TZuoyet instance");
		try
		{
			TZuoyet result = (TZuoyet) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TZuoyet instance)
	{
		log.debug("attaching dirty TZuoyet instance");
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

	public void attachClean(TZuoyet instance)
	{
		log.debug("attaching clean TZuoyet instance");
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

	public static TZuoyetDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TZuoyetDAO) ctx.getBean("TZuoyetDAO");
	}
}