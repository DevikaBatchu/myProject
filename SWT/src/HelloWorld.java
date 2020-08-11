import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Display display = new Display();
		Shell shell = new Shell();
		
		shell.setText("Hello World");
		
		shell.open();
		
		
		// setup event loop
		while(!shell.isDisposed()) {
			
			if(!display.readAndDispatch()) {
				
				// if no more entries in the event queue
				display.sleep();
				
			}
		}
		
		display.dispose();
	}

}
