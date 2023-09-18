package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.rays.dto.UserDTO;

public class TestCriteriaAggregate {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(UserDTO.class);

		ProjectionList p = Projections.projectionList();

		p.add(Projections.max("id"));

		criteria.setProjection(p);

		List list = criteria.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {

			Object dto = (Object) it.next();

			System.out.print(dto);

		}

		tx.commit();

		session.close();

	}

}
