import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		try {
			
		if(args.length > 0)
		{
			
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the desired scale factor: ");
		float scaleFactor = scn.nextFloat();
		System.out.println("And the offset: ");
		float offSet = scn.nextFloat();
		
		/*
		System.out.println("Enter the path for the image: \n");
		String forTheImage = scn.next();
		
		System.out.println("Enter the destination: \n");
		String forTheDestination = scn.next();
			*/	
		//String pathToImage = "C:\\Users\\bidil\\OneDrive\\Desktop\\car_test_java.bmp";
		
		long startTime = System.currentTimeMillis();
		//ContrastChanger cc = new ContrastChanger(scaleFactor, offSet, forTheImage, forTheDestination);
		ContrastChanger cc = new ContrastChanger(scaleFactor, offSet, args[0], args[1]);
		cc.contrastChange(scaleFactor, offSet);
		
		long stopTime = System.currentTimeMillis();
		
		// Compute the total time of the execution
		cc.setTotalTimeOfExecution(stopTime - startTime);
		scn.close();
		
		System.out.println("The process took " + (cc.getTotalTimeOfExecution() / 1000.00) + " seconds.");
		}
		} catch(Exception ex)
		{
			ex.printStackTrace();
		}
			
	}

}