
import java.sql.*;

import java.util.Vector;



public class GestorDB {

	private Connection con;
    
    private String dataSource = "//localhost/games";
    private String username = "root";
    private String password = "toor";
    private String driver = "com.mysql.jdbc.Driver";
    private String protocol = "jdbc:mysql";    
    
    public GestorDB(){
    }
    
    public GestorDB(String dataSource, String username, String password){
    	this.dataSource = dataSource;
    	this.username = username;
    	this.password = password;
    }
    
    public void conectar() throws ClassNotFoundException, SQLException{
        Class.forName(driver);        
        String url = protocol + ":" + dataSource;
        con = DriverManager.getConnection(url, username, password);               
    }
    
    public void desconectar() throws SQLException{
        con.close();
    }    
    
    public Game getGame(int id) throws SQLException{        
    	Game game = null;
    	String select = "select * from GAMES where id='" + id +"'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        if (rs.next()){
        	game = new Game();
        	game.setName(rs.getString("name"));
        	game.setDescription(rs.getString("description"));
        	game.setType(rs.getString("type"));
        	game.setId(rs.getInt("id"));
        	game.setAge(rs.getInt("age"));
        }
        rs.close();
        stmt.close();  
        return game;
    }
    
    public void insertGame(Game game) throws SQLException{
        String insert = "insert into GAMES " +
                        "(name, description, type, age) " +
                        "VALUES ('" + game.getName() +
                        "','" + game.getDescription() +
                        "','" + game.getType() +
                        "','"  + game.getAge() + "')";                        
        Statement stmt = con.createStatement();
        stmt.executeUpdate(insert);
        stmt.close();        
    }
    
   
}