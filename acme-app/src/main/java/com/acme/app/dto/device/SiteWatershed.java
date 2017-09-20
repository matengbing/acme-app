package com.acme.app.dto.device;

import java.io.Serializable;
import java.util.List;

import com.acme.app.model.reptile.StationInfo;

public class SiteWatershed implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6011658123710148124L;

	private Long id;
	
	private String vally;
	
	private List<StationInfo> site;
	
	public SiteWatershed(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVally() {
		return vally;
	}

	public void setVally(String vally) {
		this.vally = vally;
	}

	public List<StationInfo> getSite() {
		return site;
	}

	public void setSite(List<StationInfo> site) {
		this.site = site;
	}
	
	
	
	
}
