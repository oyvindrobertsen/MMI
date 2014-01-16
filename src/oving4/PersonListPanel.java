package oving4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PersonListPanel extends JPanel implements ListSelectionListener {
    
    private JList<Person> personList;
    private JScrollPane scrollPane;
    private DefaultListModel<Person> personListModel;
    private PersonPanel personPanel;
    private JButton newPersonButton, deletePersonButton;
    
    public PersonListPanel() {
        personList = new JList<Person>();
        personListModel = new DefaultListModel<Person>();
        personList.setName("PersonList");
        personList.setModel(personListModel);
        personList.addListSelectionListener(this);
        
        scrollPane = new JScrollPane(personList);
        
        
        personPanel = new PersonPanel();
        personPanel.setName("PersonPanel");
        
        newPersonButton = new JButton("Add");
        newPersonButton.setName("NewPersonButton");
        newPersonButton.addActionListener(new AddAction());
        
        deletePersonButton = new JButton("Remove");
        deletePersonButton.setName("DeletePersonButton");
        deletePersonButton.addActionListener(new DeleteAction());
        
        add(scrollPane);
        add(personPanel);
        add(newPersonButton);
        add(deletePersonButton);
    }
    
    public void setModel(DefaultListModel<Person> model) {
        this.personListModel = model;
        personList.setModel(model);
    }
    
    public DefaultListModel<Person> getModel() {
        return this.personListModel;
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (personList.getSelectedValue() != null) {
            personPanel.setModel(personList.getSelectedValue());
        } else {
            personPanel.setModel(new Person(" "));
        }
    }
    
    class AddAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Person p = new Person(" ");
            personListModel.addElement(p);
            personList.setSelectedValue(p, true);
            personPanel.setModel(p);
        }
    }
    
    class DeleteAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            personListModel.removeElement(personList.getSelectedValue());
        }
        
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        PersonListPanel panel = new PersonListPanel();
        Person person1 = new Person("Øyvind Robertsen");
        Person person2 = new Person("Odd Norstoga");
        Person person3 = new Person("Batman");
        DefaultListModel<Person> dlm = new DefaultListModel<Person>();
        dlm.addElement(person1);
        dlm.addElement(person2);
        dlm.addElement(person3);
        panel.setModel(dlm);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
