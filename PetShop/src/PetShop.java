
public class PetShop {

	public static void main(String[] args) {
		//int a;
		//for(a = 0; a < 100; a++) {
		//	String cpf = "888888888";
		//	if(a >= 0 && a < 10) {
		//		cpf += "0";
		//	}
		//	cpf += String.valueOf(a);
		//	System.out.print(cpf + ": ");
		//	if(Utils.validarCpf(cpf)) {
		//		System.err.println("CPF válido\n");
		//	} else {
		//		System.out.println("CPF inválido\n");
		//	}
		//}
		
		
		
		
		BD bd = new BD();
		bd.conectar();
		
		GatoRepositorio gatoRepo = new GatoRepositorio(bd);
		
		TelaGatoListagem telaGatoListagem = new TelaGatoListagem(gatoRepo);
		telaGatoListagem.setVisible(true);
	}

}
