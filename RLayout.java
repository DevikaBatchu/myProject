import org.eclipse.swt.SWT;

import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class RLayout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Display display = new Display();
		Shell shell = new Shell(display);
		
		//Creating a Row layout
		RowLayout rowLayout = new RowLayout();
		
		// optionally set layout fields
		rowLayout.wrap = true;
		
		// set the layout into composite
		shell.setLayout(rowLayout);
		
		// creating the children of layout
		new Button(shell, SWT.PUSH).setText("B1");
		new Button(shell, SWT.PUSH).setText("Wide Button 2");
		new Button(shell, SWT.PUSH).setText("Button 3");
		
		shell.pack();
		
		shell.open();
		
		while(!shell.isDisposed()) {
			
			if(!display.readAndDispatch()) {
				
				display.sleep();
			}
		}
		

	}

}
