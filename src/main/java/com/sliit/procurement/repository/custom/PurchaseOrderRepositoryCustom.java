package com.sliit.procurement.repository.custom;

import com.sliit.procurement.model.PurchaseOrder;

import java.util.List;

/**
 * Created by Saranki on 11/17/2017.
 */
public interface PurchaseOrderRepositoryCustom
{
    List<PurchaseOrder> getPurchaseOrderByRequisitionId(String requisitionId);
}
