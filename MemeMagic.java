import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

/**
* Homework 7
* Janco Megerssa, jam6nnu
*
* Sources: TA and cohort help, lecture slides, TA and Instructor office hours, and piazza
*/

/**
 * MemeMagic Graphical User Interface 
 * 
 * This class contains the graphical user interface for the Meme Magic Software
 * 
 * You will need to implement certain portions of this class, marked with comments starting with "TODO" to connect 
 * it with your existing code. 
 * 
 * This class provides an example layout for the GUI. You are encouraged to be creative in your design. 
 * More information about Swing is online at: 
 * https://docs.oracle.com/javase/tutorial/uiswing/components/componentlist.html.
 */
public class MemeMagic extends JFrame {

    /**
     * Serialization string required by extending JFrame
     */
    private static final long serialVersionUID = 1L;
    
    private User user;
    private GraphicalMeme currentMeme;
    
    private String backgroundImageFilename;

    private BorderLayout panelLayout;
    private JLabel backgroundImageFileNameLabel;
    private JLabel imageDisplayLabel;
    private JPanel controlPanel;
    private JPanel memeViewPanel;
    private JPanel panelPane;
    private JTextField backgroundImageTitleText;
    private JTextField backgroundImageDescriptionText;
    private JTextField memeCaptionText;
    private JComboBox dropdown;
    
    
    public MemeMagic() {
        this.user = new User();
    }
    
    public MemeMagic(User user) {
        this.user = user;
    }


    /**
     * Main method.  This method initializes a PhotoViewer, loads images into a PhotographContainer, then
     * initializes the Graphical User Interface.
     * 
     * @param args  Optional command-line arguments
     */
    public static void main(String[] args) {
        
        // Create a User object for this instance of Meme Magic
        User user = new User();

        // Instantiate the PhotoViewer Class
        MemeMagic myViewer = new MemeMagic(user);
        
        // Invoke and start the Graphical User Interface
        javax.swing.SwingUtilities.invokeLater(() -> myViewer.initialize());
    }

