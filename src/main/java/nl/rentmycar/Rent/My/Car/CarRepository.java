package nl.rentmycar.Rent.My.Car;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car,Long>{


    Iterable<Car> findCarByBrandContaining(String brand);
}
