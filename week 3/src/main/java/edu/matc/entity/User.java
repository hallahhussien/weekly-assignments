
package edu.matc.entity;

import edu.matc.util.LocalDateAttributeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

    /**
     * A class to represent a user.
     * @author Hallah
     *
     */
    @Entity
    @Table(name = "users")
    public class User {

        @Id
        @GeneratedValue(generator="increment")
        @GenericGenerator(name="increment",strategy="increment")
        @Column(name = "id")
        private int id;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "last_name")
        private String lastName;

        @Column(name = "date_of_birth")
        @Convert(converter = LocalDateAttributeConverter.class)
        private LocalDate dateOfBirth;

        /**
         * Empty constructor
         */
        public User() {

        }

        /**
         * Constructor that takes in four parameters to immediately set
         * to the User's instance variables
         * @param id
         * @param firstName
         * @param lastName
         * @param dateOfBirth
         */
        public User(int id, String firstName, String lastName, LocalDate dateOfBirth) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.dateOfBirth = dateOfBirth;
        }

        /**
         * Getter for id
         * @return the user's id
         */
        public int getId() {
            return id;
        }

        /**
         * Setter for id
         * @param id the user's soon-to-be id
         */
        public void setId(int id) {
            this.id = id;
        }

        /**
         * Getter for first name
         * @return the user's first name
         */
        public String getFirstName() {
            return firstName;
        }

        /**
         * Setter for first name
         * @param firstName the user's soon-to-be first name
         */
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        /**
         * Getter for last name
         * @return the user's last name
         */
        public String getLastName() {
            return lastName;
        }

        /**
         * Setter for last name
         * @param lastName the user's soon-to-be last name
         */
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        /**
         * Getter for date of birth
         * @return the user's date of birth
         */
        public LocalDate getDateOfBirth() {
            return dateOfBirth;
        }

        /**
         * Setter for date of birth
         * @param dateOfBirth the user's soon-to-be date of birth
         */
        public void setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }
    }
