package com.acme.app.dto.device;

import java.io.Serializable;

/**
 * 地图展示数据
 * @author YL.Z
 *
 * @date 2017年4月5日 下午5:10:25
 */
public class SiteDataDto extends SuperSiteDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2451993519468753430L;
	private int score;//评分

	private int scoreLevel;//评分等级	
	
	private String wpubdate;

    private String waterplace;

    private String wph;

    private String thewlevel;

    private String a;

    private String nhthn;

    private String codmn;

    private String year;

    private String wdo;

    private String prewlevel;

    private String contamination;
    
	private String lat;
	
	private String lng;
	
	private SiteDataAverage average;

	public String getWpubdate() {
		return wpubdate;
	}

	public void setWpubdate(String wpubdate) {
		this.wpubdate = wpubdate;
	}

	public String getWaterplace() {
		return waterplace;
	}

	public void setWaterplace(String waterplace) {
		this.waterplace = waterplace;
	}

	public String getWph() {
		return wph;
	}

	public void setWph(String wph) {
		this.wph = wph;
	}

	public String getThewlevel() {
		return thewlevel;
	}

	public void setThewlevel(String thewlevel) {
		this.thewlevel = thewlevel;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getNhthn() {
		return nhthn;
	}

	public void setNhthn(String nhthn) {
		this.nhthn = nhthn;
	}

	public String getCodmn() {
		return codmn;
	}

	public void setCodmn(String codmn) {
		this.codmn = codmn;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getWdo() {
		return wdo;
	}

	public void setWdo(String wdo) {
		this.wdo = wdo;
	}

	public String getPrewlevel() {
		return prewlevel;
	}

	public void setPrewlevel(String prewlevel) {
		this.prewlevel = prewlevel;
	}

	public String getContamination() {
		return contamination;
	}

	public void setContamination(String contamination) {
		this.contamination = contamination;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public SiteDataAverage getAverage() {
		return average;
	}

	public void setAverage(SiteDataAverage average) {
		this.average = average;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScoreLevel() {
		return scoreLevel;
	}

	public void setScoreLevel(int scoreLevel) {
		this.scoreLevel = scoreLevel;
	}

	
}
