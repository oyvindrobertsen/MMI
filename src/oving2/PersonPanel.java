package oving2;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class PersonPanel extends JPanel implements KeyListener,
    ActionListener, ChangeListener {

    static final int MIN_HEIGHT = 120;
    static final int MAX_HEIGHT = 220;

    private JPanel mainPanel;
    private GridBagConstraints nameGBC, emailGBC, dobGBC, genderGBC,
    heightGBC;
    private JTextField namePropertyComponent, emailPropertyComponent,
    dateOfBirthPropertyComponent;
    private JComboBox<Gender> genderPropertyComponent;
    private JSlider heightPropertyComponent;
    private JLabel nameLabel, emailLabel, dobLabel, genderLabel, heightLabel;
    private Person model;


    public PersonPanel() {
        model = null;
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        add(mainPanel);

        namePropertyComponent = new JTextField(30);
        namePropertyComponent.setName("NamePropertyComponent");
        nameLabel = new JLabel("Name: ");
        nameGBC = new GridBagConstraints();
        nameGBC.gridx = 0;
        nameGBC.gridy = 0;
        mainPanel.add(nameLabel, nameGBC);
        nameGBC.gridx = 1;
        mainPanel.add(namePropertyComponent, nameGBC);
        namePropertyComponent.addKeyListener(this);

        emailPropertyComponent = new JTextField(30);
        emailPropertyComponent.setName("EmailPropertyComponent");
        emailLabel = new JLabel("Email: ");
        emailGBC = new GridBagConstraints();
        emailGBC.gridx = 0;
        emailGBC.gridy = 1;
        mainPanel.add(emailLabel, emailGBC);
        emailGBC.gridx = 1;
        mainPanel.add(emailPropertyComponent, emailGBC);
        emailPropertyComponent.addKeyListener(this);

        dateOfBirthPropertyComponent = new JTextField(30);
        dateOfBirthPropertyComponent.setName("DateOfBirthPropertyComponent");
        dobLabel = new JLabel("Date of Birth: ");
        dobGBC = new GridBagConstraints();
        dobGBC.gridx = 0;
        dobGBC.gridy = 2;
        mainPanel.add(dobLabel, dobGBC);
        dobGBC.gridx = 1;
        mainPanel.add(dateOfBirthPropertyComponent, dobGBC);
        dateOfBirthPropertyComponent.addKeyListener(this);

        genderPropertyComponent = new JComboBox<Gender>(Gender.values());
        genderPropertyComponent.setName("GenderPropertyComponent");
        genderLabel = new JLabel("Gender: ");
        genderGBC = new GridBagConstraints();
        genderGBC.gridx = 0;
        genderGBC.gridy = 3;
        mainPanel.add(genderLabel, genderGBC);
        genderGBC.gridx = 1;
        genderGBC.anchor = GridBagConstraints.WEST;
        mainPanel.add(genderPropertyComponent, genderGBC);
        genderPropertyComponent.addActionListener(this);

        heightPropertyComponent = new JSlider(JSlider.HORIZONTAL, MIN_HEIGHT,
                MAX_HEIGHT, 175);
        heightPropertyComponent.setName("HeightPropertyComponent");
        heightPropertyComponent.setMajorTickSpacing(10);
        heightPropertyComponent.setMinorTickSpacing(1);
        heightPropertyComponent.setPaintTicks(true);
        heightPropertyComponent.setPaintLabels(true);
        heightLabel = new JLabel("Height: ");
        heightGBC = new GridBagConstraints();
        heightGBC.gridx = 0;
        heightGBC.gridy = 4;
        mainPanel.add(heightLabel, heightGBC);
        heightGBC.fill = GridBagConstraints.HORIZONTAL;
        heightGBC.gridx = 1;
        mainPanel.add(heightPropertyComponent, heightGBC);
        heightPropertyComponent.addChangeListener(this);
    }

    public void setModel(Person p) {
        this.model = p;
        namePropertyComponent.setText(p.getName());
        emailPropertyComponent.setText(p.getEmail());
        dateOfBirthPropertyComponent.setText(p.getDateOfBirth());
        genderPropertyComponent.setSelectedItem(p.getGender());
        heightPropertyComponent.setValue(p.getHeight());
    }
    
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER && model != null) {
            if (e.getSource() == namePropertyComponent) {
                model.setName(namePropertyComponent.getText());
            } else if (e.getSource() == emailPropertyComponent) {
                model.setEmail(emailPropertyComponent.getText());
            } else if (e.getSource() == dateOfBirthPropertyComponent) {
                model.setDateOfBirth(dateOfBirthPropertyComponent.getText());
            }
            KeyboardFocusManager manager = 
                    KeyboardFocusManager.getCurrentKeyboardFocusManager();
            manager.focusNextComponent();
        }
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == genderPropertyComponent && model != null) {
            model.setGender((Gender)genderPropertyComponent.getSelectedItem());
        }
        
    }
    
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == heightPropertyComponent && model != null) {
            model.setHeight(heightPropertyComponent.getValue());
        }
        
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Testing Øving 2");
        frame.getContentPane().add(new PersonPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
