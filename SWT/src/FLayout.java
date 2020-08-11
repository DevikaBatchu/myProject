
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class FLayout {

	//private int type;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Display display = new Display();
		Shell shell = new Shell(display);
		
		//Creating a fillLayout
		FillLayout  fLayout = new FillLayout();
		
		// Setting layout as vertical 
		fLayout.type = SWT.VERTICAL;
		
		// creating a composite
		shell.setLayout(fLayout);
		
		// creating children for composite
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
		
		shell.dispose();

	}

}
