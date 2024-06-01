package com.groceteria.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceteria.base.model.GroceteriaUserSystemInfo;

public interface SystemInfoRepository extends JpaRepository<GroceteriaUserSystemInfo, Long> {

}
