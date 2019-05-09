package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TShipinDAO;
import com.model.TShipin;
import com.opensymphony.xwork2.ActionSupport;

public class shipinAction
{
	private int shipinId;
	private String shipinName;
	private String shipinJianjie;
	private String fujian;
	private String fujianYuanshiming;
	private String message;
	private String path;;
	
	private TShipinDAO shipinDAO;
	
	public String shipinAdd()
	{
		TShipin shipin=new TShipin();
		shipin.setShipinName(shipinName);
		shipin.setFujian(fujian);
		shipin.setShipinJianjie(shipinJianjie);
		shipin.setFujianYuanshiming(fujianYuanshiming);
		shipin.setShijian(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		shipin.setDel("no");
		
		shipinDAO.save(shipin);
		this.setMessage("操作成功");
		this.setPath("shipinMana.action");
		return "succeed";
	}
	
	public String shipinMana()
	{
		String sql="from TShipin where del='no'";
		List shipinList=shipinDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("shipinList", shipinList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String shipinDel()
	{
		TShipin shipin=shipinDAO.findById(shipinId);
		shipin.setDel("yes");
		shipinDAO.attachDirty(shipin);
		this.setMessage("操作成功");
		this.setPath("shipinMana.action");
		return "succeed";
	}
	
	public String shipinAll()
	{
		String sql="from TShipin where del='no'";
		List shipinList=shipinDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("shipinList", shipinList);
		return ActionSupport.SUCCESS;
	}
	
	public String shipinDetailQian()
	{
		TShipin shipin=shipinDAO.findById(shipinId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("shipin", shipin);
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





	public void setFujianYuanshiming(String fujianYuanshiming)
	{
		this.fujianYuanshiming = fujianYuanshiming;
	}





	public String getMessage()
	{
		return message;
	}





	public void setMessage(String message)
	{
		this.message = message;
	}





	public String getPath()
	{
		return path;
	}





	public void setPath(String path)
	{
		this.path = path;
	}





	public TShipinDAO getShipinDAO()
	{
		return shipinDAO;
	}





	public void setShipinDAO(TShipinDAO shipinDAO)
	{
		this.shipinDAO = shipinDAO;
	}





	public int getShipinId()
	{
		return shipinId;
	}





	public void setShipinId(int shipinId)
	{
		this.shipinId = shipinId;
	}





	public String getShipinJianjie()
	{
		return shipinJianjie;
	}





	public void setShipinJianjie(String shipinJianjie)
	{
		this.shipinJianjie = shipinJianjie;
	}





	public String getShipinName()
	{
		return shipinName;
	}





	public void setShipinName(String shipinName)
	{
		this.shipinName = shipinName;
	}
	
}
