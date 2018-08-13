//implementação de uma arvore binária de busca.
// todos os nós a esquerda da raiz são menores 
// todos os nós a direita da raiz são maiores
// os nós também são arvores binárias de busca.
// implementação da soma dos nós da arvore.

//Desenvolva um método que dado um nó da árvore calcule a soma de todos os nós subsequentes.

//OBS: o método desenvolvido soma todos os nós da arvore. Para evetuar um método que busque apartir de um nó,
// precisa ser especificado o algorítimo - Pré-ordem, in-ordem ou pós-ordem. Uma vez que os nós subsequentes
// são visitados levando em conta um destes. Sendo assim, foi feito uma soma padrão dos nós da arvore.
// Caso deseje a soma seguindo uma das ordenações, favor informar qual, para implementação da sobrecarga do 
// método sum seguindo o algorítimo especificado.

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
