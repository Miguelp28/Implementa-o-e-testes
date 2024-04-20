package entidade;

public class Carro extends Veiculo{
//ATRIBUTOS
	private String placa;
	private String tracao;
	private int velocidadeAtual;
	private int velocidadeMax;
//CONSTRUTOR
	public Carro(String marca, String modelo, String cor, String placa, String tracao, int velocidadeMax) {
		super(marca, modelo, cor);
		this.placa = placa;
		this.tracao = tracao;
		this.velocidadeMax = velocidadeMax;
	}
//METODOS
	@Override
	public void acelerar(){//não sera 
		if(isStatusFuncionamento() == true) {
			for (int i = 0; i < velocidadeMax; i++) {
				velocidadeAtual = i;
				System.out.println("O carro está acelerando!! velocidade atual: km/h:"+velocidadeAtual);
			}
		}else {
			System.out.println("Carro está desligado");
		}
	}
	@Override
	public void frear(){
		if(isStatusFuncionamento() == true) {
			while(velocidadeAtual > 0) {
				System.out.println("O carro está freiando!! velocidade atual: km/h:"+velocidadeAtual);
				velocidadeAtual --;
			}
		}else {
			System.out.println("O carro está parado e desligado");
		}
	}
//TOSTRING
	@Override
		public String toString() {
			return "Marca: "+getMarca()+"\nModelo: "+getModelo()+"\nCor: "+getCor()+"\nPlaca: "+placa+"\nTração: "+tracao+"\nVelocidade maxima: "+velocidadeMax+"Km/h";
		}
//GETTERS AND SETTERS
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getTracao() {
		return tracao;
	}
	public void setTracao(String tracao) {
		this.tracao = tracao;
	}
	public int getVelocidadeAtual() {
		return velocidadeAtual;
	}
	public void setVelocidadeAtual(int velocidadeAtual) {
		this.velocidadeAtual = velocidadeAtual;
	}
	public int getVelocidadeMax() {
		return velocidadeMax;
	}
	public void setVelocidadeMax(int velocidadeMax) {
		this.velocidadeMax = velocidadeMax;
	}
	
}
