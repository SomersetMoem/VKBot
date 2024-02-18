package bot.model;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataInitializer {
    private final static Logger LOG = Logger.getLogger(DataInitializer.class);
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DataInitializer(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void initializeDataProcedure() {
        LOG.info("Заполняем таблицу Procedure");
        if (checkTableProceduresIsEmpty() == 0) {
            String insertQuery = "INSERT INTO your_table_name (column1, column2, column3) VALUES (?, ?, ?)";
            jdbcTemplate.update(insertQuery, "value1", "value2", "value3");
            jdbcTemplate.update(insertQuery, "value4", "value5", "value6");
        } else {
            LOG.info("Таблица Procedure уже заполнена данными");
        }
    }

    public int checkTableProceduresIsEmpty() {
        LOG.info("Проверяем наличие данных в таблице Procedure");
        String countQuery = "SELECT COUNT(*) FROM your_table_name";
        int rowCount = jdbcTemplate.queryForObject(countQuery, Integer.class);
        return rowCount;
    }
}
