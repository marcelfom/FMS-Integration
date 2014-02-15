package com.fms.facilitymaintenance;

public interface IMaintenance {
	
	public int getMaintenanceId();
	public void setMaintenanceId(int maintId);
    public String getActualStartDate();
    public void setActualStartDate(String date);
    public String getActualEndDate();
    public void setActualEndDate(String date);
	public String getResolveDesc();
	public void setResolveDesc(String maintSerivceOffered);
    public String getTechnician();
    public void setTechnician(String technician);
	public double getServiceCost();
	public void setServiceCost(double maintServiceCost);

}
