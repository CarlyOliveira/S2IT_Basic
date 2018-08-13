import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Questao8 {

	public static void main(String[] args) {

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("Digite o primeiro número inteiro.");
			String str = in.readLine();
			Integer n1 = Integer.parseInt(str);
			System.out.print("Digite o segundo número inteiro.");
			str = in.readLine();
			Integer n2 = Integer.parseInt(str);

			System.out.println("Gerando o terceiro número.");
			String resposta = gerarN3(n1, n2).toString();

			System.out.println("Valor de número C:" + resposta);

		} catch (NumberFormatException e) {
			System.out.println(
					"Ocorreu um erro. O formato do valor digitado é invalido. Por favor, digite números inteiros que unidos estejam entre:"
							+ "-2147483648 a + 2147483647. ");
		} catch (Exception e) {
			System.out.println("Ocorreu um erro. Apenas números inteiros são válidos.");
		}

	}

	static Integer gerarN3(Integer n1, Integer n2) {

		char[] arrayN1;
		char[] arrayN2;

		arrayN1 = n1.toString().toCharArray();
		arrayN2 = n2.toString().toCharArray();

		char[] arrayN3 = new char[arrayN2.length + arrayN1.length];

		if (arrayN1.length == arrayN2.length) {

			for (int i = 0; i < (arrayN1.length + arrayN2.length); i++) {

				if (i % 2 != 0) {
					arrayN3[i] = arrayN2[(i - 1) / 2];
				} else {
					arrayN3[i] = arrayN1[(((i + 2) / 2) - 1)];
				}
			}

		} else if (arrayN1.length > arrayN2.length) {

			for (int i = 0; i < (arrayN2.length + arrayN1.length); i++) {

				if (i % 2 != 0 && ((i - 1) / 2) < arrayN2.length) {
					arrayN3[i] = arrayN2[(i - 1) / 2];
				} else {
					if (((i - 1) / 2) < arrayN2.length) {
						arrayN3[i] = arrayN1[(((i + 2) / 2) - 1)];
					} else {
						arrayN3[i] = arrayN1[((arrayN1.length) - ((arrayN2.length + arrayN1.length) - i))];
					}
				}
			}
		} else {

			for (int i = 0; i < (arrayN1.length + arrayN2.length); i++) {

				if (i % 2 == 0 && (i - 1) < arrayN1.length) {
					arrayN3[i] = arrayN1[(((i + 2) / 2) - 1)];
				} else {
					if ((i - 1) < arrayN1.length) {
						arrayN3[i] = arrayN2[(i - 1) / 2];
					} else {
						arrayN3[i] = arrayN2[((arrayN2.length) - ((arrayN2.length + arrayN1.length) - i))];
					}
				}

			}

		}

		Integer c = Integer.valueOf(String.copyValueOf(arrayN3));

		if (c > 1000000) {
			c = -1;
		}

		return c;

	}

}
