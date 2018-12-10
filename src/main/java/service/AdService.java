package service;

import domain.Ad;
import domain.Category;
import domain.Company;

import java.util.List;

public interface AdService {
    public List<Ad> getAll();
    public Ad get(Long id);
    public void save(Ad ad);
    public void delete(Ad ad);
    public List<Ad> getByCategory(Category category);
    public Company getCompany(Long id);
}
