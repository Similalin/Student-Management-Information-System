package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TZuoyetDAO;
import com.model.TTea;
import com.model.TZuoyet;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class zuoyetAction extends ActionSupport
{
	private Integer id;
	private String mingcheng;
	private String fujian;
	private String beizhu;
	
	private String fabushi;
	private Integer teaId;
	
	private TZuoyetDAO zuoyetDAO;
	
	public String zuoyetAdd()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		Map session=ActionContext.getContext().getSession();
		TTea tea=(TTea)session.get("tea");
		
		TZuoyet zuoyet=new TZuoyet();
		
		//zuoyet.setId(id);
		zuoyet.setMingcheng(mingcheng);
		zuoyet.setFujian(fujian);
		zuoyet.setBeizhu(beizhu);
		
		zuoyet.setFabushi(fabushi);
		zuoyet.setTeaId(tea.getTeaId());
		
		zuoyetDAO.save(zuoyet);
		
		request.put("msg", "信息添加完毕");
		
		return "msg";
	}
	
	public String zuoyetMine()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		Map session=ActionContext.getContext().getSession();
		TTea tea=(TTea)session.get("tea");
		
		String sql="from TZuoyet where teaId="+tea.getTeaId();
		List zuoyetList=zuoyetDAO.getHibernateTemplate().find(sql);
		
		request.put("zuoyetList", zuoyetList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String zuoyetDel()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		TZuoyet zuoyet=zuoyetDAO.findById(id);
		
		zuoyetDAO.delete(zuoyet);
		
		request.put("msg", "信息删除完毕");
		
		return "msg";
	}
	
	public String zuoyetAll()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		String sql="from TZuoyet order by fabushi desc";
		List zuoyetList=zuoyetDAO.getHibernateTemplate().find(sql);
		
		request.put("zuoyetList", zuoyetList);
		return ActionSupport.SUCCESS;
	}

	
	public String zuoyetDetailQian()
	{
		TZuoyet zuoyet=zuoyetDAO.findById(id);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zuoyet", zuoyet);
		return ActionSupport.SUCCESS;
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

	public String getBeizhu()
	{
		return beizhu;
	}

	public void setBeizhu(String beizhu)
	{
		this.beizhu = beizhu;
	}

	public String getFabushi()
	{
		return fabushi;
	}

	public void setFabushi(String fabushi)
	{
		this.fabushi = fabushi;
	}

	public Integer getTeaId()
	{
		return teaId;
	}

	public void setTeaId(Integer teaId)
	{
		this.teaId = teaId;
	}

	public TZuoyetDAO getZuoyetDAO()
	{
		return zuoyetDAO;
	}

	public void setZuoyetDAO(TZuoyetDAO zuoyetDAO)
	{
		this.zuoyetDAO = zuoyetDAO;
	}

	
}
