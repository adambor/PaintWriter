package sk.hc.adambor;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main extends JFrame implements ActionListener, ChangeListener, MouseListener, WindowListener {
    
	/**
	 * @author Adambor
	 */
	private static final long serialVersionUID = -8160853006771979624L;
	
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel paintpanel = new JPanel();
	JLabel bg = new JLabel();
	JTextPane log = new JTextPane();
	JTextArea color1 = new JTextArea();
	JTextArea color2 = new JTextArea();
	JTextField char1set = new JTextField();
	JTextField char2set = new JTextField();
	JTextField char3set = new JTextField();
	JTextField char4set = new JTextField();
	JTextField char5set = new JTextField();
	JTextField char6set = new JTextField();
    JButton char1setb = new JButton();
	JButton char2setb = new JButton();
	JButton char3setb = new JButton();
	JButton char4setb = new JButton();
	JButton char5setb = new JButton();
	JButton char6setb = new JButton();
	Color cdright = new Color(0,0,0);
	Color cdleft = new Color(255,255,255);
	Color char1 = new Color(255,0,0);
	Color char2 = new Color(0,255,0);
	Color char3 = new Color(0,0,255);
	Color char4 = new Color(0,0,0);
	Color char5 = new Color(255,255,255);
	Color char6 = new Color(127,127,127);
	Color chosen = null;
	JSlider ver = new JSlider(JSlider.HORIZONTAL, 0, 30, 30);
	JSlider hor = new JSlider(JSlider.VERTICAL, 0, 20, 20);
	Integer widthl=30;
	Integer heightl=20;
	JButton Gen = new JButton();
	JMenuItem Clear = new JMenuItem("",new ImageIcon(Main.class.getResource("/Images/New.png")));
	JButton[][] aa = new JButton[20][30];
	JMenuBar menubar = new JMenuBar();
	JMenuItem SetSize = new JMenuItem("Set size",new ImageIcon(Main.class.getResource("/Images/resize.png")));
	JMenu File = new JMenu();
	JMenu edit = new JMenu();
	JMenuItem Save = new JMenuItem("",new ImageIcon(Main.class.getResource("/Images/Save.png")));
	JMenuItem Open = new JMenuItem("",new ImageIcon(Main.class.getResource("/Images/Open.png")));
	JMenuItem Import = new JMenuItem("",new ImageIcon(Main.class.getResource("/Images/Import.png")));
	JMenuItem SaveAs = new JMenuItem("",new ImageIcon(Main.class.getResource("/Images/SaveAs.png")));
	JMenuItem random = new JMenuItem("",new ImageIcon(Main.class.getResource("/Images/random.png")));
	JMenuItem fill = new JMenuItem("",new ImageIcon(Main.class.getResource("/Images/fill.png")));
    BufferedImage image;
    JFileChooser fcload = new JFileChooser();
    JFileChooser fcsave = new JFileChooser();
    File file = null;
    File propfile = new File("props");
    boolean overwriten = false;
	char[] textArray = new char[30];
	
	public static void main(String[] args) {
		try {
			@SuppressWarnings("unused")     
			Main main = new Main();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
	public void FillButtons(){
	for(Integer i=0; i<heightl; i++ ){
		for(Integer e=0; e<widthl; e++ ){
	aa[i][e]=new JButton();
	aa[i][e].setText("");
	aa[i][e].setBackground(new Color(0,0,0));
	aa[i][e].setCursor(getCursor("/Images/pencil.png",0,31));
	aa[i][e].setSize(20, 20);
	aa[i][e].addMouseListener(this);
    panel.add(aa[i][e]);
    aa[i][e].setVisible(true);
		}
	}
	}
	public void DisableButtons(){
	for(Integer i=0; i<20; i++ ){
		for(Integer e=0; e<30; e++ ){
    aa[i][e].setVisible(false);
		}
	}
	}
	public void EnableButtons(){
	for(Integer i=0; i<heightl; i++ ){
		for(Integer e=0; e<widthl; e++ ){
    aa[i][e].setVisible(true);
		}
	}
	}
	
	public Main() throws FileNotFoundException {

        Splash spl = new Splash();
        
		this.setSize(800, 750);
		this.setTitle("Paint Writer - Undefined0.pw");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        FillButtons();
        
        spl.add(10);
		log.setText("");
		log.setBounds(0,0,600,200);
		panel2.add(log);
		log.setBackground(new Color(123,164,92));
		log.setVisible(true);
		log.setEditable(false);
		panel2.setLayout(null);
		panel2.setVisible(true);
		
		bg.setIcon(new ImageIcon(Main.class.getResource("/Images/bg.png")));
		bg.setBounds(0, 0, 800, 750);
		this.setContentPane(bg);
		panel.setOpaque(false);
		panel2.setOpaque(false);
		panel3.setOpaque(false);
		paintpanel.setOpaque(false);
		
		panel.setLayout(new GridLayout(20,30));
		panel2.setBounds(50, 470, 600, 200);
		panel.setBounds(50, 50, 600, 400);
	    
		GridLayout layout = new GridLayout(1,1);
		layout.setVgap(20);
		
		panel3.setLayout(layout);
		panel3.setVisible(true);
		panel3.setBounds(660, 520, 100, 100);
		
		GridLayout layout2 = new GridLayout(6,2);
		layout2.setVgap(5);
		
		paintpanel.setLayout(layout2);
		paintpanel.setVisible(true);
		paintpanel.setBounds(660, 50, 100, 200);
		
		Gen.setText("Generate");
		Gen.setBackground(new Color(123,164,92));
		Gen.addActionListener(this);
	    Gen.setFont(new Font(Gen.getFont().getName(), Font.BOLD, 15));
		panel3.add(Gen);
		
		char1set.setText(":)");
		char1set.setBounds(0,0,30,20);
		
		char2set.setText(":3");
		char2set.setBounds(0,30,30,20);
		
		char3set.setText("(c)");
		char3set.setBounds(0,60,30,20);
		
		char4set.setText("<3");
		char4set.setBounds(0,90,30,20);
		
		char5set.setText(":*");
		char5set.setBounds(0,120,30,20);
		
		char6set.setText(":(");
		char6set.setBounds(0,150,30,20);
        spl.add(10);
		
		fcload = new JFileChooser(){
		    /**
			 * 
			 */
			private static final long serialVersionUID = 6233411678519455096L;

			@Override
		    protected JDialog createDialog( Component parent ) throws HeadlessException {
		        JDialog dialog = super.createDialog( parent );
		        BufferedImage image = null;
				try {
					image = ImageIO.read(Main.class.getResource("/Images/Open.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
		        dialog.setIconImage( image );
		        return dialog;
		    }
		 };
			fcload.setAcceptAllFileFilterUsed(false);
			fcload.setMultiSelectionEnabled(false);
			fcload.setFileFilter(new FileNameExtensionFilter("Paint Writer File (.pw)","pw"));
			fcload.setDialogTitle("Open...");
		fcsave = new JFileChooser(){
			    /**
			 * 
			 */
			private static final long serialVersionUID = -7892626226273294574L;

				@Override
			    protected JDialog createDialog( Component parent ) throws HeadlessException {
			        JDialog dialog = super.createDialog( parent );
			        BufferedImage image = null;
					try {
						image = ImageIO.read(Main.class.getResource("/Images/SaveAs.png"));
					} catch (IOException e) {
						e.printStackTrace();
					}
			        dialog.setIconImage( image );
			        return dialog;
			    }
			    @Override
			    public void approveSelection(){
			        File f = getSelectedFile();
			        if(f.exists() && getDialogType() == SAVE_DIALOG){
			        	JOptionPane jop = new JOptionPane("Do you want to overwrite this file ?",JOptionPane.PLAIN_MESSAGE,JOptionPane.YES_NO_OPTION);
			        	jop.setIcon(new ImageIcon(Main.class.getResource("/Images/SaveAs64.png")));
			        	JDialog jd = jop.createDialog("File exist");
			        	try {
							jd.setIconImage(ImageIO.read(Main.class.getResource("/Images/SaveAs.png")));
							jd.setVisible(true);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        	
			            int result = (Integer) jop.getValue();
			            switch(result){
			                case JOptionPane.YES_OPTION:
			                    super.approveSelection();
			                    return;
			                case JOptionPane.NO_OPTION:
			                    return;
			                case JOptionPane.CLOSED_OPTION:
			                    return;
			                case JOptionPane.CANCEL_OPTION:
			                    cancelSelection();
			                    return;
			            }
			        }
			        super.approveSelection();
			    }    
			 };
			fcsave.setAcceptAllFileFilterUsed(false);
			fcsave.setMultiSelectionEnabled(false);
			fcsave.setFileFilter(new FileNameExtensionFilter("Paint Writer File (.pw)","pw"));
			fcsave.setDialogTitle("Save as...");
		

		this.setCursor(getCursor("/Images/cursor.png",0,0));
		this.getRootPane().setCursor(getCursor("/Images/cursor.png",0,0));
		
		char1setb.setCursor(getCursor("/Images/pipete.png",1,28));
		char2setb.setCursor(getCursor("/Images/pipete.png",1,28));
		char3setb.setCursor(getCursor("/Images/pipete.png",1,28));
		char4setb.setCursor(getCursor("/Images/pipete.png",1,28));
		char5setb.setCursor(getCursor("/Images/pipete.png",1,28));
		char6setb.setCursor(getCursor("/Images/pipete.png",1,28));
		
		char1setb.setText("");
		char1setb.setBackground(char1);
		char1setb.setBounds(35,0,30,20);
		char1setb.addMouseListener(this);
		
		char2setb.setText("");
		char2setb.setBackground(char2);
		char2setb.setBounds(35,30,30,20);
		char2setb.addMouseListener(this);
		
		char3setb.setText("");
		char3setb.setBackground(char3);
		char3setb.setForeground(new Color(255,255,255));
		char3setb.setBounds(35,60,30,20);
		char3setb.addMouseListener(this);
		
		char4setb.setText("");
		char4setb.setBackground(char4);
		char4setb.setForeground(new Color(255,255,255));
		char4setb.setBounds(35,90,30,20);
		char4setb.addMouseListener(this);

        spl.add(10);
		char5setb.setText("");
		char5setb.setBackground(char5);
		char5setb.setBounds(35,120,30,20);
		char5setb.addMouseListener(this);
		
		char6setb.setText("");
		char6setb.setBackground(char6);
		char6setb.setForeground(new Color(255,255,255));
		char6setb.setBounds(35,150,30,20);
		char6setb.addMouseListener(this);
		
		paintpanel.add(char1set);
		paintpanel.add(char1setb);
		paintpanel.add(char2set);
		paintpanel.add(char2setb);
		paintpanel.add(char3set);
		paintpanel.add(char3setb);
		paintpanel.add(char4set);
		paintpanel.add(char4setb);
		paintpanel.add(char5set);
		paintpanel.add(char5setb);
		paintpanel.add(char6set);
		paintpanel.add(char6setb);
		

		
		Clear.setIconTextGap(10);
		Clear.setText("New                ");
        Clear.setAccelerator(KeyStroke.getKeyStroke("control N"));
		Clear.addActionListener(this);
		
		ver.setMinorTickSpacing(1);
		ver.setMajorTickSpacing(10);
		ver.setPaintTicks(true);
		ver.setBounds(44, 20, 612, 30);
		ver.addChangeListener(this);
		this.add(ver);
		
		hor.setInverted(true);
		hor.setMinorTickSpacing(1);
		hor.setMajorTickSpacing(10);
		hor.setPaintTicks(true);
		hor.setBounds(20, 44, 30, 412);
		hor.addChangeListener(this);
		this.add(hor);
		
		color1.setBounds(660,260,100,80);
		color1.setEditable(false);
		color1.setBackground(char5);
		color1.setBorder(BorderFactory.createLineBorder(new Color(255,255,0),3));
		color1.setToolTipText("Farba 1");
        spl.add(10);
		
		color2.setBounds(660,350,100,80);
		color2.setEditable(false);
		color2.setBackground(char4);
		color2.setBorder(BorderFactory.createLineBorder(new Color(255,255,0),3));
		color2.setToolTipText("Farba 2");

		JScrollPane editorScrollPane = new JScrollPane(log);
		editorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		editorScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        editorScrollPane.setPreferredSize(new Dimension(250, 145));
        editorScrollPane.setMinimumSize(new Dimension(10, 10));
        editorScrollPane.setBounds(0, 0, 600, 200);
        panel2.add(editorScrollPane);
        spl.add(10);

        Open.setIconTextGap(10);
        Open.setText("Open");
        Open.setAccelerator(KeyStroke.getKeyStroke("control O"));
        Open.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				load();
			}
        });
        Save.setIconTextGap(10);
        Save.setText("Save");
        Save.setAccelerator(KeyStroke.getKeyStroke("control S"));
        Save.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				save();
			}
        });
        random.setIconTextGap(10);
        random.setText("Random");
        random.setAccelerator(KeyStroke.getKeyStroke("control R"));
        random.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				random();
			}
        });
        fill.setIconTextGap(10);
        fill.setText("Fill");
        fill.setAccelerator(KeyStroke.getKeyStroke("control F"));
        fill.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fillWith();
			}
        });
        spl.add(10);
        Import.setIconTextGap(10);
        Import.setText("Import            ");
        Import.setAccelerator(KeyStroke.getKeyStroke("control I"));
        Import.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
                fromText();
			}
        });
        SaveAs.setIconTextGap(10);
        SaveAs.setText("Save as...");
        SaveAs.setAccelerator(KeyStroke.getKeyStroke("control shift S"));
        SaveAs.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
                saveAs();
			}
        });
        spl.add(10);
        SetSize.setIconTextGap(10);
        SetSize.setIcon(new ImageIcon(Main.class.getResource("/Images/resize.png")));
        SetSize.setAccelerator(KeyStroke.getKeyStroke("control alt S"));
        SetSize.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
                setSize();
			}
        });
        edit.setText("Edit");
        File.setText("File");
        File.add(Open);
        File.add(Save);
        File.add(SaveAs);
        File.add(new JSeparator());
        File.add(Clear);
        edit.add(Import);
        edit.add(SetSize);
        edit.add(new JSeparator());
        edit.add(random);
        edit.add(fill);
        menubar.add(File);
        menubar.add(edit);
        spl.add(10);
        
		try {
			image = ImageIO.read(Main.class.getResource("/Images/bandicam 2015-01-28 14-44-14-995.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
        spl.add(10);
	    
        if(!propfile.exists()){
		try {
			String content = "";
			FileWriter fw;
			fw = new FileWriter(propfile.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        } else {
        	try{
            String path = readFile("props");
        	file = new File(path);
        	StringBuilder str = new StringBuilder();
        	Integer chars = 1;
        	boolean color = false;
            if(file!=null){
            	System.out.println(file);
                this.setTitle("Paint Writer - "+file.getName());
    		log.setText("");
    		for(Integer b=0; b<20; b++ ){
    			for(Integer o=0; o<30; o++ ){
    	    aa[b][o].setBackground(new Color(0,0,0));
    			}
    		}
    		String text="";
    		try {
    			text = readFile(file.getAbsolutePath());
    		} catch (IOException e1) {
    			e1.printStackTrace();
    		}
    		textArray = text.toCharArray();
    		heightl = 1;
    		widthl = 0;
    		Integer e=0;
    		Integer o=0;
    		for(Integer i=0; i<textArray.length; i++ ){
    			if(color==false){
    		if(textArray[i]=='1') aa[e][o].setBackground(char1);
    		if(textArray[i]=='2') aa[e][o].setBackground(char2);
    		if(textArray[i]=='3') aa[e][o].setBackground(char3);
    		if(textArray[i]=='4') aa[e][o].setBackground(char4);
    		if(textArray[i]=='5') aa[e][o].setBackground(char5);
    		if(textArray[i]=='6') aa[e][o].setBackground(char6);
    		if(textArray[i]=='1'||textArray[i]=='2'||textArray[i]=='3'||textArray[i]=='4'||textArray[i]=='5'||textArray[i]=='6') widthl++;
    		if(textArray[i]=='7'){
    			e++;
    			o=0;
    			heightl++;
    			widthl=0;
    		} else {
    			o++;
    		}
    		System.out.println(textArray[i]);
    		if(textArray[i]=='-') {
                color = true;
    		}
    		} else {
    			if(textArray[i]=='|'){
    				if(chars==1) char1set.setText(str.toString());
    				if(chars==2) char2set.setText(str.toString());
    				if(chars==3) char3set.setText(str.toString());
    				if(chars==4) char4set.setText(str.toString());
    				if(chars==5) char5set.setText(str.toString());
    				if(chars==6) char6set.setText(str.toString());
    				str = null;
    				str = new StringBuilder();
    				chars++;
    			} else {
    				str.append(textArray[i]);
    				System.out.println(str.toString());
    			}
    		}
    		}
    		ver.setValue(widthl);
    		hor.setValue(heightl);
            }
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
        }
        spl.add(10);
		
		this.addWindowListener(this);
		setLook();
        this.setIconImage(image);
        this.setJMenuBar(menubar);
		this.add(color1);
		this.add(color2);
	    this.add(panel);
		this.add(panel2);
		this.add(panel3);
		this.add(paintpanel);
	    this.setLayout(null);
	    this.validate();
	    this.repaint();
	    spl.remove();
	    this.setVisible(true);
        spl.add(10);
	}
	
    public void windowClosing(WindowEvent e) {
    	System.out.println(overwriten);
    	if(overwriten){
    	if(JOptionPane.showConfirmDialog(Main.this, "Do you want to save file before close ?","Close confirmation",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
    		save();
    	}
    	}
        ActionListener task = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Main.this.isDisplayable()) {
                    Main.this.dispose();
                }
            }
        };
        Timer timer = new Timer(500, task); //fire every half second
        timer.setInitialDelay(2000);        //first delay 2 seconds
        timer.setRepeats(false);
        timer.start();
    }
	@Override
	public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource()==Gen) { 
			heightl=hor.getValue();
			widthl=ver.getValue();
			log.setText("");
			Integer height=0;
			for(JButton[] but : aa){
				Integer width=0;
				for(JButton button2 : but) {
					if(height<heightl){
					if(width<widthl){
					System.out.println(button2.getBackground()+" ; "+char4);
					if(button2.getBackground().getRGB()==char1.getRGB()) log.setText(log.getText()+char1set.getText());
					if(button2.getBackground().getRGB()==char2.getRGB()) log.setText(log.getText()+char2set.getText());
					if(button2.getBackground().getRGB()==char3.getRGB()) log.setText(log.getText()+char3set.getText());
					if(button2.getBackground().getRGB()==char4.getRGB()) log.setText(log.getText()+char4set.getText());
					if(button2.getBackground().getRGB()==char5.getRGB()) log.setText(log.getText()+char5set.getText());
					if(button2.getBackground().getRGB()==char6.getRGB()) log.setText(log.getText()+char6set.getText());
					width++;
					}
					}
				}
				if(height<heightl+1){
				log.setText(log.getText()+"\n");
				height++;
				}
			}
			}
			if(arg0.getSource()==Clear){
                New();
				}
			}
	@Override
    public void mouseClicked(MouseEvent e){

	}
	@Override
	public void stateChanged(ChangeEvent arg0) {
		if(arg0.getSource()==hor)
		heightl=hor.getValue();
		if(arg0.getSource()==ver)
		widthl=ver.getValue();
		
		DisableButtons();
		EnableButtons();
        panel.validate();
        panel.repaint();
        this.validate();
        this.repaint();
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource()==char1setb||e.getSource()==char2setb||e.getSource()==char3setb||e.getSource()==char4setb||e.getSource()==char5setb||e.getSource()==char6setb){
			JButton button = (JButton) e.getSource();
			if(e.getButton()==MouseEvent.BUTTON1){
				cdleft = button.getBackground();
				color1.setBackground(cdleft);
			}
			if(e.getButton()==MouseEvent.BUTTON3){
				cdright = button.getBackground();
				color2.setBackground(cdright);
			}
		} else {
		
		if(e.getButton() == MouseEvent.BUTTON1){
		JButton click = (JButton) e.getSource();
		click.setBackground(cdleft);
		overwriten = true;
		}
		if (e.getButton() == MouseEvent.BUTTON3) {
		JButton click = (JButton) e.getSource();
	    click.setBackground(cdright);
		overwriten = true;
		}
		}	
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
	public void fromText() {
        JPanel pan = new JPanel();
		JTextArea area = new JTextArea();
		
		JScrollPane editorScrollPane = new JScrollPane(area);
		editorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		editorScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        editorScrollPane.setPreferredSize(new Dimension(200, 200));
        editorScrollPane.setMinimumSize(new Dimension(10, 10));
        pan.setPreferredSize(new Dimension(200,220));
        pan.add(editorScrollPane);
		
		final JComponent[] inputs = new JComponent[] {
				new JLabel("Import:"),
				pan,
		};
        JOptionPane jop = new JOptionPane(
                inputs,
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION
                );
        jop.setIcon(new ImageIcon(Main.class.getResource("/Images/Import64.png")));
        JDialog dialog = jop.createDialog("Import");

        Image image;
		try {
			image = ImageIO.read(Main.class.getResource("/Images/Import.png"));
	        dialog.setIconImage( image );
	        dialog.setVisible(true);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		if((Integer)jop.getValue()==JOptionPane.OK_OPTION){
        
		if(!area.getText().equals("")){
			if(JOptionPane.showConfirmDialog(this, "Do you want to save this file before importing ?", "Import confirmation", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
				save();
			}
		for(Integer b=0; b<20; b++ ){
			for(Integer o=0; o<30; o++ ){
	    aa[b][o].setBackground(new Color(0,0,0));
			}
		}
		this.setTitle("Paint Writer - Undefined.pw");
		file = null;
		overwriten = true;
		String text = area.getText();
		text=text.replace(char1set.getText(), "1");
		text=text.replace(char2set.getText(), "2");
		text=text.replace(char3set.getText(), "3");
		text=text.replace(char4set.getText(), "4");
		text=text.replace(char5set.getText(), "5");
		text=text.replace(char6set.getText(), "6");
		text=text.replace("\n", "7");
		
		textArray = text.toCharArray();
		Integer e=0;
		Integer o=0;
		for(Integer i=0; i<textArray.length; i++ ){
		if(textArray[i]=='1') aa[e][o].setBackground(char1);
		if(textArray[i]=='2') aa[e][o].setBackground(char2);
		if(textArray[i]=='3') aa[e][o].setBackground(char3);
		if(textArray[i]=='4') aa[e][o].setBackground(char4);
		if(textArray[i]=='5') aa[e][o].setBackground(char5);
		if(textArray[i]=='6') aa[e][o].setBackground(char6);
		if(textArray[i]=='7'){
			e++;
			o=0;
		} else {
			o++;
		}
		System.out.println(textArray[i]);
		}
		}
		}
	}
	public void load(){
		Integer chars=1;
		StringBuilder str = new StringBuilder();
		boolean color = false;
        fcload.setSelectedFile(new File(""));
        int returnVal = fcload.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fcload.getSelectedFile();
        	System.out.println(file);
            if(!file.getAbsolutePath().endsWith(".pw")){
            	file = new File(file.getAbsolutePath()+".pw");
            }
            //This is where a real application would open the file.
            System.out.println("Opening: " + file.getName() + ".");
            if(file!=null&&file.exists()){
                this.setTitle("Paint Writer - "+file.getName());
    		log.setText("");
    		for(Integer b=0; b<20; b++ ){
    			for(Integer o=0; o<30; o++ ){
    	    aa[b][o].setBackground(new Color(0,0,0));
    			}
    		}
    		String text="";
    		try {
    			text = readFile(file.getAbsolutePath());
    		} catch (IOException e1) {
    			e1.printStackTrace();
    		}
    		textArray = text.toCharArray();
    		heightl = 1;
    		widthl = 0;
    		Integer e=0;
    		Integer o=0;
    		for(Integer i=0; i<textArray.length; i++ ){
    			if(color==false){
    		if(textArray[i]=='1') aa[e][o].setBackground(char1);
    		if(textArray[i]=='2') aa[e][o].setBackground(char2);
    		if(textArray[i]=='3') aa[e][o].setBackground(char3);
    		if(textArray[i]=='4') aa[e][o].setBackground(char4);
    		if(textArray[i]=='5') aa[e][o].setBackground(char5);
    		if(textArray[i]=='6') aa[e][o].setBackground(char6);
    		if(textArray[i]=='1'||textArray[i]=='2'||textArray[i]=='3'||textArray[i]=='4'||textArray[i]=='5'||textArray[i]=='6') widthl++;
    		if(textArray[i]=='7'){
    			e++;
    			o=0;
    			heightl++;
    			widthl=0;
    		} else {
    			o++;
    		}
    		System.out.println(textArray[i]);
    		if(textArray[i]=='-') {
                color = true;
    		}
    		} else {
    			if(textArray[i]=='|'){
    				if(chars==1) char1set.setText(str.toString());
    				if(chars==2) char2set.setText(str.toString());
    				if(chars==3) char3set.setText(str.toString());
    				if(chars==4) char4set.setText(str.toString());
    				if(chars==5) char5set.setText(str.toString());
    				if(chars==6) char6set.setText(str.toString());
    				str = null;
    				str = new StringBuilder();
    				chars++;
    			} else {
    				str.append(textArray[i]);
    				System.out.println(str.toString());
    			}
    		}
    		}
    		ver.setValue(widthl);
    		hor.setValue(heightl);
            }
            writeToProps(file.getAbsolutePath());
			overwriten = false;
        } else {
        	System.out.println("Open command cancelled by user.");
        }

	}
	private String readFile( String file ) throws IOException {
	    @SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader( new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();

	    while( ( line = reader.readLine() ) != null ) {
	        stringBuilder.append( line );
	    }

	    return stringBuilder.toString();
	}
	public void saveAs(){
		boolean found = false;
		int a = 0;
		while(found==false){
			File f = new File(fcsave.getCurrentDirectory()+"\\"+"Undefined"+a+".pw");
		if(!f.getAbsoluteFile().exists()){
			found = true;
			fcsave.setSelectedFile(new File("Undefined"+a));
		}
		a++;
		}
        int returnVal = fcsave.showSaveDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fcsave.getSelectedFile();

            if(!file.getName().endsWith(".pw")){
            System.out.println(file.getAbsolutePath()+".pw");
            file = new File(file.getAbsolutePath()+".pw");
            }
            //This is where a real application would open the file.
            System.out.println("Opening: " + file.getName());
            this.setTitle("Paint Writer - "+file.getName());
            save();
            writeToProps(file.getAbsolutePath());
        }
	}
	public void save(){
		try{
		if(file!=null){
			StringBuilder content = new StringBuilder();
			Integer height=0;
			for(JButton[] but : aa){
				Integer width=0;
				for(JButton button2 : but) {
					if(height<heightl){
					if(width<widthl){
					if(button2.getBackground().getRGB()==char1.getRGB()) content.append("1");
					if(button2.getBackground().getRGB()==char2.getRGB()) content.append("2");
					if(button2.getBackground().getRGB()==char3.getRGB()) content.append("3");
					if(button2.getBackground().getRGB()==char4.getRGB()) content.append("4");
					if(button2.getBackground().getRGB()==char5.getRGB()) content.append("5");
					if(button2.getBackground().getRGB()==char6.getRGB()) content.append("6");
					width++;
					}
					}
				}
				if(height<heightl-1){
				content.append("7");
				}
				if(height<heightl+1) height++;
			}
			content.append("-"+char1set.getText()+"|");
			content.append(char2set.getText()+"|");
			content.append(char3set.getText()+"|");
			content.append(char4set.getText()+"|");
			content.append(char5set.getText()+"|");
			content.append(char6set.getText()+"|");
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(content.toString());
				bw.close();
	 
				System.out.println("Done");
			} else {
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content.toString());
			bw.close();
			overwriten = false;
			System.out.println("Done");
	        }
	        } else {
	        	saveAs();
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    public void New(){
    	if(overwriten==true){
		if(JOptionPane.showConfirmDialog(this, "Do you want to save this file ?","New file confirmation",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
			save();
		}
        }
    	overwriten = false;
		log.setText("");
		for(Integer b=0; b<20; b++ ){
			for(Integer o=0; o<30; o++ ){
	    aa[b][o].setBackground(new Color(0,0,0));
			}
		}
		setSize();
		file = null;
		this.setTitle("Paint Writer - Undefined.pw");
    }
	public void setLook(){
		LookAndFeelInfo[] inst = UIManager.getInstalledLookAndFeels();
		panel.setBackground(new Color(214,217,223));
		for(LookAndFeelInfo but : inst){
			System.out.println(but.getClassName());
		}
        try {
            UIManager.setLookAndFeel( "javax.swing.plaf.nimbus.NimbusLookAndFeel" );
            SwingUtilities.updateComponentTreeUI(this);
            SwingUtilities.updateComponentTreeUI(panel2);
            SwingUtilities.updateComponentTreeUI(paintpanel);
            SwingUtilities.updateComponentTreeUI(panel3);
            UIManager.setLookAndFeel( "com.sun.java.swing.plaf.windows.WindowsLookAndFeel" );
            SwingUtilities.updateComponentTreeUI(menubar);
            UIManager.setLookAndFeel( "javax.swing.plaf.nimbus.NimbusLookAndFeel" );
            SwingUtilities.updateComponentTreeUI(File);
            SwingUtilities.updateComponentTreeUI(edit);
            SwingUtilities.updateComponentTreeUI(fcload);
            SwingUtilities.updateComponentTreeUI(fcsave);
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		
	}
	public void writeToProps(String content){
		try {
			FileWriter fw;
			fw = new FileWriter(propfile.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void setSize(){
		JTextField h = new JTextField();
		JTextField w = new JTextField();
		w.setText(""+widthl);
		h.setText(""+heightl);
		
		final JComponent[] inputs = new JComponent[] {
				new JLabel("Height: "),
				h,
				new JLabel("Width: "),
				w,
		};
        JOptionPane jop = new JOptionPane(
                inputs,
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION
                );
        jop.setIcon(new ImageIcon(Main.class.getResource("/Images/resize64.png")));
        JDialog dialog = jop.createDialog("Set size");

        Image image;
		try {
			image = ImageIO.read(Main.class.getResource("/Images/resize.png"));
	        dialog.setIconImage( image );
	        dialog.setVisible(true);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if((Integer)jop.getValue()==JOptionPane.OK_OPTION){
		ver.setValue(Integer.parseInt(w.getText()));
		hor.setValue(Integer.parseInt(h.getText()));
		DisableButtons();
		EnableButtons();
        panel.validate();
        panel.repaint();
		}
	}
	public Cursor getCursor(String path, Integer h, Integer w){
		Cursor c = null;
		try {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Image img;
			img = ImageIO.read(Main.class.getResource(path));
			  c = toolkit.createCustomCursor(img , new Point(h, w), "img");
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return c;
	}
	public void random(){
		for(Integer i=0; i<heightl; i++ ){
			for(Integer e=0; e<widthl; e++ ){
				Random rand = new Random();
                Integer x = rand.nextInt(6);
            	if(x==0) aa[i][e].setBackground(char1);
            	if(x==1) aa[i][e].setBackground(char2);
            	if(x==2) aa[i][e].setBackground(char3);
            	if(x==3) aa[i][e].setBackground(char4);
            	if(x==4) aa[i][e].setBackground(char5);
            	if(x==5) aa[i][e].setBackground(char6);
			}
		}
		overwriten = true;
	}
	public void fillWith(){
		
		JButton but1 = new JButton();
		JButton but2 = new JButton();
		JButton but3 = new JButton();
		JButton but4 = new JButton();
		JButton but5 = new JButton();
		JButton but6 = new JButton();
		
		chosen = char1;
		but1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		but1.setBackground(char1);
		but2.setBackground(char2);
		but3.setBackground(char3);
		but4.setBackground(char4);
		but5.setBackground(char5);
		but6.setBackground(char6);
		
		but1.setPreferredSize(new Dimension(100,50));
		but2.setPreferredSize(new Dimension(100,50));
		but3.setPreferredSize(new Dimension(100,50));
		but4.setPreferredSize(new Dimension(100,50));
		but5.setPreferredSize(new Dimension(100,50));
		but6.setPreferredSize(new Dimension(100,50));
		
		but1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chosen=char1;
				but1.setBorder(null);
				but2.setBorder(null);
				but3.setBorder(null);
				but4.setBorder(null);
				but5.setBorder(null);
				but6.setBorder(null);
				but1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
			}
		});
		but2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chosen=char2;
				but1.setBorder(null);
				but2.setBorder(null);
				but3.setBorder(null);
				but4.setBorder(null);
				but5.setBorder(null);
				but6.setBorder(null);
				but2.setBorder(BorderFactory.createLineBorder(Color.BLUE));
			}
		});
		but3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chosen=char3;
				but1.setBorder(null);
				but2.setBorder(null);
				but3.setBorder(null);
				but4.setBorder(null);
				but5.setBorder(null);
				but6.setBorder(null);
				but3.setBorder(BorderFactory.createLineBorder(Color.BLUE));
			}
		});
		but4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chosen=char4;
				but1.setBorder(null);
				but2.setBorder(null);
				but3.setBorder(null);
				but4.setBorder(null);
				but5.setBorder(null);
				but6.setBorder(null);
				but4.setBorder(BorderFactory.createLineBorder(Color.BLUE));
			}
		});
		but5.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chosen=char5;
				but1.setBorder(null);
				but2.setBorder(null);
				but3.setBorder(null);
				but4.setBorder(null);
				but5.setBorder(null);
				but6.setBorder(null);
				but5.setBorder(BorderFactory.createLineBorder(Color.BLUE));
			}
		});
		but6.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chosen=char6;
				but1.setBorder(null);
				but2.setBorder(null);
				but3.setBorder(null);
				but4.setBorder(null);
				but5.setBorder(null);
				but6.setBorder(null);
				but6.setBorder(BorderFactory.createLineBorder(Color.BLUE));
			}
		});
		
		
		final JComponent[] inputs = new JComponent[] {
				new JLabel("Fill with: "),
				but1,
				but2,
				but3,
				but4,
				but5,
				but6,
		};
        JOptionPane jop = new JOptionPane(
                inputs,
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION
                );
        jop.setIcon(new ImageIcon(Main.class.getResource("/Images/fill64.png")));
        JDialog dialog = jop.createDialog("Fill");

        Image image;
		try {
			image = ImageIO.read(Main.class.getResource("/Images/fill.png"));
	        dialog.setIconImage( image );
	        dialog.setVisible(true);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if((Integer)jop.getValue()==JOptionPane.OK_OPTION){
		for(Integer i=0; i<heightl; i++ ){
			for(Integer e=0; e<widthl; e++ ){
            	aa[i][e].setBackground(chosen);
			}
		}
		overwriten = true;
		}
	}
}