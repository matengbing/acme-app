package com.acme.app.dto.device;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author YL.Z
 *
 * @date 2017年3月31日 下午10:01:47
 */
public class SensorDto implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4940181749493512620L;

	private Long id;

    private String deviceName;

    private String title;

    private String about;

    private String type;

    private BigDecimal lat;

    private BigDecimal lng;

    private String unit;

    private Date gmtCreate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getLng() {
		return lng;
	}

	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	@Override
	public String toString() {
		return "SensorDto [id=" + id + ", deviceName=" + deviceName + ", title=" + title + ", about=" + about
				+ ", type=" + type + ", lat=" + lat + ", lng=" + lng + ", unit=" + unit + ", gmtCreate=" + gmtCreate
				+ "]";
	}
    
    
    
}
