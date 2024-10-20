package barinov.coffee.bean.controller.repository;

import barinov.coffee.bean.controller.model.Roasting;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.UUID;

public class RoastingCustomRepositoryImpl implements RoastingCustomRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Tuple> getAllBrigadeRoastingMainInf() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createTupleQuery();

        Root<Roasting> root = cq.from(Roasting.class);

        createQueryAllBrigadeRoastingMainInf(cb, cq, root);

        return em.createQuery(cq).getResultList();
    }

    @Override
    public Tuple getBrigadeRoastingMainInfByUuid(String uuid) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createTupleQuery();

        Root<Roasting> root = cq.from(Roasting.class);

        createQueryAllBrigadeRoastingMainInf(cb, cq, root);

        cq.where(cb.equal(root.get("brigade").get("uuid"), UUID.fromString(uuid)));

        return em.createQuery(cq).getSingleResult();
    }

    @Override
    public List<Tuple> getAllCountryRoastingMainInf() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createTupleQuery();

        Root<Roasting> root = cq.from(Roasting.class);

        createQueryAllCountryRoastingMainInf(cb, cq, root);

        return em.createQuery(cq).getResultList();
    }

    @Override
    public Tuple getCountryRoastingMainInfByCountryName(String country) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createTupleQuery();

        Root<Roasting> root = cq.from(Roasting.class);

        createQueryAllCountryRoastingMainInf(cb, cq, root);

        cq.where(cb.equal(root.get("country"), country));

        return em.createQuery(cq).getSingleResult();
    }


    public void createQueryAllBrigadeRoastingMainInf(CriteriaBuilder cb, CriteriaQuery<Tuple> cq, Root<Roasting> root) {
        cq.multiselect(root.get("brigade").get("uuid"), cb.count(root), cb.sum(root.get("outputWeight")));
        cq.groupBy(root.get("brigade").get("uuid"));
    }

    public void createQueryAllCountryRoastingMainInf(CriteriaBuilder cb, CriteriaQuery<Tuple> cq, Root<Roasting> root) {
        cq.multiselect(root.get("country"), cb.count(root), cb.sum(root.get("outputWeight")));
        cq.groupBy(root.get("country"));
    }
}
