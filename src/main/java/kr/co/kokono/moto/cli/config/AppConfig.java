package kr.co.kokono.moto.cli.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"kr.co.kokono.moto"})
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public DataSource dataSource(
            @Value("${jdbc.username}") String uid,
            @Value("${jdbc.password}") String upw,
            @Value("${jdbc.url}") String url,
            @Value("${jdbc.driver-class}") String driver) {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(uid);
        config.setPassword(upw);

        return new HikariDataSource(config);
    }

    @Bean
    public JdbcTemplate template(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


}
