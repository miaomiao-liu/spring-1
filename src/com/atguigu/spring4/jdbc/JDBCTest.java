package com.atguigu.spring4.jdbc;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by miaomiao on 18-1-20.
 */
public class JDBCTest {

    private ApplicationContext ctx = null;
    private JdbcTemplate jdbcTemplate;
    private EmployeeDao employeeDao;
    private DepartmentDao departmentDao;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    {
        ctx = new ClassPathXmlApplicationContext("resources4/applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        employeeDao = (EmployeeDao) ctx.getBean("employeeDao");
        departmentDao = ctx.getBean(DepartmentDao.class);
        namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
    }


    /**
     * 使用具名参数
     */
    @Test
    public void testNamedParameterJdbcTemplate2(){
        String sql = "INSERT INTO employees (last_name,email,dept_id)"
                +" VALUES(:lastName,:email,:deptId)";
        Employee employee = new Employee();
        employee.setLastName("XYZ");
        employee.setEmail("xyz@sina.com");
        employee.setDeptId(3);

        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(employee);
        namedParameterJdbcTemplate.update(sql,paramSource);

    }

    /**
     * 使用具名参数
     * 可以为参数取名（参数多时，便于维护），较麻烦
     */
    @Test
    public void testNamedParameterJdbcTemplate(){
        String sql = "INSERT INTO employees (last_name,email,dept_id) VALUES(:ln,:email,:deptid)";
        Map<String,Object> paraMap = new HashMap();
        paraMap.put("ln","FF");
        paraMap.put("email","ff@atguigu.com");
        paraMap.put("deptid","2");

        namedParameterJdbcTemplate.update(sql,paraMap);
    }

    @Test
    public void testDepartmentDao(){
        System.out.println(departmentDao.get(1));
    }

    @Test
    public void testEmployeeDao(){
        System.out.println(employeeDao.get(1));
    }

    /**
     * 获取单个列的值,或统计查询
     */
    @Test
    public void testQueryForObject2(){
        String sql = "SELECT count(id) FROM employees";
        Long count = jdbcTemplate.queryForObject(sql,Long.class);
        System.out.println(count);
    }

    /**
     * 查到实体类的集合
     */
    @Test
    public  void queryForList(){
        String sql = "SELECT id,last_name lastName,email FROM employees WHERE id > ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        List<Employee> employees = jdbcTemplate.query(sql,rowMapper,5);
        System.out.println(employees);
    }

    /**
     * 从数据库中获取一条记录
     * rowMapper：指定如何去映射结果集的行，常用的实现类BeanPropertyRowMapper
     * 不支持级联属性：JdbcTemplate只是JDBC的一个小工具，而不是ORM框架
     * 当前ORM框架主要有五种：Hibernate(Nhibernate)，iBATIS，mybatis，EclipseLink，JFinal。
     */
    @Test
    public void testQueryForObject(){
        String sql = "SELECT id,last_name lastName,email,dept_id as \"department.id\" FROM employees WHERE id = ?";

        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql,rowMapper,1);

        System.out.println(employee);
    }


    /**
     * 批量更新：批量INSERT，UPDATE，DELETE
     * 最后一个参数是Object[]的List类型，插入一条数据需要一个Object数组
     */
    @Test
    public void testBatchUpdate(){
        String sql = "INSERT INTO employees (last_name,email,dept_id) VALUES(?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>();

        batchArgs.add(new Object[]{"AA","aa@atguigu.com","1"});
        batchArgs.add(new Object[]{"BB","bb@atguigu.com","2"});
        batchArgs.add(new Object[]{"CC","cc@atguigu.com","3"});
        batchArgs.add(new Object[]{"DD","dd@atguigu.com","3"});
        batchArgs.add(new Object[]{"EE","ee@atguigu.com","2"});

        jdbcTemplate.batchUpdate(sql,batchArgs);
    }

    /**
     * 执行INSERT ， UPDATE ， DELETE
     */
    @Test
    public void testUpdate(){
        String sql = "UPDATE employees SET last_name = ? WHERE id = ?";
        jdbcTemplate.update(sql,"Jack",5);

    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println(dataSource.getConnection());
    }

}
