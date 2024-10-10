package vn.project.Services.Impl;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import vn.project.Dao.IUserDao;
import vn.project.Dao.Impl.Userimpl;
import vn.project.Model.UserModel;
import vn.project.Services.IUserService;

public class UserServiceImpl implements IUserService{

	
	public  IUserDao userdao = new Userimpl();
	
	@Override
	public List<UserModel> FindAll() {
	
		return userdao.FindAll();
	}

	@Override
	public UserModel FindById(int id) {
		return userdao.FindById(id);
	}

	@Override
	public void insert(UserModel user) {
		userdao.insert(user);
	}

	@Override
	public void update(UserModel user) {
		userdao.update(user);
	}

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.FindByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel register(String username, String password, String email, String fullname) {
		userdao.insert(new UserModel(username, password, email,fullname));
		return null;
	}

	@Override
	public UserModel FindByUserName(String username) {
		return userdao.FindByUserName(username);
	}

	@Override
	public boolean send(String to, String subject, String password) {
		// Get properties object
				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.host", sendEmail.HOST_NAME);
				props.put("mail.smtp.socketFactory.port", sendEmail.SSL_PORT);
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.port", sendEmail.SSL_PORT);

				// get Session
				Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(sendEmail.APP_EMAIL, sendEmail.APP_PASSWORD);
					}
				});

				// compose message
				try {

					MimeMessage message = new MimeMessage(session);
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
					message.setSubject("Testing Subject");
					message.setText(" Mật khẩu mới của bạn là: 123456");

					// send message
					Transport.send(message);
					return true;

				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}
	}

	@Override
	public UserModel rp(String email) {
		return null;
	}

}
