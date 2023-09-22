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
        Join<Flat, ResidentsRC> residentsJoin = flatRoot.join("residentsRCList", JoinType.LEFT);

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
                        residentsJoin.get("entry_by_car")
                )
        );

        query.where(criteriaBuilder.and
                (criteriaBuilder.equal(residentsJoin.get("entry_by_car"), '-')));
        query.orderBy(criteriaBuilder.asc(residentsJoin.get("name")));

        return entityManager.createQuery(query).getResultList();
    }
}

