package com.fms.inspection;


public class Inspection implements IInspection{

    private int inspectionId;
    private String actualStartDate;
    private String actualEndDate;
    private String technician;
    private String probDesc;


    @Override
    public int getInspectionId() {
        return inspectionId;
    }

    @Override
    public void setInspectionId(int inspectionId) {
       this.inspectionId = inspectionId;
    }

    @Override
    public String getActualStartDate() {
        return actualStartDate;
    }

    @Override
    public void setActualStartDate(String date) {
        this.actualStartDate = date;
    }

    @Override
    public String getActualEndDate() {
        return actualEndDate;
    }

    @Override
    public void setActualEndDate(String date) {
        this.actualEndDate = date;
    }

    @Override
    public String getTechnician() {
        return technician;
    }

    @Override
    public void setTechnician(String technician) {
          this.technician = technician;
    }

    @Override
    public String getProbDesc() {
        return probDesc;
    }

    @Override
    public void setProbDesc(String desc) {
        this.probDesc = desc;
    }

}
