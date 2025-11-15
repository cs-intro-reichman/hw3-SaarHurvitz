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
		//System.out.println(endBalance(loan, rate, n, 10000));
		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
		iterationCounter = 0;
		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) {	
		double sum = loan;
		for(int i = 0; i < n; i++){
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
		double L = 0;
		double H = loan;
		double M = (L + H) / 2;
		double sum = endBalance(loan, rate, n, H);
		
		while (Math.abs(H - L) >= epsilon) {
			sum = endBalance(loan, rate, n, M);
		if(sum >= 0 && sum < epsilon){
			iterationCounter++;
				return M;
			}
		else if(sum > epsilon){
			iterationCounter++;
				L = M;
		}
		else if(sum < 0){
			iterationCounter++;
			H = M;
		}
		M = (L + H) / 2;
		}
		return (L + H) / 2;
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
        double L = 0.001;
		double sum = (loan - L) * rate;
		double H = loan;
		double between = 0;
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