package com.sliit.procurement.repository.custom.impl;

import com.sliit.procurement.model.PurchaseOrder;
import com.sliit.procurement.repository.custom.PurchaseOrderRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Saranki on 11/17/2017.
 */
//@Repository
//@Transactional(readOnly=true)
public class PurchaseOrderRepositoryImpl implements PurchaseOrderRepositoryCustom
{

//    @PersistenceContext
//    EntityManager entityManager;
//
//    @Override
//    public List<PurchaseOrder> getPurchaseOrderByRequisitionId(String requisitionId) {
//        Query query = entityManager.createNativeQuery("SELECT p.* FROM purchase_order as p " +
//                "WHERE p.requisitionId =? LIMIT 1", PurchaseOrder.class);
//        query.setParameter(1, requisitionId);
//
//        return query.getResultList();
//    }
//
//    @Override
//    public List<PurchaseOrder> getMinimumAmountPurchaseOrderByRequisitionId(String requisitionId) {
//        Query query = entityManager.createNativeQuery("SELECT * FROM purchase_order as p " +
//                "WHERE p.requisitionId =? ORDER BY amount ASC LIMIT 1", PurchaseOrder.class);
//        query.setParameter(1, requisitionId);
//
//        return query.getResultList();
//    }
}
