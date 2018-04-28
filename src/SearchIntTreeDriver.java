
public class SearchIntTreeDriver {

	public static void main(String[] args) {
		SearchIntTree sit = new SearchIntTree();
		
		sit.add(55);
		sit.add(87);
		sit.add(60);
		sit.add(29);
		sit.add(42);
		sit.add(91);
		sit.add(-3);
		
		sit.print();
		System.out.println('\n');
		sit.printSideways();
		System.out.println();
		
		System.out.println("Removing 42");
		sit.remove(42);	//remove leaf
		sit.printSideways();
		
		System.out.println("\nRemoving 29");
		sit.remove(29);	//remove node with left child only
		sit.printSideways();
		
		System.out.println("\nRemoving 55");
		sit.remove(55);	//remove node with two children
		sit.printSideways();
		
		System.out.println("\nRemoving 55");
		sit.remove(87);	//remove node with right child only
		sit.printSideways();
		
		System.out.println('\n');
		sit.print();
	}

}
