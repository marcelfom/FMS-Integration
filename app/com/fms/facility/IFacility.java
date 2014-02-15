package com.fms.facility;

import java.util.*;

public interface IFacility {

    public int getFacilityId();
	public void setFacilityId(int facilityId);
    public String getName();
    public void setName(String name);
    public String getManager();
    public void setManager(String manager);
    public String getOfficeAddress();
    public void setOfficeAddress(String officeAddress);
    public int getSize();
    public void setSize(int size);
    public int getNumParkingSpace();
    public void setNumParkingSpace(int numParkingSpace);

	public void addUnits(IUnit IUnit);
    public List<IUnit> listUnit();

}
