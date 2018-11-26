package Action;

import java.sql.SQLException;
import java.util.List;

import UserDao_dengluxitong.UserDao_dengluxitong;
import User_dengluxitong.User_dengluxitong;

public class Action {

	public static void main(String[] args) throws SQLException {
		UserDao_dengluxitong userdao = new UserDao_dengluxitong();
		List<User_dengluxitong> user=userdao.query();
		for (User_dengluxitong u : user) {
			System.out.println(u.getID()+","+u.getCODE()+","+u.getMOLD()+","+u.getNUM());
		}
		/*
		User_dengluxitong user=new User_dengluxitong();
		user.setID("6656");
		user.setCODE("147258");
		user.setMOLD("Ñ§Éú");
		user.setNUM(1);
		userdao.Add_dengluxitong(user);*/
	}
}
