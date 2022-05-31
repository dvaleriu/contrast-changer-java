

public abstract class Algorithm implements Function
{
	
	private String[] stepsInApplyingAlgorithm;
	
	private int numberOfSteps;
	
	
	private float totalTimeOfExecution;
	
	private float complexityOfTheAlgorithm;
	
	
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
	
	
	public abstract void applyAlgorithm();
	
	
	public abstract String getTask();
	
	

	
	public float getTotalTimeOfExecution() {
		return totalTimeOfExecution;
	}

	public void setTotalTimeOfExecution(float totalTimeOfExecution) {
		this.totalTimeOfExecution = totalTimeOfExecution;
	}
	
	
	public float getComplexityOfTheAlgorithm() {
		return complexityOfTheAlgorithm;
	}

	
	public void setComplexityOfTheAlgorithm(float complexityOfTheAlgorithm) {
		this.complexityOfTheAlgorithm = complexityOfTheAlgorithm;
	}
	
}
