package l4;

public class Inicio {
	public static void main(String[] args) throws Exception {
		String ip = EnvioComentario.pegaIpCliente();
		String nomeUser = EnvioComentario.pegaNomeComputador();
		Cliente c = new Cliente(ip, 3000, nomeUser);
		EnvioComentario.comentar(c);

		//EnvioComentario.comentar(c);
	}
}
