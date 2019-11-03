package com.example.ymldemo.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping(value = "/items")
    public ModelAndView readItem() {
        ModelAndView modelAndView = new ModelAndView("itemsList");
        modelAndView.addObject( "itemsList",itemService.getAllItems());

        return modelAndView;
    }

    //@GetMapping(value = "/items/new")

    //@PostMapping(value = "/items/new")

    //@GetMapping(value = "/items/find")

    //@GetMapping(value = "/items/{itemId}/edit")

    //@PostMapping(value = "/items/{itemId}/edit")


}
