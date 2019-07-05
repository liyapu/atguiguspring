package com.lyp.learn.demo.jdbc;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class JdbcTemplateTest {

    ApplicationContext acx = null;
    JdbcTemplate jdbcTemplate = null;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;
    {
        acx = new ClassPathXmlApplicationContext("jdbc-tempate.xml");
        jdbcTemplate = (JdbcTemplate) acx.getBean("jdbcTemplate");
        namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) acx.getBean("namedParameterJdbcTemplate");
    }

    /**
     * 测试数据源 获取连接是否正常
     * @throws SQLException
     */
    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = (DataSource) acx.getBean("dataSource");
        System.out.println(dataSource);
        System.out.println(dataSource.getConnection());
    }

    /**
     *  可以执行 insert,update ,delete 语句
     */
    @Test
    public void testUpdate1(){
        String sql = "UPDATE student SET age = ? WHERE id = ?";
        int rows = jdbcTemplate.update(sql,23,4);
        System.out.println(rows);
    }

    /**
     * 批量执行，insert,update,delete
     */
    @Test
    public void testBatchUpdate(){
        String sql = "INSERT INTO student (name,address,age) VALUES (?,?,?) ";
        List<Object[]> args = new ArrayList<>();
        args.add(new Object[]{"AA","aa",36});
        args.add(new Object[]{"BB","bb",27});
        args.add(new Object[]{"CC","cc",18});
        args.add(new Object[]{"DD","dd",35});
        args.add(new Object[]{"EE","ee",20});
        args.add(new Object[]{"FF","ff",60});

        int [] rows = jdbcTemplate.batchUpdate(sql,args);
        System.out.println(Arrays.toString(rows));
    }

    /**
     * 查询一个对象
     *  需要自己 last_money AS lastMoney 通过别名映射字段
     *  通过RowMapper 去指定映射结果集
     */
    @Test
    public void testQueryForObject(){
        String sql="SELECT id,name,address,age,last_money AS lastMoney FROM student WHERE id = ?";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
        Student student = jdbcTemplate.queryForObject(sql,rowMapper,10);
        System.out.println(student);
    }

    /**
     * 查询一组对象
     */
    @Test
    public void testQueryList(){
        String sql="SELECT id,name,address,age,last_money AS lastMoney FROM student WHERE id > ?";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
        List<Student> students = jdbcTemplate.query(sql,rowMapper,2);

        for(Student s : students){
            System.out.println(s);
        }
    }

    /**
     * 查询统计值
     */
    @Test
    public void testQueryCount(){
        String sql = "SELECT COUNT(*) FROM student";
        int count = jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(count);
    }

    /**
     * 查询统计值
     */
    @Test
    public void testQueryCount2(){
        String sql = "SELECT COUNT(*) FROM student WHERE id > ?";
        int count = jdbcTemplate.queryForObject(sql,Integer.class,10);
        System.out.println(count);
    }

    /**
     * 查询一个字段
     */
    @Test
    public void testQueryOneField(){
        String sql = "SELECT name FROM student WHERE id = ?";
        String field = jdbcTemplate.queryForObject(sql,String.class,2);
        System.out.println(field);
    }


    /**
     * 测试带参数的 JdbcTemplate
     */
    @Test
    public void testNamedParameterJdbcTemplate(){
//        String sql = "INSERT INTO student (name,address,age) VALUES (?,?,?) ";
        String sql = "INSERT INTO student (name,address,age,last_money) VALUES (:name,:address,:age,:lm) ";
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("name","张三");
        paramMap.put("address","北京");
        paramMap.put("age","10");
        paramMap.put("lm","99");
        int rows = namedParameterJdbcTemplate.update(sql,paramMap);
        System.out.println(rows);
    }


    /**
     * 传入一个对象
     */
    @Test
    public void testNamedParameterJdbcTemplate2(){
        String sql = "INSERT INTO student (name,address,age,last_money) VALUES (:name,:address,:age,:lastMoney) ";
        Student student = new Student();
        student.setName("张三丰");
        student.setAddress("武当山");
        student.setAge(88);
        student.setLastMoney(100);

        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(student);
        int rows = namedParameterJdbcTemplate.update(sql,sqlParameterSource);
        System.out.println(rows);
    }


    class StudentRowMapper implements RowMapper<Student>{

        //rs为返回结果集，以每行为单位封装着
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setAddress(rs.getString("address"));
            student.setAge(rs.getInt("age"));
            student.setLastMoney(rs.getInt("lastMoney"));
            return student;
        }
    }

}
