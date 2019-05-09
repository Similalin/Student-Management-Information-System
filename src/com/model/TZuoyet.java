package com.model;

/**
 * TZuoyet entity. @author MyEclipse Persistence Tools
 */

public class TZuoyet implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String mingcheng;
	private String fujian;
	private String beizhu;
	
	private String fabushi;
	private Integer teaId;

	// Constructors

	/** default constructor */
	public TZuoyet()
	{
	}

	/** full constructor */
	public TZuoyet(String mingcheng, String fujian, String beizhu,
			String fabushi, Integer teaId)
	{
		this.mingcheng = mingcheng;
		this.fujian = fujian;
		this.beizhu = beizhu;
		this.fabushi = fabushi;
		this.teaId = teaId;
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

	public String getBeizhu()
	{
		return this.beizhu;
	}

	public void setBeizhu(String beizhu)
	{
		this.beizhu = beizhu;
	}

	public String getFabushi()
	{
		return this.fabushi;
	}

	public void setFabushi(String fabushi)
	{
		this.fabushi = fabushi;
	}

	public Integer getTeaId()
	{
		return this.teaId;
	}

	public void setTeaId(Integer teaId)
	{
		this.teaId = teaId;
	}

}