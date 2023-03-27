package com.koltech.koltech.controller;

import com.koltech.koltech.model.Audit;
import com.koltech.koltech.model.Measurement;
import com.koltech.koltech.model.MeasurementRepository;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.security.RolesAllowed;
import javax.persistence.PrePersist;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalDateTime;


@Controller
public class MeasurementController {
    private MeasurementRepository repository;
    private LocalDateTime createdOn;

    public MeasurementController(MeasurementRepository repository) {
        this.repository = repository;
    }

    @RolesAllowed("user")
    @GetMapping("/measurement")
    String showMeasure(Model model,Principal principal){
        KeycloakAuthenticationToken keycloakAuthenticationToken = (KeycloakAuthenticationToken) principal;
        AccessToken accessToken = keycloakAuthenticationToken.getAccount().getKeycloakSecurityContext().getToken();
        model.addAttribute("signedName",accessToken.getGivenName() + " " + accessToken.getFamilyName());
        model.addAttribute("measurements",repository);
        model.addAttribute("newMeasurement",new Measurement());
        return "measurement";
    }

    @RolesAllowed("user")
    @GetMapping("/koltechApplication")
    String showWebSite(Model model,Principal principal){
        KeycloakAuthenticationToken keycloakAuthenticationToken = (KeycloakAuthenticationToken) principal;
        AccessToken accessToken = keycloakAuthenticationToken.getAccount().getKeycloakSecurityContext().getToken();
        model.addAttribute("signedName",accessToken.getGivenName() + " " + accessToken.getFamilyName());
        model.addAttribute("measurements",repository);
        model.addAttribute("newMeasurement",new Measurement());
        return "koltechApplication";
    }

    @RolesAllowed("user")
    @PostMapping("/add")
    String addUser(Model model,Principal principal){
        createdOn = LocalDateTime.now();
        KeycloakAuthenticationToken keycloakAuthenticationToken = (KeycloakAuthenticationToken) principal;
        AccessToken accessToken = keycloakAuthenticationToken.getAccount().getKeycloakSecurityContext().getToken();
        Measurement newMeasurement = new Measurement(generateA1(),generateC_C1(),generateG(),generateH(),generateL_L1(),checkComplianceA1(),checkComplianceC_C1(),checkComplianceG(),checkComplianceH(),checkComplianceL_L1(),accessToken.getGivenName() + " " + accessToken.getFamilyName(),createdOn);
        repository.save(newMeasurement);
        return "redirect:/measurement";
    }

    @PostMapping("/logout")
    String logout(HttpServletRequest request, Model model) throws ServletException {
        request.logout();
        model.addAttribute("measurements",repository);
        model.addAttribute("newMeasurement",new Measurement());
        return "redirect:/koltechApplication";
    }

    //-----------------------LOGIC---------------------------

    private float A1value;
    private float C_C1value;
    private float Hvalue;
    private float Gvalue;
    private float L_L1value;

    //Generate A1
    private float generateA1(){
        double value;
        double rand = Math.random()*1.2;
        double plusMinus = Math.random();
        if(plusMinus >= 0.5) {
            value = 1360 + rand ;
        }
        else {
            value = 1360 - rand ;
        }
        A1value =(float)(Math.round(value*1000)*0.001);
        return A1value;
    }

    //Generate L_L1
    private float generateL_L1(){
        double value;
        double rand = Math.random()*0.7;
        double plusMinus = Math.random();
        if(plusMinus >= 0.5) {
            value = 920 + rand ;
        }
        else {
            value = 920 - rand ;
        }
        L_L1value = (float)(Math.round(value*1000)*0.001);
        return L_L1value;
    }
    //Generate C_C1
    private float generateC_C1(){
        double value;
        double rand = Math.random()*1.2;
        double plusMinus = Math.random();
        if(plusMinus >= 0.5) {
            value = 219 + rand;
        }
        else {
            value = 219 - rand;
        }
        C_C1value = (float)(Math.round(value*1000)*0.001);
        return C_C1value;
    }
    //Generate H
    private float generateH(){
        double value;
        double rand = Math.random()*0.6;
        double plusMinus = Math.random();
        if(plusMinus >= 0.5) {
            value = 0.3 + rand * 0.01;
        }
        else {
            value = 0.3 - rand * 0.01;
        }
        Hvalue = (float)(Math.round(value*1000)*0.001);
        return Hvalue;
    }
    //Generate G
    private float generateG(){
        double value;
        double rand = Math.random()*0.6;
        double plusMinus = Math.random();
        if(plusMinus >= 0.5) {
            value = 0.8 + rand * 0.01;
        }
        else {
            value = 0.8 - rand * 0.01;
        }
        Gvalue = (float)(Math.round(value*1000)*0.001);
        return Gvalue;
    }
    //CheckComplianceA1
    private boolean checkComplianceA1(){
        if(A1value <= 1361.0 && A1value >= 1358.0){
           return true ;
        }else {
            return false;
        }
    }
    //CheckComplianceA1
    private boolean checkComplianceL_L1(){
        if(L_L1value <= 920.6 && L_L1value >= 919.4){
            return true ;
        }else {
            return false;
        }
    }
    //CheckComplianceA1
    private boolean checkComplianceC_C1(){
        if(C_C1value <= 220.0 && C_C1value >= 218.0){
            return true ;
        }else {
            return false;
        }
    }
    //CheckComplianceA1
    private boolean checkComplianceG(){
        if(Gvalue <= 0.80549 && Gvalue >= 0.79451){
            return true ;
        }else {
            return false;
        }
    }
    //CheckComplianceA1
    private boolean checkComplianceH(){
        if(Hvalue <= 0.30549 && Hvalue >= 0.29451){
            return true ;
        }else {
            return false;
        }
    }

}