    /**
     * Initialize all the GUI components.  This method will be called by
     * SwingUtilities when the application is started.
     */
    private void initialize() {

        // Tell Java to exit the program when the window is closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Tell Java to title the window to Meme Magic
        this.setTitle("Meme Magic");

        // We will use border layout on the main panel, since it is much easier for organizing panels.
        panelLayout = new BorderLayout();
        panelPane = new JPanel(panelLayout);

        // Create a label to display the full image.
        imageDisplayLabel = new JLabel();
        imageDisplayLabel.setHorizontalAlignment(JLabel.CENTER);
        imageDisplayLabel.setPreferredSize(new Dimension(550, 550));

        // Create a panel on which to display the full image
        memeViewPanel = new JPanel(new BorderLayout());
        memeViewPanel.setPreferredSize(new Dimension(550, 550));
        memeViewPanel.add(imageDisplayLabel, BorderLayout.CENTER);


        // Create a panel on which to display the controls for building a Meme
        controlPanel = new JPanel(new BorderLayout());
   
    
        // Create a panel that holds BackgroundImage information and give it a title
        JPanel backgroundImagePanel = new JPanel(new BorderLayout());
        backgroundImagePanel.setBorder(BorderFactory.createTitledBorder("Background Image"));
        
        // Create a panel that provides input for the BackgroundImage fileName
        JPanel backgroundImageFilePanel = new JPanel();
        // Create a panel that provides input for the BackgroundImage Title
        JPanel backgroundImageTitlePanel = new JPanel();      
        // Create a panel that provides input for the BackgroundImage Description
        JPanel backgroundImageDescriptionPanel = new JPanel();
        // Labels for background image panel
        // Label
        JLabel backgroundImageFileLabel = new JLabel("Filename: ");
        backgroundImageFileLabel.setPreferredSize(new Dimension(100, 20));
        backgroundImageFilePanel.add(backgroundImageFileLabel);
        //Label
        JLabel backgroundImageTitleLabel = new JLabel("Title: ");
        backgroundImageTitleLabel.setPreferredSize(new Dimension(100, 20));
        backgroundImageTitlePanel.add(backgroundImageTitleLabel);
        //Label
        JLabel backgroundImageDescriptionLabel = new JLabel("Description: ");
        backgroundImageDescriptionLabel.setPreferredSize(new Dimension(100, 20));
        backgroundImageDescriptionPanel.add(backgroundImageDescriptionLabel);
        //Text Fields for the backgroundImage panel
        //Text field
        backgroundImageTitleText = new JTextField(39);
        backgroundImageTitlePanel.add(backgroundImageTitleText, BorderLayout.CENTER);
        //Text field
        backgroundImageDescriptionText = new JTextField(39);
        backgroundImageDescriptionPanel.add(backgroundImageDescriptionText, BorderLayout.SOUTH);
        
        // Browse Button for background image panel
        JButton backgroundImageButton = new JButton("Browse");
        backgroundImageFilePanel.add(backgroundImageButton);
        backgroundImageButton.setPreferredSize(new Dimension(85, 20));
        
        // Create a panel for Meme
        JPanel memePanel = new JPanel(new BorderLayout());
        memePanel.setBorder(BorderFactory.createTitledBorder("Meme"));
        
        // Create a panel that provides input for the meme caption
        JPanel memeCaptionPanel = new JPanel();
        // Create a panel that provides input for the meme vertical aligning
        JPanel memeVerticalAlignPanel = new JPanel();
        // Labels for meme caption panel
        // Label
        JLabel memeCaptionLabel = new JLabel("Caption: ");
        memeCaptionLabel.setPreferredSize(new Dimension(100, 20));
        memeCaptionPanel.add(memeCaptionLabel);
        // Label
        JLabel memeVerticalAlignLabel = new JLabel("Vertical Align: ");
        memeVerticalAlignLabel.setPreferredSize(new Dimension(100, 20));
        memeVerticalAlignPanel.add(memeVerticalAlignLabel);
       
        //Text field for meme caption panel
        memeCaptionText = new JTextField(39);
        memeCaptionPanel.add(memeCaptionText, BorderLayout.NORTH);
       
        // vertical align combo box for meme vertical align panel
        String [] verticalAlignment = {"top", "middle", "bottom"};  //Used the link in Homework 7 for this: Helpful GUI examples in Swing and then referred to the JComboBox documentation
        dropdown = new JComboBox<String>(verticalAlignment);
        dropdown.setPreferredSize(new Dimension(350, 20));
        memeVerticalAlignPanel.add(dropdown);
        
        // TODO The button needs a listener
        backgroundImageButton.setActionCommand("click");
        backgroundImageButton.addActionListener(new OpenButtonListener()); //referred to ActionWindow in class for adding a listener to button

        // Panel for generating and saving panel
        JPanel generateSaveMemePanel = new JPanel();
        controlPanel.add(generateSaveMemePanel, BorderLayout.SOUTH);
        
        //Generate button
        JButton generateMemeButton = new JButton("Generate");
        generateSaveMemePanel.add(generateMemeButton, BorderLayout.SOUTH);
        //listener for generate button
        generateMemeButton.setActionCommand("click");
        generateMemeButton.addActionListener(new GenerateButtonListener());
        
        // Save button
        JButton saveMemeButton = new JButton("Save");
        generateSaveMemePanel.add(saveMemeButton, BorderLayout.SOUTH);
        // listener for save button
        saveMemeButton.setActionCommand("click");
        saveMemeButton.addActionListener(new SaveButtonListener());
        
        // Label that will contain the filename of the image
        backgroundImageFileNameLabel = new JLabel("<choose>");
        backgroundImageFilePanel.add(backgroundImageFileNameLabel);
        backgroundImageFileNameLabel.setPreferredSize(new Dimension(265, 20));
        
        // Add the panel about the BackgroundImage fileName to the BackgroundImage information panel
        backgroundImagePanel.add(backgroundImageFilePanel, BorderLayout.NORTH);
        
        // Add the panel about the BackgroundImage title to the BackgroundImage information panel
        backgroundImagePanel.add(backgroundImageTitlePanel, BorderLayout.CENTER);
        
        // Add the panel about the BackgroundImage description to the BackgroundImage information panel
        backgroundImagePanel.add(backgroundImageDescriptionPanel, BorderLayout.SOUTH);
        
        // Add the panel about the meme caption to the meme information panel
        memePanel.add(memeCaptionPanel, BorderLayout.NORTH);
        
        // Add the panel about the meme vertical align to the meme information panel
        memePanel.add(memeVerticalAlignPanel, BorderLayout.CENTER);
        
        // TODO Complete the Control Panel implementation (with Background Image and Meme panels)
        // Add the BackgroundImage information panel to the control panel
        controlPanel.add(backgroundImagePanel, BorderLayout.NORTH);
        // Add the BackgroundImage information panel to the control panel
        controlPanel.add(memePanel, BorderLayout.CENTER);
     
        // Add all the panels to the main display based on BorderLayout
        controlPanel.setPreferredSize(new Dimension(500,570));
        panelPane.add(controlPanel, BorderLayout.WEST);
        panelPane.add(memeViewPanel, BorderLayout.CENTER);

        // Add the panelPane to the contentPane of the Frame (Window)
        this.getContentPane().add(panelPane);

        // Set the preferred size and show the main application window
        this.setPreferredSize(new Dimension(1150, 570));
        this.pack();
        this.setVisible(true);
    }
    
    
    /**
     * ActionListener for the open button.  When the button is pressed, this ActionListener
     * opens a FileChooser, asks the user to choose a JPG image file, then
     * sets the field backgroundImageFilename in the main class.
     */
    private class OpenButtonListener implements ActionListener {
        /**
         * Action performed operation.  Opens a save FileChooser, asks the user to choose a JPG image file, then
         * sets the field backgroundImageFilename in the main class.
         * 
         * @param evt The event that was performed
         */
        @Override
        public void actionPerformed(ActionEvent evt) {
            JFileChooser chooser2 = new JFileChooser();
            chooser2.setDialogTitle("Choose a Background Image");
            chooser2.setFileFilter(new FileNameExtensionFilter("JPEG Images", "jpg", "jpeg"));
            int returnVal = chooser2.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                backgroundImageFilename = chooser2.getSelectedFile().getAbsolutePath();
                backgroundImageFileNameLabel.setText(backgroundImageFilename);
            }

        }
    }
    
    
    /**
     * ActionListener for the save button.  When the button is pressed, this ActionListener
     * opens a save FileChooser, asks the user to choose a location and filename, then
     * writes the graphical meme data to a PNG image file.
     */
    private class SaveButtonListener implements ActionListener {
        /**
         * Action performed operation.  Opens a save FileChooser, asks the user to choose
         * a location and filename, then writes the graphical meme data to a PNG file.
         * 
         * @param evt The event that was performed
         */
        @Override
        public void actionPerformed(ActionEvent evt) {
            JFileChooser chooser2 = new JFileChooser();
            chooser2.setDialogTitle("Save Meme");
            chooser2.setFileFilter(new FileNameExtensionFilter("PNG Images", "png"));
            int returnVal = chooser2.showSaveDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                String destinationFile = chooser2.getSelectedFile().getAbsolutePath();
                if (!destinationFile.contains(".png"))
                    destinationFile += ".png";
                
                // TODO: Writing an image throws a checked exception that must be handled.
                //       Catch the exceptions and provide the user with an appropriate message
                try {
    				ImageIO.write(currentMeme.compileMeme(), "png", new File(destinationFile));
    			} 
                catch (IllegalArgumentException e) {
            		JDialog error = new JDialog();
            		JOptionPane.showMessageDialog(error, "The wrong argument was used.", "error", JOptionPane.ERROR_MESSAGE);
    				System.err.println("The wrong argument was used.");
    			}
            	catch (FileNotFoundException e) {
            		JDialog error = new JDialog();
            		JOptionPane.showMessageDialog(error, "The file was not found", "error", JOptionPane.ERROR_MESSAGE);
    				System.err.println("The file was not found.");
    			}
            	catch(NullPointerException e) {
            		JDialog error = new JDialog();
            		JOptionPane.showMessageDialog(error, "Object reference is null, meme was not saved", "error", JOptionPane.ERROR_MESSAGE);
            		System.err.println("Object reference is null.");
            	}
            	catch(Exception e) {
            		JDialog error = new JDialog();
            		JOptionPane.showMessageDialog(error, "An error occured, meme was not saved", "error", JOptionPane.ERROR_MESSAGE);
    				System.err.println("An error occured.");
    			} 
            }

        }
    }
    
    private class GenerateButtonListener implements ActionListener {
        /**
         * Action performed operation.  Opens a save FileChooser, asks the user to choose
         * a location and filename, then writes the graphical meme data to a PNG file.
         * 
         * @param evt The event that was performed 
         */
        @Override
        public void actionPerformed(ActionEvent evt) {
        	String title = backgroundImageTitleText.getText();
        	String description = backgroundImageDescriptionText.getText();
        	String caption = memeCaptionText.getText();
        	String verticalAlignment = (String) dropdown.getSelectedItem(); //Used the link in Homework 7 for this: Helpful GUI examples in Swing and then referred to the JComboBox documentation
        	BackgroundImage bgImage1 = new BackgroundImage();bgImage1.setImageFileName(backgroundImageFilename);bgImage1.setTitle(title);bgImage1.setDescription(description); //piazza 
        	currentMeme = new GraphicalMeme(bgImage1, caption, user);
        	currentMeme.setCaptionVerticalAlign(verticalAlignment); //setting the caption vertical alignment
        	try {
        		BufferedImage compiledCurrentMeme = currentMeme.compileMeme(); //meme compiled into a buffered image // looked at GraphicalMeme class and Java documentation in Homework 7 pdf
				ImageIcon icon  = new ImageIcon(compiledCurrentMeme); //cohort and TA help
				imageDisplayLabel.setIcon(icon); 
				memeViewPanel.add(imageDisplayLabel).repaint(); 
			}
        	catch (IllegalArgumentException e) {
        		JDialog error = new JDialog();
        		JOptionPane.showMessageDialog(error, "The wrong argument was used.", "error", JOptionPane.ERROR_MESSAGE);
				System.err.println("The wrong argument was used.");
			}
        	catch (FileNotFoundException e) {
        		JDialog error = new JDialog();
        		JOptionPane.showMessageDialog(error, "The file was not found", "error", JOptionPane.ERROR_MESSAGE);
				System.err.println("The file was not found.");
			}
        	catch(NullPointerException e) {
        		JDialog error = new JDialog();
        		JOptionPane.showMessageDialog(error, "Object reference is null, meme was not generated", "error", JOptionPane.ERROR_MESSAGE);
        		System.err.println("Object reference is null.");
        	}
        	catch(Exception e) {
        		JDialog error = new JDialog();
        		JOptionPane.showMessageDialog(error, "An error occured, meme was was not generated", "error", JOptionPane.ERROR_MESSAGE);
				System.err.println("An error occured.");
			}
        	
            }

        }
    }

