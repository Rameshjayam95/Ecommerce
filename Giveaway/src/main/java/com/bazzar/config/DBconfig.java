package com.bazzar.config;

import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bazzar.model.Cart;
import com.bazzar.model.Category;
import com.bazzar.model.Product;
import com.bazzar.model.Supplier;
import com.bazzar.model.UserDetail;
//it allows us to use annotations for dependency injection.
@Configuration
@EnableTransactionManagement
@ComponentScan("com.bazzar")

public class DBconfig 
{

	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/newdb");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		System.out.println("DataSource object is Created");
		return dataSource;
	}
	
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties properties=new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		
		DataSource dataSource=this.getH2DataSource();
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(dataSource);
		factory.addProperties(properties);
		
		factory.addAnnotatedClass(Category.class);
		factory.addAnnotatedClass(Product.class);
		factory.addAnnotatedClass(Supplier.class);
		factory.addAnnotatedClass(UserDetail.class);
		factory.addAnnotatedClass(Cart.class);
		System.out.println("Session Factory Object is crated");
			SessionFactory sessionFactory=factory.buildSessionFactory();
		return sessionFactory;
	}
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("---Transaction Manager Object is Created ---");
		return new HibernateTransactionManager(sessionFactory);
	
    }
}
