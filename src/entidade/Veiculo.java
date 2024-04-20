package entidade;

public abstract class Veiculo {
//ATRIBUTOS
	private String marca;
	private String modelo;
	private String cor;
	private boolean statusFuncionamento = false;
//CONSTRUTOR
	public Veiculo(String marca, String modelo, String cor) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
	}
//METODOS
	public abstract void acelerar();
	public abstract void frear();
	public boolean ligar() {
		return statusFuncionamento = true;
	}
	public boolean desligar() {
		return statusFuncionamento = false;
	}
//GETTERS AND SETTERS
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public boolean isStatusFuncionamento() {
		return statusFuncionamento;
	}
	public void setStatusFuncionamento(boolean statusFuncionamento) {
		this.statusFuncionamento = statusFuncionamento;
	}
	
	
}