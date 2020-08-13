package com.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.swt.*;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.*;

import com.model.DogShowEntry;

import org.eclipse.swt.layout.*;

import org.eclipse.swt.events.*;

import org.eclipse.swt.graphics.*;


public class DogShowE {

     static Image dogImage;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Display display;

	     Shell shell;

	     Text dogName;

	     Combo dogBreed;

	     Canvas dogPhoto;

	     List categories;

	     Text ownerName;

	     Text ownerPhone;
	     
	   
	     
		
		   display = new Display();

	       shell = new Shell(display);
	       
	       shell.setText("Dog Show Entry");

	       GridLayout gridLayout = new GridLayout();

	       gridLayout.numColumns = 3;

	       shell.setLayout(gridLayout);
	       
	       
	       // creating a Scrollable composite to scroll horizontally and vertically
	       
	       ScrolledComposite scrolledComposite = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
	       
	       scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
	       
	       
	       
	       // create a child composite to hold controls
	       
	       Composite child = new Composite(scrolledComposite, SWT.NONE);
	       child.setLayout(gridLayout);
	       
	       
	       
	       // Setting a title
	       
	       Label label1 = new Label(child, SWT.NULL);
	       
	       Font font = new Font(label1.getDisplay(),  new FontData("Mono", 10, SWT.BOLD));
	       label1.setFont(font);
	       
	       label1.setText("-------------  Dog Show Entry  --------------");
	       
