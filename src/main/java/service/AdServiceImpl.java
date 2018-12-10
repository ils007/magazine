package service;

import domain.Ad;
import domain.Category;
import domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AdRepository;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class AdServiceImpl implements AdService {
    @Autowired
    private AdRepository adRepository;

    @Transactional
    public List<Ad> getAll() {
        return adRepository.findAll();
    }
    @Transactional
    public Ad get(Long id) {
        return adRepository.getOne(id);
    }

    //If the entity has not yet been persisted, Spring Data JPA saves the entity with a call to the entityManager.persist(…) method.
    // Otherwise, it calls the entityManager.merge(…) method.
    public void save(Ad ad) {
        adRepository.save(ad);
    }

    public void delete(Ad ad) {
        adRepository.delete(ad);
    }

    public List<Ad> getByCategory(Category category) {
        return adRepository.findByCategory(category);
    }

    public Company getCompany(Long id) {
        return adRepository.getOne(id).getCompany();
    }
}
