package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.TLiuyanDAO;
import com.model.TAdmin;
import com.model.TLiuyan;
import com.model.TStu;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class liuyanAction extends ActionSupport
{
	private Integer id;
	private String neirong;
	private String liuyanshi;
	private Integer stuId;

	private String huifu;
	private String huifushi;
	
	private TLiuyanDAO liuyanDAO;
	
	
	
	public String liuyanAdd()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		TStu stu=(TStu)session.getAttribute("stu");
		
		TLiuyan liuyan=new TLiuyan();
		
		liuyan.setNeirong(neirong);
		liuyan.setLiuyanshi(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		liuyan.setStuId(stu.getStuId());
		
		liuyan.setHuifu("");
		liuyan.setHuifushi("");
		liuyanDAO.save(liuyan);
		
		request.setAttribute("msg", "问题发布完毕");
		return "msg";
	}
	
	
	public String liuyanMana()
	{
		String sql="from TLiuyan order by liuyanshi";
		List liuyanList=liuyanDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("liuyanList", liuyanList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String liuyanDel()
	{
		TLiuyan liuyan=liuyanDAO.findById(id);
		liuyanDAO.delete(liuyan);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("msg", "问题删除成功");
		return "msg";
	}
	
	
	public String liuyanHuifu()
	{
		TLiuyan liuyan=liuyanDAO.findById(id);
		liuyan.setHuifu(huifu);
		liuyan.setHuifushi(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		
		liuyanDAO.attachDirty(liuyan);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("msg", "回复完毕");
		return "msg";
	}
	
	
	
	
	public String liuyanAll()
	{
		String sql="from TLiuyan order by liuyanshi desc";
		List liuyanList=liuyanDAO.getHibernateTemplate().find(sql);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("liuyanList", liuyanList);
		return ActionSupport.SUCCESS;
	}
	
	public String liuyanDetail()
	{
		TLiuyan liuyan=liuyanDAO.findById(id);
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("liuyan", liuyan);
		return ActionSupport.SUCCESS;
	}

	public String getHuifu()
	{
		return huifu;
	}

	public void setHuifu(String huifu)
	{
		this.huifu = huifu;
	}

	public String getHuifushi()
	{
		return huifushi;
	}

	public void setHuifushi(String huifushi)
	{
		this.huifushi = huifushi;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public TLiuyanDAO getLiuyanDAO()
	{
		return liuyanDAO;
	}

	public void setLiuyanDAO(TLiuyanDAO liuyanDAO)
	{
		this.liuyanDAO = liuyanDAO;
	}

	public String getLiuyanshi()
	{
		return liuyanshi;
	}

	public void setLiuyanshi(String liuyanshi)
	{
		this.liuyanshi = liuyanshi;
	}

	public String getNeirong()
	{
		return neirong;
	}

	public void setNeirong(String neirong)
	{
		this.neirong = neirong;
	}

	public Integer getStuId()
	{
		return stuId;
	}

	public void setStuId(Integer stuId)
	{
		this.stuId = stuId;
	}
	
}
