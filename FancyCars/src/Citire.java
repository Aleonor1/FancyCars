import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Citire extends Mainn {
	
	public AVLtree read() throws IOException {
		
		//File file = new File("C:\\Users\\Adrian\\Desktop\\FancyCars\\src\\input.txt"); 
		File file = new File("C:\\Users\\Adrian\\Desktop\\FancyCars\\input2.txt");
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String st;
		AVLtree avl_total_cars = new AVLtree();
		ArrayList<String> ar = new ArrayList<String>();
		
		while ((st = br.readLine()) != null) {
			
		  if (st.equals("AM")) {
			  
			  ar.removeAll(ar);
			  ar.add(st);
			  
			  for (int i = 0; i < 10; ++i) {
				  ar.add(br.readLine());
			  }
			  cat_AM autovehicul_aux = new cat_AM(ar.get(0) ,ar.get(1) ,ar.get(2) ,ar.get(3) ,ar.get(4) ,ar.get(5) ,ar.get(6) , ar.get(7) , Integer.parseInt(ar.get(8)), ar.get(9), ar.get(10));
			  avl_total_cars.insert(autovehicul_aux);
			  
		  } else if (st.equals("A1")) {
			  
			  ar.removeAll(ar);
			  ar.add(st);
			  
			  for (int i = 0; i < 10; ++i) {
				  ar.add(br.readLine());
			  }
			  cat_A1 autovehicul_aux = new cat_A1(ar.get(0), ar.get(1), ar.get(2), ar.get(3), ar.get(4), ar.get(5), ar.get(6), ar.get(7), Integer.parseInt(ar.get(8)), ar.get(9), Integer.parseInt(ar.get(10)));
			  avl_total_cars.insert(autovehicul_aux);
			  
		  } else if (st.equals("A2")) {
			  
			  ar.removeAll(ar);
			  ar.add(st);
			  
			  for (int i = 0; i < 10; ++i) {
				  ar.add(br.readLine());
			  }
			  cat_A2 autovehicul_aux = new cat_A2(ar.get(0), ar.get(1), ar.get(2), ar.get(3), ar.get(4), ar.get(5), ar.get(6), ar.get(7), Integer.parseInt(ar.get(8)), ar.get(9), Integer.parseInt(ar.get(10)));
			  avl_total_cars.insert(autovehicul_aux);
			  
		  } else if (st.equals("B1")) {
			  
			  ar.removeAll(ar);
			  ar.add(st);
			  
			  for (int i = 0; i < 11; ++i) {
				  ar.add(br.readLine());
			  }
			  cat_B1 autovehicul_aux = new cat_B1(ar.get(0), ar.get(1), ar.get(2), ar.get(3), ar.get(4), ar.get(5), ar.get(6), ar.get(7), Integer.parseInt(ar.get(8)), Integer.parseInt(ar.get(9)), Integer.parseInt(ar.get(10)), Integer.parseInt(ar.get(11)));
			  avl_total_cars.insert(autovehicul_aux);
			  
		  } else if (st.equals("BE")) {
			  
			  ar.removeAll(ar);
			  ar.add(st);
			  
			  for (int i = 0; i < 11; ++i) {
				  ar.add(br.readLine());
			  }
			  cat_BE autovehicul_aux = new cat_BE(ar.get(0), ar.get(1), ar.get(2), ar.get(3), ar.get(4), ar.get(5), ar.get(6), ar.get(7), Integer.parseInt(ar.get(8)), Integer.parseInt(ar.get(9)), Integer.parseInt(ar.get(10)), Integer.parseInt(ar.get(11)));
			  avl_total_cars.insert(autovehicul_aux);
			  
		  } else if (st.equals("C1")) {
			  
			  ar.removeAll(ar);
			  ar.add(st);
			  
			  for (int i = 0; i < 10; ++i) {
				  ar.add(br.readLine());
			  }
			  cat_C1 autovehicul_aux = new cat_C1(ar.get(0), ar.get(1), ar.get(2), ar.get(3), ar.get(4), ar.get(5), ar.get(6), ar.get(7), Integer.parseInt(ar.get(8)), Integer.parseInt(ar.get(9)), Float.parseFloat(ar.get(10)));
			  avl_total_cars.insert(autovehicul_aux);
			  
		  } else if (st.equals("C1E")) {
			  
			  ar.removeAll(ar);
			  ar.add(st);
			  
			  for (int i = 0; i < 10; ++i) {
				  ar.add(br.readLine());
			  }
			  cat_C1E autovehicul_aux = new cat_C1E(ar.get(0), ar.get(1), ar.get(2), ar.get(3), ar.get(4), ar.get(5), ar.get(6), ar.get(7), Integer.parseInt(ar.get(8)), Integer.parseInt(ar.get(9)), ar.get(10));
			  avl_total_cars.insert(autovehicul_aux);
			  
		  } else if (st.equals("CE")) {
			  
			  ar.removeAll(ar);
			  ar.add(st);
			  for (int i = 0; i < 10; ++i) {
				  ar.add(br.readLine());
			  }
			  cat_CE autovehicul_aux = new cat_CE(ar.get(0), ar.get(1), ar.get(2), ar.get(3), ar.get(4), ar.get(5), ar.get(6), ar.get(7), Integer.parseInt(ar.get(8)), Integer.parseInt(ar.get(9)), ar.get(10));
			  avl_total_cars.insert(autovehicul_aux);
			  
		  } else if (st.equals("D1")) {
			  
			  ar.removeAll(ar);
			  ar.add(st);
			  
			  for (int i = 0; i < 10; ++i) {
				  ar.add(br.readLine());
			  }
			  cat_D1 autovehicul_aux = new cat_D1(ar.get(0), ar.get(1), ar.get(2), ar.get(3), ar.get(4), ar.get(5), ar.get(6), ar.get(7), Integer.parseInt(ar.get(8)), Integer.parseInt(ar.get(9)), Boolean.parseBoolean(ar.get(10)));
			  avl_total_cars.insert(autovehicul_aux);
			  
		  } else if (st.equals("D1E")) {
			  
			  ar.removeAll(ar);
			  ar.add(st);
			  
			  for (int i = 0; i < 10; ++i) {
				  ar.add(br.readLine());
			  }
			  cat_D1E autovehicul_aux = new cat_D1E(ar.get(0), ar.get(1), ar.get(2), ar.get(3), ar.get(4), ar.get(5), ar.get(6), ar.get(7), Integer.parseInt(ar.get(8)), Integer.parseInt(ar.get(9)), Boolean.parseBoolean(ar.get(10)));
			  avl_total_cars.insert(autovehicul_aux);
			  
		  } else if (st.equals("DE")) {
			  
			  ar.removeAll(ar);
			  ar.add(st);
			  
			  for (int i = 0; i < 10; ++i) {
				  ar.add(br.readLine());
			  }
			  cat_DE autovehicul_aux = new cat_DE(ar.get(0), ar.get(1), ar.get(2), ar.get(3), ar.get(4), ar.get(5), ar.get(6), ar.get(7), Integer.parseInt(ar.get(8)), Integer.parseInt(ar.get(9)), Float.parseFloat(ar.get(10)));
			  avl_total_cars.insert(autovehicul_aux);  
		  }
		}
		br.close();
		return avl_total_cars;
	}
}
