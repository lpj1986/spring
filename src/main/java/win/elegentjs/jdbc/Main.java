package win.elegentjs.jdbc;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        SimpleJdbcTemplate template = (SimpleJdbcTemplate) applicationContext.getBean("jdbcTemplate");
        List<Map<String, Object>> list = template.queryForList("select * from product");

        System.out.println(list);


    }
}
