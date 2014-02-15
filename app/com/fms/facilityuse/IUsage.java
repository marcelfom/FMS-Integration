package com.fms.facilityuse;

/* *
 *
 *  */
public interface IUsage {

    public int getUsageId();
    public void setUsageId(int id);
    public String getStartDate();
    public void setStartDate(String date);
    public String getEndDate();
    public void setEndDate(String date);
    public String getOwner();
    public void setOwner(String owner) ;
    /*
	public Object isInUseDuringInterval();
	public Object assignFacilityToUse();
	public Object vacateFacility();
	public Object listInspections();
	public Object listActualUsage();
	public Object calcUsageRate();
	*/

}
