package oving3;

import javax.swing.JFrame;

import oving3.PersonPanel;

@SuppressWarnings("serial")
public class PassivePersonPanel extends PersonPanel {
       
    public PassivePersonPanel() {
        super();
        super.namePropertyComponent.setEnabled(false);
        super.emailPropertyComponent.setEnabled(false);
        super.dateOfBirthPropertyComponent.setEnabled(false);
        super.genderPropertyComponent.setEnabled(false);
        super.heightPropertyComponent.setEnabled(false);
    }
    
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Testing Øving 3");
        Person commonPerson = new Person("Øyvind");
        PassivePersonPanel passivePanel = new PassivePersonPanel();
        passivePanel.setModel(commonPerson);
        frame1.getContentPane().add(passivePanel);
        JFrame frame2 = new JFrame("Testing Øving 3");
        PersonPanel panel = new PersonPanel();
        panel.setModel(commonPerson);
        frame2.getContentPane().add(panel);
        frame1.pack();
        frame1.setVisible(true);
        frame2.pack();
        frame2.setVisible(true);
    }

}
