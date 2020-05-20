package nhathuoclankha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nhathuoclankha.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

  List<Customer> findByPhoneNumber(String phone);

  List<Customer> findByPhoneNumberAndNameAndTraiDungThuoc(String phone, String name,
      String traiDungThuoc);

  List<Customer> findByName(String name);

  List<Customer> findByPhoneNumberIsContaining(String phone);

  List<Customer> findDistinctByPhoneNumberIsContaining(String phone);

  @Query(value = "select distinct(phone_number) from nhathuoc.customer where phone_number like ?1 ;", nativeQuery = true)
  List<String> findListPhoneNumber(String phone);

  @Query(value = "select distinct(name) from nhathuoc.customer where name like ?1 ;", nativeQuery = true)
  List<String> findListName(String name);

}
