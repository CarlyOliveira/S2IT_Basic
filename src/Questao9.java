//implementa��o de uma arvore bin�ria de busca.
// todos os n�s a esquerda da raiz s�o menores 
// todos os n�s a direita da raiz s�o maiores
// os n�s tamb�m s�o arvores bin�rias de busca.
// implementa��o da soma dos n�s da arvore.

//Desenvolva um m�todo que dado um n� da �rvore calcule a soma de todos os n�s subsequentes.

//OBS: o m�todo desenvolvido soma todos os n�s da arvore. Para evetuar um m�todo que busque apartir de um n�,
// precisa ser especificado o algor�timo - Pr�-ordem, in-ordem ou p�s-ordem. Uma vez que os n�s subsequentes
// s�o visitados levando em conta um destes. Sendo assim, foi feito uma soma padr�o dos n�s da arvore.
// Caso deseje a soma seguindo uma das ordena��es, favor informar qual, para implementa��o da sobrecarga do 
// m�todo sum seguindo o algor�timo especificado.

public class Questao9 {

	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree();

		System.out.println(binaryTree);
		binaryTree.insert(8);
		System.out.println(binaryTree);
		binaryTree.insert(12);
		System.out.println(binaryTree);
		binaryTree.insert(14);
		System.out.println(binaryTree);
		binaryTree.insert(3);
		System.out.println(binaryTree);
		binaryTree.insert(6);
		System.out.println(binaryTree);
		binaryTree.insert(7);
		System.out.println(binaryTree);
		binaryTree.insert(9);
		System.out.println(binaryTree);
		binaryTree.insert(22);
		System.out.println(binaryTree);
		System.out.println(binaryTree.sum());

	}

	static class BinaryTree {

		private No root;

		public void insert(int valor) {
			if (root == null) {
				root = new No(valor);
			} else {
				No no = new No(valor);
				insert(root, no);
			}
		}

		private void insert(No tree, No no) {
			if (no.value > tree.value) {
				if (tree.rigth == null) {
					tree.rigth = no;
				} else {
					insert(tree.rigth, no);
				}
			} else {
				if (tree.left == null) {
					tree.left = no;
				} else {
					insert(tree.left, no);
				}
			}
		}

		public int sum() {
			return root == null ? 0 : root.sum();
		}

		@Override
		public String toString() {
			return root == null ? "*" : root.toString();
		}

		private class No {

			private int value;
			private No rigth;
			private No left;

			public No(int value) {
				this.value = value;
			}

			public int sum() {
				return value + (rigth == null ? 0 : rigth.sum()) + (left == null ? 0 : left.sum());
			}

			@Override
			public String toString() {
				return (left == null ? "*" : "(" + left + ")") + value + (rigth == null ? "*" : "(" + rigth + ")");
			}
		}
	}

}
