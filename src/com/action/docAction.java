package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TDocDAO;
import com.model.TDoc;
import com.opensymphony.xwork2.ActionSupport;

public class docAction extends ActionSupport
{
	private int id;
	private String mingcheng;
	private String fujian;
	private String fujianYuanshiming;
	 
	private String message;
	private String path;
	
	private TDocDAO docDAO;
	
	public String docAdd()
	{
		TDoc doc=new TDoc();
		doc.setMingcheng(mingcheng);
		doc.setFujian(fujian);
		doc.setFujianYuanshiming(fujianYuanshiming);
		doc.setShijian(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		doc.setDel("no");
		docDAO.save(doc);
		this.setMessage("操作成功");
		this.setPath("docMana.action");
		return "succeed";
	}
	
	public String docDel()
	{
		TDoc doc=docDAO.findById(id);
		doc.setDel("yes");
		docDAO.attachDirty(doc);
		this.setMessage("删除成功");
		this.setPath("docMana.action");
		return "succeed";
	}
	
	public String docMana()
	{
		String sql="from TDoc where del='no'";
		List docList=docDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("docList", docList);
		return ActionSupport.SUCCESS;
	}
	
	

	public String docAll()
	{
		String sql="from TDoc where del='no'";
		List docList=docDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("docList", docList);
		return ActionSupport.SUCCESS;
	}
	
	public String docDetailQian()
	{
		TDoc doc=docDAO.findById(id);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("doc", doc);
		return ActionSupport.SUCCESS;
	}

	public String getFujian()
	{
		return fujian;
	}

	public void setFujian(String fujian)
	{
		this.fujian = fujian;
	}

	public String getFujianYuanshiming()
	{
		return fujianYuanshiming;
	}

	public TDocDAO getDocDAO()
	{
		return docDAO;
	}

	public void setDocDAO(TDocDAO docDAO)
	{
		this.docDAO = docDAO;
	}

	public void setFujianYuanshiming(String fujianYuanshiming)
	{
		this.fujianYuanshiming = fujianYuanshiming;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getMingcheng()
	{
		return mingcheng;
	}

	public void setMingcheng(String mingcheng)
	{
		this.mingcheng = mingcheng;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}
	
}
