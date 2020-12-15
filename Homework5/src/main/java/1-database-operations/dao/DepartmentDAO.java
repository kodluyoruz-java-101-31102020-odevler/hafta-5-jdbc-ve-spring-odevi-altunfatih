package db.connection.mysql.connection.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import db.connection.mysql.connection.DbSQLQuery;
import db.connection.mysql.connection.model.Department;


public class DepartmentDAO {

    private static final Logger logger = LogManager.getLogger(DepartmentDAO.class);


    public List<Department> getAll() {

        List<Department> departments = new ArrayList<Department>();

        ResultSet resultSet = DbSQLQuery.select("SELECT * FROM departments");

        try {
            if (resultSet == null) {
                return departments;
            }
            while (resultSet.next()) {
                Department department = new Department(resultSet.getString("dept_no"), resultSet.getString("dept_name"));
                departments.add(department);
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return departments;
    }

}
