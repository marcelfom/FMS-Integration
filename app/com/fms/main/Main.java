package com.fms.main;

import java.util.*;

import com.fms.dal.TruncateDAO;
import com.fms.facility.*;
import com.fms.facilityRequest.*;
import com.fms.facilitymaintenance.*;
import com.fms.facilityschedule.*;
import com.fms.facilityuse.*;
import com.fms.inspection.*;
import com.fms.service.*;

public class Main {
	
	public static void main(String[] args){

        //Persistence Managers:
        FacilityMgrService facManager = new ConcreteFacilityMgrService();
        UnitMgrService unitManager = new ConcreteUnitMgrService();
        RequestMgrService requestManager = new ConcreteRequestMgrService();
        ScheduleMgrService scheduleManager = new ConcreteScheduleMgrService();
        UsageMgrService usageManager = new ConcreteUsageMgrService();
        MaintenanceMgrService maintenanceManager = new ConcreteMaintenanceMgrService();
        InspectionMgrService inspectionManager = new ConcreteInspectionMgrService();

        //Facility1
        IFacility facility1 = new HouseFacility();
        facility1.setName("Housing Facility 1");
        facility1.setManager("Chris Cornell");
        facility1.setOfficeAddress("101 Foreman Rd, Chicago");
        facility1.setNumParkingSpace(24);
        facility1.setSize(8000);
        facility1.setFacilityId(1); // TODO <-- This is necessary here to print units during debugging


        //Unit1
        //Currently, field in House is not saved into database.
        //I think there would be a House table in db with unit Id as a foreign key
        //for this layer.
        IUnit unit1 = new House("houseSpecificField");
        unit1.setVacancy(true);

        //IUnit2
        IUnit unit2 = new House("houseSpecificField");
        unit2.setVacancy(true);

        facility1.addUnits(unit1);
        facility1.addUnits(unit2);


        int facility1Id = facManager.createFacility(facility1);
        facility1.setFacilityId(facility1Id);
        int unit1Id = unitManager.createUnit(unit1, facility1);
        unit1.setUnitId(unit1Id);
        int unit2Id = unitManager.createUnit(unit2, facility1);
        unit2.setUnitId(unit2Id);

        /*Usages */
        IUsage usage1 = new Usage();
        usage1.setStartDate("01-01-2010");
        usage1.setEndDate("12-31-2011");
        usage1.setOwner("Sam Sky");

        IUsage usage2 = new Usage();
        usage2.setStartDate("06-01-2012");
        usage2.setEndDate("05-31-2013");
        usage2.setOwner("Uncle Bob");

        IUsage usage3 = new Usage();
        usage3.setStartDate("08-01-2013");
        usage3.setEndDate("07-01-2014");
        usage3.setOwner("Uncle Bob");


        unit1.addUsage(usage1);
        unit1.addUsage(usage2);
        unit1.addUsage(usage3);

        usageManager.createUsage(usage1, unit1);
        usageManager.createUsage(usage2, unit1);
        usageManager.createUsage(usage3, unit1);


        IRequest request1 = new Request();
        request1.setRequestDate("02-09-14");
        request1.setRequestedBy("Rozy Kay");
        request1.setRequestType(RequestType.Maintenance);
        request1.setProblemDescription("Sink Maintenance");
        unit1.addRequest(request1);

        IRequest request2 = new Request();
        request2.setRequestDate("02-10-14");
        request2.setRequestedBy("Mary Jane");
        request2.setRequestType(RequestType.Inspection);
        request2.setProblemDescription("Plumbing Inspection");
        unit1.addRequest(request2);

        int request1Id = requestManager.createRequest(request1, unit1);
        request1.setRequestId(request1Id);
        int request2Id = requestManager.createRequest(request2, unit1);
        request2.setRequestId(request2Id);



        ISchedule schedule1 = new Schedule();
        schedule1.setScheduleStartDate("02-12-2014");
        schedule1.setScheduleEndDate("02-12-2014");
        schedule1.setTechnician("Tech John Smith");

        unit1.addSchedule(schedule1);

        int schedule1Id = scheduleManager.createSchedule(schedule1, request1, unit1);
        schedule1.setScheduleId(schedule1Id);

        ISchedule schedule2 = new Schedule();
        schedule2.setScheduleStartDate("02-05-2014");
        schedule2.setScheduleEndDate("02-05-2014");
        schedule2.setTechnician("Tech Billy Bob");

        unit1.addSchedule(schedule2);

        int schedule2Id = scheduleManager.createSchedule(schedule2, request2, unit1);
        schedule2.setScheduleId(schedule2Id);

        IMaintenance maintenance1 = new Maintenance();
        maintenance1.setActualStartDate("02-14-2014");
        maintenance1.setActualEndDate("02-14-2014");
        maintenance1.setResolveDesc("Sink Clogged. Replaced with new.");
        maintenance1.setTechnician("Tech John Smith");
        maintenance1.setServiceCost(452.20);

        unit1.addMaintenance(maintenance1);

        maintenanceManager.createMaintenance(maintenance1, unit1, schedule1);

        IInspection inspection1 = new Inspection();
        inspection1.setActualStartDate("02-06-2014");
        inspection1.setActualEndDate("02-06-2014");
        inspection1.setTechnician("Tech Billy Bob");
        inspection1.setProbDesc("Sink might need replacement");

        unit1.addInspection(inspection1);

        int inspection1Id = inspectionManager.createInspection(inspection1, unit1, schedule1);
        inspection1.setInspectionId(inspection1Id);






        //Facility2
        IFacility facility2 = new HouseFacility();
        facility2.setName("Housing Facility 2");
        facility2.setManager("John Doe");
        facility2.setOfficeAddress("101 Foreman Rd, Mobile");
        facility2.setNumParkingSpace(48);
        facility2.setSize(1500);

        facManager.createFacility(facility2);


        List<IFacility> facilites = facManager.listFacilities();
        System.out.println("Facilities list size: " + facilites.size());

        // Display all facilities
        Iterator<IFacility> itr = facilites.iterator();
        IFacility facility;
        int count = 0;
        while(itr.hasNext()){
        	count++;
        	facility = itr.next();
            System.out.println("Facility " + count + ": " + facility.getName());
        }
        
        /*// Code above is linear, O(n), while code commented out below is approximately O(n^2)
        */

        // Display all units for a particular facility
        List<IUnit> unitsForFacility1 = facManager.listUnits(facility1);
        IUnit unit;
        Iterator<IUnit> itr2 = unitsForFacility1.iterator();
        count = 0;
        while(itr2.hasNext()){
        	count++;
        	unit = itr2.next();
            System.out.println("Unit " + count + ": " + unit.getUnitId() + " Is it Vacant? " + unit.isVacant());
        }

        //Displays all requests for the Unit pulled from Database.
        List<IRequest> requestsForUnit1 = requestManager.listRequestsForUnit(unit1);
        IRequest req;
        Iterator<IRequest> itr3 = requestsForUnit1.iterator();
        count = 0;
        while(itr3.hasNext()){
            count++;
            req = itr3.next();
            System.out.println("Request " + count + ": " + req.getRequestId() + " Type? " + req.getRequestType());
        }

        //Displays all requests for the Unit pulled from Object itself.
        //Just a Test Display:
        List<IRequest> requestsForUnit1Object = unit1.getRequestList();
        IRequest req2;
        Iterator<IRequest> itr33 = requestsForUnit1Object.iterator();
        count = 0;
        while(itr33.hasNext()){
            count++;
            req2 = itr33.next();
            System.out.println("Request Object " + count + ": " + req2.getRequestId() + " Type? " + req2.getRequestType());
        }


        //Displays all schedules for the Unit
        List<ISchedule> schedulesForUnit1 = scheduleManager.listSchedulesForUnit(unit1);
        ISchedule sch;
        Iterator<ISchedule> itr4 = schedulesForUnit1.iterator();
        count = 0;
        while(itr4.hasNext()){
            count++;
            sch = itr4.next();
            System.out.println("Schedule " + count + ": " + sch.getScheduleId() + " starts at:  " + sch.getScheduleStartDate());
        }

        //Displays all Usages for the Unit
        List<IUsage> usagesForUnit1 = usageManager.listUsagesForUnit(unit1);
        IUsage us;
        Iterator<IUsage> itr5 = usagesForUnit1.iterator();
        count = 0;
        while (itr5.hasNext()){
            count++;
            us = itr5.next();
            System.out.println("Usages " + count + ": " + us.getUsageId() + " started :  " + us.getStartDate() + " ended : " + us.getEndDate() + " owned by: " + us.getOwner());
        }

        //Displays all Maintenances for the Unit
        List<IMaintenance> maintainancesForUnit1 = maintenanceManager.listMaintenanceForUnit(unit1);
        IMaintenance m;
        Iterator<IMaintenance> itr6 = maintainancesForUnit1.iterator();
        count = 0;
        while (itr6.hasNext()){
            count++;
            m = itr6.next();
            System.out.println("Maintenances " + count + ": " + m.getMaintenanceId() + " actualStartDate :  " + m.getActualStartDate() +
                                    " actualEndDate : " + m.getActualEndDate() + " resolveDesc: " + m.getResolveDesc() +
                                    " serviceCost: " + m.getServiceCost() + " technician: " + m.getTechnician());
        }


        //Displays all Inspections for the Unit
        List<IInspection> inspectionsForUnit1 = inspectionManager.listInspectionsForUnit(unit1);
        IInspection i;
        Iterator<IInspection> itr7 = inspectionsForUnit1.iterator();
        count = 0;
        while (itr7.hasNext()){
            count++;
            i = itr7.next();
            System.out.println("Inspections " + count + ": " + i.getInspectionId() + " actualStartDate :  " + i.getActualStartDate() +
                    " actualEndDate : " + i.getActualEndDate() + " probDesc: " + i.getProbDesc() +
                    " technician: " + i.getTechnician());
        }


	}

}
