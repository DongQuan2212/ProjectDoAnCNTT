package vn.project.Dao;

import java.util.List;

import vn.project.Model.UserModel;

public interface IUserDao {

	List<UserModel> FindAll();

	UserModel FindById(int id);

	void insert(UserModel user);

	void update(UserModel user);

	UserModel FindByUserName(String username);

	UserModel FindByEmail(String email);
	
	UserModel rp(String email);

}
