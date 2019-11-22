package user;
import java.util.List;

import user.User;
public interface UserDAO {
	public void insertUser(User user);//声明插入（增）方法
	public void updateUser(User user);//声明更新（改）方法
	public void deleteUser(String sid);//声明删除方法
	public User getUser(String sid);//声明查询一个用户信息的方法
	public List<User> getUserByC(String sql);// 声明查询多个用户信息的方法
}
