package model.dao;

public class FabricOrderDAO {
	
	private DatabaseOrderType type;
	
	public FabricOrderDAO() {
		type = DatabaseOrderType.DATAORDER;
	}

	public FabricOrderDAO(DatabaseOrderType tipo) {
		type = tipo;
	}

	public DatabasePedidosDAO factory() {
		return new DatabasePedidosImp();
	}
	
	private enum DatabaseOrderType{
		DATAORDER
	}
}
