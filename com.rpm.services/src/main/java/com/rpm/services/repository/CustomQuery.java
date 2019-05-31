package com.rpm.services.repository;

import java.util.List;

import com.rpm.services.model.DynamicQuery;

/**
 * @author MohanRamu
 *
 * @param <T>
 */
public interface CustomQuery<T> {

	List<T> getByDynamicQuery(DynamicQuery dynamicQuery);
}
