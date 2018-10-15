package pe.edu.cibertec.spring.base.repository.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@PropertySource("classpath:jpa.properties")
public class ConfiguracionJpa {
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_DEFAULT_SCHEMA = "hibernate.default_schema";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_HIBERNATE_GENERATE_STATISTICS = "hibernate.generate_statistics";
    private static final String PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE = "hibernate.jdbc.batch_size";
    private static final String[] ENTITYMANAGER_PACKAGES_TO_SCAN = {"pe.edu.cibertec.spring.base.dominio"};

    @Value("${jpa.hibernate.dialect}")
    private String dialect;
    @Value("${jpa.hibernate.default_schema}")
    private String defaultSchema;
    @Value("${jpa.hibernate.show_sql}")
    private boolean showSql;
    @Value("${jpa.hibernate.generate_statistics}")
    private boolean generateStatistics;
    @Value("${jpa.hibernate.jdbc.batch_size}")
    private String jdbcBatchSize;

    private HibernateJpaVendorAdapter vendorAdaptor() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(showSql);
        return vendorAdapter;
    }

    private Properties jpaHibernateProperties() {
        Properties properties = new Properties();

        properties.put(PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE, jdbcBatchSize);
        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, showSql);
        properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, dialect);
        properties.put(PROPERTY_NAME_HIBERNATE_GENERATE_STATISTICS, generateStatistics);
        properties.put(PROPERTY_NAME_HIBERNATE_DEFAULT_SCHEMA, defaultSchema);

        return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);             
        entityManagerFactoryBean.setJpaProperties(jpaHibernateProperties());

        return entityManagerFactoryBean;
    }
}
