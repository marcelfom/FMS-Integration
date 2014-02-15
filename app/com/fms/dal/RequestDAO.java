package com.fms.dal;

import com.fms.facility.IUnit;
import com.fms.facilityRequest.IRequest;
import com.fms.facilityRequest.Request;
import com.fms.facilityRequest.RequestType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class RequestDAO {

    public static int createRequest(IRequest request, IUnit unit) throws SQLException{
        int returnId = 0;
        Statement statement = DBHelper.getLocalConnection().createStatement();
        //System.out.println(request.getRequestType());
        String sqlQuery = "Insert into Request (unitId, requestDate, probDesc, requestType, requestedBy) Values ('" +
                                                unit.getUnitId() + "' , '" +
                                                request.getRequestDate() + "' , '" +
                                                request.getProblemDescription() + "' , '" +
                                                request.getRequestType() + "' , '" +
                                                request.getRequestedBy() + "');";
        try{
            statement.execute(sqlQuery);
            String getNewId = "Select * from Request where Id = (Select Max(Id) from Request);";
            ResultSet rs = statement.executeQuery(getNewId);
            try{
                while (rs.next()){
                    returnId = rs.getInt("Id");
                }
            }catch (Exception e){
                System.out.println("RequestDAO.createUnit() returnId : " + e.getMessage());
            }finally {
                rs.close();
            }
        }catch (Exception e){
            System.out.println("RequestDAO.createRequest() msg: " + e.getMessage());
        }finally {
            DBHelper.closeConnection();
            statement.close();
        }
        return returnId;
    }

    public static ArrayList<IRequest> listRequestsForUnit(IUnit unit) throws SQLException{
        ArrayList<IRequest> requestList = new ArrayList<IRequest>();
        Statement statement = DBHelper.getLocalConnection().createStatement();
        String sqlQuery = "Select * from Request where unitId = " + unit.getUnitId() + ";";
        try{
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            try{
                while(resultSet.next()){
                    IRequest r = new Request();
                    r.setRequestId(resultSet.getInt("Id"));
                    r.setRequestDate(resultSet.getString("requestDate"));
                    r.setRequestedBy(resultSet.getString("requestedBy"));

                    System.out.println(resultSet.getString("requestType"));
                    //Please ignore this enum type for now.
                    if(resultSet.getString("requestType") == "Maintenance"){
                        r.setRequestType(RequestType.Maintenance);
                        System.out.println("In Maint");
                    }
                    else if (resultSet.getString("requestType") == "Inspection"){
                        r.setRequestType(RequestType.Inspection);
                        System.out.println("In Inspec");
                    }
                    r.setRequestType(RequestType.Inspection);

                    r.setProblemDescription(resultSet.getString("probDesc"));
                    requestList.add(r);
                }
            }catch (Exception e){
                System.out.println("RequestDAO.listRequestsForUnit() resultSet : " + e.getMessage());
            }finally {
                resultSet.close();
            }
        }catch(Exception e){
            System.out.println("RequestDAO.listRequestsForUnit() : " + e.getMessage());
        }finally {
            DBHelper.closeConnection();
            statement.close();
        }
        return requestList;
    }

    public static ArrayList<IRequest> listRequestsByUnitID(int unitId) throws SQLException{
        ArrayList<IRequest> requestList = new ArrayList<IRequest>();
        Statement statement = DBHelper.getLocalConnection().createStatement();
        String sqlQuery = "Select * from Request where unitId = " + unitId + ";";
        try{
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            try{
                while(resultSet.next()){
                    IRequest r = new Request();
                    r.setRequestId(resultSet.getInt("Id"));
                    r.setRequestDate(resultSet.getString("requestDate"));
                    r.setRequestedBy(resultSet.getString("requestedBy"));

                    System.out.println(resultSet.getString("requestType"));
                    //Please ignore this enum type for now.
                    if(resultSet.getString("requestType") == "Maintenance"){
                        r.setRequestType(RequestType.Maintenance);
                        System.out.println("In Maint");
                    }
                    else if (resultSet.getString("requestType") == "Inspection"){
                        r.setRequestType(RequestType.Inspection);
                        System.out.println("In Inspec");
                    }
                    r.setRequestType(RequestType.Inspection);

                    r.setProblemDescription(resultSet.getString("probDesc"));
                    requestList.add(r);
                }
            }catch (Exception e){
                System.out.println("RequestDAO.listRequestsForUnit() resultSet : " + e.getMessage());
            }finally {
                resultSet.close();
            }
        }catch(Exception e){
            System.out.println("RequestDAO.listRequestsForUnit() : " + e.getMessage());
        }finally {
            DBHelper.closeConnection();
            statement.close();
        }
        return requestList;
    }
}
