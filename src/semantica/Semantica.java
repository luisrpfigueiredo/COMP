package semantica;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import Matrix.Node;
import Matrix.SimpleNode;

public class Semantica {

	private static HashMap<String, double[][]> symbolTable= new HashMap<>();;
	
	public static void analise(Node node) throws Exception{
	 	SimpleNode n = (SimpleNode) node; 
		
		for(int i = 0; i < n.jjtGetNumChildren(); i++) {
			
			switch(n.jjtGetChild(i).toString()){
			case "input":
				if(symbolTable.get((String) ((SimpleNode) n.jjtGetChild(i)).jjtGetValue())!=null)
					throw new Exception("vari�vel de input j� declarada"); 
				double [][] matrix = analisaTamanhoLinha(n.jjtGetChild(i));
				symbolTable.put((String) ((SimpleNode) n.jjtGetChild(i)).jjtGetValue(), matrix);
				analise(n.jjtGetChild(i));
				break;
				
			case "output":
				analise(n.jjtGetChild(i));
				break;
				
			case "InnerArray":
				analise(n.jjtGetChild(i));
				break;
				
			case "Term":
				SimpleNode filho= (SimpleNode)  n.jjtGetChild(i);
				Object objeto = filho.jjtGetValue();
				
				if (!(objeto instanceof Double)){
					throw new Exception("N�o � double"); 
				}
				break;
				
			case "Matrix":
				if(symbolTable.get((String) ((SimpleNode) n.jjtGetChild(i)).jjtGetValue())==null)
					throw new Exception("vari�vel de input - " +(String) ((SimpleNode) n.jjtGetChild(i)).jjtGetValue()+" nao foi declarada"); 
				break;

			case "Mul":
				analise(n.jjtGetChild(i));
				break;
				
			case "Add":
				
				verificaSePodeSomar(n.jjtGetChild(i));
				analise(n.jjtGetChild(i));
				break;
				
			case "Sub":
				verificaSePodeSubtrair(n.jjtGetChild(i));
				analise(n.jjtGetChild(i));
				break;
				
			case "Tra":

				analise(n.jjtGetChild(i));
				break;
			}
			
			
		}
		
	}
	
	// SO FUNCIONA COM SOMA TERMO A TERMO, E NAO SOMA DIRETA DE MATRIZES
	private static void verificaSePodeSomar(Node node) throws Exception{
		
		int largura=-1,altura=-1;
		
		for(int i = 0; i < node.jjtGetNumChildren(); i++) {
		
			double[][] array=symbolTable.get((String) ((SimpleNode) node.jjtGetChild(i)).jjtGetValue());
			
			if (array==null){
				throw new Exception("vari�vel de input - " +(String) ((SimpleNode) node.jjtGetChild(i)).jjtGetValue()+" nao foi declarada"); 
			}
			
			if(largura==-1 && altura==-1){
				largura=array[0].length;
				altura=array.length;
			}else if(largura!=array[0].length || altura!=array.length){
				throw new Exception("vari�veis a somar n�o t�m tamanhos identicos"); 
				
			}
			
		}
		
		
		
		
	}
	
private static void verificaSePodeSubtrair(Node node) throws Exception{
		
		int largura=-1,altura=-1;
		
		for(int i = 0; i < node.jjtGetNumChildren(); i++) {
		
			double[][] array=symbolTable.get((String) ((SimpleNode) node.jjtGetChild(i)).jjtGetValue());
			
			if (array==null){
				throw new Exception("vari�vel de input - " +(String) ((SimpleNode) node.jjtGetChild(i)).jjtGetValue()+" nao foi declarada"); 
			}
			
			if(largura==-1 && altura==-1){
				largura=array[0].length;
				altura=array.length;
			}else if(largura!=array[0].length || altura!=array.length){
				throw new Exception("vari�veis a subtrair n�o t�m tamanhos identicos"); 
				
			}
			
		}
		
		
		
		
	}
	
	
	private static double[][] analisaTamanhoLinha(Node node) throws Exception{
		
		int tamanhoLinha=-1;
		double [][] matrix;
		
		for(int i = 0; i < node.jjtGetNumChildren(); i++) {
			
			int tamanho=node.jjtGetChild(i).jjtGetNumChildren();
			
			if(tamanhoLinha==-1){
				tamanhoLinha=tamanho;
			}
			else if(tamanhoLinha!=tamanho){
				throw new Exception("Tamanho das linhas da matriz n�o � igual"); 
			}
		}
		
		matrix=new double[node.jjtGetNumChildren()][tamanhoLinha];
		for(int i = 0; i < node.jjtGetNumChildren(); i++)
			for(int j=0; j < tamanhoLinha; j++)
				matrix[i][j] = (double) ((SimpleNode) node.jjtGetChild(i).jjtGetChild(j)).jjtGetValue();
		
		return matrix;
	}
	
	public static void printMap() {
		System.out.println("PRINT DA SYMBOL TABLE");
		for (Map.Entry<String, double[][]> entry : symbolTable.entrySet()) {
		    String key = entry.getKey();
		    double[][] value = entry.getValue();
		    System.out.println(key + "-");
		    
		    int i=value.length;
		    int h=value[0].length;
		    
		    for(int z=0;z<i;z++){
		        for(int d=0;d<h;d++){
		            System.out.print("\t"+value[z][d]);
			    }

		    	System.out.println();
		    }
		    
		}
	}
}