package tw.com.vortex.util;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import tw.com.vortex.model.user.bean.UserBean;
import tw.com.vortex.model.user.dao.UserDaoImpl;

public class RandomInsert {
	public static void insertUsers(int counts, int year_start, int year_end) {
		List<UserBean> beanList = new ArrayList<>();
		UserBean bean = null;
		while(counts > 0) {
			String username = getSaltString();
			String password = getSaltString();
			String email = getSaltString()+"@gmail.com";
	        GregorianCalendar gc = new GregorianCalendar();
	        int year = randBetween(year_start, year_end);
	        gc.set(gc.YEAR, year);
	        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
	        gc.set(gc.DAY_OF_YEAR, dayOfYear);
	        String date = gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH);
			String gender  = (Math.random() <= 0.5) ? "male" : "female";
			bean = new UserBean();
			bean.setUsername(username);
			bean.setPassword(password);
			bean.setEmail(email);
			bean.setRegDay(Date.valueOf(date));
			bean.setGender(gender);
			beanList.add(bean);
			counts--;
		}
		try(Connection conn = ConnectionFactory.getConnection()){
			UserDaoImpl dao = new UserDaoImpl(conn);
			dao.insertUser(beanList);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	private static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
