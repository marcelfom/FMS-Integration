package com.fms.service;

import com.fms.dal.FacilityDAO;
import com.fms.facility.*;

import java.sql.SQLException;
import java.util.*;

public class ConcreteFacilityMgrService implements FacilityMgrService {

    @Override
    public int createFacility(IFacility facility) {
        int newId = 0;
        try {
            newId = FacilityDAO.createFacility(facility);
        } catch (SQLException e) {
            System.out.println("ConcreteFacilityManagerService: createFacility()");
            e.printStackTrace();
        }
        return newId;
    }

    @Override
    public IFacility readFacility(int id) {
        IFacility f = new Facility();
        try {
            f = FacilityDAO.readFacility(id);
        } catch (SQLException e) {
            System.out.println("ConcreteFacilityManagerService: readFacility()");
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public void updateFacility(IFacility facility) {

    }

    @Override
    public void deleteFacility(IFacility facility) {

    }

    @Override
    public ArrayList<IFacility> listFacilities() {
        ArrayList<IFacility> f = new ArrayList<IFacility>();
        try{
            f = FacilityDAO.listFacilities();
        }catch (SQLException e){
            System.out.println("ConcreteFacilityManagerService: readFacility()");
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public ArrayList<IUnit> listUnits(IFacility f) {
        ArrayList<IUnit> u = new ArrayList<IUnit>();
        try{
            u = FacilityDAO.listUnits(f);
        }catch (SQLException e){
            System.out.println("ConcreteFacilityManagerService: readFacility()");
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public ArrayList<IUnit> listUnitsForFacilityId(int facId) {
        ArrayList<IUnit> u = new ArrayList<IUnit>();
        try{
            u = FacilityDAO.listUnitsForFacilityId(facId);
        }catch (SQLException e){
            System.out.println("ConcreteFacilityManagerService: readFacility()");
            e.printStackTrace();
        }
        return u;
    }
}
