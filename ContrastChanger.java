import java.awt.image.BufferedImage; // Use a jpeg image as a bmp one
import java.awt.image.RescaleOp; // Used for the contrast changer
import java.io.File; // For the images
import java.io.IOException; // For the FileNotFoundException
import javax.imageio.ImageIO; // Reading the files
import javax.swing.ImageIcon; // Used to link an image with the frame
import javax.swing.JFrame; // Create the window in which the image appears
import javax.swing.JLabel; // Used to insert elements in the window
import javax.swing.JPanel; // Add elements to the frame

public class ContrastChanger extends Filter
{
	// Source
	BufferedImage bfi;
	
	// Destination
	BufferedImage bfi1;
	
	// Perform a pixel-by-pixel re-scaling of the data
	// in the source image by multiplying the value for each pixel
	// by a scale factor and then adding an offset
	RescaleOp rescale;
	
	//implementation of the Icon interface that paints Icons from Images
	ImageIcon ico;
	ImageIcon ico1;

	JLabel picLab = new JLabel();
	JLabel picBef = new JLabel();
			
	public ContrastChanger(float sf, float ofs, String pathS, String pathD) throws IOException
	{
		super();
		// JFrame and JPanel to create the window
		// JFrame is used to create the top-level window with a title and a border
		// JPanel is used to add elements in the window
		JFrame jf = new JFrame();
		JFrame before = new JFrame();
		
        JPanel jp = new JPanel();    
        JPanel bfjp = new JPanel();
        
        // add the panel and the label to the frame
        jf.add(jp);
        before.add(bfjp);
        
        // Add the image to the panel
        jp.add(picLab);
        before.add(picBef);

        // And display them both
        jf.setVisible(true);
        before.setVisible(true);
        
        // Set the sizes of the frame
        jf.setSize(740, 587);
        before.setSize(740, 587);
        
        // The location on the screen
        jf.setLocation(200,100);
        before.setLocation(920, 100);
        
        before.setTitle("Image before the Modification");
        jf.setTitle("Image Contrast Modification Result");
        
        // Make sure that it closes when the application is stopped
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        before.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    // Used to manipulate the images
	    // as files
	    File file = new File(pathS);
	    File file1 = new File(pathD);
	               
       // Treating the exception that can appear when reading the image 
       try 
       {           
    	   // create buffered images using ImageIO.read method
           bfi = ImageIO.read(file); 
           bfi1 = ImageIO.read(file1);
           
       } catch (IOException ex) 
       {
    	   ex.printStackTrace();
       }               
	}
	
	@Override
	public void applyFilter(float ...fVar)
	{
		// calls the contrast change using the scale factor and the offset
		contrastChange(fVar[0], fVar[1]);
		
		// create the image icons
		ico = new ImageIcon(bfi);
		ico1 = new ImageIcon(bfi1);
		
		picBef.setIcon(ico1);
        picLab.setIcon(ico);
	}
	
	@Override
	public void applyFunction(float ...varF)
	{
		applyFilter(varF[0], varF[1]);
	}
	
	// Logs the information of the filter
	 public void contrastChange(float ...varArgFloat)
	 {
		 float scaleFactor = varArgFloat[0];
		 float offSet = varArgFloat[1];
		 
		 // Apply the change in the contrast
         rescale(scaleFactor, offSet);
         
         ico = new ImageIcon(bfi);
         ico1 = new ImageIcon(bfi1);
         picLab.setIcon(ico); 
         picBef.setIcon(ico1);
         
         System.out.println("Contrast applied with a scale factor of: ");
         System.out.println(scaleFactor);
         System.out.println("And an offset of: ");
         System.out.println(offSet);
    }
	 
	// The contrast changing function
     public void rescale(float sclF, float offS)
     {
    	 // Construct a new RescaleOp with the scale factor, offset and no rendering hints
        rescale = new RescaleOp(sclF,offS, null);
        
        // Apply the filter to the image given as a parameter
        bfi = rescale.filter(bfi, bfi);
        //(source,destination)
     }

	@Override
	public String getTask() {
		
		return null;
	}

	@Override
	public double returnTheResult() 
	{ return 0; }

	@Override
	public void applyFunction() {
		;
		
	}
}