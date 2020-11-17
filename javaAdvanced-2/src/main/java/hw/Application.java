package hw;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args)
			throws Exception, IllegalAccessException, ClassNotFoundException, SQLException {

		AutoDao autoDao = new AutoDao(ConnectionUtils.connectToDB());

		List<Auto> listOfAuto = new ArrayList<>();
		listOfAuto.add(new Auto("Audi", 320, 50000));
		listOfAuto.add(new Auto("Bmw", 300, 45000));
		listOfAuto.add(new Auto("Mersedes", 300, 60000));

		// INSERT

		listOfAuto.forEach(auto -> {
			try {
				autoDao.insert(auto);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});

		// READ-BY-ID

		Auto autoFromDB = autoDao.read(1);
		System.out.println(autoFromDB);

		// READ-ALL
		autoDao.readAll().forEach(System.out::println);
		System.out.println("************************************************\n");

		// DELETE
		autoDao.delete(3);

		// READ-ALL
		autoDao.readAll().forEach(System.out::println);
		System.out.println("************************************************\n");

		// DROP
		autoDao.drop();

		// READ-ALL
		autoDao.readAll().forEach(System.out::println);
		System.out.println("************************************************\n");
	}

}
