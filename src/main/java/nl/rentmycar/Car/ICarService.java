package nl.rentmycar.Car;
import java.util.List;
import java.util.Optional;


public interface ICarService {
    List<Car> findAll();

    Optional<Car> findById(long id);

    List<Car> findByBrandContaining(String brand);

    Optional<Car> insertImage(Car car);
}

