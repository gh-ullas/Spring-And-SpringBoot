package com.example.repository;

import com.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void save(Employee employee){
        String sql = "INSERT INTO employee(name, department, salary) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                employee.getName(),
                employee.getDepartment(),
                employee.getSalary());
    }

    @Override
    public Employee findById(int id){
        String sql = "SELECT * FROM employee WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,new EmployeeRowMapper(),id);
    }

    @Override
    public List<Employee> findAll(){
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql,new EmployeeRowMapper());
    }

    @Override
    public void deleteById(int id){
        String sql = "DELETE FROM employee where id=?";
        jdbcTemplate.update(sql,id);
    }

    static class EmployeeRowMapper implements RowMapper<Employee>{
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setDepartment(rs.getString("department"));
            emp.setSalary(rs.getDouble("salary"));
            return emp;
        }
    }
}
