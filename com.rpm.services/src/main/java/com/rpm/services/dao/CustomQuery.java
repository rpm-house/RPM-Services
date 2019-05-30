package com.rpm.services.dao;

import java.util.List;

import com.rpm.services.model.DynamicQuery;

public interface CustomQuery<T> {

	List<T> getByDynamicQuery(DynamicQuery dynamicQuery);
}
