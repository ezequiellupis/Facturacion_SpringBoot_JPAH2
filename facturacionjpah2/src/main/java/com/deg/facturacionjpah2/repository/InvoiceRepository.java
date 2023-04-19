package com.deg.facturacionjpah2.repository;

import com.deg.facturacionjpah2.model.InvoiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceModel,Long> {

}
