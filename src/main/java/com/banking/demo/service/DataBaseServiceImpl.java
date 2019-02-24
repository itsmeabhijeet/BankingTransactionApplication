/**
 * 
 */
package com.banking.demo.service;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.banking.demo.model.Account;
import com.banking.demo.model.TransactionType;

/**
 * @author Abhijeet Gupta
 * MySQL implementation of Interface-DataBaseService
 */
@Service("MySQLDataBaseService")
public class DataBaseServiceImpl implements IdataBaseService {

	@Value("${app.datasource.driverClassName}")
	private String driverClassName;
	@Value("${app.datasource.url}")
	private String url;
	@Value("${app.datasource.username}")
	private String username;
	@Value("${app.datasource.password}")
	private String password;

	private JdbcTemplate jdbcTemplateObject;

	private final static String SQL_UPDATE_ACCOUNT_NEW_BALANCE = "update account set balance= ? where accountid =?";

	private final static String SQL_FETCH_ACCOUNT_DETAILS = "select balance from accont where accountid= ?";

	@Bean
	public DataSource dbService() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		return dataSource;
	}

	@Override
	public boolean transfer(int fromAccontNumber, int toAccountNumber, double amount) {
		int updateAccountBalance = 0;
		updateAccountBalance = updateAccountBalance(fromAccontNumber, amount, TransactionType.WITHDRAW);
		if (updateAccountBalance == 1)
			updateAccountBalance = updateAccountBalance(toAccountNumber, amount, TransactionType.DEPOSIT);
		return (updateAccountBalance == 1);
	}

	@Transactional(rollbackOn = DataAccessException.class)
	private int updateAccountBalance(int accountNumber, double amount, TransactionType type) {
		int updateQueryRes = 0;
		if (type == TransactionType.WITHDRAW) {
			
			Account fromAccount = fetchAccountDetails(accountNumber);
			double newBalance = fromAccount.getBalance() - amount;
			updateQueryRes = updateAccountWithNewBalance(fromAccount, newBalance);

		} else if (type == TransactionType.DEPOSIT) {

			Account toAccount = fetchAccountDetails(accountNumber);
			double newBalance = toAccount.getBalance() + amount;
			updateQueryRes = updateAccountWithNewBalance(toAccount, newBalance);
		}
		return updateQueryRes;
	}

	private int updateAccountWithNewBalance(Account toAccount, double newBalance) {
		int updateQueryRes;
		updateQueryRes = jdbcTemplateObject.update(SQL_UPDATE_ACCOUNT_NEW_BALANCE, newBalance,
				toAccount.getAccountNumber());
		return updateQueryRes;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Account fetchAccountDetails(int accountNumber) {
		Account toAccount = (Account) jdbcTemplateObject.queryForObject(SQL_FETCH_ACCOUNT_DETAILS,
				new Object[] { accountNumber }, new BeanPropertyRowMapper(Account.class));
		return toAccount;
	}
}
