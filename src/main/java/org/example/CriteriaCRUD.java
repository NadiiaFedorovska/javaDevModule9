package org.example;

import org.example.data.*;
import javax.persistence.criteria.*;
import java.util.List;

import static org.example.App.entityManager;

public class CriteriaCRUD {
    public List<MemberInfo> findMembersWithoutEntryByCar() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<MemberInfo> query = criteriaBuilder.createQuery(MemberInfo.class);
        query.distinct(true);

        Root<Flat> flatRoot = query.from(Flat.class);

        Join<Flat, Building> buildingJoin = flatRoot.join("building", JoinType.LEFT);
        Join<Flat, ResidentsRC> residentsJoin = flatRoot.join("residentsRC", JoinType.LEFT);

        Subquery<Long> subquery = query.subquery(Long.class);
        Root<Flat> subqueryFlatRoot = subquery.from(Flat.class);
        Join<Flat, ResidentsRC> subqueryResidentsJoin = subqueryFlatRoot.join("residentsRC", JoinType.LEFT);
        subquery.select(criteriaBuilder.count(subqueryFlatRoot.get("id")))
                .where(criteriaBuilder.equal(subqueryResidentsJoin, residentsJoin));

        subquery.select(criteriaBuilder.count(subqueryFlatRoot.get("id")))
                .where(criteriaBuilder.equal(subqueryResidentsJoin, residentsJoin));

        query.select(
                criteriaBuilder.construct(
                        MemberInfo.class,
                        flatRoot.get("id"),
                        flatRoot.get("flatNumber"),
                        flatRoot.get("numberOfRooms"),
                        flatRoot.get("square"),
                        buildingJoin.get("street"),
                        buildingJoin.get("buildingNumber"),
                        residentsJoin.get("name"),
                        residentsJoin.get("eMail"),
                        residentsJoin.get("tel"),
                        residentsJoin.get("entryByCar")
                )
        );

        query.where(criteriaBuilder.and(
                criteriaBuilder.equal(residentsJoin.get("entryByCar"), '-'),
                  criteriaBuilder.equal(subquery, 1L)
        ));

        return entityManager.createQuery(query).getResultList();
    }
}

