package TP5.Q4;

/**
 * @overview Un client représente un client de banque. Un client a un nom, un prénom
 * C'est un type immutable.
 * Il est défini tel que <Nom, Prénom> tel que:
 * @specfield Nom: String // Nom de famille du client
 * @specfield Prénom: String // Prénom du client
 */
public class Personne {
    private String lastName, firstName;


    /**
     * FA(c): <c.lastName, c.firstName>
     */

    /**
     * IR(c): lastName != null && firstName != null
     */

    /**
     * @effects initialise une nouvelle personne avec this.lastName = lastName && this.firstName
     */
    public Personne(String lastName, String firstName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @return this.lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return this.firstName
     */
    public String getFirstName() {
        return firstName;
    }
}
