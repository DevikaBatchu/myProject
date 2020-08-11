import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class TreeAndMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Display display = Display.getDefault();
		 
	        Shell shell = new Shell(display);
	        
	        shell.setLayout(new FillLayout());
	        
	        final Tree tree = new Tree(shell, SWT.V_SCROLL);
	        
	        for (int i = 0; i < 5; i++) {
	        	
	            TreeItem item1 = new TreeItem(tree, SWT.NONE);
	            
	            item1.setText(String.valueOf(i));
	            
	            for (int k = 0; k < 5; k++) {
		        	
		            TreeItem item2 = new TreeItem(item1, SWT.NONE);
		            
		            item2.setText(String.valueOf(i) + " " + String.valueOf(k));
		            
		            for (int j = 0; j < 3; j++) {
		            	
		                TreeItem subItem = new TreeItem(item2, SWT.NONE);
		                
		                subItem.setText(String.valueOf(i) + " " + String.valueOf(k) + " " + String.valueOf(j));
		            }
	            }
	            
	            
	        }
	        
	        tree.pack();
	        
	        Menu menu = new Menu(tree); 
	        
	        MenuItem menuItem = new MenuItem(menu, SWT.NONE);
	        menuItem.setText("Print Element");
	        
	       // menuItem.addSelectionListener(widgetSelectedAdapter(e->System.out.println(tree.getSelection()[0].getText())));
	        menuItem.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
	        tree.setMenu(menu);
	        
	        shell.setSize(400, 200);
	        
	        shell.open();
	        
	        while (!shell.isDisposed()) {
	        	
	            if (!display.readAndDispatch()) {
	            	
	                display.sleep();
	            }
	        }

	}

}
