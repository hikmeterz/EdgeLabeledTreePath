import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<String> paths = new ArrayList<String>();
		ArrayList<String> trees = new ArrayList<String>();
		
		
		Scanner inputStream=null;
		//dosya okuma line line.
		int numberOfPaths=0;
		int numberOfTrees=0;
		try {
			inputStream = new Scanner(new File(args[0]));
		}catch(FileNotFoundException e){
			System.out.println("ERROR.");
			System.exit(0);
		}
		String s="";
		while(inputStream.hasNextLine()) {
			s=inputStream.nextLine();
			trees.add(s);
			s="";
		}
		s="";
		inputStream.close();
		try {
			inputStream = new Scanner(new File(args[1]));
		}catch(FileNotFoundException e){
			System.out.println("ERROR.");
			System.exit(0);
		}
		while(inputStream.hasNextLine()) {
			s=inputStream.nextLine();
			paths.add(s);
			s="";
		
		
		}
		inputStream.close();
	
		
		Tree[] real_trees = new Tree[trees.size()];
		
		Tree tree=null;
		
		for(int i=0;i<real_trees.length;i++) {
			
			real_trees[i]=treeOlustur(tree, trees.get(i));
			
		}
		
		
		double mean;
		int mean2;
		for(int i=0;i<paths.size();i++) {
			mean=findMean(real_trees,paths.get(i));
			mean2=(int)mean;
			if(mean==-1000) {
				System.out.println("Path bulunamadi.");
				continue;
			}
			if(mean2==mean)
				System.out.println(mean2);
			else 
				System.out.printf("%.2f%n", mean);
				
		}
		
       
	}
	
	
	public static double findMean(Tree[] trees, String path) {
		
		int numberOfValues=0;
		double mean;
		double sum=0;
		int value=0;
		boolean isHeap=false;
		
		for(int i=0;i<trees.length;i++){ //each tree t in file1:
			value=Value(trees[i],path);
			
			isHeap=isHeap(trees[i]);
			//System.out.println(isHeap);
			if(value!=-1000 && isHeap){ //p has a value:
				value=value*2;
				sum+=value;
				numberOfValues++;
				//find value of p in t (considering whether there is a heap)
			}else if(value!=-1000 && !isHeap){//heap degilse...
				sum+=value;
				numberOfValues++;
			}
			
		}
		if(numberOfValues==0) {
			return -1000;
			
		}
		
		return sum/numberOfValues;
	}
	public static boolean isHeap(Tree t){
		Tree tmp=t;
		Node n =tmp.getRoot();
		if(n.isHeap(n))
			return true;
		else 
			return false;
		
	}
	
	
	public static int Value(Tree t,String path){
		String root=""+path.charAt(0);
		Node iterator=t.getRoot();
		boolean pathBulundu=false;
		int value=0;
		if(t.getRoot().getElement().equals(root)) {
			for(int i=1;i<path.length();i++) {
				if(path.charAt(i)>96 && path.charAt(i)< 123) {//edge...
					if(i!=path.length()-1){
						
						for(int j=0;j<iterator.getSize();j++){//child edge control....
							if(iterator.getChild(j).getElement().charAt(0)==path.charAt(i) && iterator.getChild(j).getElement().charAt(1) == path.charAt(i+1)) {
								//path dogru yolda....
								iterator=iterator.getChild(j);
								pathBulundu=true;
								break;
							}
						}
						if(pathBulundu) {
							pathBulundu=false;
							i=i+1;
						}else{
							
							return -1000;
						}
						
					}else if(i==path.length()-1) {
						//son edge....
						for(int j=0;j<iterator.getSize();j++){//child edge control....
							if(iterator.getChild(j).getElement().charAt(0)==path.charAt(i) ) {
								if(iterator.getChild(j).getElement().charAt(1)>47 &&iterator.getChild(j).getElement().charAt(1)<58)
									value=iterator.getChild(j).getElement().charAt(1)-'0';
								else
									return-1000;
								pathBulundu=true;
							}
						}
						if(pathBulundu) {
							break;
						}else{
							
							return -1000;
						}
					
					}	
					
				}
				
			}
			
			
			
		}else
				
			return -1000;//no value
		
			
			
	return value;
		
		
		
	}
	
	public static Tree treeOlustur(Tree t,String tree){
		//System.out.println(x);
		if(tree.charAt(0)>64 || tree.charAt(0) <91) {
			t = new Tree(""+tree.charAt(0));
			
		}else {
			return null;
				
		}
		Node iterator=t.getRoot();
		String child="";
		for(int i=2;i<tree.length();i++) {
			
			
			if(tree.charAt(i)>96 && tree.charAt(i)< 123) {//if edge.. small
				child=tree.charAt(i)+""+tree.charAt(i+1);
				
				
				if(tree.charAt(i+1)>47 && tree.charAt(i+1) <58) {//external node...
					iterator.addChild(child);
				}else if(tree.charAt(i+1) >64 && tree.charAt(i+1) <91) {//internal node.
					iterator.addChild(child);
					
				}
				i=i+1;
			}else if(tree.charAt(i)=='(') {
				iterator=iterator.getChild(iterator.getThchild()-1);
				
			}else if(tree.charAt(i)==')') {
				if(iterator!=t.getRoot())
					iterator=iterator.getParent();
				
			}
			
		}
		
		return t;
		
		
		
	}
	
	

}
