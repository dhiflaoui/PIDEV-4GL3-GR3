package tn.esprit.PidevService.Impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import EntityBase.IBaseEntity;
import tn.esprit.PidevService.Interf.IBaseEntityLocalService;
import tn.esprit.PidevService.Interf.IBaseEntityRemoteService;


public class BaseEntityService<T extends IBaseEntity>
		implements IBaseEntityLocalService<T>, IBaseEntityRemoteService<T> {
	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;

	protected Class<T> entityClass;

	public BaseEntityService(Class<T> entityClass) {

		this.entityClass = entityClass;
	}

	@Override
	public int add(T t) {
		em.persist(t);
		return 1;
	}

	@Override
	public List<T> getAll() {
		List<T> list = em.createQuery("Select e from " + entityClass.getSimpleName() + " e", entityClass)
				.getResultList();
		return list;
	}

	@Override
	public void deleteById(Long id) {
		T t = em.find(entityClass, id);

		em.remove(t);

	}

	@Override
	public void update(T t) {
		em.merge(t);
	}

}

