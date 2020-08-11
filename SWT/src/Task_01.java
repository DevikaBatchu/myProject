import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Task_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Display display = new Display();
		
		Shell shell = new Shell(display);
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("         Dog Show");
		
		label = new Label(shell, SWT.NONE);
		label.setText("Entry         ");
		
		// creating a Grid layout 1
		GridLayout gLayout = new GridLayout(2, false);
		shell.setLayout(gLayout);
		
		
	    label = new Label(shell, SWT.NONE);
		label.setText("Dog's Name: ");
		
		Text txtAnotherTest = new Text(shell, SWT.NONE);
        txtAnotherTest.setText("                       ");
		
		label = new Label(shell, SWT.NONE);
		label.setText("Breed : ");
		
		txtAnotherTest = new Text(shell, SWT.NONE);
        txtAnotherTest.setText("                       ");
		
		
		
		// creating another composite for image
		
		 Composite composite = new Composite(shell, SWT.BORDER);
	        
	     GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
	     gridData.horizontalSpan = 2;
	     composite.setLayoutData(gridData);
		
		 composite.setLayout(new GridLayout(2, false));
		 
		 label = new Label(composite, SWT.NONE);
		 label.setText("PHOTO: ");
		 
		 txtAnotherTest = new Text(composite, SWT.NONE);
	     txtAnotherTest.setText("                          ");

		 new Button(composite, SWT.PUSH).setText("Browse");
		 new Button(composite, SWT.PUSH).setText("Delete");
		
		
		
		// creating owner Info
		
		Group group = new Group(shell, SWT.NONE);
        group.setText("Owner Info");
        gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
        gridData.horizontalSpan = 2;
        group.setLayoutData(gridData);
        
        group.setLayout(new GridLayout(2, false));
        
        label = new Label(group, SWT.NONE);
		label.setText("Name: ");
        txtAnotherTest = new Text(group, SWT.NONE);
        txtAnotherTest.setText("                          ");
        
        label = new Label(group, SWT.NONE);
		label.setText(" Phone : ");
        txtAnotherTest = new Text(group, SWT.NONE);
        txtAnotherTest.setText("                           ");
        
        Button button = new Button(shell, SWT.NONE);
        button.setText("Enter");
        button.setBounds(100, 200, 400, 600);
		
		
		shell.pack();
		shell.open();
        
        while (!shell.isDisposed()) {
        	
            if (!display.readAndDispatch()) {
            	
                display.sleep();
            }
        }

	}

}
