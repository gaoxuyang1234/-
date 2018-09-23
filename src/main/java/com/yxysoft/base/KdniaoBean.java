package com.yxysoft.base;

import java.util.List;

/**
 * 该类是用于映射快递鸟回执信息的JSON实体类
 * @author 111
 *
 */
public class KdniaoBean {
	private String LogisticCode;
	
	private String ShipperCode;
	
	private List<KdniaoBeanY> Traces;
	
	private Boolean Success; 
	
	private String Reason;
	

	public String getLogisticCode() {
		return LogisticCode;
	}




	public void setLogisticCode(String logisticCode) {
		LogisticCode = logisticCode;
	}




	public String getShipperCode() {
		return ShipperCode;
	}




	public void setShipperCode(String shipperCode) {
		ShipperCode = shipperCode;
	}




	public List<KdniaoBeanY> getTraces() {
		return Traces;
	}




	public void setTraces(List<KdniaoBeanY> traces) {
		Traces = traces;
	}

	public Boolean getSuccess() {
		return Success;
	}




	public void setSuccess(Boolean success) {
		Success = success;
	}




	public String getReason() {
		return Reason;
	}




	public void setReason(String reason) {
		Reason = reason;
	}




	class KdniaoBeanY{
		private String AcceptStation;
		private String AcceptTime;
		public String getAcceptStation() {
			return AcceptStation;
		}
		public void setAcceptStation(String acceptStation) {
			AcceptStation = acceptStation;
		}
		public String getAcceptTime() {
			return AcceptTime;
		}
		public void setAcceptTime(String acceptTime) {
			AcceptTime = acceptTime;
		}
		
	}




	@Override
	public String toString() {
		return "KdniaoBean [LogisticCode=" + LogisticCode + ", ShipperCode=" + ShipperCode + ", Traces=" + Traces
				+ ", Success=" + Success + ", Reason=" + Reason + "]";
	}
	
	
}
