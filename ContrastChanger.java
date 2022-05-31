import java.awt.image.BufferedImage; 
import java.awt.image.RescaleOp;
import java.io.File; 
import java.io.IOException; 
import javax.imageio.ImageIO;
import javax.swing.ImageIcon; 
import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JPanel; 

public class ContrastChanger extends Filter
{
	
	BufferedImage bfi;
	
	
	BufferedImage bfi1;
	
	RescaleOp rescale;
	
	ImageIcon ico;
	ImageIcon ico1;

	JLabel picLab = new JLabel();
	JLabel picBef = new JLabel();
			
	public ContrastChanger(float sf, float ofs, String pathS, String pathD) throws IOException
	{
		super();
		JFrame jf = new JFrame();
		JFrame before = new JFrame();
		
        JPanel jp = new JPanel();    
        JPanel bfjp = new JPanel();
        
        
        jf.add(jp);
        before.add(bfjp);
        
       
        jp.add(picLab);
        before.add(picBef);

      
        jf.setVisible(true);
        before.setVisible(true);
        
      
        jf.setSize(740, 587);
        before.setSize(740, 587);
        
      
        jf.setLocation(200,100);
        before.setLocation(920, 100);
        
        before.setTitle("Image before the Modification");
        jf.setTitle("Image Contrast Modification Result");
        
      
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        before.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    File file = new File(pathS);
	    File file1 = new File(pathD);
	               
     
       try 
       {           
    	   
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
		
		contrastChange(fVar[0], fVar[1]);
		

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
	
	
	 public void contrastChange(float ...varArgFloat)
	 {
		 float scaleFactor = varArgFloat[0];
		 float offSet = varArgFloat[1];
		 
		
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
	 
	
     public void rescale(float sclF, float offS)
     {
        rescale = new RescaleOp(sclF,offS, null);
       
        bfi = rescale.filter(bfi, bfi);
       
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
