
// Every filter is inherited from a algorithm

public abstract class Filter extends Algorithm
{
	// Class atributes //
	// Since every filter has details about the steps it takes
	// this array, specifies those details
	private int numberOfDetails;
		
	// Enumerates the details of the Filter
	String[] filterDetails;
		
	// What category is the algorithm from(mathematical, photo etc.)
	String filterCategory;
		
	// The parameters that the filter uses
	float[] parameters;
	
	
	// Class methods
	public Filter() {}
	
	public Filter(int numS, String[] stps) {
		super(numS, stps);
	}
	
	public Filter(int numS, String[] stps, String fc,int nD,  String[] fs)
	{
		super(numS, stps);
		
		filterCategory = fc;
		numberOfDetails = nD;
	}
	
	/**
	 * @returns the numberOfDetails of a algorithm
	 */
	public int getNumberOfDetails()
	{
		return this.numberOfDetails;
	}
	
	/**
	 * @param numberOfDetails sets the numberOfDetails of the algorithm
	 */
	public void setNumberOfDetails(int numberOfDetails)
	{
		this.numberOfDetails = numberOfDetails;
	}
	
	@Override
	public void applyAlgorithm()
	{
		applyFilter();
	}	
	
	public abstract void applyFilter(float ...paramL);

}
