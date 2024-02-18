package bot.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataInitializer {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DataInitializer(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void initializeData() {
        String insertQuery = "INSERT INTO your_table_name (column1, column2, column3) VALUES (?, ?, ?)";
        jdbcTemplate.update(insertQuery, "value1", "value2", "value3");
        jdbcTemplate.update(insertQuery, "value4", "value5", "value6");
    }
}
