package com.jtakdn.gameLibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;

import com.jtakdn.gameLibrary.dto.Customer;
import com.jtakdn.gameLibrary.dto.Game;
import com.jtakdn.gameLibrary.dto.Loan;
import com.jtakdn.gameLibrary.service.GameLibraryServiceLayerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController
{
    @Autowired
    GameLibraryServiceLayerImpl serv;

    @GetMapping("/")
    public String index(Model model)
    {
        return "index";
    }

    @GetMapping("/customers")
    public String customers(Model model)
    {
        model.addAttribute("customers", serv.getAllCustomers());
        return "customers";
    }

    @GetMapping("/games")
    public String games(Model model)
    {
        model.addAttribute("games", serv.getAllGames());
        return "games";
    }

    @GetMapping("/rentals")
    public String rentals(Model model)
    {
        model.addAttribute("rentals", serv.getAllLoans());
        return "rentals";
    }

    @GetMapping("/deleteCust")
    public String deleteCust(Integer custID, Model model)
    {
        serv.deleteCustomer(Integer.toString(custID.intValue()));
        return "redirect:/customers";
    }

    @GetMapping("/deleteRent")
    public String deleteRent(Integer rentID, Model model)
    {
        serv.deleteLoan(Integer.toString(rentID));
        return "redirect:/rentals";
    }

    @GetMapping("/deleteGame")
    public String deleteGame(Integer gameID, Model model)
    {
        serv.deleteGame(Integer.toString(gameID));
        return "redirect:/games";
    }

    @GetMapping("/getGameByID")
    public String getGameByID(String gameID, Model model)
    {
        model.addAttribute("game", serv.getGame(gameID));
        return "game";
    }

    @GetMapping("/getLoanByID")
    public String getRentalByID(String loanID, Model model)
    {
        model.addAttribute("rental", serv.getLoan(loanID));
        return "rental";
    }

    @GetMapping("/getCustByID")
    public String getCustByID(String custID, Model model)
    {
        model.addAttribute("customer", serv.getCustomer(custID));
        return "customer";
    }

    @PostMapping("/addGame")
    public String addGame(@Valid Game newGame, BindingResult result)
    {
        if (result.hasErrors()) return "/games";
        newGame = serv.createGame(newGame);
        return "redirect:/getGameByID?gameID=" + newGame.getGameId();
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@Valid Customer newCust, BindingResult result) 
    {
        if (result.hasErrors()) return "/customers";
        newCust = serv.createCustomer(newCust);
        return "redirect:/getCustByID?custID=" + newCust.getCustomerId();
    }

    @PostMapping("/addLoan")
    public String addLoan(@Valid Loan newLoan, BindingResult result) 
    {
        if (result.hasErrors()) return "/rentals";
        newLoan = serv.createLoan(newLoan);
        return "redirect:/getLoanByID?loanID=" + newLoan.getLoanId();
    }

    @PostMapping("/editGame")
    public String editGame(@Valid Game newGame, BindingResult result)
    {
        if (result.hasErrors()) return "/games";
        serv.updateGame(newGame);
        return "redirect:/getGameByID?gameID=" + newGame.getGameId();
    }

    @PostMapping("/editCustomer")
    public String editCustomer(@Valid Customer newCust, BindingResult result) 
    {
        if (result.hasErrors()) return "/customers";
        serv.updateCustomer(newCust);
        return "redirect:/getCustByID?custID=" + newCust.getCustomerId();
    }

    @PostMapping("/editLoan")
    public String editLoan(@Valid Loan newLoan, BindingResult result) 
    {
        if (result.hasErrors()) return "/rentals";
        serv.updateLoan(newLoan);
        return "redirect:/getLoanByID?loanID=" + newLoan.getLoanId();
    }
}