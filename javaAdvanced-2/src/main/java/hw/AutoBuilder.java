package hw;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AutoBuilder {

	public static Auto build(ResultSet result) throws SQLException {

		int id = result.getInt("id");
		String model = result.getString("model");
		int topSpeed = result.getInt("top_speed");
		int coast = result.getInt("coast");

		return new Auto(model, topSpeed, coast);
	}

}
