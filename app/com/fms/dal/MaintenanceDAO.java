package com.fms.dal;


import com.fms.facility.IUnit;
import com.fms.facilitymaintenance.IMaintenance;
import com.fms.facilitymaintenance.Maintenance;
import com.fms.facilityschedule.ISchedule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class MaintenanceDAO {

    public static int createMaintenance(IMaintenance maintenance, IUnit unit, ISchedule schedule) throws SQLException{
        int returnId = 0;
        Statement statement = DBHelper.getLocalConnection().createStatement();
        String sqlQuery = "Insert into Maintenance (unitId, scheduleId, actualStartDate, actualEndDate, resolveDesc, technician, serviceCost) Values ('" +
                                                    unit.getUnitId() + "','" +
                                                    schedule.getScheduleId() + "','" +
                                                    maintenance.getActualStartDate() + "','" +
                                                    maintenance.getActualEndDate() + "','" +
                                                    maintenance.getResolveDesc() + "','" +
                                                    maintenance.getTechnician() + "','" +
                                                    maintenance.getServiceCost() + "');";
        try{
            statement.execute(sqlQuery);
            String getNewId = "Select * from Maintenance where Id = (Select Max(Id) from Maintenance);";
            ResultSet rs = statement.executeQuery(getNewId);
            try{
                while (rs.next()){
                    returnId = rs.getInt("Id");
                }
            }catch (Exception e){
                System.out.println("MaintenanceDAO.createMaintenance() returnId : " + e.getMessage());
            }finally {
                rs.close();
            }
        }catch (Exception e){
            System.out.println("MaintenanceDAO.createMaintenance() msg: " + e.getMessage());
        }finally {
            DBHelper.closeConnection();
            statement.close();
        }
        return returnId;
    }

    public static ArrayList<IMaintenance> listMaintenanceForUnit(IUnit unit) throws SQLException{
        ArrayList<IMaintenance> maintenanceList = new ArrayList<IMaintenance>();
        Statement statement = DBHelper.getLocalConnection().createStatement();
        String sqlQuery = "Select * from Maintenance where unitId = " + unit.getUnitId() + ";";
        try{
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            try{
                while(resultSet.next()){
                    IMaintenance m = new Maintenance();
                    m.setMaintenanceId(resultSet.getInt("Id"));
                    m.setActualStartDate(resultSet.getString("actualStartDate"));
                    m.setActualEndDate(resultSet.getString("actualEndDate"));
                    m.setResolveDesc(resultSet.getString("resolveDesc"));
                    m.setTechnician(resultSet.getString("technician"));
                    m.setServiceCost(resultSet.getDouble("serviceCost"));
                    maintenanceList.add(m);
                }
            }catch (Exception e){
                System.out.println("MaintenanceDAO.listMaintenanceForUnit() resultSet : " + e.getMessage());
            }finally {
                resultSet.close();
            }
        }catch(Exception e){
            System.out.println("MaintenanceDAO.listMaintenanceForUnit() : " + e.getMessage());
        }finally {
            DBHelper.closeConnection();
            statement.close();
        }
        return maintenanceList;
    }

}
