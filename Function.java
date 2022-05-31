//import java.lang.*;

// At the lowest level, every filter is a function

public interface Function 
{	
	// Class attributes
	public String[] dataParams = new String[5];
	
	// Array of strings that will analyze the function
	public String[] functionAnalysis = {};
	
	public int numberOfParams = 5;
	
	public float result = 0.0f;
	
	// Define the limits of the function's values
	public float maximumValue = 1000f;
	
	public float minimumValue = -1000f;

	public static String functionName = "";
	
	// Class methods
	public double returnTheResult();
	
	// Method that will set the parameters of the function
	public default void setTheParams(int nmb, String ...params)
	{
		try {
		if(nmb != 5)
			System.out.println("There must be exactly 5 parameters!");
		
		// Copies the parameters
		System.arraycopy(params, 0, dataParams, 0, 5);
		
		boolean same = true;
		
		// and checks if the strings are the same
		for(int i = 0 ;i < 5; ++i)
			if(dataParams[i] != params[i])
				same = false;
		if(same == true)
			System.out.println("Assignment was successful!");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void applyFunction();
	
	public void applyFunction(float ...fList);
}
