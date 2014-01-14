package oving3;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Person {
    
    public static final String NAME_PROPERTY = "nameField";
    public static final String DOB_PROPERTY = "dobField";
    public static final String EMAIL_PROPERTY = "emailField";
    public static final String GENDER_PROPERTY = "genderField";
    public static final String HEIGHT_PROPERTY = "heightField";
    
    private PropertyChangeSupport pcs;
    private String name, dateOfBirth, email;
    private Gender gender;
    private int height;
    
    public Person(String name) {
        this.name = name;
        
        pcs = new PropertyChangeSupport(this);
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        pcs.firePropertyChange(NAME_PROPERTY, oldName, name);
    }
    
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(String dateOfBirth) {
        String oldDOB = this.dateOfBirth;
        this.dateOfBirth = dateOfBirth;
        pcs.firePropertyChange(DOB_PROPERTY, oldDOB, dateOfBirth);
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        pcs.firePropertyChange(EMAIL_PROPERTY, oldEmail, email);
    }
    
    public Gender getGender() {
        return gender;
    }
    
    public void setGender(Gender gender) {
        Gender oldGender = this.gender;
        this.gender = gender;
        pcs.firePropertyChange(GENDER_PROPERTY, oldGender, gender);
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        int oldHeight = this.height;
        this.height = height;
        pcs.firePropertyChange(HEIGHT_PROPERTY, oldHeight, height);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
}
