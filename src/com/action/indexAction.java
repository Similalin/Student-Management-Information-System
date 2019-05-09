package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TGonggaoDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class indexAction extends ActionSupport
{
	private TGonggaoDAO gonggaoDAO;
	
	public TGonggaoDAO getGonggaoDAO()
	{
		return gonggaoDAO;
	}

	public void setGonggaoDAO(TGonggaoDAO gonggaoDAO)
	{
		this.gonggaoDAO = gonggaoDAO;
	}

	public String index()
	{
		List gonggaoList =gonggaoDAO.findAll();
		Map session=ActionContext.getContext().getSession();
		session.put("gonggaoList", gonggaoList);
		
		return ActionSupport.SUCCESS;
	}
}