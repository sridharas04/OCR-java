/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocr;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import com.aspose.ocr.*;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
public class Ocr {
	Ocr() throws IOException
	{
		init();
	}
	JFrame f=new JFrame("Ocr Processor Engine");
    JPanel panel=new JPanel();
    JLabel label=new JLabel();
	public String path;
	public String resource;
	public String image;
	public int i1;
	public void init() throws IOException {
		// TODO Auto-generated method stub
	            final JLabel l0=new JLabel("OPTICALCHARACTER RECOGNIZATION SOFTWARE");
	            l0.setBounds(110,01, 300,20);
		    final JLabel l1=new JLabel("Output File Path:");
		    l1.setBounds(20,40, 150,30);  
		    final JLabel l2=new JLabel("Image File Path:");
		    l2.setBounds(20,40, 200,90); 		    
		    final JLabel l3=new JLabel("Resource File Path:");
		    l3.setBounds(16,40, 290,150);
		    final JTextField t1 = new JTextField();  
		    t1.setBounds(180,40, 340,30);   
		    final JTextField t2 = new JTextField();  
		    t2.setBounds(180,74, 340,30);
		    final JTextField t3 = new JTextField();  
		    t3.setBounds(180,107, 340,30);
                    final JLabel l6=new JLabel("Status :");
		    l6.setBounds(35,167, 400,30);
		    final JLabel l4=new JLabel("Waiting for user input :-)");
		    l4.setBounds(95,167, 400,30);
		    final JLabel l5=new JLabel("@copyright 2017 p.sridhar");
		    l5.setBounds(310,350, 480,30);
		    final JTextArea t4 = new JTextArea();
		    t4.setBounds(20,230,500,150);
		     f.add(l0); 
		     f.add(l1); 
		     f.add(l4);
		     f.add(l5);
                     f.add(l6);
		     f.add(l2); 
		     f.add(l3);  
		     f.add(t1);  
		     f.add(t2); 
		     f.add(t3); 
		     f.add(t4);
		     f.setSize(550,480);    
		     f.setLayout(null);    
		     f.setVisible(true);
		     t4.setText("Monitoring............$");
		     path= JOptionPane.showInputDialog("Enter Output File Path:");
		     t1.setText(path);
		     l4.setText("Creating File.....Done!");
		     t4.setText("File created in: "+path);
		     image=JOptionPane.showInputDialog("Enter Image File Path:");		    
		     t2.setText(image);
		     l4.setText("Scanning image...........Done!.. :-)");
		     t4.setText("Recognizing image in: "+image);
		     resource=JOptionPane.showInputDialog("Enter Resource File Path:");
		     t3.setText(resource);
		     l4.setText("Loading Resource File...........Done!!");
		     t4.setText("Loading Fonts and libraries from: "+resource);
		     String text = null;
	            File writerfile=new File(path);
	            writerfile.createNewFile();			
	            com.aspose.ocr.OcrEngine Engine = new com.aspose.ocr.OcrEngine(); 
	            l4.setText("Staring Ocr Engine....$");
			     t4.setText("Converting Image Into Text.....!");
	            Engine.setResource(new FileInputStream(resource));						
	            Engine.setImage(ImageStream.fromFile(image));
	            OcrEngine ocr = new OcrEngine();
	            ILanguage language = Language.load("english");
	            ocr.getLanguages().addLanguage(language);
	            BufferedWriter writer = null;			
					writer = new BufferedWriter(new FileWriter(writerfile));			
					writer.write("");//flushing	
					 l4.setText("Preparing File...........$");
				     t4.setText("Processing 10%");
	                Engine.process(); 
	                text=Engine.getText().toString();
	                l4.setText("Preparing File...........$");
				     t4.setText("Processing 50%");
					writer.write(text);	
					l4.setText("Preparing File...........$");
				     t4.setText("Processing 100%");
					writer.close();	
					JOptionPane.showMessageDialog(null,"Converted Sucessfully......!");
					t4.setText(text);
					i1=JOptionPane.showConfirmDialog(t4, "Want to do again?");
					if(i1==0)
					{
						t1.setText(null);
						t2.setText(null);
						t3.setText(null);
						t4.setText(null);
						init();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Thanks for using my software....!");
						f.dispose();
					}
					
	}
	
	
public static void main(String []args) throws IOException{
	        new Ocr();   
	       
}
}
