package com.sosam.service;

import java.util.List;
import java.util.Optional;

import com.sosam.model.Mountain;
import com.sosam.model.MountainJoin;

public interface MountainService {

	List<Mountain> findBymNameContains(String mName);

	Optional<Mountain> findById(String mCode);

	List<Mountain> findAll();

	List<MountainJoin> mntnFilter(MountainJoin mj) throws Exception;

}
