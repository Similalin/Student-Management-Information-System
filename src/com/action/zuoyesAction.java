package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TZuoyesDAO;
import com.model.TStu;
import com.model.TZuoyes;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class zuoyesAction extends ActionSupport
{
	private Integer id;
	private String mingcheng;
	private String fujian;
	private String tijiaoshi;
	
	private Integer stuId;
	private Integer zuoyetId;
	private String huifu;
	
	private TZuoyesDAO zuoyesDAO;
	
	public String zuoyesAdd()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		Map session=ActionContext.getContext().getSession();
		TStu stu=(TStu)session.get("stu");
		
		TZuoyes zuoyes=new TZuoyes();
		
		//zuoyes.setId(id);
		zuoyes.setMingcheng(mingcheng);
		zuoyes.setFujian(fujian);
		zuoyes.setTijiaoshi(tijiaoshi);
		
		zuoyes.setStuId(stu.getStuId());
		zuoyes.setZuoyetId(zuoyetId);
		zuoyes.setHuifu("");
		
		zuoyesDAO.save(zuoyes);
		
		request.put("msg", "作业提交完毕");
		return "msg";
		
	}
	
	
	public String zuoyesMine()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		Map session=ActionContext.getContext().getSession();
		TStu stu=(TStu)session.get("stu");
		
		String sql="from TZuoyes where stuId="+stu.getStuId();
		List zuoyesList =zuoyesDAO.getHibernateTemplate().find(sql);
		request.put("zuoyesList", zuoyesList);
		return ActionSupport.SUCCESS;
	}
	
	public String zuoyesDel()
	{
		TZuoyes zuoyes=zuoyesDAO.findById(id);
		zuoyesDAO.delete(zuoyes);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "作业删除完毕");
		return "msg";
	}
	
	
	public String zuoyesMana()
	{
		String sql="from TZuoyes where zuoyetId="+zuoyetId;
		List zuoyesList =zuoyesDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zuoyesList", zuoyesList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String zuoyesHuifu()
	{
		TZuoyes zuoyes=zuoyesDAO.findById(id);
		zuoyes.setHuifu(huifu);
		zuoyesDAO.attachDirty(zuoyes);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "批阅完毕");
		return "msg";
	}


	public Integer getId()
	{
		return id;
	}


	public void setId(Integer id)
	{
		this.id = id;
	}


	public String getMingcheng()
	{
		return mingcheng;
	}


	public void setMingcheng(String mingcheng)
	{
		this.mingcheng = mingcheng;
	}


	public String getFujian()
	{
		return fujian;
	}


	public void setFujian(String fujian)
	{
		this.fujian = fujian;
	}


	public String getTijiaoshi()
	{
		return tijiaoshi;
	}


	public void setTijiaoshi(String tijiaoshi)
	{
		this.tijiaoshi = tijiaoshi;
	}


	public Integer getStuId()
	{
		return stuId;
	}


	public void setStuId(Integer stuId)
	{
		this.stuId = stuId;
	}


	public Integer getZuoyetId()
	{
		return zuoyetId;
	}


	public void setZuoyetId(Integer zuoyetId)
	{
		this.zuoyetId = zuoyetId;
	}


	public String getHuifu()
	{
		return huifu;
	}


	public void setHuifu(String huifu)
	{
		this.huifu = huifu;
	}


	public TZuoyesDAO getZuoyesDAO()
	{
		return zuoyesDAO;
	}


	public void setZuoyesDAO(TZuoyesDAO zuoyesDAO)
	{
		this.zuoyesDAO = zuoyesDAO;
	}
	
	
}
