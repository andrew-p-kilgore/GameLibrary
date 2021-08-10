package com.jtakdn.gameLibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController
{
    /*
    @Autowired
    Service serv;
    */
    @GetMapping("/")
    public String index(Model model)
    {
        return "index";
    }

    /*
     * @GetMapping("/customers") public String customers(Model model) {
     * model.addAttribute("customers",serv.getAllCustomers()); return
     * "customers"; }
     * 
     * @GetMapping("/games") public String games(Model model) {
     * model.addAttribute("games",serv.getAllGames()); return "games"; }
     * 
     * @GetMapping("/rentals") public String rentals(Model model) {
     * model.addAttribute("rentals",serv.getAllrentals()); return "rentals"; }
     * 
     * @GetMapping("/deleteCust") public String delCust(Integer custID, Model
     * model) { serv.deleteCust(custID); return "redirect:/customers"; }
     * 
     * @GetMapping("/deleteRent") public String delRent(Integer rentID, Model
     * model) { serv.deleteRent(rentID); return "redirect:/rentals"; }
     * 
     * @GetMapping("/deleteGame") public String delGame(Integer gameID, Model
     * model) { serv.deleteGame(gameID); return "redirect:/games"; }
     */

}
