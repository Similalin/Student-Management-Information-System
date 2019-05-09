package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TZuoyes;

/**
 * A data access object (DAO) providing persistence and search support for
 * TZuoyes entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TZuoyes
 * @author MyEclipse Persistence Tools
 */

public class TZuoyesDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TZuoyesDAO.class);
	// property constants
	public static final String MINGCHENG = "mingcheng";
	public static final String FUJIAN = "fujian";
	public static final String TIJIAOSHI = "tijiaoshi";
	public static final String STU_ID = "stuId";
	public static final String ZUOYET_ID = "zuoyetId";
	public static final String HUIFU = "huifu";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TZuoyes transientInstance)
	{
		log.debug("saving TZuoyes instance");
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

	public void delete(TZuoyes persistentInstance)
	{
		log.debug("deleting TZuoyes instance");
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

	public TZuoyes findById(java.lang.Integer id)
	{
		log.debug("getting TZuoyes instance with id: " + id);
		try
		{
			TZuoyes instance = (TZuoyes) getHibernateTemplate().get(
					"com.model.TZuoyes", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TZuoyes instance)
	{
		log.debug("finding TZuoyes instance by example");
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
		log.debug("finding TZuoyes instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TZuoyes as model where model."
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

	public List findByTijiaoshi(Object tijiaoshi)
	{
		return findByProperty(TIJIAOSHI, tijiaoshi);
	}

	public List findByStuId(Object stuId)
	{
		return findByProperty(STU_ID, stuId);
	}

	public List findByZuoyetId(Object zuoyetId)
	{
		return findByProperty(ZUOYET_ID, zuoyetId);
	}

	public List findByHuifu(Object huifu)
	{
		return findByProperty(HUIFU, huifu);
	}

	public List findAll()
	{
		log.debug("finding all TZuoyes instances");
		try
		{
			String queryString = "from TZuoyes";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TZuoyes merge(TZuoyes detachedInstance)
	{
		log.debug("merging TZuoyes instance");
		try
		{
			TZuoyes result = (TZuoyes) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TZuoyes instance)
	{
		log.debug("attaching dirty TZuoyes instance");
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

	public void attachClean(TZuoyes instance)
	{
		log.debug("attaching clean TZuoyes instance");
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

	public static TZuoyesDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TZuoyesDAO) ctx.getBean("TZuoyesDAO");
	}
}