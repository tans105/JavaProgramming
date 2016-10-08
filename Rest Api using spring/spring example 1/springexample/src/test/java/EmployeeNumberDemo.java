
import com.dao.UserDao;

public class EmployeeNumberDemo {

	public static void main(String args[]) {
		UserDao dao = new UserDao();
		System.out.println(dao.validateEmployeeNumber("321"));

	}
}
