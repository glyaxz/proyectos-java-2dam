package EjerciciosTema2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ejercicio2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/Unidad2", "accesoDatos","Usuario1.");
			
			String ventaId = args[0];
			String clienteId = args[1];
			String productoId = args[2];
			String cantidad = args[3];
			String date = "curdate()";
			
			if(Integer.parseInt(cantidad) >= 0) {
				PreparedStatement ps = connect.prepareStatement("insert into ventas values("
										+ "?,"
										+ "?,"
										+ "?,"
										+ "?,"
										+ "? "
										+ ")");
				
				ps.setInt(1, Integer.parseInt(ventaId));
				LocalDate today = LocalDateTime.now().toLocalDate();
				ps.setString(2, today.toString());
				ps.setInt(3, Integer.parseInt(clienteId));
				ps.setInt(4, Integer.parseInt(productoId));
				ps.setInt(5, Integer.parseInt(cantidad));
				
				ps.executeUpdate();
				
				System.out.println("Insert realizado");
				
			}else {
				System.out.println("La cantidad introducida es menor a 0");
				System.err.println("No ha sido posible realizar el Insert");
			}
			

			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			int errorCode = e.getErrorCode();
			switch(errorCode) {
				case 1062:
					System.out.println("La clave primaria está duplicada");
					break;
				
				case 1216:
					System.out.println("Un identificador externo no coincide con los datos");
					break;
				default:
					System.out.println("Código de error no identificado: " + errorCode + "\n"
							 + "Mensaje del SGBD: " + e.getMessage());
			}
			System.err.println("No ha sido posible realizar el Insert");
		}

	}
}
