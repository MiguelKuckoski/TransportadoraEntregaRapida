package vo;

public class Usuario {
	private Controle controle;

	public Usuario(Controle controle) {
		this.controle = controle;
	}

	public void cadastrarObjeto(String nomeRemetente, Endereco endRemetente, String nomeDestinatario,
			Endereco endDestinatario, Double peso, String codLocalizador) {

		Pacote pacote = new Pacote(nomeRemetente, endRemetente, nomeDestinatario, endDestinatario, peso,
				codLocalizador);
		controle.addPacote(pacote);
	}

	public void criarRoteiro() {
		// TODO
	}

	public void listarRoteiro() {
		// TODO
	}

	public void cadastrarVeiculo(String marca, String modelo, int ano, String placa, String tipo, Motorista motorista) {
		Veiculo veiculo = new Veiculo();
		if (tipo.equalsIgnoreCase("van")) {
			veiculo = new Van(marca, modelo, ano, placa, tipo);
		} else if (tipo.equalsIgnoreCase("caminh�o")) {
			veiculo = new Caminhao(marca, modelo, ano, placa, tipo);
		} else if (tipo.equalsIgnoreCase("carreta")) {
			veiculo = new Carreta(marca, modelo, ano, placa, tipo);
		}

		if (motorista != null) {
			veiculo.setMotorista(motorista);
		}

		controle.addVeiculo(veiculo);
	}

	public void cadastrarMotorista(String nome, String nascimento, Endereco endereco, String cnhNum, String cnhTipo) {
		Motorista motorista = new Motorista(nome, nascimento, endereco, cnhNum, cnhTipo);
		controle.addMotorista(motorista);
	}

}
