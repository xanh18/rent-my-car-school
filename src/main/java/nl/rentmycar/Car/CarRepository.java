package nl.rentmycar.Car;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car,Long>{


    Iterable<Car> findCarByBrandContaining(String brand);
}

