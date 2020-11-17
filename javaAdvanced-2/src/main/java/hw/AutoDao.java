package hw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutoDao {

	private static String CREAT = "insert into car(`model`, `top_speed`,`coast`) values (?,?,?)";
	private static String READ_BY_ID = "select * from car where id=?";
	private static String READ_ALL = "select * from car";
	private static String DELETE_BY_ID = "delete from car where id=?";
	private static String DROP = "drop table car";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public AutoDao(Connection connection) {
		this.connection = connection;
	}

	public void insert(Auto auto) throws SQLException {
		preparedStatement = connection.prepareStatement(CREAT);
		preparedStatement.setString(1, auto.getModel());
		preparedStatement.setInt(2, auto.getTopSpeed());
		preparedStatement.setInt(3, auto.getCoast());
		preparedStatement.executeUpdate();
	}

	public Auto read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return AutoBuilder.build(result);
	}

	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

	public void drop() throws SQLException {
		preparedStatement = connection.prepareStatement(DROP);
		preparedStatement.executeUpdate();
	}

	public List<Auto> readAll() throws SQLException {
		List<Auto> listOfAuto = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			listOfAuto.add(AutoBuilder.build(result));
		}
		return listOfAuto;
	}

}
