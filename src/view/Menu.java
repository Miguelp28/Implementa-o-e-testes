package view;

import java.util.ArrayList;
import java.util.Scanner;
import entidade.Carro;

public class Menu {
//	INICIALIZAÇÃO DO ARRAYLIST-----------------------------------------------------------------------------------------------------------------
	private static ArrayList<Carro> catalogoCarro = new ArrayList<>();
//	LOOP MENU PRINCIPAL------------------------------------------------------------------------------------------------------------------------
	public void menuPrincipal(){
		boolean stop = true;//stop loop menu principal
		while(stop == true){
			try {
				System.out.println("Seja bem vindo a concessionaria Simas Turbo");
				System.out.print("Escolha uma das opções abaixo: \n[1]Olhar Catalogo de veiculos \n[2]Adicionar um veiculo ao catalogo "
						+ "\n[3]Informações de contato \n[4]Excluir um carro \n[5]Testar carro dinamometro automatico\n[6]Sair do app \nOpção: ");
				int opt = Integer.parseInt(scanner.nextLine());//metodo para identificar a entrada se é string ou int
				if(opt == 1){
					catalogo();
				}else if(opt == 2){
					addCarroMenu();
				}else if(opt == 3){
					infoContato();
				}else if(opt == 4){
					dellCarroMenu();
				}else if(opt == 5){
					dinamometro();
				}else if(opt == 6){
					scanner.close();
					stop = false;
				}
			} catch (Exception e) {
				menuErrado();
			}
			
		}
	}
//	MENU GENERICO------------------------------------------------------------------------------------------------------------------------------
	private void menuErrado() {
		spacoVazio();
		System.out.println("Opção incorreta ou valor incorreto, pressione enter para retornar a menu principal:");
		scanner.nextLine();
	}
	private void menuErradoAdicao() {
		spacoVazio();
		System.out.println("Esta placa já existe no sistema, pressione enter para retornar a menu principal:");
		scanner.nextLine();
	}
	private void dadosNaoEncontrados(){
		spacoVazio();
		System.out.println("O carro informado não possuimos em catalogo ou foi digitado incorretamente! pressione enter para voltar ao menu");
		scanner.nextLine();
	}
	private void dadosEncontrados(){
		spacoVazio();
		System.out.println("Estes foram os dados do veiculo, precione enter para voltar ao menu!");
		scanner.nextLine();
	}
	private void confirmacao(){
		spacoVazio();
		System.out.println("Dados salvos, precione enter para continuar: ");
		scanner.nextLine();
	}
	private void confirmacaoCancelamento(){
		spacoVazio();
		System.out.println("Operação cançelado com sucesso, precione enter para continuar: ");
		scanner.nextLine();
	}
//	MENU SECUNDARIO----------------------------------------------------------------------------------------------------------------------------
	private void catalogo(){
		spacoVazio();
		System.out.println("Deseja procurar por \n[1]placa \n[2]Ou ver o acervo de carros da Simas Turbo?");
		int opt1 = Integer.parseInt(scanner.nextLine());
		if(opt1 == 1){
			spacoVazio();
			System.out.println("Qual a placa do carro?");
			String placa = scanner.nextLine().trim();
			if(findCarByPlate(placa) != null){
				spacoVazio();
				spaco();
				System.out.println(findCarByPlate(placa).toString());;
				spaco();
				dadosEncontrados();
			}else{
				dadosNaoEncontrados();
			}
		}else if(opt1 == 2){
			if(catalogoCarro.isEmpty() == true){
				System.out.println("Não existe carros em nosso sistema no momento, precione enter para voltar ao menu:");
				scanner.nextLine();
			}else if(catalogoCarro.isEmpty() == false){
				spacoVazio();
				historicoCatalogo();
				System.out.println("Precione enter para voltar ao menu");
				scanner.nextLine();
			}
		}else{
			menuErrado();
		}
	}
	private void addCarroMenu(){
		spacoVazio();
		System.out.print("Qual a marca do carro: ");
		String marca = scanner.nextLine();
		System.out.print("\nQual o modelo do carro: ");
		String modelo = scanner.nextLine();
		System.out.print("\nQual a cor do carro: ");
		String cor = scanner.nextLine();
		System.out.print("\nQual a placa do carro: ");
		String placa = scanner.nextLine().trim();
		System.out.print("\nQual a tração do carro: ");
		String tracao = scanner.nextLine();
		System.out.print("\nQual a velocidade maxima(Somente numero inteiro): ");
		int velmax = Integer.parseInt(scanner.nextLine());
		spacoVazio();
		System.out.println("Confira os dados abaixo: ");
		spaco();
		System.out.println("Marca: "+marca+"\nModelo: "+modelo+"\nCor: "+cor+"\nPlaca: "+placa+"\nTração: "+tracao+"\nVelocidade maxima: "+velmax+"km/h");
		spaco();
		System.out.print("Deseja adicionar este veiculo no sistema:\n[1]Sim \n[2]Não \nOpção: ");
		int opt1 = Integer.parseInt(scanner.nextLine());
		if(opt1 == 1 && findCarByPlate(placa) == null){
			addCarroLista(marca, modelo, cor, placa, tracao, velmax);
			confirmacao();
		}else if(opt1 == 2){
			System.out.println("Adição do carro foi cancelado com sucesso!! precione enter para voltar ao menu");			
			scanner.nextLine();
		}else if(findCarByPlate(placa) != null){
			menuErradoAdicao();
		}else{
			menuErrado();
		}
	}
	private void infoContato(){
		spacoVazio();
		System.out.println("Telefone: 11 9999-9999 \nE-Mail: SimasTurbo@suporte.com");
		System.out.println("Precione enter para voltar ao menu");
		scanner.nextLine();
	}
	private void dellCarroMenu(){
		spacoVazio();
		System.out.print("Digite a placa do veiculo: ");
		String placa = scanner.nextLine();
		if(findCarByPlate(placa) != null){
			System.out.println("Deseja deletar o carro: ");
			spaco();
			System.out.println(findCarByPlate(placa).toString());
			spaco();
			System.out.print("Confirme com [1] ou cançele com [2]: ");
			int opt1 = Integer.parseInt(scanner.nextLine());
			if(opt1 == 1){
				dellCarroLista(placa);
			}else if(opt1 == 2){
				confirmacaoCancelamento();
			}else{
				menuErrado();
			}
		}else{
			dadosNaoEncontrados();
		}
	}
	private void dinamometro(){
		spacoVazio();
		System.out.print("Digite a placa de qual carro deseja testar: ");
		String placa = scanner.nextLine();
		if(findCarByPlate(placa) != null){
			spaco();
			System.out.println(findCarByPlate(placa).toString());
			spaco();
			findCarByPlate(placa).ligar();
			findCarByPlate(placa).acelerar();
			findCarByPlate(placa).frear();
			findCarByPlate(placa).desligar();
			System.out.println("O carro está perfeito! Precione enter para voltar ao menu: ");
			scanner.nextLine();
		}else if(findCarByPlate(placa) == null){
			dadosNaoEncontrados();
		}else{
			menuErrado();
		}
	}
//	METODOS------------------------------------------------------------------------------------------------------------------------------------
	private void historicoCatalogo(){// VARRE A LISTA DO CATALOGO
		for(Carro car : catalogoCarro){
			spaco();
			System.out.println(car.toString());
			spaco();
		}
	}
	private Carro findCarByPlate(String placa){// BUSCA PELA PLACA DO CARRO
		for(Carro car: catalogoCarro){
			if(car.getPlaca().equalsIgnoreCase(placa)){
				return car;
			}
		}
		return null;
	}
	private void addCarroLista(String marca, String modelo, String cor, String placa, String tracao, int velocidadeMax){// ADICIONAR CARRO NA LISTA
		spacoVazio();
		catalogoCarro.add(new Carro(marca, modelo, cor, placa, tracao, velocidadeMax));
	}
	private void dellCarroLista(String placa){// APAGAR CARRO DA LISTA
		catalogoCarro.remove(findCarByPlate(placa));
	}
//	METODOS SIMPLES
	private void spaco() {System.out.println("********************************************************");};
	private void spacoVazio(){System.out.println("\n");};
	private Scanner scanner = new Scanner(System.in);
}
