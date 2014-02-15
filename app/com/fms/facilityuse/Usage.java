package com.fms.facilityuse;


public class Usage implements IUsage {

    private int usageId;
    private String startDate;
    private String endDate;
    private String owner;

    @Override
    public int getUsageId() {
        return usageId;
    }

    @Override
    public void setUsageId(int id) {
        this.usageId = id;
    }

    @Override
    public String getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(String date) {
        this.startDate = date;
    }

    @Override
    public String getEndDate() {
        return endDate;
    }

    @Override
    public void setEndDate(String date) {
        this.endDate = date;
    }

    @Override
    public String getOwner() {
        return owner;
    }

    @Override
    public void setOwner(String owner) {
        this.owner = owner;
    }
}
