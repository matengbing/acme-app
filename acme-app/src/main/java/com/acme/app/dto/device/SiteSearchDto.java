package com.acme.app.dto.device;

import java.io.Serializable;

/**
 * 站点查询数据结果
 * 
 * DTO
 * @author YL.Z
 *
 * @date 2017年4月15日 下午12:21:57
 */
public class SiteSearchDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5813261026269152494L;
	private Long id;
	private String waterplace;
	
	private SiteDataChart chart;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWaterplace() {
		return waterplace;
	}

	public void setWaterplace(String waterplace) {
		this.waterplace = waterplace;
	}

	public SiteDataChart getChart() {
		return chart;
	}

	public void setChart(SiteDataChart chart) {
		this.chart = chart;
	}
	
	
	
}
