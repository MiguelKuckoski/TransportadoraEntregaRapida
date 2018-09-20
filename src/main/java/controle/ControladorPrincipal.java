package controle;

public class ControladorPrincipal {

	private ControleVeiculo controleVeiculo;
	private ControleMotorista controleMotorista;
	private ControlePacote controlePacote;
	private ControleRota controleRota;

	public ControladorPrincipal() {

		this.controleVeiculo = new ControleVeiculo();
		this.controleMotorista = new ControleMotorista();
		this.controlePacote = new ControlePacote();
		this.controleRota = new ControleRota();
	}

	public ControleMotorista getControleMotorista() {
		return controleMotorista;
	}

	public void setControleMotorista(ControleMotorista controleMotorista) {
		this.controleMotorista = controleMotorista;
	}

	public ControleVeiculo getControleviculo() {
		return controleVeiculo;
	}

	public void setControleviculo(ControleVeiculo controleviculo) {
		this.controleVeiculo = controleviculo;
	}

	public ControleVeiculo getControleVeiculo() {
		return controleVeiculo;
	}

	public void setControleVeiculo(ControleVeiculo controleVeiculo) {
		this.controleVeiculo = controleVeiculo;
	}

	public ControlePacote getControlePacote() {
		return controlePacote;
	}

	public void setControlePacote(ControlePacote controlePacote) {
		this.controlePacote = controlePacote;
	}

	public ControleRota getControleRota() {
		return controleRota;
	}

	public void setControleRota(ControleRota controleRota) {
		this.controleRota = controleRota;
	}

}
