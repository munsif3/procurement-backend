package com.sliit.procurement.repository;

import com.sliit.procurement.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by User on 22/11/2017.
 */
public interface ItemRepository extends JpaRepository<Item,String> {
}
