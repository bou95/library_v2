package com.library.action;

import com.library.service.UsersService;
import com.library.wsdl.users.UserInfo;
import com.opensymphony.xwork2.ActionSupport;
import entities.Users;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UsersAction extends ActionSupport implements SessionAware {

    @Autowired
    UsersService service;

    private long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Users users;

    private Map<String, Object> session;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public String doCreate(){
        String Result = ActionSupport.INPUT;
        if (!StringUtils.isAnyEmpty(email, password , lastName, firstName)){
            users = service.create(email, password, lastName, firstName);
            if (users != null) {
                    Result = ActionSupport.SUCCESS;
            }else{
                this.addActionError("l'adresse email existe déjà en base de donnée");
            }
        }else{
            this.addActionError("Veuillez remplir les champs obligatoires");
        }
        return Result;
    }

    public String getUserById(){
        if (id < 1) {
            this.addActionError("Vous devez indiquer un id ");
        } else {
            users= service.getUserById(id);
            return ActionSupport.SUCCESS;
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doLogin(){
        String Result = ActionSupport.INPUT;
        if (!StringUtils.isAnyEmpty(email, password)){
            users = service.login(email, password);
            if(users != null) {
                this.session.put("user", users);
                Result = ActionSupport.SUCCESS;
            }else{
                this.addActionError("L'adresse email ou le mot de passe sont erronés");
            }
        }else{
            this.addActionError("Veuillez remplir les champs obligatoires");
        }
        return Result;
    }

    public String doLogout() {
        // Suppression de l'utilisateur en session
        this.session.remove("user");

        return ActionSupport.SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }
}
