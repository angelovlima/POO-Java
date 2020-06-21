package l4.servidor;

public class Inicio {
	public static void main(String[] args) throws Exception {
		Servidor s = new Servidor(3000);
		s.escutar();
	}
}
