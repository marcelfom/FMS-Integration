package com.fms.facilitymaintenance;


public class Maintenance implements IMaintenance {

    private int maintenanceId;
    private String actualStartDate;
    private String actualEndDate;
    private String resolveDesc;
    private String technician;
    private double serviceCost;

    @Override
    public int getMaintenanceId() {
        return maintenanceId;
    }

    @Override
    public void setMaintenanceId(int maintenanceId) {
        this.maintenanceId = maintenanceId;
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
	public String getResolveDesc() {
		return resolveDesc;
	}

	@Override
	public void setResolveDesc(String resolveDesc) {
		this.resolveDesc = resolveDesc;
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
	public double getServiceCost() {
		return serviceCost;
	}

	@Override
	public void setServiceCost(double serviceCost) {
		this.serviceCost = serviceCost;
	}
}
