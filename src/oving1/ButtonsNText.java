package oving1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

@SuppressWarnings("serial")
public class ButtonsNText extends JPanel implements ActionListener, KeyListener {
	public JFrame frame;
	public JTextField textLine;
	public JToggleButton lowerCaseButton, upperCaseButton;
	public JCheckBox continuousButton;
	public ButtonGroup buttonGroup;
	
	public ButtonsNText() {
		frame = new JFrame();
		populatePanel();
		frame.add(this);
	}
	
	private void populatePanel() {
		textLine = new JTextField(40);
		lowerCaseButton = new JToggleButton("Lower Case");
		upperCaseButton = new JToggleButton("Upper Case");
		continuousButton = new JCheckBox("Continuous?");
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(lowerCaseButton);
		buttonGroup.add(upperCaseButton);
		
		
		textLine.setName("TextLine");
		lowerCaseButton.setName("LowerCaseButton");
		upperCaseButton.setName("UpperCaseButton");
		continuousButton.setName("ContinuousButton");
		
		textLine.addKeyListener(this);
		lowerCaseButton.addActionListener(this);
		upperCaseButton.addActionListener(this);
		continuousButton.addActionListener(this);
		
		add(textLine);
		add(lowerCaseButton);
		add(upperCaseButton);
		add(continuousButton);
	}
	
	private void textLineToLowerCase() {
		int pos = textLine.getCaretPosition();
		textLine.setText(textLine.getText().toLowerCase());
		textLine.setCaretPosition(pos);
	}
	
	private void textLineToUpperCase() {
		int pos = textLine.getCaretPosition();
		textLine.setText(textLine.getText().toUpperCase());
		textLine.setCaretPosition(pos);
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == lowerCaseButton) {
			textLineToLowerCase();
		} else if (e.getSource() == upperCaseButton) {
			textLineToUpperCase();
		} else if (e.getSource() == continuousButton) {
			textLine.requestFocus();
		}
		
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (lowerCaseButton.isSelected()) {
				textLineToLowerCase();
			} else if (upperCaseButton.isSelected()) {
				textLineToUpperCase();
			}
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {
		if (continuousButton.isSelected()) {
			if (lowerCaseButton.isSelected()) {
				textLineToLowerCase();
			} else if (upperCaseButton.isSelected()) {
				textLineToUpperCase();
			}
		}
	}
}
