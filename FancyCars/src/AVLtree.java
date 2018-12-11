import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class AVLtree extends Mainn {
 
    public Node root;
 
    private static class Node {
        private Autovehicul key1;
        private int balance;
        private int height;
        private Node left;
        private Node right;
        private Node parent;
 
        Node(Autovehicul key1_aux, Node parent) {
            this.key1 = key1_aux;
            this.parent = parent;
        }
    }
 
    public boolean insert(Autovehicul key1_aux) {
        if (root == null) {
            root = new Node(key1_aux, null);
            return true;
        }
 
        Node n = root;
        while (true) {
        	String key1_nr=n.key1.get_nr_matriculare();
        	String key2_nr=key1_aux.get_nr_matriculare();
            if (key1_nr.equals(key2_nr))
                return false;
 
            Node parent = n;
 
            int goLeft_aux = key1_nr.compareTo(key2_nr);
            boolean goLeft = true;
            if ( goLeft_aux > 0 ) {
            	goLeft = true;
            } else {
            	goLeft = false;
            }
            n = goLeft ? n.left : n.right;
 
            if (n == null) {
                if (goLeft) {
                    parent.left = new Node(key1_aux,parent);
                } else {
                    parent.right = new Node(key1_aux, parent);
                }
                rebalance(parent);
                break;
            }
        }
        return true;
    }
    
    public void print(Node n) {
    	
    	if (root == null) {
    		System.out.println("Nu sunt autovehicule inregistrate");
    		
    	} else {
    		
    		System.out.println(n.key1.nr_inmatriculare);
    		if (n.left != null) {
    			print(n.left);
    		}
    		
    		if (n.right != null) {
    			print(n.right);
    		}
    	}
    }
    
    public void print_data(Node n,String data){
    	String[] data1 = data.split("\\/");
    	String[] data2 = n.key1.data_inmatriculare.split("\\/");
    	if (root == null) {
    		System.out.println("Nu sunt autovehicule inregistrate"); 
    	}
    	else
    	{
    		if (Integer.parseInt(data1[2])<Integer.parseInt(data2[2]))
    		{
    			n.key1.print();
    			Mainn.contor_data++;
    		}
    		else if (Integer.parseInt(data1[2])==Integer.parseInt(data2[2]))
    			if (Integer.parseInt(data1[1])<Integer.parseInt(data2[1]))
    			{
        			n.key1.print();
        			Mainn.contor_data++;
        		}
    			else if (Integer.parseInt(data1[2])==Integer.parseInt(data2[2]))
    				if (Integer.parseInt(data1[1])==Integer.parseInt(data2[1]))
    					if (Integer.parseInt(data1[0])<Integer.parseInt(data2[0]))
    					{
    		    			n.key1.print();
    		    			Mainn.contor_data++;
    		    		}
    		if (n.left!=null) {
    			print_data(n.left,data);
    		}
    		if (n.right!=null)
    		{
    			print_data(n.right,data);
    		}
    	}
    
    }
    
    public void buildArray(Node n) {
    	if (root == null) {
    		System.out.println("Nu exista autovehicule in baza de date.");
    	} else {
    		Mainn.autovehicule_sortate_dupa_tip.add(n.key1);
    		Mainn.date_inmatriculare.add(n.key1.get_data_inmatriculare());
    		if (n.left != null) {
    			buildArray(n.left);
    		}
    		if (n.right != null) {
    			buildArray(n.right);
    		}
    	}
    }
    
    public void print_dupa_revizie(Node n,String data){
    	String[] data1 = data.split("\\/");
    	String[] data2 = n.key1.data_ultimei_revizii.split("\\/");
    	if (root == null) {
    		System.out.println("Nu sunt autovehicule inregistrate"); 
    	}
    	else
    	{
    		if (Integer.parseInt(data1[2])>Integer.parseInt(data2[2]))
    		{
    			n.key1.print();
    			Mainn.contor_revizie++;
    		}
    		else if (Integer.parseInt(data1[2])==Integer.parseInt(data2[2]))
    			if (Integer.parseInt(data1[1])>Integer.parseInt(data2[1]))
    			{
        			n.key1.print();
        			Mainn.contor_revizie++;
        		}
    			else if (Integer.parseInt(data1[2])==Integer.parseInt(data2[2]))
    				if (Integer.parseInt(data1[1])==Integer.parseInt(data2[1]))
    					if (Integer.parseInt(data1[0])>Integer.parseInt(data2[0]))
    					{
    		    			n.key1.print();
    		    			Mainn.contor_revizie++;
    		    		}
    		if (n.left!=null) {
    			print_dupa_revizie(n.left,data);
    		}
    		if (n.right!=null)
    		{
    			print_dupa_revizie(n.right,data);
    		}
    	}
    
    }
    public void search_by_name(String nume_aux, Node n) {
    	if (root == null) {
    		System.out.println("Baza de date goala.");
    	} else {
    		String proprietar_aux = n.key1.get_nume();
    		if (proprietar_aux.equals(nume_aux)) {
    			n.key1.print();
    			Mainn.parametru_aux_4+=1;
    		}
    		if (n.left != null) {
    			search_by_name(nume_aux, n.left);
    		}
    		if (n.right != null) {
    			search_by_name(nume_aux, n.right);
    		}
    	}
    }

    
    public <E> E search_car(String search) {
    	if (root == null) {
    		//Autovehicul aux = new Autovehicul();
    		//return aux;
    		return (E) "no autovehicles";
    	} else {
    		String key1_aux = root.key1.get_nr_matriculare();
    		if (search.equals(key1_aux)) {
    			return (E) root.key1;
    		} else {
    			if (search.compareTo(key1_aux)<0) {
    				return search(search,root.left);
    			} else {
    				return search(search,root.right);
    			}
    		}
    	}
    }
    
    private <E> E search(String what, Node where) {
    	String key1_aux = where.key1.get_nr_matriculare();
    	if (what.equals(key1_aux)) {
			return (E) where.key1;
		} else {
			if (what.compareTo(key1_aux)<0) {
				if (where.left != null) {
					return search(what,where.left);
				} else {
					//Autovehicul aux = new Autovehicul();
					//System.out.println("Not found");
					return (E) "not found";
				}
			} else {
				if (where.right != null) {
					return search(what,where.right);
				} else {
					//Autovehicul aux = new Autovehicul();
					//System.out.println("Not found");
					return (E) "not found";
				}
			}
		}
    }
 
    private void delete(Node node) {
        if (node.left == null && node.right == null) {
            if (node.parent == null) {
                root = null;
            } else {
                Node parent = node.parent;
                if (parent.left == node) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                rebalance(parent);
            }
            return;
        }
 
        if (node.left != null) {
            Node child = node.left;
            while (child.right != null) child = child.right;
            node.key1 = child.key1;
            delete(child);
        } else {
            Node child = node.right;
            while (child.left != null) child = child.left;
            node.key1 = child.key1;
            delete(child);
        }
    }
 
    public void delete(String delKey) {
        if (root == null)
            return;
 
        Node child = root;
        while (child != null) {
            Node node = child;
            String key1_nr = node.key1.get_nr_matriculare();
            int goLeft_aux = key1_nr.compareTo(delKey);
            System.out.println(goLeft_aux + " " + key1_nr);
            boolean goLeft = true;
            if ( goLeft_aux < 0 ) {
            	goLeft = true;
            } else {
            	goLeft = false;
            }
            child = goLeft ? node.right : node.left;
            if (delKey.equals(key1_nr)) {
            	System.out.println("found");
                delete(node);
                return;
            }
        }
    }
 
    private void rebalance(Node n) {
        setBalance(n);
 
        if (n.balance == -2) {
            if (height(n.left.left) >= height(n.left.right))
                n = rotateRight(n);
            else
                n = rotateLeftThenRight(n);
 
        } else if (n.balance == 2) {
            if (height(n.right.right) >= height(n.right.left))
                n = rotateLeft(n);
            else
                n = rotateRightThenLeft(n);
        }
 
        if (n.parent != null) {
            rebalance(n.parent);
        } else {
            root = n;
        }
    }
 
    private Node rotateLeft(Node a) {
 
        Node b = a.right;
        b.parent = a.parent;
 
        a.right = b.left;
 
        if (a.right != null)
            a.right.parent = a;
 
        b.left = a;
        a.parent = b;
 
        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }
 
        setBalance(a, b);
 
        return b;
    }
 
    private Node rotateRight(Node a) {
 
        Node b = a.left;
        b.parent = a.parent;
 
        a.left = b.right;
 
        if (a.left != null)
            a.left.parent = a;
 
        b.right = a;
        a.parent = b;
 
        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }
 
        setBalance(a, b);
 
        return b;
    }
 
    private Node rotateLeftThenRight(Node n) {
        n.left = rotateLeft(n.left);
        return rotateRight(n);
    }
 
    private Node rotateRightThenLeft(Node n) {
        n.right = rotateRight(n.right);
        return rotateLeft(n);
    }
 
    private int height(Node n) {
        if (n == null)
            return -1;
        return n.height;
    }
 
    private void setBalance(Node... nodes) {
        for (Node n : nodes) {
            reheight(n);
            n.balance = height(n.right) - height(n.left);
        }
    }
 
    public void printBalance() {
        printBalance(root);
    }
 
    private void printBalance(Node n) {
        if (n != null) {
            printBalance(n.left);
            System.out.printf("%s ", n.balance);
            printBalance(n.right);
        }
    }
 
    private void reheight(Node node) {
        if (node != null) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }
    }
    
    public void write(Node n, BufferedWriter write_avl, FileWriter file_avl) throws IOException {
		if (root == null) {
			System.out.println("Nu exista autovehicule in baza de date.");
		} else {
			n.key1.write_in_file(write_avl, file_avl);
			if (n.left != null) {
				write(n.left, write_avl, file_avl);
			}
			if (n.right != null) {
				write(n.right, write_avl, file_avl);
			}
		}
    }
    
    
}