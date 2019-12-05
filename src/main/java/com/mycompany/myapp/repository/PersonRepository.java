package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * Spring Data  repository for the Person entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    /**
     * 使用方法名 命名规范
     * 返回值可以是List<Person>或者List<Optional<Person>>
     * @param name
     * @return
     */
    List<Optional<Person>> findAllByNameLike(String name);

    /**
     *  不论返回值是List<Optional<Person>>、List<Person>、Optional<Person>、Person。jpa框架都可以智能的转变为你想要的结果
     * @param id
     * @return
     */
    @Query("select p from Person p where p.id=:id")
    List<Optional<Person>> selectById(@Param("id") Long id);
//    Optional<Person> selectById(@Param("id") Long id);
    @Query(nativeQuery = true ,value = "select count(1) from person")
    long getCount();

    @Query("select p from Person p where p.age=:age")
    List<Optional<Person>> queryByAge(@Param("age") int age);

    @Query("select p from Person p where p.age=?1")
    List<Optional<Person>> queryByAge2(int age);


    /**
     *
     * @param age
     * @param pageable
     * @return
     */
    @Query(value = "select p.* from person p where if(?1 !='',p.age=?1,1=1)",nativeQuery = true)
    List<Person> queryByAgeAndPage(Integer age, Pageable pageable);

    /**
     *
     * @Query("select a " +
     *     "from com.taoqi.co.domain.FundProduct as b " +
     *     "left join com.taoqi.co.domain.LendingOrganization as a " +
     *     "on a.lendingOrganizationCode = b.lendingOrganizationCode " +
     *     "where b.partnerAccount = :partnerAccount " +
     *     "and (:#{#dto.name} is null or a.name like %:#{#dto.name}%)" +
     *     "and (:#{#dto.connectType} is null or a.connectType = :#{#dto.connectType}) " +
     *     "and (:#{#dto.startTime} is null or cast(a.gmtCreate as string) > :#{#dto.startTime}) " +
     *     "and (:#{#dto.endTime} is null or cast(a.gmtCreate as string) < :#{#dto.endTime})" +
     *     "GROUP BY a.lendingOrganizationCode ")
     * Page<LendingOrganization> findAllByFundproductAndPartner(@Param("dto") LendingOrganizationQueryDTO dto, @Param("partnerAccount") String partnerAccount, Pageable pageable);
     *
     * @Query(value = "select case when (u.dbStatus=1) then u.loginName else 'zz' end from User u ")
     *     List<String> findUserByCaseFunc();
     *
     *
     * @param age
     * @param pageable
     * @return
     */
    @Query(value = "select  p from Person as p where 1=1 ")
    List<Person> queryByCondition(@Param("person") Person person, Pageable pageable);
}
