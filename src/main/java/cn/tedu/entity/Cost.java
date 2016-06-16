package cn.tedu.entity;

import java.sql.Timestamp;

public class Cost {
	public Integer costID;
	public String name;
	// 基本时长
	public Double baseDuration;
	// 基本费用
	public Double baseCost;
	// 单位费用
	public Double unitCost;
	// 状态 0 启动  1 禁用
	public String status;
	// 描述
	public String descr;
	// 创建时间
	private Timestamp creatime;
	// 开通时间
	private Timestamp startime;
	// 资费类型 1 包月 2 套餐 3 计时
 	private Integer costType;
	public Integer getCostID() {
		return costID;
	}
	public void setCostID(Integer costID) {
		this.costID = costID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getBaseDuration() {
		return baseDuration;
	}
	public void setBaseDuration(Double baseDuration) {
		this.baseDuration = baseDuration;
	}
	public Double getBaseCost() {
		return baseCost;
	}
	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}
	public Double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String sratus) {
		this.status = sratus;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Timestamp getCreatime() {
		return creatime;
	}
	public void setCreatime(Timestamp caratime) {
		this.creatime = caratime;
	}
	public Timestamp getStartime() {
		return startime;
	}
	public void setStartime(Timestamp startime) {
		this.startime = startime;
	}
	public Integer getCostType() {
		return costType;
	}
	public void setCostType(Integer costType) {
		this.costType = costType;
	}
}
