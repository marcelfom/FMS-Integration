package com.fms.service;


import com.fms.facility.IUnit;

import com.fms.facilitymaintenance.*;
import com.fms.facilityschedule.ISchedule;

import java.util.*;


/** This interface is responsible for handling all maintenance administrative duties for 
 * a facility, such as recording maintenance service request, maintenance invoices/orders,
 * and the scheduling for a particular maintenance job. This interface persists the administrative 
 * details to the database as well as retrieves them.
 * */
public interface MaintenanceMgrService {

    public int createMaintenance(IMaintenance maintenance, IUnit unit, ISchedule schedule);

    public ArrayList<IMaintenance> listMaintenanceForUnit(IUnit unit);
	
}
