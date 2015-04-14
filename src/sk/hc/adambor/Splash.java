package sk.hc.adambor;
 
import javax.swing.*;

import java.awt.*;
 
public class Splash extends JFrame {
 
    /**
	 * @author Adambor
	 */
	private static final long serialVersionUID = -8971965832490705559L;
    private ImageIcon img;
    private static JProgressBar pbar;
    Thread t = null;
 
    public Splash() {
        super("Splash");
    	try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
        setSize(411, 207);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        img = new ImageIcon(getClass().getResource("/Images/loading.png"));

        setContentPane(new JLabel(img));
        setLayout(null);
        pbar = new JProgressBar();
        pbar.setMinimum(0);
        pbar.setMaximum(100);
        pbar.setStringPainted(true);
        pbar.setForeground(Color.LIGHT_GRAY);
        add(pbar);
        pbar.setPreferredSize(new Dimension(411, 20));
        pbar.setBounds(0, 187, 411, 20);
        setVisible(true);
    	try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
    }
    
    public void remove(){
        setVisible(false);
    }
    public void add(int i){
        pbar.setValue(pbar.getValue()+i);
    }
}