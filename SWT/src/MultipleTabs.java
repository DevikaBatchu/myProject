import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class MultipleTabs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Display display = new Display();
        Shell shell = new Shell(display);

        shell.setLayout(new GridLayout());
        
        // SWT.BOTTOM to show at the bottom
        CTabFolder folder = new CTabFolder(shell, SWT.BOTTOM);
        
        GridData data = new GridData(SWT.FILL,SWT.FILL, true, true, 2, 1);
        
        folder.setLayoutData(data);
        folder.setSelectionForeground(display.getSystemColor(SWT.COLOR_RED));
        
        CTabItem cTabItem1 = new CTabItem(folder, SWT.NONE);
        cTabItem1.setText("Tab1");
        
        CTabItem cTabItem2 = new CTabItem(folder, SWT.NONE);
        cTabItem2.setText("Tab2");
        
        CTabItem cTabItem3 = new CTabItem(folder, SWT.NONE);
        cTabItem3.setText("Tab3");

        Text text1 = new Text(folder, SWT.BORDER);
        Text text2 = new Text(folder, SWT.BORDER);
        Text text3 = new Text(folder, SWT.BORDER);
        
        text1.setText("Hello Tab1");
        cTabItem1.setControl(text1);
        
        text2.setText("Hello Tab2");
        cTabItem2.setControl(text2);
        
        text3.setText("Hello Tab3");
        cTabItem3.setControl(text3);
        
        
       /* Control[] controls = new Control[] { cTabItem2, cTabItem1, cTabItem3 };
        
        shell.setTabList(controls);*/

        shell.pack();
        shell.open();
        
        while (!shell.isDisposed()) {
        	
            if (!display.readAndDispatch()) {
            	
                display.sleep();
            }
        }

	}

}
