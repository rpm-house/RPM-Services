package com.rpm.services.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.rpm.services.model.DynamicQuery;

@Repository
public class CustomQueryImpl<T> implements CustomQuery<T> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private final MongoTemplate mongoTemplate;

	public CustomQueryImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getByDynamicQuery(DynamicQuery dynamicQuery) {
		final Query query = new Query();
		final List<Criteria> criteria = new ArrayList<>();

		if (dynamicQuery.getOperator().equalsIgnoreCase("equal")) {
			criteria.add(Criteria.where(dynamicQuery.getKey()).is(dynamicQuery.getValue()));
		} else {
			criteria.add(Criteria.where(dynamicQuery.getKey()).gte((dynamicQuery.getValue())));
		}
		/*
		 * if(dynamicQuery.getAuthorNameLike() != null) {
		 * criteria.add(Criteria.where("authorNames").regex(MongoRegexCreator.INSTANCE.
		 * toRegularExpression( dynamicQuery.getAuthorNameLike(), Part.Type.CONTAINING
		 * ), "i")); } if(dynamicQuery.getPublishDateBefore() != null) {
		 * criteria.add(Criteria.where("publishDate").lte(dynamicQuery.
		 * getPublishDateBefore())); } if(dynamicQuery.getPublishDateAfter() != null) {
		 * criteria.add(Criteria.where("publishDate").gte(dynamicQuery.
		 * getPublishDateAfter())); } if(dynamicQuery.getSubject() != null) {
		 * criteria.add(Criteria.where("subjects").regex(MongoRegexCreator.INSTANCE.
		 * toRegularExpression( dynamicQuery.getSubject(), Part.Type.SIMPLE_PROPERTY ),
		 * "i")); }
		 */
		if (!criteria.isEmpty()) {
			query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
		}
		return (List<T>) mongoTemplate.find(query, getClass(dynamicQuery.getEntity()));

	}

	Class<?> getClass(String className) {
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
