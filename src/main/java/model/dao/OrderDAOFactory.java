package model.dao;

public class OrderDAOFactory {
	
	/**/
	private DatabaseOrderType type;
	
	public OrderDAOFactory() {
		type = DatabaseOrderType.DATAORDER;
	}

	public OrderDAOFactory(DatabaseOrderType tipo) {
		type = tipo;
	}

	public DatabasePedidosDAO factory() {
		return new DatabasePedidosImp();
	}
	
	private enum DatabaseOrderType{
		DATAORDER
	}
}
