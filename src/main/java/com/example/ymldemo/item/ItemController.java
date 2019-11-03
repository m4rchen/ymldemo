package com.example.ymldemo.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping(value = "/items")
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView("items/itemsList");
        modelAndView.addObject( "itemsList",itemService.getAllItems());

        return modelAndView;
    }

    @GetMapping(value = "/items/{itemId}")
    public ModelAndView getInfo(@PathVariable("itemId") long itemId){
        ModelAndView modelAndView = new ModelAndView("items/itemsInfo");
        Optional<Item> item = itemService.getById(itemId);

        if (item != null){
            modelAndView.addObject("id", itemId);
            modelAndView.addObject("item", item.get());
        }

        return modelAndView;
    }

    @GetMapping(value = "/items/{itemId}/edit")
    public ModelAndView getEditItem(@PathVariable("itemId") long itemId){
        ModelAndView modelAndView = new ModelAndView("items/itemsEdit");
        Optional<Item> item = itemService.getById(itemId);

        if (item != null){
            modelAndView.addObject("item", item.get());
        }

        return modelAndView;
    }

    @PostMapping(value = "/items/{itemId}/edit")
    public String setEditItem(@ModelAttribute Item item, @PathVariable("itemId") Long itemId){
        item.setId(itemId);
        itemService.editItem(item);
        return "redirect:/items/"+item.getId();
    }
    //@GetMapping(value = "/items/new")

    //@PostMapping(value = "/items/new")

    //@GetMapping(value = "/items/find")




}
