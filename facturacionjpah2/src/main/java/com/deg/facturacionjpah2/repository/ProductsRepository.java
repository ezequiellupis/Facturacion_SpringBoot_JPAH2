package com.deg.facturacionjpah2.repository;

import com.deg.facturacionjpah2.model.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface ProductsRepository extends JpaRepository<ProductsModel,Long> {

	Optional<ProductsModel> findByCode(String code);
}
