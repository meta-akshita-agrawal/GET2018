


public final class Polynomial {
	
	int[][] polyFunction;
	
	Polynomial(int[][] polyFunction){
		this.polyFunction = polyFunction;
	}
	
	double evaluate(double x){
		double result=0.0;
		for(int i=0;i<polyFunction.length;i++){
			result += x*(Math.pow(polyFunction[i][1], polyFunction[i][0]));
		}
		return result;
	}
	
	int degree(){
		return polyFunction[0][0];
	}
	
	int[][] addPoly(Polynomial p1, Polynomial p2){
		int j=0;
		int k=0;
		int highestDegree = (p1.polyFunction[0][0]>p2.polyFunction[0][0]) ? p1.polyFunction[0][0]:p2.polyFunction[0][0];
		int counter= highestDegree+1;
		int[][] arrayWithZeroes = new int[highestDegree+1][2];
		for(int i=highestDegree;i>=0;i--){
			if((j<p1.polyFunction.length && p1.polyFunction[j][0] == i) && (k<p2.polyFunction.length && p2.polyFunction[k][0]==i)){
				arrayWithZeroes[i][0] = i;
				arrayWithZeroes[i][1] = p1.polyFunction[j][1] + p2.polyFunction[k][1];
				System.out.println("-------------->" + arrayWithZeroes[i][1]);
				j = j+1;
				k = k+1;
			}
			else if(j<p1.polyFunction.length && p1.polyFunction[j][0] == i){
				arrayWithZeroes[i][0] = i;
				arrayWithZeroes[i][1] = p1.polyFunction[j][1];
				j = j+1;
			}
			else if(k<p2.polyFunction.length && p2.polyFunction[k][0] == i){
				arrayWithZeroes[i][0] = i;
				arrayWithZeroes[i][1] = p2.polyFunction[k][1];
				k = k+1;
			}
			else{
				arrayWithZeroes[i][0] = 0;
				arrayWithZeroes[i][0] = 0;
				counter--;
			}
			System.out.println(j + " " + k);
		}
		System.out.println(counter);
		System.out.println("------------------");
		
		for(int i=0;i<arrayWithZeroes.length;i++){
			System.out.println();
			for(int v=0;v<2;v++){
				System.out.print(arrayWithZeroes[i][v] + " ");
			}
		}
		
		System.out.println("---------------------");
		int[][] arrayWithoutZeroes = new int[counter][2];
		int m=0;
		for(int i=arrayWithZeroes.length - 1; i>=0; i--){
			if(arrayWithZeroes[i][1] != 0){
				arrayWithoutZeroes[m][0] = arrayWithZeroes[i][0];
				arrayWithoutZeroes[m][1] = arrayWithZeroes[i][1];
				m=m+1;
			}
		}
		return arrayWithoutZeroes;
		
	}
	
	
	int[][] multiply(Polynomial p1, Polynomial p2){
		int commonTermsSize = p1.polyFunction.length * p2.polyFunction.length;
		int[][] array = new int[commonTermsSize][2];
		int index=0;
		for(int i=0;i<p1.polyFunction.length;i++) {
			for(int j=0;j<p2.polyFunction.length;j++) {
				array[index][0] = p1.polyFunction[i][0] + p2.polyFunction[j][0];
				array[index][1] = p1.polyFunction[i][1] * p2.polyFunction[j][1];
				index++;
			}
		}
		
		int counter=array.length;
		for(int i=0;i<array.length-1;i++) {
			if(array[i][0] == array[i+1][0]) {
				array[i+1][0] = 0;
				array[i][1] = array[i][1] + array[i+1][1];
				array[i+1][1] = 0;
				counter--;
			}
		}
		System.out.println(counter);
		int[][] finalArray = new int[counter][2];
		int k=0;
		for(int i=0;i<array.length;i++) {
			if(array[i][1] != 0) {
				finalArray[k][0] = array[i][0];
				finalArray[k][1] = array[i][1];
				k=k+1;
			}
		}
		return finalArray;
	}
	
	public static void main(String[] args){
		int[][] poly1 = new int[][]{{8,5},{5,1},{0,3}};
		int[][] poly2 = new int[][]{{5,2},{2,8}};
		Polynomial p1 = new Polynomial(poly1);
		Polynomial p2 = new Polynomial(poly2);
		int[][] newArr = p1.multiply(p1,p2);
		System.out.println("---------------------");
		for(int i=0;i<newArr.length;i++){
			System.out.print(newArr[i][1] + "x^" + newArr[i][0]);
			System.out.print(" + ");
		}
	}

	
	
}
