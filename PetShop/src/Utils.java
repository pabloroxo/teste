
public class Utils {

	public static boolean validarCpf(String cpf) {

		String ncpf = cpf.replaceAll("[^\\d]", "");
		
		int soma1 = 0, soma2 = 0, a;
		
		for(a = 0; a < 9; a++) {
			soma1 += (10 - a) * Integer.parseInt(String.valueOf(ncpf.charAt(a)));
		}
		
		soma1 = (soma1 * 10) % 11;
		if(soma1 == 10) {
			soma1 = 0;
		}
		
		for(a = 0; a < 10; a++) {
			soma2 += (11 - a) * Integer.parseInt(String.valueOf(ncpf.charAt(a)));
		}
		
		soma2 = (soma2 * 10) % 11;
		if(soma2 == 10) {
			soma1 = 0;
		}
		
		if(soma1 == Integer.parseInt(String.valueOf(ncpf.charAt(9))) && soma2 == Integer.parseInt(String.valueOf(ncpf.charAt(10))) ) {
			return true;
		}
		
		return false;
	}

}
