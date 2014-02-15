package com.fms.dal;


import com.fms.facility.IUnit;
import com.fms.facilityRequest.IRequest;
import com.fms.facilityschedule.ISchedule;
import com.fms.facilityschedule.Schedule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ScheduleDAO {


    public static int createSchedule(ISchedule schedule, IRequest request, IUnit unit) throws SQLException{
        int returnId = 0;
        Statement statement = DBHelper.getLocalConnection().createStatement();
        String sqlQuery = "Insert into Schedule (unitId, requestId, startDate, endDate, technician) Values ('" +
                                                unit.getUnitId() + "','" +
                                                request.getRequestId() + "','" +
                                                schedule.getScheduleStartDate() + "','" +
                                                schedule.getScheduleEndDate() + "','" +
                                                schedule.getTechnician() + "');";
        try{
            statement.execute(sqlQuery);
            String getNewId = "Select * from Schedule where Id = (Select Max(Id) from Schedule);";
            ResultSet rs = statement.executeQuery(getNewId);
            try{
                while (rs.next()){
                    returnId = rs.getInt("Id");
                }
            }catch (Exception e){
                System.out.println("ScheduleDAO.createSchedule() returnId : " + e.getMessage());
            }finally {
                rs.close();
            }
        }catch (Exception e){
            System.out.println("ScheduleDAO.createSchedule() msg: " + e.getMessage());
        }finally {
            DBHelper.closeConnection();
            statement.close();
        }
        return returnId;
    }

    public static ArrayList<ISchedule> listSchedulesForUnit(IUnit unit) throws SQLException{
        ArrayList<ISchedule> scheduleList = new ArrayList<ISchedule>();
        Statement statement = DBHelper.getLocalConnection().createStatement();
        String sqlQuery = "Select * from Schedule where unitId = " + unit.getUnitId() + ";";
        try{
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            try{
                while(resultSet.next()){
                    ISchedule s = new Schedule();
                    s.setScheduleId(resultSet.getInt("Id"));
                    s.setScheduleStartDate(resultSet.getString("startDate"));
                    s.setScheduleEndDate(resultSet.getString("endDate"));
                    s.setTechnician(resultSet.getString("technician"));
                    scheduleList.add(s);
                }
            }catch (Exception e){
                System.out.println("ScheduleDAO.listSchedulesForUnit() resultSet : " + e.getMessage());
            }finally {
                resultSet.close();
            }
        }catch(Exception e){
            System.out.println("ScheduleDAO.listSchedulesForUnit() : " + e.getMessage());
        }finally {
            DBHelper.closeConnection();
            statement.close();
        }
        return scheduleList;
    }

    public static ArrayList<ISchedule> listSchedulesByUnitId(int unitId) throws SQLException{
        ArrayList<ISchedule> scheduleList = new ArrayList<ISchedule>();
        Statement statement = DBHelper.getLocalConnection().createStatement();
        String sqlQuery = "Select * from Schedule where unitId = " + unitId + ";";
        try{
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            try{
                while(resultSet.next()){
                    ISchedule s = new Schedule();
                    s.setScheduleId(resultSet.getInt("Id"));
                    s.setScheduleStartDate(resultSet.getString("startDate"));
                    s.setScheduleEndDate(resultSet.getString("endDate"));
                    s.setTechnician(resultSet.getString("technician"));
                    scheduleList.add(s);
                }
            }catch (Exception e){
                System.out.println("ScheduleDAO.listSchedulesForUnit() resultSet : " + e.getMessage());
            }finally {
                resultSet.close();
            }
        }catch(Exception e){
            System.out.println("ScheduleDAO.listSchedulesForUnit() : " + e.getMessage());
        }finally {
            DBHelper.closeConnection();
            statement.close();
        }
        return scheduleList;
    }
}
