import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class CompositeEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Display display = new Display();
		Shell shell = new Shell(display);
		
		// setting size for composite
		shell.setSize(300,300);
		
		// creating composite
		shell.setLayout(new RowLayout());
		
		shell.setText("Composite Example");
		
		Composite composite = new Composite(shell, SWT.NONE);
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		
		composite.setLayout(gridLayout);
		
		for(int i=0; i<28; i++) {
			
			Label label = new Label(composite, SWT.SHADOW_NONE);
			
			label.setText("Label" + i);
		}
		
		shell.open();
		
		while(!shell.isDisposed()) {
			
			if(!display.readAndDispatch()) {
				
				display.sleep();
			}
		}
		
		shell.dispose();
	}

}
