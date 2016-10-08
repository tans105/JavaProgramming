
import com.dao.UserDao;

public class EmployeeNumberDemo {

	public static void main(String args[]) {
		UserDao dao = new UserDao();
		System.out.println(dao.validateEmployeeNumber("1234567"));
		dao.updateStatus("1234567", 1);

	}
}
