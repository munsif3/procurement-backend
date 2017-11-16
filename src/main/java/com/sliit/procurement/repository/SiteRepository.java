package com.sliit.procurement.repository;

import com.sliit.procurement.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Munsif on 11/15/2017.
 */
@Repository
public interface SiteRepository extends JpaRepository<Site, String>{

}
