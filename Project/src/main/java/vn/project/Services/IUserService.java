package vn.project.Services;

import java.util.List;

import vn.project.Model.UserModel;

public interface IUserService {

	List<UserModel> FindAll();

	UserModel FindById(int id);

	UserModel FindByUserName(String username);

	void insert(UserModel user);

	void update(UserModel user);

	UserModel login(String username, String password);

	UserModel register(String username, String password, String email, String fullname);

	boolean send(String to, String subject, String password);

	UserModel rp(String email);
}
