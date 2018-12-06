package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
public class AppConfig {
    @Bean(name="dataSource")
    public DataSource getDataSource(){
        // Создания источника данных
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // Задание параметров подключения к базе данных
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring");
        dataSource.setUsername("root");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setPassword("123456");
        return dataSource;
    }
    @Bean(name="entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getEntityManager(){
        // Создание класса фабрики, реализующей интерфейс FactoryBean<EntityManagerFactory>
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        // Задание источника подключения
        factory.setDataSource(getDataSource());
        // Задание адаптера для конкретной реализации JPA
        // указывает, какая именно библиотека будет использоваться в качестве поставщика постоянства
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        // Указание пакетов, в которых будут находиться классы-сущности
        factory.setPackagesToScan("domain");
        // Создание свойств для настройки Hibernate
        Properties jpaProperties = new Properties();
        // Указание диалекта конкретной базы данных – необходимо для генерации запросов Hibernate к БД
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        // Указание максимальной глубины связи (будет рассмотрено в следующем уроке)
        jpaProperties.put("hibernate.max_fetch_depth", 3);
        // Определение максимального количества строк, возвращаемых за один запрос из БД
        jpaProperties.put("hibernate.jdbc.fetch_size", 50);
        // Определение максимального количества запросов при использовании пакетных операций
        jpaProperties.put("hibernate.jdbc.batch_size", 10);

        // Включает логирование
        jpaProperties.put("hibernate.show_sql", true);

        factory.setJpaProperties(jpaProperties);

        return factory;

    }

}
