package com.fms.facilityschedule;

public interface ISchedule {

    public int getScheduleId();
    public void setScheduleId(int scheduleId);
	public String getScheduleStartDate();
    public void setScheduleStartDate(String date);
    public String getScheduleEndDate();
	public void setScheduleEndDate(String date);
    public String getTechnician();
    public void setTechnician(String technician);

}
