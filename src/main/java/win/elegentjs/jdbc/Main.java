package win.elegentjs.jdbc;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import win.elegentjs.jdbc.datasource.DataSourceEnum;
import win.elegentjs.jdbc.datasource.DataSourceTypeManager;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        JdbcTemplate template = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

        DataSourceTypeManager.set(DataSourceEnum.MASTER);
        List<Map<String, Object>> list = template.queryForList("select * from T_BASE_RESOURCE");


        DataSourceTypeManager.set(DataSourceEnum.SLAVE1);
        list = template.queryForList("select * from T_BASE_RESOURCE");

        System.out.println(list);


    }
}
