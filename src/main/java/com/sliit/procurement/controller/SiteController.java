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

    @ResponseBody
    @RequestMapping(value = "/sites/{siteId}", method = RequestMethod.GET)
    public Site getSiteById(@PathVariable("siteId") String siteId) {
        return siteService.getSiteBySiteId(siteId);
    }

    @ResponseBody
    @RequestMapping(value = "/sites", method = RequestMethod.POST, consumes = "application/json")
    public Site addSite(@RequestBody Site site) {
        return siteService.addSite(site);
    }

    @ResponseBody
    @RequestMapping(value = "/sites", method = RequestMethod.PUT)
    public Site updateSite(@RequestBody final Site site) {
        return siteService.updateSite(site);
    }

    @ResponseBody
    @RequestMapping(value = "/sites/{siteId}", method = RequestMethod.DELETE)
    public String deleteSite(@PathVariable("siteId") String siteId){
        siteService.deleteSite(siteId);
        return "DELETED";
    }
}
