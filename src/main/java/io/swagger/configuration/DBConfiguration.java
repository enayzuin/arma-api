
package io.swagger.configuration;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource.hikari")
public class DBConfiguration extends HikariConfig {

	@Bean
	DataSource dataSource() throws SQLException {
		this.setDataSourceClassName("com.microsoft.sqlserver.jdbc.SQLServerDataSource");
		this.setUsername("sa");
		this.setPassword("@Enay59aw55Zuin");
		this.addDataSourceProperty("url", "jdbc:sqlserver://192.168.1.104:1433;databaseName=FORTNITE");
		HikariDataSource ds = new HikariDataSource(this);
		return ds;
	}

	/**
	 * Construtor da classe.
	 */
	public DBConfiguration() {
		super();
	}

}
