package be.thomasmore.party.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class HomeController {
    private final int mySpecialNumber = 35;
    private final String[] venueNames = {"Zillion", "Carré", "Cherrymoon" , "Carat", "Boccacio" , "Cocorico", "Illusion"};



    @GetMapping(value = {"/", "/home", "/home/"})

    public String home(Model model) {
        model.addAttribute( "mySpecialNumber", mySpecialNumber );
        return "home";
    }

    @GetMapping(value = {"/venuelist", "/venuelist/"})

    public String venuelist(Model model){
        model.addAttribute("venueNames", venueNames);
        return "venuelist";
    }

    @GetMapping("/about")

    public String about(){
        return "about";
    }


    @GetMapping("/pay")
    public String pay(Model model){
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        model.addAttribute("today",format.format(today));
        c.add(Calendar.DATE,5);
        Date paydate = c.getTime();
        model.addAttribute("paydate", format.format(paydate));
        return "pay";
    }


    @GetMapping(value = {"/venuedetails","/venuedetails/{venuename}"})
    public String venuedetails(Model model, @PathVariable (required = false) String venuename){
        model.addAttribute("venuename",venuename);
        return "venuedetails";
    }


}
