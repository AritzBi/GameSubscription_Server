import java.sql.SQLException;


public class Service {
    public static void main(String[] args) {
        Service test = new Service();
        Game game=new Game("asdahkjda","asdadas",12,"123");
        test.insertGame(game);
        System.out.println("Done!");
    }
    
    public void insertGame(Game game){
    	GestorDB gbd = new GestorDB();
    	try {
			gbd.conectar();
			gbd.insertGame(game);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }
}
