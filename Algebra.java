// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    //System.out.println(plus(2,-3));   // 2 + 3
	    //System.out.println(minus(7,2));  // 7 - 2
   		//System.out.println(minus(2,0));  // 2 - 7
 		//System.out.println(times(-5,-1));  // 3 * 4
   		//System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		//System.out.println(pow(5,3));      // 5^3
   		//System.out.println(pow(3,5));      // 3^5
   		//System.out.println(div(12,0));   // 12 / 3    
   		//System.out.println(div(5,5));    // 5 / 5  
   		//System.out.println(div(26,-5));    // 25 / 7
		//System.out.println(mod(7,7));
		//System.out.println(7%7);
		//System.out.println(-25%-7);     
		//System.out.println(1%5);  // 25 % 7
   		//System.out.println(mod(120,6));  // 120 % 6    
   		
   		System.out.println(sqrt(10));
		System.out.println((int)Math.sqrt(10));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// Replace the follwowing statement with your code
		if(x2 > 0){
        for(int i = 0; i < x2;i++){
				x1++;
		}
		return x1;
		}
		else if(x2 < 0){
			for(int i = 0; i > x2; i--){
				x1--;
		}
		return x1;
		}
			return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Replace the following statement with your code
		if(x2 > 0){
        for(int i = 0; i < x2;i++){
				x1--;
		}
		return x1;
		}
		else if(x2 < 0){
			for(int i = 0; i > x2; i--){
				x1++;
		}
		return x1;
		}
			return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// Replace the following statement with your code
		int num = 0;
		if(x2 > 0 && x1 > 0){

			for(int j = 0; j < x1; j++){

			num = plus(num, x2);

		}

		return num;

		}
		else if(x2 < 0 && x1 < 0){

			for(int j = 0; j > x1; j--){

			num = minus(num, x2);

		}

		return num;

		}
		else if(x2 < 0 && x1 > 0){

			for(int j = 0; j < x1; j++){

			num = plus(num, x2);

		}
		return num;
	}
	else if(x2 > 0 && x1 < 0){

			for(int j = 0; j > x1; j--){

			num = minus(num, x2);

		}
		return num;
	}	
		return 0;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// Replace the following statement with your code
		return 0;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		// Replace the following statement with your code
		if(x2 == 0){
			System.out.print("You can't do that!!! try number other than ");
			return 0;
		}

		int num = 0;
		int count = 0;
		int i = 0;

		if(x2 < 0 && x1 > 0){
			x2 = times(x2, -1);
			while(num != x1 + 1){
			
			if(i == x2){
				count--;
				i = 0;
			}

			i++;
			num++;

		}
		return count;
		}
		else if(x2 > 0 && x1 < 0){
			x1 = times(x1, -1);
			while(num != x1 + 1){
			
			if(i == x2){
				count--;
				i = 0;
			}

			i++;
			num++;

		}
		return count;
		}
		else if(x1 < 0 && x2 < 0){
			x1 = times(x1, -1);
			x2 = times(x2, -1);
		}
		
		while(num != x1 + 1){
			
			if(i == x2){
				count++;
				i = 0;
			}

			i++;
			num++;

	}
		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		
		if(x2 == 0){
			System.out.println("Error, try something other than ");
			return 0;
		}
		else if(x1 < x2){
			return x1;
		}
		else if(x2 == x1){
			return 0;
		}
		int likeX2 = x2;
		while (x2<x1) {
			x2 = plus(x2, likeX2);
		}
		if(x2 > x1){
			x2 = minus(x2, likeX2);
		}

		int num3 = minus(x1, x2);
		
		return num3;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		// Replace the following statement with your code
		int num = 0;	
		while (minus(times(num, num), x) < 0) {
			num++;
		}
		//creates integer of the current sum and the previous sum
		int num2 = minus(num, 1);
		int num3 = times(minus(times(num2, num2), x),-1);
		int num4 = minus(times(num, num), x);
		//checking what's closer to sqrt on int values
		if(num3 <= num4){
			num--;
		}
		return num;
	}	  	  
}