package controllers;

import com.fms.facility.IFacility;
import com.fms.service.*;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.Dashboard;
import views.html.*;


public class DashboardController extends Controller {

    public static Result get(){
        return render();
    }

    public static Result render(){
        return ok(Dashboard.render());
    }

    public static Result listFacilities(){
        FacilityMgrService facilityMgrService = new ConcreteFacilityMgrService();
        return ok(listFacilities.render(facilityMgrService.listFacilities()));
    }

    public static Result listUnitsForFacility(int f){
        FacilityMgrService facilityMgrService = new ConcreteFacilityMgrService();
        return ok(listUnits.render(facilityMgrService.listUnitsForFacilityId(f)));
    }

    public static Result listRequestsForUnit(int unitId){
         RequestMgrService requestMgrService = new ConcreteRequestMgrService();
        return ok(listRequests.render(requestMgrService.listRequestsByUnitID(unitId)));
    }

    public static Result listSchedulesForUnit(int unitId){
        ScheduleMgrService scheduleMgrService = new ConcreteScheduleMgrService();
        return ok(listSchedules.render(scheduleMgrService.listSchedulesByUnitId(unitId)));
    }

    public static Result listUsagesForUnit(int unitId){
        UsageMgrService usageMgrService = new ConcreteUsageMgrService();
        return ok(listUsages.render(usageMgrService.listUsagesByUnitId(unitId)));
    }
}
