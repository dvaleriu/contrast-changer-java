

public abstract class Filter extends Algorithm
{
	private int numberOfDetails;
	
	String[] filterDetails;
	String filterCategory;
	float[] parameters;
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
	
	public int getNumberOfDetails()
	{
		return this.numberOfDetails;
	}
	
	
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
