package com.springlearn.beans.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserjdbcRepository implements UserRepository {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("UserjdbcRepository save...");
	}
}
