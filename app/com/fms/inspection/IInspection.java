package com.fms.inspection;

public interface IInspection {
	
	public int getInspectionId();
	public void setInspectionId(int inspectionId);
    public String getActualStartDate();
    public void setActualStartDate(String date);
    public String getActualEndDate();
    public void setActualEndDate(String date);
    public String getTechnician();
    public void setTechnician(String technician);
    public String getProbDesc();
    public void setProbDesc(String desc);

}
