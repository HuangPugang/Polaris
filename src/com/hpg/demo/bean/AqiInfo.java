package com.hpg.demo.bean;

import java.io.Serializable;

public class AqiInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String sitename;
	private String cityname;
	private int aqi;
	private String rank;
	private float pm25;
	private float pm10;
	private float co;
	private float no2;
	private float o3;
	private float so2;
	private String primary_pollutant;
	private String times;
	
	
	
	public AqiInfo(){
		super();
	}
	public AqiInfo(String sitename, String cityname, int aqi, String rank,
			float pm25, float pm10, float co, float no2, float o3, float so2,
			String primary_pollutant, String times) {
		super();
		this.sitename = sitename;
		this.cityname = cityname;
		this.aqi = aqi;
		this.rank = rank;
		this.pm25 = pm25;
		this.pm10 = pm10;
		this.co = co;
		this.no2 = no2;
		this.o3 = o3;
		this.so2 = so2;
		this.primary_pollutant = primary_pollutant;
		this.times = times;
	}
	public String getSitename() {
		return sitename;
	}
	public void setSitename(String sitename) {
		this.sitename = sitename;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public int getAqi() {
		return aqi;
	}
	public void setAqi(int aqi) {
		this.aqi = aqi;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public float getPm25() {
		return pm25;
	}
	public void setPm25(float pm25) {
		this.pm25 = pm25;
	}
	public float getPm10() {
		return pm10;
	}
	public void setPm10(float pm10) {
		this.pm10 = pm10;
	}
	public float getCo() {
		return co;
	}
	public void setCo(float co) {
		this.co = co;
	}
	public float getNo2() {
		return no2;
	}
	public void setNo2(float no2) {
		this.no2 = no2;
	}
	public float getO3() {
		return o3;
	}
	public void setO3(float o3) {
		this.o3 = o3;
	}
	public float getSo2() {
		return so2;
	}
	public void setSo2(float so2) {
		this.so2 = so2;
	}
	public String getPrimary_pollutant() {
		return primary_pollutant;
	}
	public void setPrimary_pollutant(String primary_pollutant) {
		this.primary_pollutant = primary_pollutant;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	
	
}
