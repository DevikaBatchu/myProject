import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class DialogBoxEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Display display = new Display ();
		Shell shell = new Shell (display);
		shell.setText("Snippet 29");
		
		Menu bar = new Menu (shell, SWT.BAR);
		shell.setMenuBar (bar);
		
		MenuItem fileItem = new MenuItem (bar, SWT.CASCADE);
		fileItem.setText ("&File");
		
		Menu submenu = new Menu (shell, SWT.DROP_DOWN);
		fileItem.setMenu (submenu);
		
		MenuItem item = new MenuItem (submenu, SWT.PUSH);
		item.addListener (SWT.Selection, e -> System.out.println ("Select All"));
		item.setText ("Select &All\tCtrl+A");
		item.setAccelerator (SWT.MOD1 + 'A');
		shell.setSize (200, 200);
		
		shell.open ();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		
		display.dispose ();
	}

}