	       GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);

	       gridData.horizontalSpan = 3;
	       
	       label1.setLayoutData(gridData);


	      
	       // creating Dog name label
	       new Label(child, SWT.NULL).setText("Dog's Name:");

	       dogName = new Text(child, SWT.SINGLE | SWT.BORDER);

	       gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);

	       gridData.horizontalSpan = 2;

	       dogName.setLayoutData(gridData);

	 
	       // creating Dog Breed label
	       new Label(child, SWT.NULL).setText("Breed:");

	       dogBreed = new Combo(child, SWT.NULL);

	       dogBreed.setItems(new String [] {"Collie", "Pitbull", "Poodle", "Scottie"});

	       dogBreed.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

	 

	       Label label = new Label(child, SWT.NULL);

	       label.setText("Categories");

	       label.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));

	      
	       // create Photo label
	       
	       new Label(child, SWT.NULL).setText("Photo:");

	       dogPhoto = new Canvas(child, SWT.BORDER);

	       gridData = new GridData(GridData.FILL_BOTH);

	       gridData.widthHint = 80;

	       gridData.heightHint = 80;

	       gridData.verticalSpan = 3;

	       dogPhoto.setLayoutData(gridData);

	       dogPhoto.addPaintListener(new PaintListener() {

	          public void paintControl(final PaintEvent event) {

	              if (dogImage != null) {

	                 event.gc.drawImage(dogImage, 0, 0);

	              }

	          }

	       });

	 
	       // create categories
	       categories = new List(child, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);

	       categories.setItems(new String [] {

	          "Best of Breed", "Prettiest Female", "Handsomest Male",

	          "Best Dressed", "Fluffiest Ears", "Most Colors",

	          "Best Performer", "Loudest Bark", "Best Behaved",

	          "Prettiest Eyes", "Most Hair", "Longest Tail",

	          "Cutest Trick"});

	       gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);

	       gridData.verticalSpan = 4;

	       int listHeight = categories.getItemHeight() * 12;

	       Rectangle trim = categories.computeTrim(0, 0, 0, listHeight);

	       gridData.heightHint = trim.height;

	       categories.setLayoutData(gridData);

	      
	       // Browse button
	       Button browse = new Button(child, SWT.PUSH);

	       browse.setText("Browse...");

	       gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);

	       gridData.horizontalIndent = 5;

	       browse.setLayoutData(gridData);

	       browse.addSelectionListener(new SelectionAdapter() {

	          public void widgetSelected(SelectionEvent event) {

	              String fileName = new FileDialog(shell).open();

	              if (fileName != null) {

	                 dogImage = new Image(display, fileName);

	              }
	              
	              dogPhoto.redraw();

	          }

	       });

	      
	       // Delete Button
	       Button delete = new Button(child, SWT.PUSH);

	       delete.setText("Delete");

	       gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_BEGINNING);

	       gridData.horizontalIndent = 5;

	       delete.setLayoutData(gridData);

	       delete.addSelectionListener(new SelectionAdapter() {

	          public void widgetSelected(SelectionEvent event) {

	              if (dogImage != null) {

	                 dogImage.dispose();

	                 dogImage = null;

	                 dogPhoto.redraw();

	              }

	          }

	       });

	      
	       // Owner Info group
	       Group ownerInfo = new Group(child, SWT.NULL);

	       ownerInfo.setText("Owner Info");

	       gridLayout = new GridLayout();

	       gridLayout.numColumns = 2;

	       ownerInfo.setLayout(gridLayout);

	       gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);

	       gridData.horizontalSpan = 2;

	       ownerInfo.setLayoutData(gridData);

	      

	       new Label(ownerInfo, SWT.NULL).setText("Name:");

	       ownerName = new Text(ownerInfo, SWT.SINGLE | SWT.BORDER);

	       ownerName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	      

	       new Label(ownerInfo, SWT.NULL).setText("Phone:");

	       ownerPhone = new Text(ownerInfo, SWT.SINGLE | SWT.BORDER);

	       ownerPhone.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	       

	      
	       // creating a Enter Button
	       
	       Button enter = new Button(child, SWT.PUSH);

	       enter.setText("Enter");

	       gridData = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);

	       gridData.horizontalSpan = 2;

	       enter.setLayoutData(gridData);

	       enter.addSelectionListener(new SelectionAdapter() {

	    	   public void widgetSelected(SelectionEvent event) {
	    		   
	    		   String dName = dogName.getText();
	    		   String dbreed = dogBreed.getText();
	    		   String oName = ownerName.getText();
	    		   String phno = ownerPhone.getText();
	    		   

	             /* System.out.println("\nDog Name: " + dogName.getText());

	              System.out.println("Dog Breed: " + dogBreed.getText());

	              System.out.println("Owner Name: " + ownerName.getText());

	              System.out.println("Owner Phone: " + ownerPhone.getText());

	              System.out.println("Categories:");*/

	              String cats[] = categories.getSelection();
	              
	             /* for (int i = 0; i < cats.length; i++) {

		                 System.out.println("\t" + cats[i]);
	            	  

		              }*/
	              
	              DogShowEntry dse = new DogShowEntry(dName, dbreed, oName, phno, cats);
	              
	              System.out.println(dse);
	              
	              try {
	            	  
					FileOutputStream fos = new FileOutputStream("Dog.txt");
					
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					
					oos.writeObject(dse);
					
					System.out.println("Details added to File");
					
					oos.close();
					
	              } catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	              } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	              }

	          }

	       });

	       
			
	       // Read Button creation
	       
	       Button read = new Button(child, SWT.PUSH);
	       
	       read.setText("Read");
	       
	       read.addSelectionListener(new SelectionAdapter() {
	    	   
	    	   public void widgetSelected(SelectionEvent event) {
	    		   
	    		   try {
	    			   
					FileInputStream fis = new FileInputStream("Dog.txt");
					ObjectInputStream ois = new ObjectInputStream(fis);
					
					Object obj = ois.readObject();
					
					DogShowEntry dog = (DogShowEntry) obj;
					
					dog.toString();
					
					String owner = dog.getOwnerName();
					
					String oName = ownerName.getText();
					
					if(owner.equalsIgnoreCase(oName)) {
						
						dogName.setText(dog.getDogName());
	    	   			dogBreed.setText(dog.getDogBreed());
	    	   			ownerName.setText(dog.getOwnerName());
	    	   			ownerPhone.setText(dog.getPhno());
						
					}else {
						

						dogName.setText("Data Not Found");
	    	   			dogBreed.setText("Data Not Found");
	    	   			// ownerName.setText("Data Not Found");
	    	   			ownerPhone.setText("Data Not Found");
						
					}
					
					ois.close();
					
					/*System.out.println("data is read from file");
					
					String oName = ownerName.getText();
					
					int flag = 0;
					
					DogShowEntry dogObj = new DogShowEntry();
					
					for( DogShowEntry dog : dogs) {
						
						if(dog.getDogName().equalsIgnoreCase(oName)) {
							
							flag = 1;
							
							dogObj = dog;
							
						}
					}
						
					if(flag == 1) {
						
						dogName.setText(dogObj.getDogName());
	    	   			dogBreed.setText(dogObj.getDogBreed());
	    	   			ownerName.setText(dogObj.getOwnerName());
	    	   			ownerPhone.setText(dogObj.getPhno());
						
						
					}else {
						
						dogName.setText("Data Not Found");
	    	   			dogBreed.setText("Data Not Found");
	    	   			ownerName.setText("Data Not Found");
	    	   			ownerPhone.setText("Data Not Found");
						
					}*/
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   
	    		   
	    	 }
		});
	       
	       
	       
	       if (dogImage != null) {

		          dogImage.dispose();

		       }
	       
	       
	       
	       // set the child as scrolled content of Scrolled composite
	       
	       scrolledComposite.setContent(child);
	       
	       
	       // set Minimum size
	       scrolledComposite.setMinSize(500, 500);
	       
	       // Expand Both horizontally and vertically
	       scrolledComposite.setExpandHorizontal(true);
	       scrolledComposite.setExpandVertical(true);

	       

	       // shell.pack();

	       shell.open();

	       while (!shell.isDisposed()) {

	          if (!display.readAndDispatch()) 
	        	  
	        	  display.sleep();

	       }
	       
	       
	      display.dispose();
	}

}
