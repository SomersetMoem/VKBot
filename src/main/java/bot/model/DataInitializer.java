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


    public void initializeDataProcedures() {
        LOG.info("Заполняем таблицу Procedures");
        if (checkTableProceduresIsEmpty() == 0) {
            String insertQuery = "INSERT INTO Procedures(name_procedure, price, description) VALUES (?, ?, ?)";
            jdbcTemplate.update(insertQuery, "Наращивание ресниц классика", 700, "Классическое наращивание ресниц");
            jdbcTemplate.update(insertQuery, "Наращивание ресниц 2Д", 999, "Наращивание ресниц методом 2D");
            jdbcTemplate.update(insertQuery, "Наращивание уголков глаз", 500, "Наращивание уголков глаз для эффектного взгляда");
        } else {
            LOG.info("Таблица Procedure уже заполнена данными");
        }
    }

    public int checkTableProceduresIsEmpty() {
        LOG.info("Проверяем наличие данных в таблице Procedures");
        String countQuery = "SELECT COUNT(*) FROM Procedures";
        int rowCount = jdbcTemplate.queryForObject(countQuery, Integer.class);
        return rowCount;
    }
}
