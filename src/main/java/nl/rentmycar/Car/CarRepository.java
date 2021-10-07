package nl.rentmycar.Car;

import org.springframework.data.repository.CrudRepository;


public interface CarRepository extends CrudRepository<Car,Long>{


    Iterable<Car> findCarByBrandContaining(String brand);
}

