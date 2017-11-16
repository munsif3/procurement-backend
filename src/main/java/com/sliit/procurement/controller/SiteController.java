package com.sliit.procurement.controller;

import com.sliit.procurement.model.Site;
import com.sliit.procurement.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Munsif on 11/15/2017.
 */
@RestController
@CrossOrigin
public class SiteController {

    @Autowired
    SiteService siteService;

    @ResponseBody
    @RequestMapping(value = "/sites", method = RequestMethod.GET)
    public List<Site> getAllSites() {
        return siteService.getAllSites();
    }

}
