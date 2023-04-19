package com.deg.facturacionjpah2.repository;

import com.deg.facturacionjpah2.model.ClientsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface ClientRepository extends JpaRepository<ClientsModel,Long> {
	Optional<ClientsModel> findByDocNumber(String docNumber);
}
