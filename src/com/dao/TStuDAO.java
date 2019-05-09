package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TStu;

/**
 * Data access object (DAO) for domain model class TStu.
 * 
 * @see com.model.TStu
 * @author MyEclipse Persistence Tools
 */

public class TStuDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TStuDAO.class);

	// property constants
	public static final String STU_XUEHAO = "stuXuehao";

	public static final String STU_REALNAME = "stuRealname";

	public static final String STU_SEX = "stuSex";

	public static final String STU_AGE = "stuAge";

	public static final String LOGIN_NAME = "loginName";

	public static final String LOGIN_PW = "loginPw";

	public static final String DEL = "del";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TStu transientInstance)
	{
		log.debug("saving TStu instance");
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

	public void delete(TStu persistentInstance)
	{
		log.debug("deleting TStu instance");
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

	public TStu findById(java.lang.Integer id)
	{
		log.debug("getting TStu instance with id: " + id);
		try
		{
			TStu instance = (TStu) getHibernateTemplate().get("com.model.TStu",
					id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TStu instance)
	{
		log.debug("finding TStu instance by example");
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
		log.debug("finding TStu instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TStu as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStuXuehao(Object stuXuehao)
	{
		return findByProperty(STU_XUEHAO, stuXuehao);
	}

	public List findByStuRealname(Object stuRealname)
	{
		return findByProperty(STU_REALNAME, stuRealname);
	}

	public List findByStuSex(Object stuSex)
	{
		return findByProperty(STU_SEX, stuSex);
	}

	public List findByStuAge(Object stuAge)
	{
		return findByProperty(STU_AGE, stuAge);
	}

	public List findByLoginName(Object loginName)
	{
		return findByProperty(LOGIN_NAME, loginName);
	}

	public List findByLoginPw(Object loginPw)
	{
		return findByProperty(LOGIN_PW, loginPw);
	}

	public List findByDel(Object del)
	{
		return findByProperty(DEL, del);
	}

	public List findAll()
	{
		log.debug("finding all TStu instances");
		try
		{
			String queryString = "from TStu";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TStu merge(TStu detachedInstance)
	{
		log.debug("merging TStu instance");
		try
		{
			TStu result = (TStu) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TStu instance)
	{
		log.debug("attaching dirty TStu instance");
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

	public void attachClean(TStu instance)
	{
		log.debug("attaching clean TStu instance");
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

	public static TStuDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TStuDAO) ctx.getBean("TStuDAO");
	}
}