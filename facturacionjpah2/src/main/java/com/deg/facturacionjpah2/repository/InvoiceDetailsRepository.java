package com.deg.facturacionjpah2.repository;

import com.deg.facturacionjpah2.model.InvoiceDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface InvoiceDetailsRepository extends JpaRepository<InvoiceDetailsModel,Long>	 {
}
