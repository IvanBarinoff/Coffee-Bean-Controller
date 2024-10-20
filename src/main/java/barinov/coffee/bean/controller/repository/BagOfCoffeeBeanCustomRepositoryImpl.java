package barinov.coffee.bean.controller.repository;

import barinov.coffee.bean.controller.model.BagOfCoffeeBean;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class BagOfCoffeeBeanCustomRepositoryImpl implements BagOfCoffeeBeanCustomRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Tuple> getRemainingCoffeeBeanByFilters(String variety, String country) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createTupleQuery();

        Root<BagOfCoffeeBean> root = cq.from(BagOfCoffeeBean.class);

        cq.multiselect(cb.count(root), root.get("variety"), root.get("country"));
        cq.groupBy(root.get("variety"), root.get("country"));

        Predicate predicate = cb.isNull(root.get("brigade"));

        if(variety != null) predicate = cb.and(predicate, cb.equal(root.get("variety"), variety));
        if(country != null) predicate = cb.and(predicate, cb.equal(root.get("country"), country));

        cq.where(predicate);

        return em.createQuery(cq).getResultList();
    }
}
