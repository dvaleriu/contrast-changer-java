
// Every algorithm is a function more complex
// that can call other functions
// and whose time of execution matters most

public abstract class Algorithm implements Function
{
	// Class attributes //
	
	// What are the steps needed to be taken to apply the algorithm
	private String[] stepsInApplyingAlgorithm;
	
	private int numberOfSteps;
	
	// How long the algorithm took to execute
	private float totalTimeOfExecution;
	
	private float complexityOfTheAlgorithm;
	
	// Constructors //
	public Algorithm() {}

	public Algorithm(int numS, String[] stps)
	{
		try {
		numberOfSteps = numS;
		
		stepsInApplyingAlgorithm = new String[numberOfSteps];
		
		for(int i = 0; i < stps.length; i++)
			stepsInApplyingAlgorithm[i] = stps[i];
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	// Class methods //
	
	// Method that will apply the algorithm to a data set
	public abstract void applyAlgorithm();
	
	// Returns the task resolved by the algorithm
	public abstract String getTask();
	
	// Method that will set the parameters of the algorithm
	//public abstract void setParams(int n, String ...par);

	/**
	 * @returns the totalTimeOfExecution
	 */
	public float getTotalTimeOfExecution() {
		return totalTimeOfExecution;
	}

	/**
	 * @param totalTimeOfExecution the totalTimeOfExecution to set
	 */
	public void setTotalTimeOfExecution(float totalTimeOfExecution) {
		this.totalTimeOfExecution = totalTimeOfExecution;
	}
	
	/**
	 * @returns the complexityOfTheAlgorithm
	 */
	public float getComplexityOfTheAlgorithm() {
		return complexityOfTheAlgorithm;
	}

	/**
	 * @param complexityOfTheAlgorithm the complexityOfTheAlgorithm to set
	 */
	public void setComplexityOfTheAlgorithm(float complexityOfTheAlgorithm) {
		this.complexityOfTheAlgorithm = complexityOfTheAlgorithm;
	}
	
}