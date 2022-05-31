

public interface Function 
{	
	
	public String[] dataParams = new String[5];
	
	
	public String[] functionAnalysis = {};
	
	public int numberOfParams = 5;
	
	public float result = 0.0f;
	
	
	public float maximumValue = 1000f;
	
	public float minimumValue = -1000f;

	public static String functionName = "";
	
	public double returnTheResult();
	
	
	public default void setTheParams(int nmb, String ...params)
	{
		try {
		if(nmb != 5)
			System.out.println("There must be exactly 5 parameters!");
		
		
		System.arraycopy(params, 0, dataParams, 0, 5);
		
		boolean same = true;
		
		
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
