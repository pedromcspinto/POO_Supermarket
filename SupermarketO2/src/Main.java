 
import java.util.Scanner;
import Exceptions.CartExistsException;
import Exceptions.EmptyCartException;
import Exceptions.FullCapacityException;
import Exceptions.InexistentCartException;
import Exceptions.InexistentProductException;
import Exceptions.ProductExistsException;
import Exceptions.ProductInexistentOnCartException;
import Iterator.IteratorClass;
import Objects.CartClass;
import Objects.ProductClass;
import Store.Store;


public class Main {
	//Constantes que definem os comandos
	public static final String CC = "CRIA CARRINHO";
	public static final String CA = "CRIA ARTIGO";
	public static final String DEP = "DEPOSITA";
	public static final String REM = "REMOVE";
	public static final String LIST = "LISTA";
	public static final String P = "PAGA";
	public static final String SAIR = "SAIR";
	public static final String CRIA = "CRIA";
	public static final String CARRINHO = "CARRINHO";
	public static final String ARTIGO = "ARTIGO";

	//Constantes que definem as mensagens para o utilizador
	public static final String CARTCREATED = "Carrinho criado com sucesso.";
	public static final String PRODUCTCREATED = "Artigo criado com sucesso.";
	public static final String PRODUCTADDED = "Artigo adicionado com sucesso.";
	public static final String PRODUCTREMOVED = "Artigo removido com sucesso.";
	public static final String SPACE =" ";

	public static void main(String[] args) {   
		Scanner in = new Scanner(System.in);
		Store s = new Store();

		String[] splited = in.nextLine().toUpperCase().split(" "); 

		while (!splited[0].equals(SAIR)){
			switch (splited[0]) {

			case CRIA:
				try {

					if(splited[1].equals(CARRINHO)) {
						String  identifier = splited[2];
						int volume = Integer.parseInt(splited[3]);
						CartClass c = s.Pass1(identifier);
						if(s.indexOfCarts(c)>=0) {
							throw new CartExistsException();

						}
						s.createCart(identifier, volume);
						System.out.println(CARTCREATED);

					}

					if (splited[1].equals(ARTIGO))	{
						String name = splited[2];
						int preco =  Integer.parseInt(splited[3]);
						int volume = Integer.parseInt(splited[4]);
						ProductClass p = s.Pass(name);
						if(s.indexOfProducts(p)>=0) {
							throw new ProductExistsException();

						}
						s.createProduct(name, volume, preco);
						System.out.println(PRODUCTCREATED);
						
					}	
				}catch(CartExistsException e) {
					System.out.println(e.getMessage());

				}catch(ProductExistsException e) {
					System.out.println(e.getMessage());

				}
				break;

			case DEP:
				try {
					String product = splited[1];
					String cart = splited[2];
					ProductClass p = s.Pass(product);
					CartClass c = s.Pass1(cart);
					if(s.indexOfCarts(c)<0) {
						throw new InexistentCartException();

					}
					if(s.indexOfProducts(p)<0) {
						throw new InexistentProductException();

					}

					if(s.isFull(c, p)) {
						throw new FullCapacityException();

					}
					
					
					s.addProduct(product, c);
					System.out.println(PRODUCTADDED);
					
				}
				catch(InexistentCartException e) {
					System.out.println(e.getMessage());

				}
				catch(InexistentProductException e) {
					System.out.println(e.getMessage());

				}
				catch(FullCapacityException e) {
					System.out.println(e.getMessage());

				}
				break;

			case REM: 
				try {
					String product = splited[1];
					String cart = splited[2];	
					CartClass c = s.Pass1(cart);
					
					if(s.indexOfCarts(c)<0) {
						throw new InexistentCartException();

					}
					
					if(s.ProductIsNotInCart(c, product)) {
						throw new ProductInexistentOnCartException();
						
					}
				
					
					s.delProduct(product, c);
					System.out.println(PRODUCTREMOVED);
					
				}
				catch(InexistentCartException e) {
					System.out.println(e.getMessage());

				}
				catch(ProductInexistentOnCartException e) {
					System.out.println(e.getMessage());

				}
			
				
				break;

			case LIST:
				
				try{
					String cart = splited[1];
					CartClass c = s.Pass1(cart);
					if(s.indexOfCarts(c)<0) {
						throw new InexistentCartException();

					}

					if(s.isEmpty(c)) {
						throw new EmptyCartException();

					}
					
					IteratorClass<String> it = s.ListCart(c);
					
					while(it.hasNext()) {
						System.out.println(s.olho(it.next()).toString().toLowerCase());
					
						
					}
					
					}
				
				catch(InexistentCartException e) {
					System.out.println(e.getMessage());

				}
				catch(EmptyCartException e) {
					System.out.println(e.getMessage());

				}
				break;

			case P:
				
				try {
					String cart2 = splited[1];
					CartClass c = s.Pass1(cart2);

					if(s.indexOfCarts(c)<0) {
						throw new InexistentCartException();

					}

					if(s.isEmpty(c)) {
						throw new EmptyCartException();

					}
					
					System.out.println(s.getTotlaPrice(c));
					s.PayCart(c);
				}
				catch(InexistentCartException e) {
					System.out.println(e.getMessage());

				}
				catch(EmptyCartException e) {
					System.out.println(e.getMessage());

				}
				break;

			default:
				System.out.println("ERRO");

			}
			System.out.println();
			splited = in.nextLine().toUpperCase().split(" ");

		}
		System.out.println("Volte sempre.");
		System.out.println();
		in.close();
	}
}