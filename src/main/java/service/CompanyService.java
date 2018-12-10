package service;

import domain.Company;

import java.util.List;

public interface CompanyService {
    public List<Company> getAll();
    public Company get(Long id);
    public void save(Company ad);
}
