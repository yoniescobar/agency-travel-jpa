package com.company.intecap.agencytravel.domain.repositories;

import com.company.intecap.agencytravel.domain.entities.FlyEntity;
import com.company.intecap.agencytravel.domain.entities.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<TourEntity, Long> {
}
