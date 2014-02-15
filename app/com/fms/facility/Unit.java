package com.fms.facility;


import com.fms.facilityRequest.IRequest;
import com.fms.facilitymaintenance.IMaintenance;
import com.fms.facilityschedule.ISchedule;
import com.fms.facilityuse.IUsage;
import com.fms.inspection.IInspection;

import java.util.*;

//making this abstract affects the persistence.
//check FacilityDAO.readFacility for details.
public class Unit implements IUnit {

    private int unitId;
    private boolean isVacant;
    private List<IUsage> usageList = new ArrayList<IUsage>();
    private List<IRequest> requestList = new ArrayList<IRequest>();
    private List<ISchedule> scheduleList =new ArrayList<ISchedule>();
    private List<IMaintenance> maintenanceList =new ArrayList<IMaintenance>();
    private List<IInspection> inspectionList =new ArrayList<IInspection>();

    @Override
    public int getUnitId(){
        return unitId;
    }

    @Override
    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    @Override
    public boolean isVacant(){
        return isVacant;
    }

    @Override
    public void setVacancy(boolean vacant){
        this.isVacant = vacant;
    }

    @Override
    public List<IUsage> getUsageList() {
        return usageList;
    }

    @Override
    public void addUsage(IUsage usage) {
        usageList.add(usage);
    }

    @Override
    public List<IRequest> getRequestList() {
        return requestList;
    }

    @Override
    public void addRequest(IRequest request) {
        requestList.add(request);
    }

    @Override
    public List<ISchedule> getScheduleList() {
        return scheduleList;
    }

    @Override
    public void addSchedule(ISchedule schedule) {
        scheduleList.add(schedule);
    }

    @Override
    public List<IMaintenance> getMaintenanceList() {
        return maintenanceList;
    }

    @Override
    public void addMaintenance(IMaintenance maintenance) {
        maintenanceList.add(maintenance);
    }

    @Override
    public List<IInspection> getInspectionList() {
        return inspectionList;
    }

    @Override
    public void addInspection(IInspection inspection) {
        inspectionList.add(inspection);
    }
}
