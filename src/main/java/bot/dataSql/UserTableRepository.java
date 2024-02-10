package bot.dataSql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTableRepository extends JpaRepository<UserTable, Long> {

    // Поиск пользователей по имени
    List<UserTable> findByFirstName(String firstName);

    // Поиск пользователей по имени и фамилии
    List<UserTable> findByFirstNameAndLastName(String firstName, String lastName);

    // Поиск пользователей, у которых возраст больше заданного значения
    List<UserTable> findByAgeGreaterThan(int age);

    // Поиск пользователей, у которых возраст меньше заданного значения
    List<UserTable> findByAgeLessThan(int age);

    // Поиск пользователей, у которых возраст находится в заданном диапазоне
    List<UserTable> findByAgeBetween(int minAge, int maxAge);

    // Подсчет количества пользователей с определенным именем
    int countByFirstName(String firstName);

    // Удаление пользователей по идентификатору и имени
    void deleteByIdAndFirstName(Long id, String firstName);

    // Поиск пользователей по имени с сортировкой по возрастанию возраста
    List<UserTable> findByFirstNameOrderByAgeAsc(String firstName);

    // Поиск пользователей по имени с сортировкой по убыванию возраста
    List<UserTable> findByFirstNameOrderByAgeDesc(String firstName);
}
