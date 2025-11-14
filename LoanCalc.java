// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		System.out.println(endBalance(loan, rate, n, 123));
		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) {	
		double sum = (loan - payment) * rate;
		for(int i = 0; i < n - 1; i++){
			System.out.println(sum);
			sum = (sum - payment) * rate;
		}
		return sum;
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		double count = 0;
		double sum = (loan - count) * rate;
		while (sum >= epsilon) {
			for(int i = 0; i < n - 1; i++){
			sum = (sum - count) * rate;
			
		}
		if(sum < epsilon){
				return count;
			}
		count += 0.001;
		iterationCounter++;
		sum = (loan - count) * rate;
		}
		return count;
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
        double L = 0.001;
		double sum = (loan - L) * rate;
		double H = sum;
		double between = 0;
		//double g = (L + H) / 2.0;
		while (Math.abs(sum) >= epsilon) {
		
		for(int i = 0; i < n - 1; i++){
			sum = (sum - L) * rate;
		}
			if(sum >= epsilon){

			between = L;
			L *= 2;
			sum = H;
		    iterationCounter++;
			sum = (loan - L) * rate;
			}
		else if(sum <= -epsilon){
			L = L - ( (L - between) / 2);
			sum = H;
			iterationCounter++;
			sum = (loan - L) * rate;
		}
		else if(sum < epsilon){
			return L;
		}
		
	}
	return L;
	}
}