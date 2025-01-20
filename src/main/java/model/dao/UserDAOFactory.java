package model.dao;


public class UserDAOFactory {

private DatabaseUserType type;
	
	public UserDAOFactory() {
		type = DatabaseUserType.DATAUSER;
	}

	public UserDAOFactory(DatabaseUserType tipo) {
		type = tipo;
	}

	public DatabaseUserDAO factory() {
		return new DatabaseUserImp();
	}
	
	private enum DatabaseUserType{
		DATAUSER
	}
}
