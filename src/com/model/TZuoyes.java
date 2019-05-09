package com.model;

/**
 * TZuoyes entity. @author MyEclipse Persistence Tools
 */

public class TZuoyes implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String mingcheng;
	private String fujian;
	private String tijiaoshi;
	
	private Integer stuId;
	private Integer zuoyetId;
	private String huifu;

	// Constructors

	/** default constructor */
	public TZuoyes()
	{
	}

	/** full constructor */
	public TZuoyes(String mingcheng, String fujian, String tijiaoshi,
			Integer stuId, Integer zuoyetId, String huifu)
	{
		this.mingcheng = mingcheng;
		this.fujian = fujian;
		this.tijiaoshi = tijiaoshi;
		this.stuId = stuId;
		this.zuoyetId = zuoyetId;
		this.huifu = huifu;
	}

	// Property accessors

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getMingcheng()
	{
		return this.mingcheng;
	}

	public void setMingcheng(String mingcheng)
	{
		this.mingcheng = mingcheng;
	}

	public String getFujian()
	{
		return this.fujian;
	}

	public void setFujian(String fujian)
	{
		this.fujian = fujian;
	}

	public String getTijiaoshi()
	{
		return this.tijiaoshi;
	}

	public void setTijiaoshi(String tijiaoshi)
	{
		this.tijiaoshi = tijiaoshi;
	}

	public Integer getStuId()
	{
		return this.stuId;
	}

	public void setStuId(Integer stuId)
	{
		this.stuId = stuId;
	}

	public Integer getZuoyetId()
	{
		return this.zuoyetId;
	}

	public void setZuoyetId(Integer zuoyetId)
	{
		this.zuoyetId = zuoyetId;
	}

	public String getHuifu()
	{
		return this.huifu;
	}

	public void setHuifu(String huifu)
	{
		this.huifu = huifu;
	}

}