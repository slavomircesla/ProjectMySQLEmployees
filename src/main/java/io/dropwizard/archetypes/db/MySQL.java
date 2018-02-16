package io.dropwizard.archetypes.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MySQL
{


    private Connection conn;
    private String driver = "com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/employees";
    private String username="root";
    private String password="";


    public String getSalary(String name)
    {

        String salary="";
        try {
            Class.forName(driver).newInstance();

            conn = DriverManager.getConnection(url,username,password);
            String query =" SELECT salaries.salary as sal FROM salaries "+
                    " INNER JOIN employees ON employees.emp_no=salaries.emp_no"+
                    " WHERE employees.last_name like '"+name+"'";

            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                salary = rs.getString("salary");
            }

        }catch(Exception ex)
        {
            System.out.println("Warning! Error:" +ex.getMessage());
        }


        return salary;
    }




}

