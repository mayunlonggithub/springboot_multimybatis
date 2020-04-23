package org.sang.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class TransactionConfig {
    @Autowired
    @Qualifier("dsOne")
    DataSource dsOne;

    @Autowired
    @Qualifier("dsTwo")
    DataSource dsTwo;

    @Bean(name = "transactionManager1")
    public PlatformTransactionManager annotationDrivenTransactionManager1() {
        return new DataSourceTransactionManager(dsOne);
    }

    @Bean(name = "transactionManager2")
    public PlatformTransactionManager annotationDrivenTransactionManager2() {
        return new DataSourceTransactionManager(dsTwo);
    }
}