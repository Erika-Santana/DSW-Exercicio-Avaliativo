package model.dao;


public class FabricUserDAO {

private DatabaseUserType type;
	
	public FabricUserDAO() {
		type = DatabaseUserType.DATAUSER;
	}

	public FabricUserDAO(DatabaseUserType tipo) {
		type = tipo;
	}

	public DatabaseUserDAO factory() {
		return new DatabaseUserImp();
	}
	
	private enum DatabaseUserType{
		DATAUSER
	}
}
