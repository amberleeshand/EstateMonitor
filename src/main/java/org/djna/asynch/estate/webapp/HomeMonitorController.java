package org.djna.asynch.estate.webapp;

import org.apache.log4j.Logger;
import org.djna.asynch.estate.data.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.swing.text.View;
import java.util.Date;
import java.util.HashMap;

@Controller
public class HomeMonitorController {
    static private Logger LOGGER = Logger.getLogger(HomeMonitorController.class);
    private HashMap<String, Integer> propertyMap = null;

    public HashMap<String, Integer> getPropertyMap() {
        if(propertyMap == null) {
            propertyMap = new HashMap<>();
            Users allUsers = new Users();
            HouseList allHouses = new HouseList();
            for (User eachUser : allUsers.getListOfUsers()) {
                String username = eachUser.getUser();

                for (House eachHouse : allHouses.getHouses()) {
                    int house = eachHouse.getHouseNumber();
                    propertyMap.put(username, house);
                }
            }
        }
        return propertyMap;
    }

    // enable simple server test
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    // display page that subscribes to one topic
    @GetMapping("/monitor")
    public String monitor(
            @RequestParam(name = "property", required = false, defaultValue = "101") String property,
            @RequestParam(name = "locationSelected", required = false, defaultValue = "hall") String location,
            Model model) {
        LOGGER.info("monitor " + property + "/" + location);
        model.addAttribute("property", property);
        model.addAttribute("location", location);
        model.addAttribute("topic", "home/thermostats/" + property + "/" + location);
        return "monitor";
    }

    @GetMapping("/myproperty")
    public String myProperty(
            @RequestParam(name = "property", required = false, defaultValue = "101") String property,
            @RequestParam(name = "locationSelected", required = false, defaultValue = "hall") String location,
            Model model) {
        LOGGER.info("monitor " + property + "/" + location);
        model.addAttribute("property", property);
        model.addAttribute("location", location);
        ThermostatReading reading = new ThermostatReading(property, new Date(), -5, location);
        model.addAttribute("reading", reading);
        return "myproperty";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/Users")
    ModelAndView home() {

        return new ModelAndView("login" , "propertyMap", propertyMap);
        }

    @GetMapping("/authenticate")
    ModelAndView authenticate(
            @RequestParam(name = "username", required = true) String name,
            @RequestParam(name = "password", required = true) String password,
            Model model){

            if(!getPropertyMap().containsKey(name)){
                String message = "Your details are not recognised, please contact an admin";
                return new ModelAndView("login" , "message", message);

            }
            else{
                if(name.startsWith("tenant")){
                    int houseNumber =  getPropertyMap().get(name);
                    System.out.println(houseNumber);
                    return new ModelAndView("tenant","authenticate", houseNumber);
                }
            }
            return new ModelAndView("estateowner");
        }
    }

