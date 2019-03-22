package entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

public class Users {

    private Long user_id;

    @Size(message="Le nom d'utilisateur doit comporter au moins 3 lettres",min=3)
    private String lastName;

    @NotNull
    private String firstName;

    @Size(message = "L'email de l'utilisateur doit comporter au moins une lettre",min = 1)
    @Pattern(message = "L'email n'est pas valide", regexp = "[^@]+@[^@]+")
    private String email;

    @NotNull
    @Size(message = "Le mot de passe de l'utilisateur doit comporter au moins 6 lettres",min = 6)
    private String password;

    private boolean reminder;

    private List<Borrows> borrows;

    private List<Reservation> reservations;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isReminder() {
        return reminder;
    }

    public void setReminder(boolean reminder) {
        this.reminder = reminder;
    }

    public List<Borrows> getBorrows() {
        return borrows;
    }

    public void setBorrows(List<Borrows> borrows) {
        this.borrows = borrows;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
