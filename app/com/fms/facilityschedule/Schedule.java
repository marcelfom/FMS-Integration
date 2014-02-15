package com.fms.facilityschedule;


public class Schedule implements ISchedule {

    private int scheduleId;
	private String scheduleStartDate;
	private String scheduleEndDate;
    private String technician;
	
	@Override
	public String getScheduleStartDate() {
		return scheduleStartDate;
	}

	@Override
	public String getScheduleEndDate() {
		return scheduleEndDate;
	}

	@Override
	public void setScheduleStartDate(String date) {
		this.scheduleStartDate = date;
		
	}

	@Override
	public void setScheduleEndDate(String date) {
		this.scheduleEndDate = date;
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
	public int getScheduleId() {
		return scheduleId;
	}

	@Override
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

}

